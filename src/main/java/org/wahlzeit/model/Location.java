package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {
	protected String name = "";
	protected Coordinate coordinate = new Coordinate();

	/**
	 * @methodtype constructor
	 */
	public Location() {

	}

	/**
	 * @methodtype constructor
	 */
	public Location(String myName) {
		this.name = myName;
	}

	/**
	 * @methodtype constructor
	 */
	public Location(Coordinate myCoordinate) {
		coordinate = myCoordinate;
	}

	/**
	 * @methodtype constructor
	 */
	public Location(String myName, Coordinate myCoordinate) {
		name = myName;
		coordinate = myCoordinate;
	}

	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate newCoordinate) {
		coordinate = newCoordinate;
	}

	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}

	/**
	 * @methodtype set
	 */
	public void setName(String newName) {
		name = newName;
	}

}
