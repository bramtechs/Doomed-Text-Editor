package com.doomhowl.doomed.stages;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.doomhowl.doomed.windows.BufferWindow;

public class EditorStage extends Stage implements Screen {

    public EditorStage(){
        super(new ScreenViewport());
    }

    @Override
    public void show() {
        // show scratchpad
        BufferWindow buffer = new BufferWindow();
        addActor(buffer);
    }

    @Override
    public void render(float delta) {
        act(delta);
        draw();
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
