package com.doomhowl.doomed.windows.comps;

import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.doomhowl.doomed.gfx.SkinManager;
import com.doomhowl.doomed.gfx.TextBufferStyle;

public class TextBuffer extends TextArea {
    public TextBuffer() {
        super("", SkinManager.getSkin());

        TextBufferStyle style = new TextBufferStyle(getStyle());
        setStyle(style);
    }
}
