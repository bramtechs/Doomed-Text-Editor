package com.doomhowl.doomed.windows.buffers;

import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.ShapeDrawerRetriever;
import com.doomhowl.doomed.gfx.SkinManager;
import com.doomhowl.doomed.gfx.styling.WidgetStyler;
import com.doomhowl.doomed.utils.ActorInitializer;
import com.doomhowl.doomed.utils.InitMethod;

public class TextBuffer extends TextArea implements InitMethod {

    public TextBuffer() {
        super("", Assets.getSkin());
        ActorInitializer.init(this);
    }

    @Override
    public void init() {
        WidgetStyler.patch(this);
    }
}
