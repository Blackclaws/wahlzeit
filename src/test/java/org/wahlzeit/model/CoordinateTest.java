package org.wahlzeit.model;

import org.junit.Test;


import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

	private Coordinate coordinateCenter;
	private Coordinate coordinateOne;
	private Coordinate coordinateTwo;
	private Coordinate coordinateThree;

	@Before
	public void initCoordinate() {
		coordinateCenter = new Coordinate(0,0);
		coordinateOne = new Coordinate(5.5,10.5);
		coordinateTwo = new Coordinate(-5.5,-10.5);
		coordinateThree = new Coordinate(-10.5,10.5);
	}
	
	/**
	 *
	 */
	@Test
	public void testLongitudinalDistance() {
		assertEquals(coordinateCenter.getLongitudinalDistance(coordinateOne),10.5,0);
		assertEquals(coordinateCenter.getLongitudinalDistance(coordinateTwo),10.5,0);
		assertEquals(coordinateOne.getLongitudinalDistance(coordinateTwo),21,0);
	}
	
	@Test
	public void testLatitudinalDistance() {
		assertEquals(coordinateCenter.getLatitudinalDistance(coordinateOne),5.5,0);
		assertEquals(coordinateCenter.getLatitudinalDistance(coordinateTwo),5.5,0);
		assertEquals(coordinateOne.getLatitudinalDistance(coordinateTwo),11,0);
	}
	
	@Test
	public void testDistance() {
		assertEquals(coordinateOne.getDistance(coordinateThree).getLatitude(),16,0);
		assertEquals(coordinateOne.getDistance(coordinateThree).getLongitude(),0,0);
		
		assertEquals(coordinateOne.getDistance(coordinateTwo).getLatitude(),11,0);
		assertEquals(coordinateOne.getDistance(coordinateTwo).getLongitude(),21,0);
		
		assertEquals(coordinateTwo.getMeterDistance(coordinateThree), 2377262,1);
	}
	
	@Test
	public void testEquals() {
		assertEquals(coordinateCenter, coordinateCenter);
		assertEquals(coordinateOne, coordinateOne);
		assertEquals(coordinateCenter, new Coordinate());
		assertThat(coordinateCenter, not(equalTo(coordinateOne)));
		assertThat(coordinateOne, not(equalTo(coordinateTwo)));
		assertThat(coordinateCenter, not(equalTo(null)));
	}
	
	@Test
	public void nullCoordinateShouldThrowException() {
		try
		{
			coordinateCenter.getLongitudinalDistance(null);
			fail("getLongitudinalDistance should throw when passed null");
		}
		catch(IllegalArgumentException e){}
		try
		{
			coordinateCenter.getLatitudinalDistance(null);
			fail("getLatitudinalDistance should throw when passed null");
		}
		catch(IllegalArgumentException e){}
		try
		{
			coordinateCenter.getDistance(null);
			fail("getDistance should throw when passed null");
		}
		catch(IllegalArgumentException e){}	
	}
	@Test(expected = IllegalArgumentException.class)
	public void usingResultShouldThrowException() {
		coordinateThree.getDistance(coordinateOne.getDistance(coordinateTwo));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeLatShouldThrowException() {
		new Coordinate(120,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tooSmallLatShouldThrowException() {
		new Coordinate(-120,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeLonShouldThrowException() {
		new Coordinate(0,200);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tooSmallLonShouldThrowException() {
		new Coordinate(0,-200);
	}
	
}
