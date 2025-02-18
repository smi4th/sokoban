package com.gitlab.sokoban.domain.features;

import com.gitlab.sokoban.domain.livingdoc.Feature;
import com.gitlab.sokoban.domain.model.Direction;
import com.gitlab.sokoban.domain.model.Sokoban;

@Feature
public class Game {
    GameResources gameResources;

    public Game(GameResources gameResources){
        this.gameResources = gameResources;
    }

    public Sokoban current() throws Exception {
        return gameResources.get();
    }

    public void execute(Direction direction) throws Exception {
        Sokoban sokoban = gameResources.get();
        sokoban.move(direction);
        sokoban.apply();

        if(sokoban.hasWon()){
            throw new Exception("You win!");
        }

    }

}
