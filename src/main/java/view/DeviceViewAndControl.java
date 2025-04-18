//package view;
//
//import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
//import service.NodeControlService;
//
//import javax.swing.*;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableCellRenderer;
//import java.awt.*;
//import java.util.List;
//
//public class DeviceViewAndControl extends JFrame {
//
//    private JTable table;
//    private DeviceTableModel tableModel;
//
//    public DeviceViewAndControl() {
//        setTitle("所有设备信息查看器");
//        setSize(1200, 800);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        tableModel = new DeviceTableModel();
//        table = new JTable(tableModel);
//        table.setRowHeight(40);
//
//        table.getColumn("操作").setCellRenderer(new ButtonRenderer());
//        table.getColumn("操作").setCellEditor(new ButtonEditor());
//
//        add(new JScrollPane(table), BorderLayout.CENTER);
//
//        JButton refreshButton = new JButton("刷新设备列表");
//        refreshButton.addActionListener(e -> fetchDeviceList());
//        add(refreshButton, BorderLayout.SOUTH);
//    }
//
//    private void fetchDeviceList() {
//        List<NodeControlServiceApi.NodeInfo> nodeList = NodeControlService.getNodesInfo();
//        tableModel.setDeviceData(nodeList);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            DeviceViewAndControl frame = new DeviceViewAndControl();
//            frame.setVisible(true);
//            frame.fetchDeviceList(); // 启动时加载数据
//        });
//    }
//
//    // 表格数据模型
//    static class DeviceTableModel extends AbstractTableModel {
//        private final String[] columns = {"节点ID", "节点名称", "设备ID", "设备名称", "状态", "是否物理节点", "操作"};
//        private Object[][] data = new Object[0][columns.length];
//
//        public void setDeviceData(List<NodeControlServiceApi.NodeInfo> nodeList) {
//            data = nodeList.stream()
//                    .flatMap(node -> node.getDataSourceListList().stream().map(device -> new Object[]{
//                            node.getNodeId().getValue(),
//                            node.getNodeName(),
//                            device.getDeviceId().getValue(),  // 显式提取 string
//                            device.getDeviceName(),
//                            device.getStatus(),
//                            node.getIsPhysical(),
//                            "" // 按钮占位符
//                    }))
//                    .toArray(Object[][]::new);
//            fireTableDataChanged();
//        }
//
//        @Override
//        public int getRowCount() {
//            return data.length;
//        }
//
//        @Override
//        public int getColumnCount() {
//            return columns.length;
//        }
//
//        @Override
//        public String getColumnName(int column) {
//            return columns[column];
//        }
//
//        @Override
//        public Object getValueAt(int rowIndex, int columnIndex) {
//            return data[rowIndex][columnIndex];
//        }
//
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            return column == 6; // 只有“操作”列可编辑
//        }
//
//        @Override
//        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//            data[rowIndex][columnIndex] = aValue;
//        }
//    }
//
//    // 渲染器
//    static class ButtonRenderer extends JPanel implements TableCellRenderer {
//        public ButtonRenderer() {
//            setLayout(new FlowLayout(FlowLayout.LEFT));
//            JButton onBtn = new JButton("开机");
//            JButton offBtn = new JButton("关机");
//            add(onBtn);
//            add(offBtn);
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
//                                                       boolean hasFocus, int row, int column) {
//            return this;
//        }
//    }
//
//    // 编辑器（按钮响应逻辑）
//    class ButtonEditor extends AbstractCellEditor implements javax.swing.table.TableCellEditor {
//        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JButton onBtn = new JButton("开机");
//        JButton offBtn = new JButton("关机");
//
//        String currentDeviceId;
//
//        public ButtonEditor() {
//            panel.add(onBtn);
//            panel.add(offBtn);
//
//            onBtn.addActionListener(e -> {
//                if (currentDeviceId != null) {
//                    NodeControlService.sendSourceCommand(currentDeviceId,
//                            NodeControlServiceApi.CmdType.START.getNumber(), 1L);
//                    JOptionPane.showMessageDialog(null, "已发送开机指令给设备 " + currentDeviceId);
//
//                    // 等待 800 毫秒再刷新状态（模拟后端响应时间）
//                    new Timer(800, evt -> {
//                        fetchDeviceList();
//                        fireEditingStopped(); // 结束编辑状态
//                    }).setRepeats(false); // 只执行一次
//                }
//            });
//
//            offBtn.addActionListener(e -> {
//                if (currentDeviceId != null) {
//                    NodeControlService.sendSourceCommand(currentDeviceId,
//                            NodeControlServiceApi.CmdType.SHUTDOWN.getNumber(), 1L);
//                    JOptionPane.showMessageDialog(null, "已发送关机指令给设备 " + currentDeviceId);
//
//                    // 等待 800 毫秒再刷新状态
//                    new Timer(800, evt -> {
//                        fetchDeviceList();
//                        fireEditingStopped();
//                    }).setRepeats(false);
//                }
//            });
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value,
//                                                     boolean isSelected, int row, int column) {
//            currentDeviceId = (String) table.getValueAt(row, 2); // 正确提取为 String
//            return panel;
//        }
//
//        @Override
//        public Object getCellEditorValue() {
//            return "";
//        }
//    }
//}
