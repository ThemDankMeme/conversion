package com.demo.conversionApplication.control;

import com.demo.conversionApplication.classes.ConversionCommands;
import com.demo.conversionApplication.classes.FetchCommands;
import com.demo.conversionApplication.classes.Mathmatics;
import com.demo.conversionApplication.classes.RetrieveJson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;


@SpringBootTest

class HelloWorldApplicationTests {
    private ConversionController controller;

	private final HashMap<String, Object> test1 = new HashMap<>();


	@Test
	void contextLoads() {
		test1.put("type", "temperature");
		test1.put("unit", "CelsiusToFahrenheit");
		test1.put("convertingValue", 63.5);
		test1.put("first", 10.0);
		test1.put("second", 13.5);
	}

	@Test
	void testMathmatics() throws Exception {
		contextLoads();
		////Testing Multiply
		ConversionCommands mathTest = new Mathmatics("first", "second", "*", "result");
		mathTest.execute(test1);
		assertEquals(135.0, test1.get("result"), "10 * 13.5 equals 135.0");

		/////Testing Addition
		mathTest = new Mathmatics("first", "second", "+", "result");
		mathTest.execute(test1);
		assertEquals(23.5, test1.get("result"),"10 + 13.5 equals 23.5" );

		/////Testing Subtract
		mathTest = new Mathmatics("second", "first", "-", "result");
		mathTest.execute(test1);
		assertEquals(3.5, test1.get("result"),"13.5 - 10 equals 3.5" );

		////Divide
		mathTest = new Mathmatics("second", "first", "/", "result");
		mathTest.execute(test1);
		assertEquals(1.35, test1.get("result"),"13.5 / 10 equals 1.35" );
	}

	@Test
	void testFetchCommands(){
		contextLoads();
		ConversionCommands[] fetchTest = new FetchCommands().commandPattern(test1);
        assertEquals(3, fetchTest.length, "temperature contains three calculations");

	}
	@Test
	void testExecution() throws Exception {
		contextLoads();
		ConversionCommands[] fetchTest = new FetchCommands().commandPattern(test1);
		for(ConversionCommands command:fetchTest){
			command.execute(test1);
		}
		assertEquals(146.3, test1.get("results"), "63.5 celsius is 146.3 fahrenheit");
	}

	@Test
	void testRetrieveJson() throws Exception {
		contextLoads();
		ConversionCommands jsonTest = new RetrieveJson("none.json","doesn'tmatter","nope");
		jsonTest.execute(test1);
		assertEquals(IOException.class, "File Not Found", "No file none.json");

	}


}
