package view;

import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.SeqGene;
import proto_compile.cetc41.nodecontrol.SourceControlServiceApi;
import service.SourceControlService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class DeviceViewAndControl extends JFrame {

    private JTable table;
    private DeviceTableModel tableModel;

    public DeviceViewAndControl() {
        setTitle("设备列表");
        setSize(1400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DeviceTableModel();
        table = new JTable(tableModel);
        table.setRowHeight(40);

        table.getColumn("操作").setCellRenderer(new ButtonRenderer());
        table.getColumn("操作").setCellEditor(new ButtonEditor());

        // 设置列宽
        table.getColumnModel().getColumn(0).setPreferredWidth(50);  // 设备ID
        table.getColumnModel().getColumn(1).setPreferredWidth(100);  // 类型
        table.getColumnModel().getColumn(2).setPreferredWidth(100);  // 状态
        table.getColumnModel().getColumn(3).setPreferredWidth(300);  // 位置（加宽）
        table.getColumnModel().getColumn(4).setPreferredWidth(400);  // 指标（加宽）
        table.getColumnModel().getColumn(5).setPreferredWidth(150);  // 操作

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton refreshButton = new JButton("刷新设备列表");
        refreshButton.addActionListener(e -> fetchDeviceList());
        add(refreshButton, BorderLayout.SOUTH);

        Timer autoRefreshTimer = new Timer(3000, e -> fetchDeviceList());
        autoRefreshTimer.start();
    }

    private void fetchDeviceList() {
        List<SourceControlServiceApi.SourceInfo> deviceInfo = SourceControlService.getDeviceInfo();
        tableModel.setDeviceData(deviceInfo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeviceViewAndControl frame = new DeviceViewAndControl();
            frame.setVisible(true);
            frame.fetchDeviceList();
        });
    }

    static class DeviceTableModel extends AbstractTableModel {
        private final String[] columns = {"设备ID", "设备类型", "状态", "位置", "指标", "操作"};
        private Object[][] data = new Object[0][columns.length];

        public void setDeviceData(List<SourceControlServiceApi.SourceInfo> sourceList) {
            data = sourceList.stream()
                    .map(d -> {
                        String positionStr = (d.hasPosition())
                                ? String.format("纬度: %.3f, 经度: %.3f, 高度: %.3f",
                                d.getPosition().getLatitude(),
                                d.getPosition().getLongitude(),
                                d.getPosition().getAltitude())
                                : "无";

                        String metricsStr = (d.hasMetrics())
                                ? d.getMetrics().getIndicesMap().entrySet().stream()
                                .map(entry -> {
                                    DCTSServiceApi.Physical p = entry.getValue();
                                    return String.format("类型: %s, 值: %.2f, 单位: %s",
                                            p.getType(), p.getValue(), p.getUnit());
                                })
                                .reduce((a, b) -> a + " | " + b)
                                .orElse("无")
                                : "无";

                        return new Object[]{
                                d.getSourceId().getValue(),
                                d.getType().name(),
                                d.getStatus().name(),
                                positionStr,
                                metricsStr,
                                ""  // 按钮列
                        };
                    })
                    .toArray(Object[][]::new);

            fireTableDataChanged();
        }


        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 5; // 只有“操作”列可编辑
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = aValue;
        }
    }

    static class ButtonRenderer extends JPanel implements TableCellRenderer {
        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(new JButton("开机"));
            add(new JButton("关机"));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements javax.swing.table.TableCellEditor {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton onBtn = new JButton("开机");
        JButton offBtn = new JButton("关机");

        String currentDeviceId;

        public ButtonEditor() {
            panel.add(onBtn);
            panel.add(offBtn);

            onBtn.addActionListener(e -> {
                if (currentDeviceId != null) {
                    SourceControlService.sendSourceCommand(Integer.parseInt(currentDeviceId),
                            SeqGene.CmdType.STARTUP.getNumber(), 1L);
                    JOptionPane.showMessageDialog(null, "已发送开机指令给设备 " + currentDeviceId);

                    Timer t = new Timer(800, event -> {
                        fetchDeviceList();
                        fireEditingStopped();
                    });
                    t.setRepeats(false);
                    t.start();
                }
            });

            offBtn.addActionListener(e -> {
                if (currentDeviceId != null) {
                    SourceControlService.sendSourceCommand(Integer.parseInt(currentDeviceId),
                            SeqGene.CmdType.SHUTDOWN.getNumber(), 1L);
                    JOptionPane.showMessageDialog(null, "已发送关机指令给设备 " + currentDeviceId);

                    Timer t = new Timer(800, event -> {
                        fetchDeviceList();
                        fireEditingStopped();
                    });
                    t.setRepeats(false);
                    t.start();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            currentDeviceId = table.getValueAt(row, 0).toString();
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }
}
