package Cell;

import java.awt.Color;


public class PixelModel {
	public static Color COLOR_SPACE = new Color(0, 0, 0);
	
	public static Color COLOR_INVADER_SKY = new Color(0, 176, 240);
	public static Color[][] INVADER_SKY = new Color[10][10];
	
	public static Color COLOR_DETONATION = new Color(255, 0, 0);
	public static Color[][] DETONATION = new Color[10][10];
	
	public static Color COLOR_PLAYER = new Color(255, 255, 255);
	public static Color[][] PLAYER = new Color[10][10];
	
	public static Color COLOR_BULLET = new Color(255, 0, 0);
	public static Color[][] BULLET = new Color[10][10];
	
	
	static {
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++) {
				INVADER_SKY[i][j] = BitModel.INVADER_SKY[i][j] ? COLOR_INVADER_SKY : COLOR_SPACE;
				DETONATION[i][j] = BitModel.DETONATION[i][j] ? COLOR_DETONATION : COLOR_SPACE;
				PLAYER[i][j] = BitModel.PLAYER[i][j] ? COLOR_PLAYER : COLOR_SPACE;
				BULLET[i][j] = BitModel.BULLET[i][j] ? COLOR_BULLET : COLOR_SPACE;
			}
	}
}
