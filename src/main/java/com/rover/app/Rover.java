package com.rover.app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rover {

    private int X;

    private int Y;

    private Direction heading;

    private Plateau plateau;

    public static Rover from(int x, int y, Direction heading, Plateau plateau) {
        return new Rover(x, y, heading, plateau);
    }

    private Rover(int x, int y, Direction heading, Plateau plateau) {
        X = x;
        Y = y;
        this.heading = heading;
        this.plateau = plateau;
    }

    public void turnLeft() {
        this.setHeading(getNewDirection(-90));
    }

    public void turnRight() {
        this.setHeading(getNewDirection(90));
    }

    public void move() {
        internalMove();
        reCalibrateCoordinates();
    }

    public void printCoordinates() {
        System.out.println(getX() + " " + getY() + " " + getHeading());
    }

    private void reCalibrateCoordinates() {
        setX(plateau.reCalibreXCoordinate(getX()));
        setY(plateau.reCalibreYCoordinate(getY()));
    }

    private void internalMove() {
        switch (getHeading()) {
            case N:
                setY(getY() + 1);
                break;
            case S:
                setY(getY() - 1);
                break;
            case E:
                setX(getX() + 1);
                break;
            case W:
                setX(getX() - 1);
                break;
            default:
                throw new RuntimeException("not Valid Heading");
        }
    }


    private Direction getNewDirection(int degreeToTurn) {
        int newHeading = (this.getHeading().getDegree() + degreeToTurn);
        if (newHeading < 0) {
            newHeading += 360;
        }
        newHeading %= 360;
        return Direction.fromDegree(newHeading);
    }

}
