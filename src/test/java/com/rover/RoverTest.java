package com.rover;

import com.rover.app.Direction;
import com.rover.app.Plateau;
import com.rover.app.Rover;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoverTest {

    @Test
    public void givenValues_shouldCreate_Rover() {
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction d = Direction.valueOf("N");

        Rover rover = Rover.from(x, y, d, plateau);

        assertEquals(0, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals(d, rover.getHeading());
    }

    @Test
    public void givenRover_turnLeft_shouldChangeDirection() {
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction north = Direction.valueOf("N");
        Rover rover = Rover.from(x, y, north, plateau);

        rover.turnLeft();

        assertEquals(0, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals("W", rover.getHeading().name());
    }

    @Test
    public void givenRover_turnRight_shouldChangeDirection() {
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction north = Direction.valueOf("N");
        Rover rover = Rover.from(x, y, north, plateau);

        rover.turnRight();

        assertEquals(0, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals("E", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingWest_turnRight_shouldChangeDirectionToNorth() {
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction west = Direction.valueOf("W");
        Rover rover = Rover.from(x, y, west, plateau);

        rover.turnRight();

        assertEquals(0, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals("N", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingEast_move_shouldMoveToEast(){
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction east = Direction.valueOf("E");
        Rover rover = Rover.from(x, y, east, plateau);

        rover.move();

        assertEquals(1, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals("E", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingNorth_move_shouldMoveToNorth(){
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction north = Direction.valueOf("N");
        Rover rover = Rover.from(x, y, north, plateau);

        rover.move();

        assertEquals(0, rover.getX());
        assertEquals(5, rover.getY());
        assertEquals("N", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingSouth_move_shouldMoveSouth(){
        Plateau plateau = Plateau.from(5, 5);
        int x = 2;
        int y = 4;
        Direction south = Direction.valueOf("S");
        Rover rover = Rover.from(x, y, south, plateau);

        rover.move();

        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("S", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingWest_move_shouldMoveWest(){
        Plateau plateau = Plateau.from(5, 5);
        int x = 2;
        int y = 4;
        Direction west = Direction.valueOf("W");
        Rover rover = Rover.from(x, y, west, plateau);

        rover.move();

        assertEquals(1, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals("W", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingNegativeCoordinate_move_shouldRecalibrateCoordinate(){
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction west = Direction.valueOf("W");
        Rover rover = Rover.from(x, y, west, plateau);

        rover.move();

        assertEquals(4, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals("W", rover.getHeading().name());
    }

    @Test
    public void givenRoverHeadingResidueCoordinate_move_shouldRecalibrateCoordinate(){
        Plateau plateau = Plateau.from(5, 5);
        int x = 0;
        int y = 4;
        Direction west = Direction.valueOf("W");
        Rover rover = Rover.from(x, y, west, plateau);

        rover.turnRight();
        rover.move();

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals("N", rover.getHeading().name());
    }

}