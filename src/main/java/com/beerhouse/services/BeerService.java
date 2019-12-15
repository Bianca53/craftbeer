package com.beerhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.entities.Beer;
import com.beerhouse.exceptions.NotFoundException;
import com.beerhouse.repository.BeerRepository;

@Service
public class BeerService {
	
	@Autowired
	private BeerRepository beerRepository;
	
	
	public List<Beer> getBeers() {
		return beerRepository.findAll();
	}
	
	public Beer saveBeer(Beer beer) {
		return beerRepository.save(beer);
	}
	
	public Beer findBeerByID(Long id) {
		Beer beer = beerRepository.findOne(id);
		if (beer != null) {
			return beer;
		} else {
			throw new NotFoundException("Beer not found!");
		}
	}
	
	public void deleteBeer(Long id) {
		Beer beer = beerRepository.findOne(id);	
		if (beer != null) {
			beerRepository.delete(beer);
		} else {
			throw new NotFoundException("Beer not found!");
		}
	}
	
}
