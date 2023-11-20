package com.demo.conversionApplication;
import java.util.HashMap;

public class Execution extends ConversionCommands {

    public Execution( ){

    }
    public HashMap<String , Object> execute(HashMap<String, Object> data) throws Exception {
        ConversionCommands [] commandList = new FetchCommands().commandPattern(data);
        for (ConversionCommands command: commandList ){
            command.execute(data);
        }
        return data;
    }
}

