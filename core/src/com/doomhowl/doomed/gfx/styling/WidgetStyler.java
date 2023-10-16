package com.doomhowl.doomed.gfx.styling;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.gfx.ShapeDrawerRetriever;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class WidgetStyler {

    private WidgetStyler() {
    }

    private static ShapeDrawer shapes(Actor actor) {
        return new ShapeDrawerRetriever(actor).getShapes();
    }

    public static void patch(TextField field) {
        field.getStyle().background = new BackgroundDrawable(Color.BLACK, shapes(field));
        field.getStyle().font = Assets.default_font.get();
    }

    public static void patch(List<?> list) {
        list.getStyle().background = new BackgroundDrawable(Color.BLACK, shapes(list));
        list.getStyle().font = Assets.default_font.get();
    }

    public static void patch(SelectBox<?> box) {
        box.getStyle().background = new BackgroundDrawable(Color.BLACK, shapes(box));
        box.getStyle().font = Assets.default_font.get();
    }

    public static void patch(Window window) {
        BackgroundDrawable bg = new BackgroundDrawable(Color.BLACK, shapes(window)).withBorder(Color.DARK_GRAY);
        bg.setTopHeight(window.getTitleLabel().getHeight());
        window.setBackground(bg);
    }
}
