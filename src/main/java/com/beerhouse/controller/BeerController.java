package com.beerhouse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.entities.Beer;
import com.beerhouse.requests.BeerRequest;
import com.beerhouse.services.BeerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value="API REST BeerHouse")
@RestController
@RequestMapping("/beers")
public class BeerController {
	@Autowired
	private BeerService beerService;
	
	@ApiOperation(value="Return a list of all beers")
	@ApiResponse(code = 200, message = "Successfully retrieved list")
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public List<Beer> getAllBeers() {
		return beerService.getBeers();
	}	
	
	@ApiOperation(value="Return a beer object given a specific ID")
	@GetMapping(path="/{id}", produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Beer> getBeer(@PathVariable Long id) {
		Beer beer = beerService.findBeerByID(id);
		return new ResponseEntity<Beer>(beer, HttpStatus.OK);	
	}	
	
	@ApiOperation(value="Create a new beer")
	@PostMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
    public ResponseEntity<Beer> insertBeer(@Valid @RequestBody BeerRequest beerRequest) {
		Beer beer = new Beer();
		beer.setName(beerRequest.getName());
		beer.setIngredients(beerRequest.getIngredients());
		beer.setAlcoholContent(beerRequest.getAlcoholContent());
		beer.setPrice(beerRequest.getPrice());
		beer.setCategory(beerRequest.getCategory());
		
		return new ResponseEntity<Beer>(HttpStatus.CREATED);
    }
	
	@ApiOperation(value="Update a beer object given a specific ID as parameter")
	@PutMapping(path="/{id}", consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Beer> updateBeer(@PathVariable Long id,@Valid @RequestBody BeerRequest beerRequest) {
		Beer beer = beerService.findBeerByID(id);
		beer.setName(beerRequest.getName());
		beer.setIngredients(beerRequest.getIngredients());
		beer.setAlcoholContent(beerRequest.getAlcoholContent());
		beer.setPrice(beerRequest.getPrice());
		beer.setCategory(beerRequest.getCategory());
		beerService.saveBeer(beer);
		return new ResponseEntity<Beer>(HttpStatus.OK);
	}
	
	@ApiOperation(value="Update a beer object given a specific ID as parameter")
	@PatchMapping(path="/{id}", consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Beer> updatePartialBeer(@PathVariable Long id,@Valid @RequestBody BeerRequest beerRequest) {
		Beer beer = beerService.findBeerByID(id);
		beer.setName(beerRequest.getName());
		beer.setIngredients(beerRequest.getIngredients());
		beer.setAlcoholContent(beerRequest.getAlcoholContent());
		beer.setPrice(beerRequest.getPrice());
		beer.setCategory(beerRequest.getCategory());
		beerService.saveBeer(beer);
		
		return new ResponseEntity<Beer>(HttpStatus.OK);
	}
	
	@ApiOperation(value="Delete a beer object given a specific ID as parameter")
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Beer> deleteBeer(@PathVariable Long id) {
		beerService.deleteBeer(id);
		return new ResponseEntity<Beer>(HttpStatus.NO_CONTENT);
	}
}
