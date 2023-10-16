package com.doomhowl.doomed.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.styling.WidgetStyler;
import com.doomhowl.doomed.utils.ActorInitializer;
import com.doomhowl.doomed.utils.InitMethod;
import com.doomhowl.doomed.windows.buffers.BufferInterface;
import com.doomhowl.doomed.windows.buffers.ExplorerBuffer;
import com.doomhowl.doomed.windows.buffers.TextBuffer;

import java.util.LinkedList;
import java.util.Queue;

public class BufferWindow extends Window implements InitMethod {
    private final Queue<BufferInterface> queue;
    private String title = "(empty)";

    public BufferWindow(boolean scratch) {
        super("(empty)", Assets.getSkin());
        ActorInitializer.init(this);
        queue = new LinkedList<>();

        setMovable(false);
        setResizable(false);
        if (scratch) {
            openBuffer();
        } else {
            openExplorer();
        }
    }

    @Override
    public void act(float delta) {
        while (!queue.isEmpty()) {
            queue.remove().init();
        }
        getTitleLabel().setText(title);
        super.act(delta);
    }

    private <T extends BufferInterface> T openBuffer(T buffer) {
        queue.add(buffer);
        if (buffer instanceof Widget wid) {
            ScrollPane pane = new ScrollPane(wid, Assets.getSkin());
            add(pane).expand().fill();
        } else {
            throw new IllegalStateException("BufferInterface should be implemented on only Widgets!");
        }
        buffer.preInit(this);
        return buffer;
    }

    public void openBuffer(String buffer) {
        openBuffer(new TextBuffer()).open(buffer);
    }

    public void openBuffer() {
        openBuffer(new TextBuffer());
    }

    public void openExplorer(String path) {
        openBuffer(new ExplorerBuffer()).navigate(path);
    }

    public void openExplorer() {
        openExplorer(Gdx.files.getExternalStoragePath());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void init() {
        WidgetStyler.patch(this);
    }
}
