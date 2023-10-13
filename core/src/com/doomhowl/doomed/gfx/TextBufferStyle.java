package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class TextBufferStyle extends TextField.TextFieldStyle {
    public TextBufferStyle(ShapeDrawer shapes, TextField.TextFieldStyle baseStyle) {
        super(baseStyle);
        background = new Background(Color.BLACK, shapes);
    }

    static class Background extends SimpleDrawable {
        private final Color color;

        public Background(Color color, ShapeDrawer shapes) {
            super(shapes);
            this.color = color;
        }

        @Override
        public void draw(Batch batch, float x, float y, float width, float height) {
            shapes.setColor(color);
            shapes.filledRectangle(x, y, width, height);
        }
    }
}
