package com.rover.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlateauTest {

    @Test(expected = Exception.class)
    public void givenInvalidXCoordinate_check_shouldThrowException() {
        Plateau plateau = Plateau.from(5, 5);

        plateau.checkXCoordinate(-1);
        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void givenInvalidYCoordinate_check_shouldThrowException() {
        Plateau plateau = Plateau.from(5, 5);

        plateau.checkYCoordinate(-1);
        Assert.fail();
    }

    @Test
    public void givenValidXCoordinate_check_shouldNotThrowException() {
        Plateau plateau = Plateau.from(5, 5);

        plateau.checkXCoordinate(5);
    }

    @Test
    public void givenValidYCoordinate_check_shouldNotThrowException() {
        Plateau plateau = Plateau.from(5, 5);

        plateau.checkYCoordinate(0);
    }

    @Test(expected = Exception.class)
    public void givenExceedXCoordinate_check_shouldThrowException() {
        Plateau plateau = Plateau.from(5, 5);

        plateau.checkXCoordinate(6);
        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void givenExceedYCoordinate_check_shouldThrowException() {
        Plateau plateau = Plateau.from(5, 5);

        plateau.checkYCoordinate(6);
        Assert.fail();
    }
}