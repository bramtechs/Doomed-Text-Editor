package com.doomhowl.doomed.stages;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.StageBackground;
import com.doomhowl.doomed.gfx.TextureGenerator;
import com.doomhowl.doomed.windows.WindowManager;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.Objects;

public class EditorStage extends Stage implements Screen {
    private ShapeDrawer shapes;
    private final StageBackground bg;
    private final WindowManager wm;

    public EditorStage(){
        super(new ScreenViewport());
        wm = new WindowManager();
        bg = new StageBackground();
    }

    @Override
    public void show() {
        addActor(bg);

        // initialize shape drawer
        Texture pixelTexture = Assets.disposable(TextureGenerator.getWhitePixel());
        shapes = new ShapeDrawer(getBatch(), new TextureRegion(pixelTexture));

        // show default layout
        wm.openScratchBuffer();
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
        super.dispose();
    }

    public ShapeDrawer getShapes() {
        return Objects.requireNonNull(shapes);
    }
}
