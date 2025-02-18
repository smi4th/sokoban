package com.gitlab.sokoban.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMapBuilder {

    @Test
    public void testMapBuilder() {
        Tile[][] tiles = MapBuilder.toTiles("#\n.\n@\n$\n*\n ");
        assertEquals(State.WALL, tiles[0][0].getState(), "Tile 0,0 should be a wall");
        assertEquals(State.STORAGE, tiles[1][0].getState(), "Tile 0,1 should be a storage");
        assertEquals(State.PLAYER, tiles[2][0].getState(), "Tile 0,2 should be a player");
        assertEquals(State.BOX, tiles[3][0].getState(), "Tile 0,3 should be a box");
        assertEquals(State.BOX_STORED, tiles[4][0].getState(), "Tile 0,4 should be a stored box");
        assertEquals(State.EMPTY, tiles[5][0].getState(), "Tile 0,5 should be empty");
    }

}
