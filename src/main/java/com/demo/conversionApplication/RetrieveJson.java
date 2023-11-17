package com.demo.conversionApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class RetrieveJson extends ConversionCommands {

    private final String fileName;
    private final String option;
    private final String factor;

    public RetrieveJson(String fileName, String option, String factor){
        this.fileName = fileName;
        this.option = option;
        this.factor = factor;
    }

    public HashMap<String, Object> execute(HashMap<String, Object> data) throws IOException {
        HashMap<String , Object> json = readJson(this.fileName);
//        String select = this.getStringValue(data, this.option);
//        System.out.println("looking at execute in retrieveJson: "+ json);
//        System.out.println("option is"+data.get(this.option));
//        System.out.println("entered map: "+json.get(this.option));
        double rate = (double) json.get(this.getStringValue(data, this.option));
        this.addToHashMap(data, this.factor, rate);
        return data;
    }
    public HashMap<String , Object> readJson(String name) throws IOException {
        String currDir = System.getProperty("user.dir");
        String resources = "/src/main/resources/static/";
        ObjectMapper objectMapper = new ObjectMapper();
//        HashMap<String , Object> testing = objectMapper.readValue(new File(currDir+resources+name), HashMap.class);
//        System.out.println(testing);
        return objectMapper.readValue(new File(currDir+resources+name), HashMap.class);
    }


}
