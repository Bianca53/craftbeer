package com.beerhouse.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.beerhouse.entities.Beer;

public interface BeerRepository extends CrudRepository<Beer, Long> {
	@Override
    List<Beer> findAll();
}
