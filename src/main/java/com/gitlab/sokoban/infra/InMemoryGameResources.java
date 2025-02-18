package com.gitlab.sokoban.infra;



import com.gitlab.sokoban.domain.features.GameResources;
import com.gitlab.sokoban.domain.livingdoc.Stub;
import com.gitlab.sokoban.domain.model.Map;
import com.gitlab.sokoban.domain.model.MapBuilder;
import com.gitlab.sokoban.domain.model.Sokoban;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Stub
public class InMemoryGameResources implements GameResources {
    @Override
    public Sokoban get() throws IOException {



        String stringMap =
                "     #####          \n" +
                "     #   #          \n" +
                "     #$  #          \n" +
                "   ###  $##         \n" +
                "   #  $ $ #         \n" +
                " ### # ## #   ######\n" +
                " #   # ## #####  ..#\n" +
                " # $  $          ..#\n" +
                " ##### ### #@##  ..#\n" +
                "     #     #########\n" +
                "     #######          ";
        System.out.println(stringMap);
        Map map = MapBuilder.build(stringMap);
        return new Sokoban(map,null,null);
    }
}


