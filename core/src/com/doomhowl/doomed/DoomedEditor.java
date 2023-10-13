package com.doomhowl.doomed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.doomhowl.doomed.stages.EditorStage;

public class DoomedEditor extends Game {
	private EditorStage stage;
	
	@Override
	public void create () {
		stage = new EditorStage();
		setScreen(stage);
		Gdx.input.setInputProcessor(stage);
	}
}
