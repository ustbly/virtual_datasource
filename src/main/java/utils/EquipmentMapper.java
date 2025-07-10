package utils;

import zb.dcts.fusion.airDomain.target.TargetOuterClass;

import java.util.Arrays;
import java.util.List;

public class EquipmentMapper {

    private static int idCounter = 1;

    public static TargetOuterClass.LinkEquipment toLinkEquipment(EquipmentXmlParser.EquipmentConfig cfg) {
        return TargetOuterClass.LinkEquipment.newBuilder()
                .setId(idCounter++)
                .setName(cfg.type)
                .setMode(cfg.workMode.equalsIgnoreCase("Fixed") ? "定频" : "跳频")
                .setStartFreq(cfg.minFreq)
                .setStopFreq(cfg.maxFreq)
                .setBand(cfg.maxFreq - cfg.minFreq)
                .setModulation(cfg.modulation)
                .build();
    }
    public static TargetOuterClass.StationEquipment toStationEquipment(EquipmentXmlParser.EquipmentConfig cfg) {
        List<Double> freqList = Arrays.asList(cfg.minFreq, cfg.maxFreq);
        return TargetOuterClass.StationEquipment.newBuilder()
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

