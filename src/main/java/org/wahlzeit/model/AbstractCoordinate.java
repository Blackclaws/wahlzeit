package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	/**
	 * Helper class that serves as a generic cartesian container for distance measurements
	 */
	protected class CartesianContainer {
		double x;
		double y;
		double z;

		/**
		 * @methodtype query
		 */
		public int hashCode()
		{
			int hash = (int) Double.valueOf(x).hashCode();
			hash += hash*64 + Double.valueOf(y).hashCode();
			hash += hash*64 + Double.valueOf(z).hashCode();
			return hash;
		}

		/**
		 * @methodtype boolean query
		 */
		public boolean equals(Object other) {
			if (other instanceof CartesianContainer) {
				CartesianContainer otherContainer = (CartesianContainer) other;
				return (otherContainer.x == x && otherContainer.y == y && otherContainer.z == z);
			}
			return false;
		}
		
		/**
		 * @methodtype query
		 */
		public double getDistance(CartesianContainer other) throws IllegalArgumentException {
			if (other != null) {
				return Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2) + Math.pow((z - other.z), 2));
			} else {
				throw new IllegalArgumentException("Passed Argument was null value");
			}
		}
	}
	
	protected void assertClassInvariants()
	{
		assert(true);
	}
	
	protected void assertGetDistancePre()
	{
		assert(true);
	}
	
	protected void assertGetDistancePost()
	{
		assert(true);
	}

	/**
	 * @methodtype Constructor
	 */
	public AbstractCoordinate() {
		super();
	}

	/**
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate other) {
		return (getDistance(other) < 0.0001);
	}

	/**
	 * @methodtype query
	 */
	public double getDistance(Coordinate other) throws IllegalArgumentException {
		assertGetDistancePre();
		checkIsNull(other);
		if (other instanceof AbstractCoordinate) {
			CartesianContainer otherContainer = ((AbstractCoordinate) other).asCartesianContainer();
			return otherContainer.getDistance(this.asCartesianContainer());
		}
		assertGetDistancePost();
		assertClassInvariants();
		return Double.MAX_VALUE;
	}

	/**
	 * @methodtype assert
	 */
	protected void checkIsNull(Coordinate other) throws IllegalArgumentException {
		if (other == null) {
			throw new IllegalArgumentException("Other coordinate must not be null");
		}
	}

	/**
	 * @methodtype conversion/helper
	 */
	public abstract CartesianContainer asCartesianContainer();

}