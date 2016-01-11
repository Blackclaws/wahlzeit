package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index=true)
public class AnimePhoto extends Photo {

	AnimeEpisode origin = null;

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
	public AnimeEpisode getAnime() {
		return origin;
	}

	/**
	 * @methodtype set
	 */
	public void setAnime(AnimeEpisode anime) {
		this.origin = anime;
		incWriteCount();
	}

}
