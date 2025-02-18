package com.gitlab.sokoban.domain.model;

public class MapBuilder {

    public MapBuilder() {}

    public static Map build(String map) {
        Tile[][] tiles = toTiles(map);
        Size size = new Size(tiles[0].length, tiles.length);
        return new Map(size, tiles);
    }

    public static Tile[][] toTiles(String map) {
        String[] lines = map.split("\n");
        Tile[][] tiles = new Tile[lines.length][lines[0].length()];
        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                tiles[y][x] = new Tile(new Position(x, y), toState(lines[y].charAt(x)));
            }
        }
        return tiles;
    }

    private static State toState(char c) {
        return switch (c) {
            case '@' -> State.PLAYER;
            case '#' -> State.WALL;
            case ' ' -> State.EMPTY;
            case '$' -> State.BOX;
            case '.' -> State.STORAGE;
            case '*' -> State.BOX_STORED;
            default -> throw new IllegalArgumentException("Invalid character: " + c);
        };
    }

}
