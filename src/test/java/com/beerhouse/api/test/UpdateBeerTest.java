package com.beerhouse.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class UpdateBeerTest {
	
	@Test
	public void updateBeerPUTTest() throws ClientProtocolException, IOException {
		// Given
	    HttpUriRequest request = RequestBuilder.create("PUT")
    		    .setUri("http://localhost:8080/beers/2")
    		    .setEntity(new StringEntity("{\"name\":\"DaDoBier\",\"ingredients\":\"barley,yeast,hops,water\",\"alcoholContent\":\"6,5% alcohol\",\"price\":7.90,\"category\":\"Red Ale\"}"
    		    , ContentType.APPLICATION_JSON))
    		    .build();
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	    // Then
	    assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));     
	}
	
	@Test
	public void updateBeerPATCHTest() throws ClientProtocolException, IOException {
		// Given
	    HttpUriRequest request = RequestBuilder.create("PATCH")
    		    .setUri("http://localhost:8080/beers/2")
    		    .setEntity(new StringEntity("{\"name\":\"BSB\",\"ingredients\":\"barley,yeast,hops,water\",\"alcoholContent\":\"6,5% alcohol\",\"price\":7.90,\"category\":\"Red Ale\"}",
    		     ContentType.APPLICATION_JSON))
    		    .build();
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	    // Then
	    assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));     
	}
	
}
