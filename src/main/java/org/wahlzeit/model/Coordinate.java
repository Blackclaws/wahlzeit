package org.wahlzeit.model;

/**
 * The coordinate class used for storing geolocations.
 * @author Felix
 *
 */
public class Coordinate {
	double latitude;
	double longitude;
	
	public Coordinate()
	{
		latitude = 0;
		longitude = 0;
	}
	
	public Coordinate(double lat, double lon) throws IllegalArgumentException
	{
		if(lat > 90 || lat < -90)
		{
			throw new IllegalArgumentException("Latitude needs to be between -90 and 90 is:" + lat);
		}
		if(lon > 180 || lon < -180)
		{
			throw new IllegalArgumentException("Longitude needs to be between -180 and 180 is:" + lon);
		}
		latitude = lat;
		longitude = lon;
	}
	
	public boolean equals(Object other)
	{
		if(other instanceof Coordinate)
		{
			Coordinate otherCoord = (Coordinate) other;
			if(otherCoord.getLatitude() != latitude || otherCoord.getLongitude() != longitude)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		return false;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public Coordinate getDistance(Coordinate other) throws IllegalArgumentException
	{
		double latDiff = getLatitudinalDistance(other);
		double lonDiff = getLongitudinalDistance(other);
		
		return new Coordinate(latDiff, lonDiff);
	}
	
	public double getLatitudinalDistance(Coordinate other) throws IllegalArgumentException
	{
		if(other == null)
		{
			throw new IllegalArgumentException("Other coordinate must not be null");
		}
		return Math.abs(other.getLatitude() - latitude);
	}
	
	public double getLongitudinalDistance(Coordinate other) throws IllegalArgumentException
	{
		if(other == null)
		{
			throw new IllegalArgumentException("Other coordinate must not be null");
		}
		return Math.abs(other.getLongitude() - longitude);
	}
}
