package com.gitlab.sokoban.domain.model;

public class Sokoban {
    private Map map;
    private Position[] storages;
    private Position player;

    public Sokoban(Map map, Position[] storages, Position player){
        this.map = map;
        this.storages = storages;
        this.player = player;
    }


}
