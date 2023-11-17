package com.demo.conversionApplication;
import java.util.HashMap;

public class Mathmatics extends ConversionCommands {
    private final String value1;
    private final String value2;
    private final String operator;
    private final String result;
    public Mathmatics(String value1, String value2, String operator, String result){
        this.value1 = value1;
        this.value2 = value2;
        this.operator = operator;
        this.result = result;
    }

    public HashMap<String, Object> execute(HashMap<String, Object> data) throws Exception {
        double result = 0;
        switch (this.operator){
            case "+":
                result = this.getNumericValue(data, this.value1)+ this.getNumericValue(data, this.value2);
                break;
            case "-":
                result = this.getNumericValue(data, this.value1) - this.getNumericValue(data, this.value2);
                break;
            case "*":
                result = this.getNumericValue(data, this.value1) * this.getNumericValue(data, this.value2);
                break;
            case "/":
                if(this.getNumericValue(data, this.value2) != 0){
                    result = this.getNumericValue(data, this.value1)/this.getNumericValue(data, this.value2);
                    break;
                }
                else
                    throw new Exception("Can't divide by Zero");
//                result = this.getNumericValue(data, this.value1) / this.getNumericValue(data, this.value2);
//                break;
            default:
                break;
        }
        this.addToHashMap(data, this.result, result);
        return data;
    }
}
