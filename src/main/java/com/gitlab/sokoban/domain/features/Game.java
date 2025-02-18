package com.gitlab.sokoban.domain.features;

import com.gitlab.sokoban.domain.livingdoc.Feature;
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

}
