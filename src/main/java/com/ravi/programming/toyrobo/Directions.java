package com.ravi.programming.toyrobo;

public enum Directions {
    EAST("EAST"),
    WEST("WEST"),
    NORTH("NORTH"),
    SOUTH("SOUTH");

    Directions(String direction) {
        this.direction = direction;
    }

    public final String direction;
}
