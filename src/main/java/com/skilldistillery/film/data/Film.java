package com.skilldistillery.film.data;

import java.util.List;

public class Film {
	private int length;
	private String rating, title, description;
	public Film(int length, String rating, String title, String description, List<Actor> cast) {
		super();
		this.length = length;
		this.rating = rating;
		this.title = title;
		this.description = description;
		this.cast = cast;
	}
	public Film(){
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Actor> getCast() {
		return cast;
	}
	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	private List<Actor>cast;
}
	
