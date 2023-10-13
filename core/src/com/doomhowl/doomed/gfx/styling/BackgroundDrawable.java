package com.doomhowl.doomed.gfx.styling;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.doomhowl.doomed.gfx.SimpleDrawable;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class BackgroundDrawable extends SimpleDrawable {
    private final Color color;
    private Color borderColor;
    private int borderSize;

    public BackgroundDrawable(Color color, ShapeDrawer shapes) {
        super(shapes);
        this.color = color;
    }

    public BackgroundDrawable withBorder(Color color, int size) {
        borderColor = color;
        borderSize = size;
        return this;
    }

    public BackgroundDrawable withBorder(Color color) {
        return withBorder(color, 2);
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        Rectangle region = getRegion(x,y,width,height);
        shapes.setColor(color);
        shapes.filledRectangle(region);

        if (borderSize > 0 && borderColor != null) {
            shapes.setColor(borderColor);
            shapes.rectangle(region, borderSize);
        }
    }
}
