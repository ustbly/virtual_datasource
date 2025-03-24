package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import entity.DeviceInfo;
import entity.SignalList;

public class InfoSystem extends DataSource {


    @Override
    public void updateFromJson(JsonNode jsonNode) {

    }

    @Override
    public void start() {
        super.start();
        System.out.println("InfoSystem-specific initialization...");
    }

    @Override
    public void shutdown() {
        super.start();
        System.out.println("InfoSystem-specific cleanup...");
    }
}

