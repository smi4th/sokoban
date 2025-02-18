package com.gitlab.sokoban.domain.model;

public class Tile {
    private Position position;
    private State state;

    public Tile(Position position, State state) {
        this.position = position;
        this.state = state;
    }

    public Position getPosition() {
        return position;
    }

    public State getState(){
        return state;
    }

    public void setState(State newState){
        state = newState;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return position.equals(tile.position) && state.equals(tile.state);
    }
}
