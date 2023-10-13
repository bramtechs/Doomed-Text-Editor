package com.doomhowl.doomed.windows.comps;

import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.doomhowl.doomed.gfx.ShapeDrawerRetriever;
import com.doomhowl.doomed.gfx.SkinManager;
import com.doomhowl.doomed.gfx.TextBufferStyle;

public class TextBuffer extends TextArea {
    private final ShapeDrawerRetriever shapes;
    public TextBuffer() {
        super("", SkinManager.getSkin());
        shapes = new ShapeDrawerRetriever(this);
    }

    @Override
    public void layout() {
        TextBufferStyle style = new TextBufferStyle(shapes.getShapes(),getStyle());
        setStyle(style);
        super.layout();
    }
}
