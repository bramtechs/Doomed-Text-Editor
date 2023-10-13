package com.doomhowl.doomed.windows;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doomhowl.doomed.gfx.ShapeDrawerRetriever;
import com.doomhowl.doomed.gfx.SkinManager;
import com.doomhowl.doomed.gfx.styling.BackgroundDrawable;
import com.doomhowl.doomed.windows.buffers.ExplorerBuffer;
import com.doomhowl.doomed.windows.buffers.TextBuffer;

public class BufferWindow extends Window {
    private final Widget buffer;
    private final ShapeDrawerRetriever shapes;

    public BufferWindow(boolean scratch) {
        super("Empty Buffer", SkinManager.getSkin());
        setMovable(false);
        setResizable(false);

        shapes = new ShapeDrawerRetriever(this);
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
        BackgroundDrawable bg = new BackgroundDrawable(Color.BLACK, shapes.getShapes()).withBorder(Color.DARK_GRAY);
        bg.setTopHeight(getTitleLabel().getHeight());
        setBackground(bg);
        super.layout();
    }
}
