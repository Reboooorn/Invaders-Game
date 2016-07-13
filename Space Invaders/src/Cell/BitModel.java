package Cell;

public class BitModel {
	/*
	 * 10 x 10 pixel model
	 * For example:
	 * ----------
	 * -#------#-
	 * --#----#--
	 * #-######-#
	 * ##########
	 * ##########
	 * -########-
	 * --#-##-#--
	 * -#------#-
	 * ----------
	 * This is invader ('#' has a color, '-' has no color).
	 */
	private static boolean x = true;
	private static boolean o = false;
	
	// sky blue
	public static boolean[][] INVADER_SKY = {
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,x,o,o,o,o,x,o,o},
		{x,o,o,x,o,o,x,o,o,x},
		{x,o,x,x,x,x,x,x,o,x},
		{x,x,x,o,x,x,o,x,x,x},
		{x,x,x,x,x,x,x,x,x,x},
		{o,x,x,x,x,x,x,x,x,o},
		{o,o,x,o,o,o,o,x,o,o},
		{o,x,o,o,o,o,o,o,x,o},
		{o,o,o,o,o,o,o,o,o,o}
	};
	
	public static boolean[][] DETONATION = {
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,x,o,o,o,o,x,o,o},
		{x,o,o,x,o,o,x,o,o,x},
		{o,x,o,o,o,o,o,o,x,o},
		{o,o,x,o,o,o,o,x,o,o},
		{x,x,o,o,o,o,o,o,x,x},
		{o,o,x,o,o,o,o,x,o,o},
		{o,x,o,o,o,o,o,o,x,o},
		{x,o,o,x,o,o,x,o,o,x},
		{o,o,x,o,o,o,o,x,o,o}
	};
	
	public static boolean[][] PLAYER = {
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,x,x,x,x,o,o,o},
		{o,o,o,x,x,x,x,o,o,o},
		{o,x,x,x,x,x,x,x,x,o},
		{x,x,x,x,x,x,x,x,x,x},
		{x,x,x,x,x,x,x,x,x,x},
		{x,x,x,x,x,x,x,x,x,x},
		{o,o,o,o,o,o,o,o,o,o}
	};
	
	public static boolean[][] BULLET = {
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,o,x,x,o,o,o,o},
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,o,o,o,o,o,o,o,o},
		{o,o,o,o,o,o,o,o,o,o}
	};
}
