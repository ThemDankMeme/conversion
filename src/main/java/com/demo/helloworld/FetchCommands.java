package com.demo.helloworld;

import java.util.HashMap;

public class FetchCommands extends ConversionCommands{
    public ConversionCommands[] commandPattern(HashMap<String, Object> data){
        ConversionCommands[] commands = new ConversionCommands[0];
        if(data.get("type").equals("temperature")){
            //This can be reduced look at putting into json like celsiusToFahrenheit: [difference, numerator, denominator] and read it correctly at RetrieveJson
            this.addToHashMap(data, "difference", 32.0);
            this.addToHashMap(data, "nine", 9.0);
            this.addToHashMap(data, "five", 5.0);
            if(data.get("unit").equals("celsius")){
                //converting Celsius to Fahrenheit
                commands = new ConversionCommands[]{
                        new Mathmatics("convertingValue", "nine","*","val1"),
                        new Mathmatics("val1", "five", "/", "val2"),
                        new Mathmatics("val2", "difference", "+", "result")

                };
            } else if (data.get("unit").equals("fahrenheit")) {
                //converting Fahrenheit to Celsius
                commands = new ConversionCommands[]{
                        new Mathmatics("convertingValue", "difference","-","val1"),
                        new Mathmatics("val1", "five", "*", "val2"),
                        new Mathmatics("val2", "nine", "/", "result")
                };
            }

        }
        else{
            commands = new ConversionCommands[]{
                    new RetrieveJson("conversion2.json", "unit", "convertingFactor"),
                    new Mathmatics("convertingValue", "convertingFactor", "*", "results")
            };

        }
        return commands;
    }

}
