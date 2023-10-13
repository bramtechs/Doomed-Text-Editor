package com.doomhowl.doomed.windows.buffers;

import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.doomhowl.doomed.gfx.ShapeDrawerRetriever;
import com.doomhowl.doomed.gfx.SkinManager;

public class TextBuffer extends TextArea {
    private final ShapeDrawerRetriever shapes;
    public TextBuffer() {
        super("", SkinManager.getSkin());
        shapes = new ShapeDrawerRetriever(this);
    }

    @Override
    public void layout() {
        getStyle().background = null;
        super.layout();
    }
}
