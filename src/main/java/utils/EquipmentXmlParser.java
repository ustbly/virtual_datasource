package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class EquipmentXmlParser {
    public static class EquipmentConfig {
        public String type;
        public double minFreq;
        public double maxFreq;
        public String modulation;
        public String workMode;

        @Override
        public String toString() {
            return "EquipmentConfig{" +
                    "type='" + type + '\'' +
                    ", minFreq=" + minFreq +
                    ", maxFreq=" + maxFreq +
                    ", modulation='" + modulation + '\'' +
                    ", workMode='" + workMode + '\'' +
                    '}';
        }
    }

    public static List<EquipmentConfig> parseConfig(String resourcePath) {
        List<EquipmentConfig> list = new ArrayList<>();
        try {
            // 从 classpath 读取资源
            InputStream in = EquipmentXmlParser.class.getClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                throw new FileNotFoundException("配置文件未找到: " + resourcePath);
            }

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            NodeList equipments = doc.getElementsByTagName("Equipment");
            for (int i = 0; i < equipments.getLength(); i++) {
                Element e = (Element) equipments.item(i);
                EquipmentConfig cfg = new EquipmentConfig();
                cfg.type = e.getElementsByTagName("Type").item(0).getTextContent();
                cfg.modulation = e.getElementsByTagName("Modulation").item(0).getTextContent();
                cfg.workMode = e.getElementsByTagName("WorkMode").item(0).getTextContent();
                cfg.minFreq = Double.parseDouble(e.getElementsByTagName("Min").item(0).getTextContent());
                cfg.maxFreq = Double.parseDouble(e.getElementsByTagName("Max").item(0).getTextContent());
                list.add(cfg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}

