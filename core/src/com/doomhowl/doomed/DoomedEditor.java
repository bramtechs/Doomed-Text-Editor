package com.doomhowl.doomed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.stages.EditorStage;

public class DoomedEditor extends Game {
	private EditorStage stage;
	private Assets assets;

	@Override
	public void create () {
		assets = new Assets();
		stage = new EditorStage();
		setScreen(stage);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		super.dispose();
		assets.dispose();
	}
}
