package com.gitlab.sokoban.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMapBuilder {

    @Test
    public void testMapBuilder() {
        String a =
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
        Tile[][] tiles = MapBuilder.toTiles(a);
        assertEquals(State.EMPTY, tiles[0][0].state(), "Tile 0,0 should be empty");

    }

}
