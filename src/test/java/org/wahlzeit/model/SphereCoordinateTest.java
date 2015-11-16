package org.wahlzeit.model;

import org.junit.Test;
import org.wahlzeit.model.AbstractCoordinate.CartesianContainer;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Test cases for the Coordinate class.
 */
public class SphereCoordinateTest {

    private SphereCoordinate coordinateCenter;
    private SphereCoordinate coordinateOne;
    private SphereCoordinate coordinateTwo;
    private SphereCoordinate coordinateThree;

    @Before
    public void initCoordinate() {
	coordinateCenter = new SphereCoordinate(0, 0, 6371000);
	coordinateOne = new SphereCoordinate(5.5, 10.5, 6371000);
	coordinateTwo = new SphereCoordinate(-5.5, -10.5, 6371000);
	coordinateThree = new SphereCoordinate(-10.5, 10.5, 6371000);
    }

    /**
     *
     */
    @Test
    public void testLongitudinalDistance() {
	assertEquals(coordinateCenter.getLongitudinalDistance(coordinateOne), 10.5, 0);
	assertEquals(coordinateCenter.getLongitudinalDistance(coordinateTwo), 10.5, 0);
	assertEquals(coordinateOne.getLongitudinalDistance(coordinateTwo), 21, 0);
    }

    @Test
    public void testLatitudinalDistance() {
	assertEquals(coordinateCenter.getLatitudinalDistance(coordinateOne), 5.5, 0);
	assertEquals(coordinateCenter.getLatitudinalDistance(coordinateTwo), 5.5, 0);
	assertEquals(coordinateOne.getLatitudinalDistance(coordinateTwo), 11, 0);
    }

    @Test
    public void testDistance() {
	assertEquals(coordinateTwo.getDistance(coordinateThree), 634893, 1);
    }
    
    @Test
    public void testAsCartesian()
    {
    	CartesianContainer internal = coordinateCenter.asCartesianContainer();
    	assertEquals(internal.x, 6371000, 0);
    	assertEquals(internal.y, 0, 0);
    	assertEquals(internal.z, 0, 0);
    }

    @Test
    public void testEquals() {
	assertEquals(coordinateCenter, coordinateCenter);
	assertEquals(coordinateOne, coordinateOne);
	assertEquals(coordinateCenter, new SphereCoordinate());
	assertThat(coordinateCenter, not(equalTo(coordinateOne)));
	assertThat(coordinateOne, not(equalTo(coordinateTwo)));
	assertThat(coordinateCenter, not(equalTo(null)));
    }

    @Test
    public void nullCoordinateShouldThrowException() {
	try {
	    coordinateCenter.getLongitudinalDistance(null);
	    fail("getLongitudinalDistance should throw when passed null");
	} catch (IllegalArgumentException e) {
	}
	try {
	    coordinateCenter.getLatitudinalDistance(null);
	    fail("getLatitudinalDistance should throw when passed null");
	} catch (IllegalArgumentException e) {
	}
	try {
	    coordinateCenter.getDistance(null);
	    fail("getDistance should throw when passed null");
	} catch (IllegalArgumentException e) {
	}
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLargeLatShouldThrowException() {
	new SphereCoordinate(120, 0, 6375000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooSmallLatShouldThrowException() {
	new SphereCoordinate(-120, 0, 6375000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLargeLonShouldThrowException() {
	new SphereCoordinate(0, 200, 6375000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooSmallLonShouldThrowException() {
	new SphereCoordinate(0, -200, 6375000);
    }
}
