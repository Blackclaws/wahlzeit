package org.wahlzeit.model;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class AnimeEpisode implements AnimeTypeInterface {
	
	@Id Long id;
	@Load Ref<AnimeType> type;
	
	private int runtime;
	private int episodeNumber;
	private String subGroup;
	
	public AnimeEpisode(AnimeType type, int runtime, int episodeNumber, String subGroup) {
		super();
		this.type = Ref.create(type);
		this.runtime = runtime;
		this.episodeNumber = episodeNumber;
		this.subGroup = subGroup;
	}

	public String getName()
	{
		if(type.get() != null)
		{
			return type.get().getName();
		}
		return null;
	}
	
	public String getGenre()
	{
		if(type.get() != null)
		{
			return type.get().getGenre();
		}
		return null;
	}
	
	public int getNumberOfEpisodes()
	{
		if(type.get() != null)
		{
			return type.get().getNumberOfEpisodes();
		}
		return -1;
	}
	
	public AnimeType getType() {
		return type.get();
	}
	
	public void setType(AnimeType type) {
		this.type = Ref.create(type);
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
