package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class AnimeType implements AnimeTypeInterface {
	private String name;
	private String genre;
	private int numberOfEpisodes;
	
	public AnimeType(String name, String genre, int numberOfEpisodes) {
		super();
		this.name = name;
		this.genre = genre;
		this.numberOfEpisodes = numberOfEpisodes;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getNumberOfEpisodes() {
		return numberOfEpisodes;
	}
	public void setNumberOfEpisodes(int numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}
	
	
}
