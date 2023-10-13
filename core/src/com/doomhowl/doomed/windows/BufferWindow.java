package com.doomhowl.doomed.windows;

import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doomhowl.doomed.gfx.SkinManager;
import com.doomhowl.doomed.windows.comps.TextBuffer;

public class BufferWindow extends Window {
    private final TextBuffer buffer;

    public BufferWindow() {
        super("Empty Buffer", SkinManager.getSkin());
        buffer = new TextBuffer();
        add(buffer).expand().fill();
    }
}
