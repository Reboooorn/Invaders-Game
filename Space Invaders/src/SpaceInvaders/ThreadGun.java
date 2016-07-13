package SpaceInvaders;

public class ThreadGun extends Thread {
	private MainPanel main;


	public ThreadGun(MainPanel main) {
		this.main = main;
	}


	public void run () {
		while (true) {
			this.main.mainWindowCheckInput();

			this.main.repaint();
			this.main.game.updateBullets();

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
