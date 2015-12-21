package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Anime implements AnimeTypeInterface {
	
	private AnimeType type;
	
	private int runtime;
	private int episodeNumber;
	private String subGroup;
	
	public Anime(AnimeType type, int runtime, int episodeNumber, String subGroup) {
		super();
		this.type = type;
		this.runtime = runtime;
		this.episodeNumber = episodeNumber;
		this.subGroup = subGroup;
	}

	public String getName()
	{
		return type.getName();
	}
	
	public String getGenre()
	{
		return type.getGenre();
	}
	
	public int getNumberOfEpisodes()
	{
		return type.getNumberOfEpisodes();
	}
	
	public AnimeType getType() {
		return type;
	}
	public void setType(AnimeType type) {
		this.type = type;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getEpisodeNumber() {
		return episodeNumber;
	}
	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	public String getSubGroup() {
		return subGroup;
	}
	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}
	
	
}
