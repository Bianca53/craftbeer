package com.beerhouse.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class GetBeerTest {
	
	@Test
	public void getAllBeersTest() throws ClientProtocolException, IOException {
		 // Given
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/beers");
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	    // Then
	     assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test
	public void getBeerByIDTest() throws ClientProtocolException, IOException {
		 // Given
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/beers/2");
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	    // Then
	     assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
}
