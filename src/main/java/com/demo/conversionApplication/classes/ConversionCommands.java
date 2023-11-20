package com.demo.conversionApplication.classes;
import java.util.HashMap;

public class ConversionCommands {
    public ConversionCommands(){}
    public HashMap<String, Object> execute(HashMap<String, Object> data) throws Exception{
        throw new Exception("Method not implemented");
    }

    protected double getNumericValue(HashMap<String, Object> data, String value){
        if(data.get(value).getClass().getSimpleName().equals("Integer")){
            int val = (int) data.get(value);
            return (double) val;
        }
        return (double) data.get(value);
    }

    protected void addToHashMap(HashMap<String, Object> data, String key, Object value){data.put(key, value);}

    protected String getStringValue(HashMap<String, Object> data, String value) throws Exception {
        if(!data.containsKey(value))
            throw new Exception("Key not contained");
        return (String) data.get(value);
    }
}
