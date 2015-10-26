package org.wahlzeit.model;

/**
 * The coordinate class used for storing geolocations.
 * @author Felix
 *
 */
public class Coordinate {
	double latitude;
	double longitude;
	boolean isResult;
	
	public Coordinate()
	{
		latitude = 0;
		longitude = 0;
	}
	
	public Coordinate(double lat, double lon)
	{
		this(lat,lon,false);
	}
	
	public Coordinate(double lat, double lon, boolean is_result) throws IllegalArgumentException
	{
		if(!is_result)
		{
			if(lat > 90 || lat < -90)
			{
				throw new IllegalArgumentException("Latitude needs to be between -90 and 90 is:" + lat);
			}
			if(lon > 180 || lon < -180)
			{
				throw new IllegalArgumentException("Longitude needs to be between -180 and 180 is:" + lon);
			}
		}
		latitude = lat;
		longitude = lon;
		isResult = is_result;
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
	
	public double getMeterDistance(Coordinate other) throws IllegalArgumentException
	{
		checkIsValid(other);
		double lat1_rad = Math.PI*latitude/180;
		double lon1_rad = Math.PI*longitude/180;
		double lat2_rad = Math.PI*other.getLatitude()/180;
		double lon2_rad = Math.PI*other.getLongitude()/180;
		
		return Math.acos(Math.sin(lat1_rad)*Math.sin(lat2_rad) + Math.cos(lat1_rad)*Math.cos(lat2_rad)*Math.cos(lon2_rad-lon1_rad))*6371000;
	}
	
	public Coordinate getDistance(Coordinate other) throws IllegalArgumentException
	{
		checkIsValid(other);
		double latDiff = getLatitudinalDistance(other);
		double lonDiff = getLongitudinalDistance(other);
		
		return new Coordinate(latDiff, lonDiff, true);
	}
	
	public double getLatitudinalDistance(Coordinate other) throws IllegalArgumentException
	{
		checkIsValid(other);
		return Math.abs(other.getLatitude() - latitude);
	}
	
	public double getLongitudinalDistance(Coordinate other) throws IllegalArgumentException
	{
		checkIsValid(other);
		return Math.abs(other.getLongitude() - longitude);
	}
	
	private void checkIsValid(Coordinate other) throws IllegalArgumentException
	{
		if(other == null)
		{
			throw new IllegalArgumentException("Other coordinate must not be null");
		}
		if(other.isResult)
		{
			throw new IllegalArgumentException("Do not reuse coordinates returned from Coordinate::getDistance() they are not coordinates!");
		}
	}
}
