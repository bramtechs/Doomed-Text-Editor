package com.doomhowl.doomed.windows;

import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.styling.WidgetStyler;
import com.doomhowl.doomed.windows.buffers.ExplorerBuffer;
import com.doomhowl.doomed.windows.buffers.TextBuffer;

public class BufferWindow extends Window {
    private final Widget buffer;

    public BufferWindow(boolean scratch) {
        super("Empty Buffer", Assets.getSkin());
        setMovable(false);
        setResizable(false);
        if (scratch) {
            buffer = new TextBuffer();
            setTitle("Scratchpad"); // TODO: make buffers change the window title
        } else {
            buffer = new ExplorerBuffer();
            setTitle("Explorer");
        }
        add(buffer).expand().fill();
    }

    private void setTitle(String title) {
        getTitleLabel().setText(title);
    }

    @Override
    public void layout() {
        WidgetStyler.patch(this);
        super.layout();
    }
}
