package com.doomhowl.doomed.windows.buffers;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.styling.WidgetStyler;
import com.doomhowl.doomed.utils.ActorInitializer;
import com.doomhowl.doomed.utils.InitMethod;

public class ExplorerBuffer extends SelectBox<String> implements InitMethod {
    public ExplorerBuffer() {
        super(Assets.getSkin());
        ActorInitializer.init(this);
    }

    @Override
    public void init() {
        WidgetStyler.patch(this);
    }
}
