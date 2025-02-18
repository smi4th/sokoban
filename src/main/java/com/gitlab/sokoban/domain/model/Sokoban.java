package com.gitlab.sokoban.domain.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class Sokoban {
    private Map map;
    private Position[] storages;
    private Position[] boxes;
    private Position player;

    public Sokoban(Map map, Position[] storages,Position[] boxes, Position player){
        this.map = map;
        this.storages = storages;
        this.boxes = boxes;
        this.player = player;
    }

    public Tile[][] getTiles() {
        return this.map.getTiles();
    }

    public Size getSize(){
        return this.map.getSize();
    }

    public Boolean canMove(Direction direction){
        Position nextPosition = new Position(player.getX() + direction.getX(), player.getY() + direction.getY());
        if (map.isWall(nextPosition)) {
            return false;
        }
        if (map.isBox(nextPosition)) {
            Position nextBoxPosition = new Position(nextPosition.getX() + direction.getX(), nextPosition.getY() + direction.getY());
            if (map.isWall(nextBoxPosition) || map.isBox(nextBoxPosition)) {
                return false;
            }
        }
        return true;
    }

    public void move(Direction direction){
        if(canMove(direction)){
            Position nextPosition = new Position(player.getX() + direction.getX(), player.getY() + direction.getY());
            if (map.isBox(nextPosition)) {
                Position nextBoxPosition = new Position(nextPosition.getX() + direction.getX(), nextPosition.getY() + direction.getY());
                for (int i = 0; i < boxes.length; i++) {
                    if (boxes[i].equals(nextPosition)) {
                        boxes[i] = nextBoxPosition;
                    }
                }
            }
            player = nextPosition;
        }
    }

    public boolean hasWon(){
        for (Position storage : storages) {
            boolean hasBox = false;
            for (Position box : boxes) {
                if (storage.equals(box)) {
                    hasBox = true;
                }
            }
            if (!hasBox) {
                return false;
            }
        }
        return true;
    }

    public void apply(){
        for (int y = 0; y < map.getSize().getHeight(); y++) {
            for (int x = 0; x < map.getSize().getWidth(); x++) {
                if(map.getTile(new Position(x,y)).state() != State.WALL){
                    map.getTile(new Position(x,y)).setState(State.EMPTY);
                }
            }
        }
        for (Position storage : storages) {
            map.getTile(storage).setState(State.STORAGE);
        }
        for (Position box : boxes) {
            map.getTile(box).setState(State.BOX);
        }
        map.getTile(player).setState(State.PLAYER);
    }
}
