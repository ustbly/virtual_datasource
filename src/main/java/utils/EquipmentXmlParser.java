package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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

    public static List<EquipmentConfig> parseConfig(File xmlFile) {
        List<EquipmentConfig> list = new ArrayList<>();
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
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

