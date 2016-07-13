package SpaceInvaders;

import java.awt.Graphics;


public class GameController {
	/* ---- Fields ---- */
	private SpaceInvadersGame Game;


	/* ---- Constractors ---- */
	public GameController (int height, int width, int cell) {
		Game = new SpaceInvadersGame(height, width, cell);
	}


	/* ---- Operations (Player) ---- */
	public void up () {
		Game.up();
	}
	
	public void down () {
		Game.down();
	}
	
	public void left () {
		Game.left();
	}

	public void right () {
		Game.right();
	}
	
	public void fire () {
		Game.fire();
	}
	
	public void fire2 () {
		Game.fire2();
	}
	
	
	/* ---- Update ---- */
	public void update () {
		Game.updateInvaders();
		Game.updateBullet();
	}
	
	public void updateInvaders () {
		Game.updateInvaders();
		//Game.updateBullet();
	}
	
	public void updateBullets () {
		//Game.updateInvaders();
		Game.updateBullet();
	}
	
	
	public void draw (Graphics g) {
		Game.draw(g);
	}
}
