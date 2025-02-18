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
    public boolean isBox(Position position) { return getTile(position).state() == State.BOX; }
    public boolean isStoredBox(Position position) {return getTile(position).state() == State.BOX_STORED; }
    public Position getPlayerPosition() {
        for (int y = 0; y < size.getHeight(); y++) {
            for (int x = 0; x < size.getWidth(); x++) {
                if (tiles[y][x].state() == State.PLAYER) {
                    return new Position(x, y);
                }
            }
        }
        return null;
    }

    public Position[] getStorages() {
        Position[] storages = new Position[size.getWidth() * size.getHeight()];
        int storageIndex = 0;
        for (int y = 0; y < size.getHeight(); y++) {
            for (int x = 0; x < size.getWidth(); x++) {
                if (tiles[y][x].state() == State.STORAGE || tiles[y][x].state() == State.BOX_STORED) {
                    storages[storageIndex++] = new Position(x, y);
                }
            }
        }
        return Arrays.copyOf(storages, storageIndex);
    }

    public Position[] getBoxes() {
        Position[] boxes = new Position[size.getWidth() * size.getHeight()];
        int boxIndex = 0;
        for (int y = 0; y < size.getHeight(); y++) {
            for (int x = 0; x < size.getWidth(); x++) {
                if (tiles[y][x].state() == State.BOX || tiles[y][x].state() == State.BOX_STORED) {
                    boxes[boxIndex++] = new Position(x, y);
                }
            }
        }
        return Arrays.copyOf(boxes, boxIndex);
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < size.getHeight(); y++) {
            for (int x = 0; x < size.getWidth(); x++) {
                sb.append(tiles[y][x].state().getSymbol());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
