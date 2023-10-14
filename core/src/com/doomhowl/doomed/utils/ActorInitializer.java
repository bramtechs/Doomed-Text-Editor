package com.doomhowl.doomed.utils;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorInitializer extends Action {
    private boolean initialized = false;
    private final InitMethod init;

    private ActorInitializer(InitMethod init) {
        this.init = init;
    }

    @Override
    public boolean act(float delta) {
        if (!initialized) {
            init.init();
            initialized = true;
        }
        return initialized;
    }

    public static void init(Actor a) {
        if (a instanceof InitMethod init) {
            a.addAction(new ActorInitializer(init));
        } else {
            throw new IllegalArgumentException("Actor needs to have the InitMethod interface!");
        }
    }
}
