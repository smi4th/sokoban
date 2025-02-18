package com.gitlab.sokoban.domain.model;

public enum Direction {

    Up,
    Down,
    Left,
    Right;

    public int getX(){
        return switch (this) {
            case Left -> -1;
            case Right -> 1;
            default -> 0;
        };
    }

    public int getY(){
        return switch (this) {
            case Up -> -1;
            case Down -> 1;
            default -> 0;
        };
    }
}
