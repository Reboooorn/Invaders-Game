package SpaceInvaders;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import UI.ActionKey;
import UI.Common;


class MainPanel extends JPanel implements KeyListener, Runnable, Common {
	public static final int HEIGHT = 20;
	public static final int WIDTH = 20;
	public static final int CELL = 60;

	private ActionKey spaceKey;
	private ActionKey Up;
	private ActionKey Down;
	private ActionKey Left;
	private ActionKey Right;

	private Thread gameLoop;

	private ThreadGun gameLoop_Gun;
	private ThreadInvader gameLoop_Invader;


	/* Create game */
	public GameController game;


	public MainPanel() {

		setPreferredSize(new Dimension(WIDTH * CELL, HEIGHT * CELL));

		setFocusable(true);
		addKeyListener(this);

		//spaceKey = new ActionKey(ActionKey.NORMAL);
		//Up = new ActionKey(ActionKey.NORMAL);
		//Down = new ActionKey(ActionKey.NORMAL);
		//Left = new ActionKey(ActionKey.NORMAL);
		//Right = new ActionKey(ActionKey.NORMAL);

		spaceKey = new ActionKey(ActionKey.DETECT_INITIAL_PRESS_ONLY);
		Up = new ActionKey(ActionKey.DETECT_INITIAL_PRESS_ONLY);
		Down = new ActionKey(ActionKey.DETECT_INITIAL_PRESS_ONLY);
		Left = new ActionKey(ActionKey.DETECT_INITIAL_PRESS_ONLY);
		Right = new ActionKey(ActionKey.DETECT_INITIAL_PRESS_ONLY);

		game = new GameController(HEIGHT, WIDTH, CELL);

		gameLoop = new Thread(this);
		gameLoop.start();

		gameLoop_Gun = new ThreadGun(this);
		gameLoop_Gun.start();

		gameLoop_Invader = new ThreadInvader(this);
		gameLoop_Invader.start();
	}


	/* Main loop */
	public void run () {
		while (true) {
			mainWindowCheckInput();

			repaint();

			//game.updateInvaders();
			//game.update();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	/* Painting */
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		this.draw(g);
	}

	public void draw (Graphics g) {
		game.draw(g);
	}


	/* Moving */
	public void mainWindowCheckInput () {
		//Random rand = new Random();
		//int r = rand.nextInt(4);
		/*
		if (r==0)
			game.up();
		if (r==1)
			game.down();
		if (r==2)
			game.left();
		if (r==3)
			game.right();
			*/

		if (spaceKey.isPressed())
			game.fire();
		if (Up.isPressed())
			game.up();
		if (Down.isPressed())
			game.down();
		if (Left.isPressed())
			game.left();
		if (Right.isPressed())
			game.right();
	}


	private void messageWindowCheckInput () {}


	/* Press the key */
	public void keyPressed (KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE)
			spaceKey.press();
		if (keyCode == KeyEvent.VK_UP)
			Up.press();
		if (keyCode == KeyEvent.VK_DOWN)
			Down.press();
		if (keyCode == KeyEvent.VK_LEFT)
			Left.press();
		if (keyCode == KeyEvent.VK_RIGHT)
			Right.press();
	}


	/* Release the key */
	public void keyReleased (KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE)
			spaceKey.release();
		if (keyCode == KeyEvent.VK_UP)
			Up.release();
		if (keyCode == KeyEvent.VK_DOWN)
			Down.release();
		if (keyCode == KeyEvent.VK_LEFT)
			Left.release();
		if (keyCode == KeyEvent.VK_RIGHT)
			Right.release();
	}


	public void keyTyped (KeyEvent e) {}
}
