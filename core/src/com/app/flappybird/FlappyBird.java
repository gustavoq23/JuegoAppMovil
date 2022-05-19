package com.app.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import states.GameStateManager;
import states.MenuState;

public class FlappyBird extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 720;
	public static final String TITLE =  "FlappyBird para android";
	private Music music;

	private GameStateManager gsm;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
		setUpMusic();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 0, 1);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();

	}
	private void setUpMusic(){
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
	}
}
