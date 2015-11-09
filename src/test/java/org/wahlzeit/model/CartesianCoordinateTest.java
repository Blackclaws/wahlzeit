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
public class CartesianCoordinateTest {

    private CartesianCoordinate coordinateCenter;
    private CartesianCoordinate coordinateOne;

    @Before
    public void initCoordinate() {
	coordinateCenter = new CartesianCoordinate(0,0,0);
	coordinateOne = new CartesianCoordinate(10,10,10);
    }

    @Test
    public void testDistance() {
	assertEquals(coordinateCenter.getDistance(coordinateOne), 17.32, 0.001);
    }

    @Test
    public void testEquals() {
	assertEquals(coordinateCenter, coordinateCenter);
	assertEquals(coordinateOne, coordinateOne);
	assertEquals(coordinateOne, new CartesianCoordinate(10,10,10));
    }

    @Test
    public void nullCoordinateShouldThrowException() {
	try {
	    coordinateCenter.getDistance(null);
	    fail("getDistance should throw when passed null");
	} catch (IllegalArgumentException e) {
	}
    }
}
