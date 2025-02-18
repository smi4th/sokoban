package com.gitlab.sokoban.infra;



import com.gitlab.sokoban.domain.features.GameResources;
import com.gitlab.sokoban.domain.livingdoc.Stub;
import com.gitlab.sokoban.domain.model.Map;
import com.gitlab.sokoban.domain.model.MapBuilder;
import com.gitlab.sokoban.domain.model.Position;
import com.gitlab.sokoban.domain.model.Sokoban;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Stub
public class InMemoryGameResources implements GameResources {
    private Map map;
    public Position[] storages;
    public Position[] boxes;
    public Position player;
    public Sokoban sok;

    public InMemoryGameResources() throws IOException {
        String mapString = Files.readString(Path.of("map.txt"));
        map = new MapBuilder().build(mapString);
        this.storages = map.getStorages();
        this.boxes = map.getBoxes();
        this.player = map.getPlayerPosition();
        this.sok = new Sokoban(map,storages,boxes,player);
    }

    @Override
    public Sokoban get() throws IOException {
        return sok;
    }
}


