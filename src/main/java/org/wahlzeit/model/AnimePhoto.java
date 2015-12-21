package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index=true)
public class AnimePhoto extends Photo {

	Anime origin = null;

	/**
	 * @methodtype constructor
	 */
	public AnimePhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public AnimePhoto(PhotoId myId) {
		super(myId);
	}

	/**
	 * @methodtype get
	 */
	public Anime getAnime() {
		return origin;
	}

	/**
	 * @methodtype set
	 */
	public void setAnime(Anime anime) {
		this.origin = anime;
		incWriteCount();
	}

}
