package com.rover.app;

import com.rover.app.Plateau;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PlateauTest {

    @Test
    public void givenXCoordinate_reCalibre_shouldCalibreXCoordinate() {
        Plateau plateau = Plateau.from(5, 5);

        int calibratedXCoordinate = plateau.reCalibreXCoordinate(-1);
        assertEquals(4, calibratedXCoordinate);
    }

    @Test
    public void givenYCoordinate_reCalibre_shouldCalibreYCoordinate() {
        Plateau plateau = Plateau.from(5, 5);

        int calibratedXCoordinate = plateau.reCalibreYCoordinate(-1);
        assertEquals(4, calibratedXCoordinate);
    }

    @Test
    public void givenXCoordinate_reCalibre_shouldCalibreXCoordinate_1() {
        Plateau plateau = Plateau.from(12, 5);

        int calibratedXCoordinate = plateau.reCalibreXCoordinate(-4);
        assertEquals(8, calibratedXCoordinate);
    }

    @Test
    public void givenXCoordinate_reCalibre_shouldCalibreXCoordinateToZero() {
        Plateau plateau = Plateau.from(12, 5);

        int calibratedXCoordinate = plateau.reCalibreXCoordinate(-12);
        assertEquals(0, calibratedXCoordinate);
    }

    @Test
    public void givenXCoordinate_reCalibre_shouldCalibreXCoordinateToOne() {
        Plateau plateau = Plateau.from(12, 5);

        int calibratedXCoordinate = plateau.reCalibreXCoordinate(-11);
        assertEquals(1, calibratedXCoordinate);
    }

    @Test
    public void givenYCoordinate_reCalibre_shouldCalibreYCoordinateToOne() {
        Plateau plateau = Plateau.from(12, 5);

        int calibratedXCoordinate = plateau.reCalibreYCoordinate(6);
        assertEquals(1, calibratedXCoordinate);
    }

    @Test
    public void givenYCoordinate_reCalibre_shouldCalibreYCoordinateToMaxValue() {
        Plateau plateau = Plateau.from(12, 5);

        int calibratedXCoordinate = plateau.reCalibreYCoordinate(5);
        assertEquals(5, calibratedXCoordinate);
    }

}