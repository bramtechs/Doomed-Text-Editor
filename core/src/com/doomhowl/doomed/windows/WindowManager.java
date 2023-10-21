package com.doomhowl.doomed.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doomhowl.doomed.windows.sides.FileTreeBuffer;
import com.doomhowl.doomed.windows.sides.MenuWindow;
import com.doomhowl.doomed.windows.sides.OutputWindow;

import java.util.HashMap;
import java.util.Map;

import static com.doomhowl.doomed.windows.ContainerLocation.*;

public class WindowManager extends Table {
    private final Map<ContainerLocation, Container<Window>> containers;

    public WindowManager() {
        containers = new HashMap<>();
        setFillParent(true);

        for (var l : ContainerLocation.values()) {
            containers.put(l, new Container<>());
        }

        // place the containers in the "spine"-table
        add(containers.get(TOP)).colspan(3).fill().row();

        add(containers.get(LEFT)).fill();
        add(containers.get(CENTER)).expand().fill();
        add(containers.get(RIGHT)).expand().fill().row();

        add(containers.get(BOTTOM)).fill().colspan(3);

        // default layout
        openWindow(new FileTreeBuffer(), LEFT);
        openWindow(new OutputWindow(), BOTTOM);
        openWindow(new MenuWindow(), RIGHT);
    }

    private void openWindow(Window window, ContainerLocation location) {
        Container<Window> cont = containers.get(location);

        // clear existing buffer of container if not the main center container
        if (location != CENTER) {
            cont.clear();
        }

        cont.fill();
        cont.setActor(window);
    }

    public void openBuffer() {
        BufferWindow buffer = new BufferWindow(false);
        openWindow(buffer, CENTER);
    }

    public void openScratchBuffer() {
        BufferWindow buffer = new BufferWindow(true);
        openWindow(buffer, CENTER);
    }

    public void openBuffer(FileHandle handle) {
        BufferWindow buffer = new BufferWindow(false);
        buffer.openBuffer(handle.path());
        openWindow(buffer, CENTER);
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.F6)) {
            openBuffer();
        }
        super.act(delta);
    }
}
