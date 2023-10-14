package com.doomhowl.doomed.assets;

public class Asset<T> {
    final String file;
    final Class<T> clazz;
    protected Assets assets;

    protected Asset(String file, Class<T> clazz) {
        this.file = file;
        this.clazz = clazz;
        Assets.addAsset(this);
    }

    void load(Assets assets) {
        this.assets = assets;
        loadImpl(assets);
    }

    protected void loadImpl(Assets assets) {
        assets.load(file, clazz);
    }

    public T get() {
        return assets.getOrThrow(file, clazz);
    }

    public static <T> Asset<T> of(String file, Class<T> clazz) {
        return new Asset<>(file, clazz);
    }
}
