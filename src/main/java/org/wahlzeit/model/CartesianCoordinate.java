package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

	protected CartesianContainer coordinates = new CartesianContainer();;
	
	public CartesianCoordinate() {
		super();
	}
	
	public CartesianCoordinate(double x, double y, double z) {
		super();
		coordinates.x = x;
		coordinates.y = y;
		coordinates.z = z;
	}
	
	/**
	 * @methodtype query
	 */
	public int hashCode()
	{
		int hash = coordinates.hashCode();
		return hash;
	}

	/**
	 * @methodtype boolean query
	 */
	public boolean equals(Object other) {
		if (other instanceof CartesianCoordinate) {
			return coordinates.equals(((CartesianCoordinate) other).coordinates);
		}
		return false;
	}
	
	@Override
	public CartesianContainer asCartesianContainer() {
		return coordinates;
	}

}
