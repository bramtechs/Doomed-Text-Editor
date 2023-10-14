package com.doomhowl.doomed.gfx;

import com.badlogic.gdx.scenes.scene2d.Actor;

import com.doomhowl.doomed.stages.EditorStage;
import space.earlygrey.shapedrawer.AbstractShapeDrawer;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class ShapeDrawerRetriever {
    private final Actor owner;
    private ShapeDrawer cachedShapeDrawer;

    public ShapeDrawerRetriever(Actor owner) {
        this.owner = owner;
    }

    public ShapeDrawer getShapes() {
        if (cachedShapeDrawer == null) {
            if (owner.getStage() == null) {
                throw new IllegalStateException("Actor is not attached to a stage");
            }
            if (!(owner.getStage() instanceof EditorStage)) {
                throw new IllegalStateException("Actor was not added to EditorStage!");
            }
            cachedShapeDrawer = ((EditorStage) owner.getStage()).getShapes();
            if (cachedShapeDrawer == null) {
                throw new IllegalStateException("SpriteDrawer is not initialized yet!");
            }
        }
        return cachedShapeDrawer;
    }
}
