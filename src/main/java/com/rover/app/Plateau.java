package com.rover.app;

import lombok.Getter;

@Getter
public class Plateau {

    private int max_X;

    private int max_Y;

    public static Plateau from(int max_X, int max_Y) {
        return new Plateau(max_X, max_Y);
    }

    private Plateau(int max_X, int max_Y) {
        this.max_X = max_X;
        this.max_Y = max_Y;
    }

    public void checkXCoordinate(int x) {
        if (x < 0 || x > this.getMax_X()) {
            throw new RuntimeException("Not valid X coordinate. Coordinate Value X: "
                    + x + " Valid Interval: " + "[0," + getMax_X() + "]" + "[0," + getMax_Y() + "]");
        }
    }

    public void checkYCoordinate(int y) {
        if (y < 0 || y > this.getMax_Y()) {
            throw new RuntimeException("Not valid Y coordinate");
        }
    }
}
