package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TextBufferStyle extends TextField.TextFieldStyle {
    public TextBufferStyle(TextField.TextFieldStyle baseStyle) {
        super(baseStyle);
    }

    class Background extends SimpleDrawable {

        @Override
        public void draw(Batch batch, float x, float y, float width, float height) {

        }
    }
}
