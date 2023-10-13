package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class TextureGenerator {
    public static Texture getWhitePixel() {
        Pixmap pix = new Pixmap(1,1, Pixmap.Format.RGBA8888);
        pix.setColor(Color.WHITE);
        pix.fill();
        Texture tex = new Texture(pix);
        pix.dispose();
        return tex;
    }
}
