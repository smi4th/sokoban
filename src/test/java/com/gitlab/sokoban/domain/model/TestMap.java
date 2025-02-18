package com.gitlab.sokoban.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMap {

    @Test
    public void testPositionIsWall() {
        Tile[][] tiles = new Tile[3][3];
        tiles[1][1] = new Tile(new Position(1, 1), State.WALL);
        Map map = new Map(3, 3, tiles);
        map.getTile(new Position(1, 1)).setState(State.WALL);
        assertTrue(map.isWall(new Position(1, 1)), "Position with wall should return true");
    }

    @Test
    public void testPositionIsNotWall() {
        Tile[][] tiles = new Tile[3][3];
        tiles[1][1] = new Tile(new Position(1, 1), State.EMPTY);
        Map map = new Map(3, 3, tiles);
        map.getTile(new Position(1, 1)).setState(State.EMPTY);
        assertFalse(map.isWall(new Position(1, 1)), "Position without wall should return false");
    }

    @Test
    public void testPositionIsInside() {
        Tile[][] tiles = new Tile[3][3];
        Map map = new Map(3, 3, tiles);
        assertTrue(map.inside(new Position(1, 1)), "Position inside map should return true");
    }

    @Test
    public void testPositionIsNotInside() {
        Tile[][] tiles = new Tile[3][3];
        Map map = new Map(3, 3,tiles);
        assertFalse(map.inside(new Position(3, 3)), "Position outside map should return false");
    }

}