package org.wahlzeit.model;

public interface Coordinate {

	/**
	 * @methodtype complex query
	 */
	double getDistance(Coordinate other) throws IllegalArgumentException;
	
	/**
	 * @methodtype boolean query
	 */
	boolean isEqual(Coordinate other);
}