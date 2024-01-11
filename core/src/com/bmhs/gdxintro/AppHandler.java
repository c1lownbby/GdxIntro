package com.bmhs.gdxintro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	int x, y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		x = 0;
		y = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();

		checkInput();
	}

	public void checkInput() {
		/*
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			y += 10;
			// y = y + 10;

		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
			x -= 10;
			// y = y + 10;

		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			y -= 10;
			// y = y + 10;

		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			x += 10;
			// y = y + 10;

		}



		System.out.print(Gdx.input.getX() + " " + Gdx.input.getY()) ;

		x = Gdx.input.getX() - img.getWidth()/2;
		y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2;



		 */


		if(x < (Gdx.input.getX() - img.getWidth()/2)) {
			x+= 20;
		}
		if(x > (Gdx.input.getX() - img.getWidth()/2)) {
			x-= 20;
		}
		if(y < (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
			y+= 20;
		}
		if(y > (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
			y-= 20;
		}

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
