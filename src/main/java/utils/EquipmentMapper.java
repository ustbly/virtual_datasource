package utils;

import zb.dcts.fusion.airDomain.target.Target;

import java.util.Arrays;
import java.util.List;

public class EquipmentMapper {

    private static int idCounter = 1;

    public static Target.LinkEquipment toLinkEquipment(EquipmentXmlParser.EquipmentConfig cfg) {
        return Target.LinkEquipment.newBuilder()
                .setId(idCounter++)
                .setName(cfg.type)
                .setMode(cfg.workMode.equalsIgnoreCase("Fixed") ? "定频" : "跳频")
                .setStartFreq(cfg.minFreq)
                .setStopFreq(cfg.maxFreq)
                .setBand(cfg.maxFreq - cfg.minFreq)
                .setModulation(cfg.modulation)
                .build();
    }
    public static Target.StationEquipment toStationEquipment(EquipmentXmlParser.EquipmentConfig cfg) {
        List<Double> freqList = Arrays.asList(cfg.minFreq, cfg.maxFreq);
        return Target.StationEquipment.newBuilder()
                .setId(idCounter++)
                .setName(cfg.type)
                .setWorkMode(cfg.workMode)
                .addAllFreq(freqList)
                .setBand((int) (cfg.maxFreq - cfg.minFreq))
                .setHpRate(cfg.workMode.equalsIgnoreCase("Hopping") ? 5 : 0)
                .setDwellTime(10)
                .setModulation(cfg.modulation)
                .build();
    }
}

