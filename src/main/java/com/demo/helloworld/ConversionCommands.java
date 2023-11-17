package com.demo.helloworld;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

public class ConversionCommands {
    public ConversionCommands(){};
    public HashMap<String, Object> execute(HashMap<String, Object> data) throws Exception{
        throw new Exception("Method not implemented");
    }

    protected double getNumericValue(HashMap<String, Object> data, String value){
        return (double) data.get(value);
    }

    protected void addToHashMap(HashMap<String, Object> data, String key, Object value){
        data.put(key, value);
    }

    protected String getStringValue(HashMap<String, Object> data, String value){
        return (String) data.get(value);
    }


}
