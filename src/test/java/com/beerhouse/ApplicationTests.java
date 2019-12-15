package com.beerhouse;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.beerhouse.Application;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationTests {

	@Test
	public void contextLoads() throws IOException {
		 
	}
	
	@Test
	public void initialConnectionTest() throws IOException {
		try {
			 HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/beers").openConnection();
		     int code = connection.getResponseCode();
		     assertEquals(200, code);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}