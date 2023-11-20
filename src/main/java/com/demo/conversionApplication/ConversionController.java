package com.demo.conversionApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;

@RestController
public class ConversionController {
    @CrossOrigin(origins = {"http://localhost:4200", "http://conversionsecondhosting.s3-website-us-west-1.amazonaws.com/"})
    @RequestMapping(value = "/convert")

    public HashMap<String, Object> convert(@RequestBody HashMap<String, Object> data)  {
        try {
            ConversionCommands convert = new Execution();
            convert.execute(data);
            return data;

        }catch (Exception err){
            throw new ResponseStatusException(
                    HttpStatus.valueOf(err.getMessage()));
        }
    }
}

