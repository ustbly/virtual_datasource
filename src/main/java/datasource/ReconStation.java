package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import entity.DeviceInfo;
import entity.SignalList;

public class ReconStation extends DataSource {


    @Override
    public void updateFromJson(JsonNode jsonNode) {

    }

    @Override
    public void start() {
        super.start();
        System.out.println("ReconStation-specific initialization...");
    }

    @Override
    public void shutdown() {
        super.start();
        System.out.println("ReconStation-specific cleanup...");
    }
}

