package com.doomhowl.doomed.windows.buffers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.styling.WidgetStyler;
import com.doomhowl.doomed.logging.Alerts;
import com.doomhowl.doomed.windows.BufferWindow;

// Extend from custom-made SearchBox
public class ExplorerBuffer extends List<FileHandle> implements BufferInterface {
    private BufferWindow win;

    public ExplorerBuffer() {
        super(Assets.getSkin());
    }

    @Override
    public void preInit(BufferWindow win) {
        this.win = win;
        this.win.setTitle("Explore");
    }

    @Override
    public void init() {
        WidgetStyler.patch(this);
    }

    public void navigate(String path) {
        FileHandle handle = Gdx.files.absolute(path);
        if (!handle.exists()) {
            Alerts.errorNotFound(path);
            return;
        }

        if (handle.isDirectory()) {
            construct(handle);
        } else {
            win.openBuffer(path);
        }
    }

    private void construct(FileHandle handle) {
        win.setTitle("Explore " + handle.toString());
        clear();

        FileHandle[] files = handle.list();
        setItems(files);
        pack();
    }
}
