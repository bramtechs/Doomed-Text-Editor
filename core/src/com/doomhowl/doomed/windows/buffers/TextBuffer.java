package com.doomhowl.doomed.windows.buffers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.ShapeDrawerRetriever;
import com.doomhowl.doomed.gfx.SkinManager;
import com.doomhowl.doomed.gfx.styling.WidgetStyler;
import com.doomhowl.doomed.logging.Alerts;
import com.doomhowl.doomed.utils.ActorInitializer;
import com.doomhowl.doomed.utils.InitMethod;
import com.doomhowl.doomed.windows.BufferWindow;

public class TextBuffer extends TextArea implements BufferInterface {
    private BufferWindow win;
    private FileHandle target;

    public TextBuffer() {
        super("", Assets.getSkin());
    }

    public void open(String path) {
        target = check(path);
    }

    @Override
    public void init() {
        WidgetStyler.patch(this);
    }

    @Override
    public void preInit(BufferWindow win) {
        this.win = win;
    }

    private FileHandle check(String path) {
        FileHandle handle = Gdx.files.absolute(path);
        if (!handle.exists()) {
            Alerts.errorNotFound(path);
            return null;
        }
        if (handle.isDirectory()) {
            win.openBuffer();
            return null;
        }
        return Gdx.files.absolute(path);
    }
}
