package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

public class StageBackground extends Widget {
    private final ShapeDrawerRetriever shapes;
    public StageBackground() {
        shapes = new ShapeDrawerRetriever(this);
        setFillParent(true);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        toBack();
        shapes.getShapes().filledRectangle(getX(), getY(), getWidth(), getHeight(), Color.DARK_GRAY);
        super.draw(batch, parentAlpha);
    }
}
