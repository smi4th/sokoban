package com.gitlab.sokoban.domain.model;

import java.util.Arrays;

public class Sokoban {
    final private Map map;
    final private Position[] storages;
    private Position player;

    public Sokoban(Map map, Position[] storages, Position player){
        this.map = map;
        this.storages = storages;
        this.player = player;
    }


    public Tile[][] getTiles(){
        return this.map.getTiles();

    public Boolean move(Direction direction){
        Position nextPosition = new Position(player.getX() + direction.getX(), player.getY() + direction.getY());
        if(map.isWall(nextPosition) || map.isStoredBox(nextPosition)){
            return false;
        }
        if(map.isBox(nextPosition)) {
            Position nextBoxPosition = new Position(nextPosition.getX() + direction.getX(), nextPosition.getY() + direction.getY());
            if (map.isWall(nextBoxPosition) || map.isBox(nextBoxPosition) || map.isStoredBox(nextBoxPosition)) {
                return false;
            }

            if (Arrays.asList(storages).contains(nextBoxPosition)) {
                map.getTile(nextPosition).setState(State.BOX_STORED);
            } else {
                map.getTile(nextPosition).setState(State.BOX);
            }
        }
        player = nextPosition;
        return true;
    }

    public Size getSize(){
        return this.map.getSize();
    }
}
