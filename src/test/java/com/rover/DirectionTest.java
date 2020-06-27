package com.rover;


import com.rover.app.Direction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DirectionTest {

    @Test
    public void givenValueN_shouldCreate_NorthDirection(){
        Direction d = Direction.valueOf("N");

        assertEquals("NORTH", d.getValue());
        assertEquals(0, d.getDegree());
    }

    @Test
    public void givenValueE_shouldCreate_EastDirection(){
        Direction d = Direction.valueOf("E");

        assertEquals("EAST", d.getValue());
        assertEquals(90, d.getDegree());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidValue_shouldThrow_exception(){
        Direction d = Direction.valueOf("invalid");

    }

    @Test
    public void givenSouthDegree_shouldReturn_SouthDirection(){
        Direction d = Direction.fromDegree(180);

        assertEquals("SOUTH", d.getValue());
        assertEquals(180, d.getDegree());
    }

}