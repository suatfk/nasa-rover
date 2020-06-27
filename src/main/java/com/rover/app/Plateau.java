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

    public int reCalibreXCoordinate(int x) {
        if (x >= 0 && x <= this.getMax_X()){
            return x;
        }

        if (x < 0) {
            x += this.getMax_X();
        }

        x %= this.getMax_X();
        return x;
    }

    public int reCalibreYCoordinate(int y) {
        if (y >= 0 && y <= this.getMax_Y()){
            return y;
        }

        if (y < 0) {
            y += this.getMax_Y();
        }

        y %= this.getMax_Y();
        return y;
    }
}
