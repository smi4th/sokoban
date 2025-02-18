package com.gitlab.sokoban.domain.model;

public class Tile {
    private Position tilePosition;
    private State tileState;

    public Tile(Position position, State state) {
        this.tilePosition = position;
        this.tileState = state;
    }

    public State state(){
        return tileState;
    }

    public void setState(State newState){
        tileState = newState;
    }

    public Position position(){
        return tilePosition;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return tilePosition.equals(tile.tilePosition) && tileState.equals(tile.tileState);
    }
}
