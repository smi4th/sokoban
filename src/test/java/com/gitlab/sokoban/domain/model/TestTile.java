package com.gitlab.sokoban.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTile {

    // Position et état égal
    @Test
    public void testTwoTilesAreEquals() {
        Position pos1 = new Position(1,2);
        Position pos2 = new Position(1, 2);

        Tile tile1 = new Tile(pos1, State.PLAYER);
        Tile tile2 = new Tile(pos2, State.PLAYER);

        assertEquals(tile1, tile2, "Tiles with same position and state should be equal");
    }

    // Position et état pas égal
    @Test
    public void testTwoTilesPositionStateAreNotEquals(){
        Position pos1 = new Position(1,3);
        Position pos2 = new Position(1, 2);

        Tile tile1 = new Tile(pos1, State.PLAYER);
        Tile tile2 = new Tile(pos2, State.WALL);

        assertNotEquals(tile1, tile2, "Tiles with different position and state should not be equal");
    }

}