package com.gitlab.sokoban.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPosition {

    @Test
    public void testPositionsAreEqual() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        assertEquals(pos1, pos2, "Positions with the same coordinates should be equal");
    }

    @Test
    public void testPositionsAreNotEqual() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(2, 3);
        assertNotEquals(pos1, pos2, "Positions with different coordinates should not be equal");
    }

}