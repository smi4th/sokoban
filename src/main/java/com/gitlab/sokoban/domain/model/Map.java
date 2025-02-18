package com.gitlab.sokoban.domain.model;

public class Map {
    private int width;
    private int height;

    private Tile[][] tiles;

    public Map(int width, int height, Tile[][] tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }

    public Tile getTile(Position position) {
        return tiles[position.getY()][position.getX()];
    }

    public boolean isWall(Position position) {
        return getTile(position).getState() == State.WALL;
    }

    public boolean inside(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }
}
