package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.doomhowl.doomed.assets.Assets;

public class SkinManager {
    private SkinManager() {
    }

    @Deprecated
    public static Skin getSkin() {
        return Assets.getSkin();
    }
}
