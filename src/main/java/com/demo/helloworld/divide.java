package com.demo.helloworld;

import java.util.HashMap;

public class divide extends ConversionCommands {
    private final String firstValue;
    private final String secondValue;
    public divide(String firstValue, String secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public HashMap<String, Object> execute(HashMap<String, Object> data) throws Exception {

        if(this.getNumericValue(data, this.secondValue) != 0){
            double result = this.getNumericValue(data, this.firstValue)/this.getNumericValue(data, this.secondValue);
            this.addToHashMap(data, "result", result);
//data.put("result", result);
            return data;
        }
        else
            throw new Exception("Can't divide by Zero");
    }
}

