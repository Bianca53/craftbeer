package com.beerhouse.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class CreateBeerTest {

	@Test
	public void insertBeerTest() throws ClientProtocolException, IOException {
		// Given
	    HttpUriRequest request = RequestBuilder.create("POST")
    		    .setUri("http://localhost:8080/beers")
    		    .setEntity(new StringEntity("{\"name\":\"Verace\",\"ingredients\":\"barley,yeast,hops,water\",\"alcoholContent\":\"5% alcohol\",\"price\":5.50,\"category\":\"Pale Ale\"}"
    		    , ContentType.APPLICATION_JSON))
    		    .build();
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	    // Then
	    assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_CREATED));     
	}
	

}
