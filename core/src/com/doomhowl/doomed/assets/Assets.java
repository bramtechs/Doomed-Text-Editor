package com.doomhowl.doomed.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashSet;
import java.util.Set;

public class Assets extends AssetManager {
    private static Assets instance;
    private static final Set<Asset<?>> assets = new HashSet<>();

    // === Declare all the assets below ===
    public static Asset<Skin> default_skin = Asset.of("skins/default/skin/uiskin.json", Skin.class);
    public static FontAsset default_font = FontAsset.of("fonts/SpaceMono-Regular.ttf");

    public Assets() {
        instance = this;

        // Setup AssetManager to load dynamic fonts
        FileHandleResolver resolver = new InternalFileHandleResolver();
        setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        for (Asset<?> a: assets) {
            a.load(this);
        }
        finishLoading();
    }

    public static Skin getSkin() {
        return default_skin.get();
    }

    <T> T getOrThrow(String file, Class<T> clazz) {
        if (!isLoaded(file)) {
            throw new IllegalStateException("Asset not loaded!\n" + this);
        }
        return get(file, clazz);
    }

    static Assets getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Assets not loaded!");
        }
        return instance;
    }

    static void addAsset(Asset<?> a) {
        assets.add(a);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Asset loader with assets:").append("\n");
        for (String name: this.getAssetNames()) {
            builder.append("--> ").append(name).append("\n");
        }
        return builder.toString();
    }
}
