package com.doomhowl.doomed.windows.buffers;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.doomhowl.doomed.gfx.SkinManager;

public class ExplorerBuffer extends SelectBox<String> {
    public ExplorerBuffer() {
        super(SkinManager.getSkin());
    }

    @Override
    public void layout() {
        getStyle().background = null;
        super.layout();
    }
}
