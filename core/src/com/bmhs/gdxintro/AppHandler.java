package com.bmhs.gdxintro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.utils.TileHandler;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture img;
	//TextureRegion subImg;

	int x, y;



	int[][] worldIntArray = {{6,6,6,6,0,0,0,0,6,6,6,6,6,6,6,6,0,0,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,6,0,3,3,3,3,0,6,6,6,6,6,6,0,3,3,3,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,3,3,3,3,3,3,0,6,6,6,6,0,3,3,3,3,3,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,1,0,0,3,3,3,3,0,0,0,0,0,0,0,3,3,3,3,0,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,1,1,1,0,3,3,3,3,3,3,3,3,3,3,3,3,3,0,1,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,1,1,1,0,3,1,1,1,3,3,3,3,3,3,3,3,3,0,1,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,3,1,3,1,1,1,1,1,1,3,3,3,3,3,3,3,3,3,0,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,0,1,1,1,1,1,1,1,1,1,3,3,3,3,3,3,3,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,6,0,1,1,1,0,0,0,1,1,1,1,1,3,3,0,0,0,1,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,6,0,1,1,0,0,1,1,0,1,1,1,1,1,0,1,1,0,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,6,0,1,1,0,0,1,1,0,1,1,1,1,1,0,1,1,0,0,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,0,0,0,3,1,0,0,0,1,1,1,3,0,1,1,0,0,0,1,3,0,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,3,3,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,0,3,3,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,3,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {0,3,0,3,1,1,1,1,3,1,0,1,1,1,1,1,0,1,1,1,1,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,0,0,1,1,1,1,0,3,3,0,1,1,1,1,1,0,1,1,0,1,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,1,0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
							 {6,6,6,0,0,3,0,1,1,3,3,3,3,3,1,1,1,1,3,0,6,6,6,6,6,6,6,6,6,5,6,6,6,6,6,6,6,6,6,6},
							 {6,5,6,0,3,3,3,0,0,0,0,0,0,0,0,0,0,3,3,3,0,6,6,6,5,6,6,6,5,6,6,6,6,6,5,6,6,6,5,6},
							 {5,5,5,5,0,0,0,5,5,5,5,5,5,5,5,5,5,0,0,0,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}};


	//int[][] worldIntArray = new int[12][20];


	@Override
	public void create () {
		batch = new SpriteBatch();

		x = 0;
		y = 0;
		/*
		pick a random [r][c] in array and drop one pixel
		 */
	}
/*
	private void setRandomArray () {
		for(int r = 0; r < worldIntArray.length; r++) {
			for(int c = 0; c < worldIntArray[r].length; c++) {
				worldIntArray[r][c] = MathUtils.random(4);
			}
		}
	}

 */

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		for(int r = 0; r < worldIntArray.length; r++) {
			for(int c = 0; c < worldIntArray[r].length; c++) {
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(worldIntArray[r][c]).getTexture(), c* Tile.ON_SCREEN_DEFAULT_WIDTH, Gdx.graphics.getHeight() -Tile.ON_SCREEN_DEFAULT_HEIGHT - (r*Tile.ON_SCREEN_DEFAULT_HEIGHT));
			}
		}


/*
		for(int r = 0; r < Gdx.graphics.getHeight(); r+=64) {
			for (int c = 0; c < Gdx.graphics.getWidth(); c+=64){
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(x++).getTexture(), c, r );
				if(x > 5){
					x = 0;
				}

			}
		}

 */

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

		/*


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
*/
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
