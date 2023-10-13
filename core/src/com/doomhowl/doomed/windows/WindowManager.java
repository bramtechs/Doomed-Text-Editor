package com.doomhowl.doomed.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import java.util.HashSet;
import java.util.Set;

public class WindowManager extends Table {
    private final Set<Window> windows;

    public WindowManager() {
        windows = new HashSet<>();
        setFillParent(true);
    }

    public void openWindow(Window window) {
        windows.add(window);
        add(window).expand().fill();
    }

    public void openBuffer() {
        BufferWindow buffer = new BufferWindow(false);
        openWindow(buffer);
    }

    public void openScratchBuffer() {
        BufferWindow buffer = new BufferWindow(true);
        openWindow(buffer);
    }

    public void openBuffer(FileHandle handle) {
        throw new IllegalStateException("Not implemented!");
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.F6)) {
            openBuffer();
        }
        super.act(delta);
    }
}
