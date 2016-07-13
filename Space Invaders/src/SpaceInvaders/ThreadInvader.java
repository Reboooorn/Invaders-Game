package SpaceInvaders;

public class ThreadInvader extends Thread {
	private MainPanel main;


	public ThreadInvader(MainPanel main) {
		this.main = main;
	}


	public void run () {
		while (true) {
			this.main.mainWindowCheckInput();

			this.main.repaint();
			this.main.game.updateInvaders();

			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
