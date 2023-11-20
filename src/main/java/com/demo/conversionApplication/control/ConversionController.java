package com.demo.conversionApplication.control;
import com.demo.conversionApplication.classes.ConversionCommands;
import com.demo.conversionApplication.classes.Execution;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;

@RestController
public class ConversionController {
    @CrossOrigin(origins = {
            "http://localhost:4200",
            "http://conversionsecondhosting.s3-website-us-west-1.amazonaws.com/",
            "http://conversionbucketapp.s3-website-us-east-1.amazonaws.com/"
    })
    @RequestMapping(value = "/convert")

    public HashMap<String, Object> convert(@RequestBody @Validated HashMap<String, Object> data)  {
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

