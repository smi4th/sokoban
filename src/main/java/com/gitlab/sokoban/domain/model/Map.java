package com.gitlab.sokoban.domain.model;

import java.util.Arrays;

public class Map {
    private Size size;
    private Tile[][] tiles;

    public Map(Size size, Tile[][] tiles) {
        this.size = size;
        this.tiles = tiles;
    }

    public Tile getTile(Position position) {
        return tiles[position.getY()][position.getX()];
    }

    public Size getSize(){
        return size;
    }

    public Tile[][] getTiles(){
        return tiles;
    }

    public boolean isWall(Position position) {
        return getTile(position).state() == State.WALL;
    }
    public boolean isBox(Position position) { return getTile(position).getState() == State.BOX; }
    public boolean isStoredBox(Position position) {return getTile(position).getState() == State.BOX_STORED; }

    public boolean inside(Position position) {
        return position.getX() >= 0 && position.getX() < size.getWidth() &&
               position.getY() >= 0 && position.getY() < size.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;

        return Arrays.deepEquals(tiles, map.tiles);
    }
}
