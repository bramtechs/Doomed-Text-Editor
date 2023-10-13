package com.doomhowl.doomed.stages;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.doomhowl.doomed.gfx.TextureGenerator;
import com.doomhowl.doomed.windows.BufferWindow;
import com.doomhowl.doomed.windows.WindowManager;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.Objects;

public class EditorStage extends Stage implements Screen {
    private ShapeDrawer shapes;
    private Texture pixelTexture;
    private WindowManager wm;

    public EditorStage(){
        super(new ScreenViewport());
    }

    @Override
    public void show() {
        // initialize shape drawer
        pixelTexture = TextureGenerator.getWhitePixel();
        shapes = new ShapeDrawer(getBatch(), new TextureRegion(pixelTexture));

        wm = new WindowManager();
        // show scratchpad
        wm.openBuffer();
        addActor(wm);
    }

    @Override
    public void render(float delta) {
        act(delta);
        draw();
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
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

    @Override
    public void dispose() {
        pixelTexture.dispose();
        super.dispose();
    }

    public ShapeDrawer getShapes() {
        return Objects.requireNonNull(shapes);
    }
}
