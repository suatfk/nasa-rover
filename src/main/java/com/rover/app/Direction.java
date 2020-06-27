package com.rover.app;

import lombok.Getter;

@Getter
public enum Direction {

    N("NORTH", 0),
    E("EAST", 90),
    S("SOUTH", 180),
    W("WEST", 270);

    private String value;

    private int degree;

    Direction(String value, int degree) {
        this.value = value;
        this.degree = degree;
    }

    public static Direction fromDegree(int degree){
        switch (degree){
            case 0:
                return N;
            case 90:
                return E;
            case 180:
                return S;
            case 270:
                return W;
            default:
                throw new RuntimeException("not valid degree");
        }
    }
}
