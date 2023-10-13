package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinManager {
    private static final String DEFAULT_SKIN_FILE = "./skins/default/skin/uiskin.json";
    private static SkinManager instance;
    private Skin activeSkin;

    private SkinManager() {
        if (instance != null) {
            throw new IllegalStateException("SkinManager already exists!");
        }
        instance = this;
    }

    public static Skin getSkin() {
        if (ins().activeSkin == null) {
            FileHandle handle = Gdx.files.internal(DEFAULT_SKIN_FILE);
            ins().activeSkin = new Skin(handle);
        }
        return ins().activeSkin;
    }

    private static SkinManager ins() {
        if (instance == null) {
            instance = new SkinManager();
        }
        return instance;
    }
}
