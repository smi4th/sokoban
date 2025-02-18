package com.gitlab.sokoban.domain.model;

public enum State {
    PLAYER,
    WALL,
    EMPTY,
    BOX,
    STORAGE,
    BOX_STORED;

    public char[] getSymbol() {
        return switch (this) {
            case PLAYER -> new char[]{'@'};
            case WALL -> new char[]{'#'};
            case EMPTY -> new char[]{' '};
            case BOX -> new char[]{'$'};
            case STORAGE -> new char[]{'.'};
            case BOX_STORED -> new char[]{'*'};
        };
    }
}
