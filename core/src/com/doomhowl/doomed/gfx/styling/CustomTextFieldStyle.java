package com.doomhowl.doomed.gfx.styling;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class CustomTextFieldStyle extends TextField.TextFieldStyle {
    public CustomTextFieldStyle(ShapeDrawer shapes, TextField.TextFieldStyle baseStyle) {
        super(baseStyle);
        background = new BackgroundDrawable(Color.BLACK, shapes);
    }
}
