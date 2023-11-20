package com.demo.conversionApplication.classes;
import com.demo.conversionApplication.classes.ConversionCommands;
import org.springframework.core.io.ClassPathResource;
import java.io.*;
import java.nio.charset.StandardCharsets;
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

    public HashMap<String, Object> execute(HashMap<String, Object> data) throws Exception {
        HashMap<String , Object> json = readJson(this.fileName);
        double rate = (double) json.get(this.getStringValue(data, this.option));
        this.addToHashMap(data, this.factor, rate);
        return data;
    }
    public HashMap<String , Object> readJson(String name) throws IOException {
//        Resource resource = new ClassPathResource("classpath:./conversion2.json");
//        System.out.println("-----------##################-----------");
//        System.out.println(resource.getFile());
//        HashMap<String, Object> objectMapper;
//        File file = ResourceUtils.getFile("classpath:conversion2.json");
//        objectMapper = new ObjectMapper().readValue(file, HashMap.class);
//        System.out.println("-----------##################-----------");
//        System.out.println(objectMapper);
////        System.out.println(new ObjectMapper().readValue(
////                new FileSystemResource("/BOOT-INF/classes/public/conversion2.json").getFile(), HashMap.class));
////        System.out.println("-----------##################-----------");
////        System.out.println(new ClassPathResource("/classes/public/"+name).getFile());
////        HashMap<String, Object> objectMapper = new ObjectMapper().readValue(
////                new ClassPathResource("/public/"+name).getFile(), HashMap.class);
////        if(objectMapper==null)
////            throw new IOException("File not read");
////        System.out.println("-----------##################-----------"+objectMapper);
////        return objectMapper;
//        return objectMapper;
//
//        ObjectMapper map = new ObjectMapper();
//        HashMap<String, Object> myMap = (HashMap<String, Object>)map.readValue((JsonParser) resource, HashMap.class);
//        System.out.println("-----------##################-----------");
//        System.out.println(myMap);
//        return myMap;
//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("./conversion2.json");
//        System.out.println(classLoader);
//
//        // the stream holding the file content
//        if (inputStream == null) {
//            throw new IllegalArgumentException("file not found! " + fileName);
//        } else {
//            System.out.println(inputStream);
//            return null;
//        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        File jsonFile = new File("/BOOT-INF/classes/public/conversion2.json");
//        HashMap<String, Object> jsonData = objectMapper.readValue(jsonFile, HashMap.class);
//        System.out.println("-----------##################-----------");
//        System.out.println(jsonData);
//        return jsonData;
//        ClassPathResource resource = new ClassPathResource("public/conversion2.json");
//        System.out.println("-----------##################-----------");
//        String absolute = String.valueOf(resource.getFile());
//
//        System.out.println(absolute);
//        ObjectMapper map = new ObjectMapper();
//        HashMap<String, Object> myMap = (HashMap<String, Object>)map.readValue((DataInput) resource, HashMap.class);
//        System.out.println(myMap);
        try{
        InputStream json = new ClassPathResource("public/"+name).getInputStream();
        String output = this.stringBuilder(json);
        return this.convertStringToHashMap(output);
        }catch (IOException err){
            throw new IOException("File Not Found");
        }

    }

    public HashMap<String, Object> convertStringToHashMap(String list){
        HashMap<String, Object> results = new HashMap<>();
        //figure out the regex for this
        //list = list.replace("  \n { } \"", "");
        list = list.replace(" ", "");
        list = list.replace("\n", "");
        list = list.replace("{","");
        list = list.replace("}","");
        list = list.replace("\"" ,"");
        String [] pairs = list.split(",");
        for(String pair:pairs){
            String [] keyValue = pair.split(":");
            results.put(keyValue[0], Double.valueOf(keyValue[1]));
        }
        return results;
    }

    public String stringBuilder(InputStream input) throws IOException {
        int bufferSize = 1024;
        char[] buffer = new char[bufferSize];
        StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(input, StandardCharsets.UTF_8);
        for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0; ) {
            out.append(buffer, 0, numRead);
        }
        return out.toString();
    }


}
