package com.demo.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);

    }
    @RequestMapping(value = "/convert")
    public Map<String, Object> test(@RequestBody Map<String, Object> data) throws IOException {
//        HashMap<String, Double> data = new HashMap<String, Double>();
//        data.put("first", value);
//        Double res = data.get("first")*.25;
//        data.put("result", res);
//        return data.get("result")


        System.out.println(data.get("measurement"));
        System.out.println(readJson("conversion2.json"));
        return data;

    }

    public HashMap<String , Double> readJson(String name) throws IOException {
        String currDir = System.getProperty("user.dir");
        String resources = "/src/main/resources/static/";
        System.out.println(System.getProperty("user.dir"));
        ObjectMapper objectMapper = new ObjectMapper();
//        HashMap<String, Double> temp = new HashMap<String, Double>();
//        temp = objectMapper.readValue(new File(currDir+resources+name), HashMap.class);
        return objectMapper.readValue(new File(currDir+resources+name), HashMap.class);

    }
}
