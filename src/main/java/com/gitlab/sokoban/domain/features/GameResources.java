package com.gitlab.sokoban.domain.features;

import com.gitlab.sokoban.domain.model.Sokoban;

import java.io.IOException;

public interface GameResources {
    public Sokoban get() throws IOException;

}
