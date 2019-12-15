package com.beerhouse.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;


public class DeleteBeerTest {
	
	@Test
	public void deleteBeer() throws ClientProtocolException, IOException {
		// Given
	    HttpUriRequest request = new HttpDelete("http://localhost:8080/beers/1");
	    		
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	    // Then
	    assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NO_CONTENT));
	}
}
