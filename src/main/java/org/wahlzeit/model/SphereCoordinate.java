package org.wahlzeit.model;

import java.io.Serializable;

/**
 * The coordinate class used for storing geolocations.
 * 
 * @author Felix
 *
 */
public class SphereCoordinate extends AbstractCoordinate implements Serializable, Coordinate {
	double latitude;
	double longitude;
	double radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphereCoordinate() {
		super();
		latitude = 0;
		longitude = 0;
		radius = 0;
	}
	/**
	 * @methodtype constructor
	 */
	public SphereCoordinate(double lat, double lon, double radius) {
		if (-90 > lat || lat > 90) {
			throw new IllegalArgumentException("Latitude needs to be between -90 and 90 is:" + lat);
		}
		if (-180 > lon || lon > 180) {
			throw new IllegalArgumentException("Longitude needs to be between -180 and 180 is:" + lon);
		}
		if(!(radius >= 0))
		{
			throw new IllegalArgumentException("Radius needs to not be smaller than 0" + lon);
		}
		latitude = lat;
		longitude = lon;
		this.radius = radius;
	}
	
	/**
	 * @methodtype query
	 */
	public int hashCode()
	{
		int hash = (int) Double.valueOf(latitude).hashCode();
		hash += hash*64 + Double.valueOf(longitude).hashCode();
		return hash;
	}

	/**
	 * @methodtype boolean query
	 */
	public boolean equals(Object other) {
		if (other instanceof SphereCoordinate) {
			SphereCoordinate otherCoord = (SphereCoordinate) other;
			return (otherCoord.getLatitude() == latitude && otherCoord.getLongitude() == longitude);
		}
		return false;
	}
	
	/**
	 * @methodtype query
	 */
	public double getHaversineDistance(SphereCoordinate other)
	{
		double lat1Rad = Math.PI * latitude / 180;
		double lon1Rad = Math.PI * longitude / 180;
		double lat2Rad = Math.PI * other.getLatitude() / 180;
		double lon2Rad = Math.PI * other.getLongitude() / 180;
	
		return Math.acos(Math.sin(lat1Rad) * Math.sin(lat2Rad)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.cos(lon2Rad - lon1Rad)) * radius;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype primitive query
	 */
	public double getLatitudinalDistance(SphereCoordinate other) throws IllegalArgumentException {
		checkIsNull(other);
		return Math.abs(other.getLatitude() - latitude);
	}

	/**
	 * @methodtype primitive query
	 */
	public double getLongitudinalDistance(SphereCoordinate other) throws IllegalArgumentException {
		checkIsNull(other);
		return Math.abs(other.getLongitude() - longitude);
	}
	
	protected void assertAsCartesianPreAndPost()
	{
		assert(!(-90 > latitude || latitude > 90));
		assert(!(-180 > longitude || longitude > 90));
		assert(!(radius < 0));
	}
	
	@Override
	public CartesianContainer asCartesianContainer() {
		assertAsCartesianPreAndPost();
		CartesianContainer container = new CartesianContainer();
		container.x = radius * Math.cos(Math.toRadians(latitude));
		container.y = radius * Math.sin(Math.toRadians(latitude))*Math.cos(Math.toRadians(longitude));
		container.z = radius * Math.sin(Math.toRadians(latitude))*Math.sin(Math.toRadians(longitude));
		assertAsCartesianPreAndPost();
		assertClassInvariants();
		return container;
	}
}
