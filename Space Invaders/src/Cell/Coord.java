package Cell;


public class Coord {
	/* ---- Fields ---- */
	private int x;
	private int y;


	/* ---- Constractors ---- */
	public Coord (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coord(Coord aCoord) {
		this(aCoord.x, aCoord.y);
	}


	/* ---- Static Methods ---- */
	public static Coord add (Coord aCoord1, Coord aCoord2) {
		return new Coord(aCoord1.x + aCoord2.x, aCoord1.y + aCoord2.y);
	}


	/* ---- Getters ---- */
	public int getX () {
		return this.x;
	}

	public int getY () {
		return this.y;
	}


	/* ---- Setters ---- */
	public void set (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void set (Coord aCoord) {
		this.x = aCoord.x;
		this.y = aCoord.y;
	}


	/* ---- Adders ---- */
	public void add (int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void add (Coord aCoord) {
		this.x += aCoord.x;
		this.y += aCoord.y;
	}
	
	
	/* ---- Reverse ---- */
	public void reverse () {
		this.x = - this.x;
		this.y = - this.y;
	}
	
	public void reverseX () {
		this.x = - this.x;
	}
	
	public void reverseY () {
		this.y = - this.y;
	}


	public boolean equals (Coord aCoord) {
		return this.x == aCoord.x && this.y == aCoord.y;
	}


	public boolean isContainedIn (Coord lowerleft, Coord upperright) {
		if (this.x >= lowerleft.x && this.y >= lowerleft.y && this.x <= upperright.x && this.y <= upperright.y)
			return true;
		else
			return false;
	}
	
	
	/* ---- toString ---- */
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}
}
