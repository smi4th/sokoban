package com.gitlab.sokoban.domain.model;

public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    public int getX(){
        return switch (this) {
            case LEFT -> -1;
            case RIGHT -> 1;
            default -> 0;
        };
    }

    public int getY(){
        return switch (this) {
            case UP -> -1;
            case DOWN -> 1;
            default -> 0;
        };
    }
}
