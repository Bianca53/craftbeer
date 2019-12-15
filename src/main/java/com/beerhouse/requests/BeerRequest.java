package com.beerhouse.requests;

import javax.validation.constraints.NotNull;

public class BeerRequest {
	@NotNull(message="Name can not be null!")
	private String name;
	@NotNull(message="ingredients can not be null!")
	private String ingredients;
	@NotNull(message="alcoholContent can not be null!")
	private String alcoholContent;
	@NotNull(message="price can not be null!")
	private double price;
	@NotNull(message="category can not be null!")
	private String category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getAlcoholContent() {
		return alcoholContent;
	}
	public void setAlcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
