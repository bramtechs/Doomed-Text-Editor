package com.doomhowl.doomed.assets;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import static com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.*;

public class FontAsset extends Asset<BitmapFont> {
    private static final int DEFAULT_SIZE = 14;
    protected FontAsset(String file) {
        super(file, BitmapFont.class);
    }

    public BitmapFont get(int size) {
        String name = genName(size);

        // get or load font
        BitmapFont font;
        if (assets.isLoaded(name)) {
            font = assets.get(name);
        } else {
            font = loadNow(size);
        }

        return font;
    }

    @Override
    protected void loadImpl(Assets assets) {
        assets.load(file, clazz, genConfig(DEFAULT_SIZE));
    }

    private BitmapFont loadNow(int size) {
        String name = genName(size);
        assets.load(name, BitmapFont.class, genConfig(size));
        assets.finishLoading();
        return assets.get(name);
    }

    private String genName(int size) {
        if (size == DEFAULT_SIZE) {
            return file;
        }
        return new FileHandle(file).pathWithoutExtension() + size + ".ttf";
    }

    private FreeTypeFontLoaderParameter genConfig(int size) {
        FreeTypeFontLoaderParameter fontConfig = new FreeTypeFontLoaderParameter();
        fontConfig.fontFileName = genName(size);
        fontConfig.fontParameters.size = size;
        return fontConfig;
    }

    public static FontAsset of(String file) {
        return new FontAsset(file);
    }
}
