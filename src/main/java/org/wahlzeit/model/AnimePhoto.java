package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class AnimePhoto extends Photo {

	protected String seriesOfOrigin;
	protected String genre;

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
	public String getSeriesOfOrigin() {
		return seriesOfOrigin;
	}

	/**
	 * @methodtype set
	 */
	public void setSeriesOfOrigin(String newSeriesOfOrigin) {
		seriesOfOrigin = newSeriesOfOrigin;
	}

	/**
	 * @methodtype get
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @methodtype set
	 */
	public void setGenre(String newGenre) {
		genre = newGenre;
	}

}
