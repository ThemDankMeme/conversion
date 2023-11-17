package com.demo.helloworld;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class ConversionController {

    @RequestMapping(value = "/convert")
    public HashMap<String, Object> convert(@RequestBody HashMap<String, Object> data)  {
        try {
//            conversions result = new conversions();
//            return result.execute(data);
//            System.out.println(data);
//            ConversionCommands test = new Mathmatics("value1", "value2", "/", "result");
//            test.execute(data);
//            return data;
//            ConversionCommands test = new RetrieveJson("conversion2.json", "selectedOption");
//            test.execute(data);
//            return data;
            ConversionCommands convert = new Execution();
            convert.execute(data);
            return data;

        }catch (Exception err){
            data.put("Error", err.getMessage());
            return data;
        }
    }


}

