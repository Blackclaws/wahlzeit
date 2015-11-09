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

    private Coordinate coordinateCenterSphere;
    private Coordinate coordinateCenterCartesian;
    private Coordinate coordinateOneSphere;
    private Coordinate coordinateOneCartesian;

    @Before
    public void initCoordinate() {
	coordinateCenterSphere = new SphereCoordinate(0, 0, 0);
	coordinateOneSphere = new SphereCoordinate(0, 0, 10);
	coordinateCenterCartesian = new CartesianCoordinate(0,0,0);
	coordinateOneCartesian = new CartesianCoordinate(10,0,0);
    }

   

    @Test
    public void testDistance() {
	assertEquals(coordinateCenterCartesian.getDistance(coordinateCenterSphere), 0, 0);
	assertEquals(coordinateCenterCartesian.getDistance(coordinateOneSphere), 10, 0);
	assertEquals(coordinateCenterCartesian.getDistance(coordinateOneSphere), coordinateCenterSphere.getDistance(coordinateOneCartesian), 0);
	assertEquals(coordinateCenterCartesian.getDistance(coordinateOneSphere), coordinateOneSphere.getDistance(coordinateCenterSphere), 0);
    }

    @Test
    public void testIsEqual() {
    	assertTrue(coordinateCenterCartesian.isEqual(coordinateCenterSphere));
    	assertTrue(coordinateOneCartesian.isEqual(coordinateOneSphere));
    }

    @Test
    public void nullCoordinateShouldThrowException() {
	try {
	    coordinateCenterSphere.getDistance(null);
	    fail("getDistance should throw when passed null");
	} catch (IllegalArgumentException e) {
	}
	try {
	    coordinateCenterCartesian.getDistance(null);
	    fail("getDistance should throw when passed null");
	} catch (IllegalArgumentException e) {
	}
    }

}
