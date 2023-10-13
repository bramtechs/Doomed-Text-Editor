package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import space.earlygrey.shapedrawer.ShapeDrawer;

public abstract class SimpleDrawable implements Drawable {
    protected final ShapeDrawer shapes;
    private final Rectangle region;
    private float padLeft;
    private float padRight;
    private float padTop;
    private float padBot;

    private float minWidth;
    private float minHeight;

    public SimpleDrawable(ShapeDrawer shapes) {
        this.shapes = shapes;
        this.region = new Rectangle();
    }

    protected Rectangle getRegion(float x, float y, float width, float height) {
        float w = Math.max(minWidth, width - padRight);
        float h = Math.max(minHeight, height - padTop);
        region.set(x + padLeft, y + padBot, w, h);
        return region;
    }

    @Override
    public float getLeftWidth() {
        return this.padLeft;
    }

    @Override
    public void setLeftWidth(float leftWidth) {
        this.padLeft = leftWidth;
    }

    @Override
    public float getRightWidth() {
        return this.padRight;
    }

    @Override
    public void setRightWidth(float rightWidth) {
        this.padRight = rightWidth;
    }

    @Override
    public float getTopHeight() {
        return this.padTop;
    }

    @Override
    public void setTopHeight(float topHeight) {
        this.padTop = topHeight;
    }

    @Override
    public float getBottomHeight() {
        return this.padBot;
    }

    @Override
    public void setBottomHeight(float bottomHeight) {
        this.padBot = bottomHeight;
    }

    @Override
    public float getMinWidth() {
        return minWidth;
    }

    @Override
    public void setMinWidth(float minWidth) {
        this.minWidth = minWidth;
    }

    @Override
    public float getMinHeight() {
        return this.minHeight;
    }

    @Override
    public void setMinHeight(float minHeight) {
        this.minHeight = minHeight;
    }
}
