package Cell;

import java.awt.Color;


public class Wall extends Cell {
	/* ---- Fields ---- */
	// Take over from Cell.
	private int HP;
	
	
	/* ---- Constractors ---- */
	public Wall(Coord coord, Color[][] pixelmodel) {
		super(coord, pixelmodel);
		this.HP = 2;
	}
	
	
	/* ---- Getters ---- */
	// Take over from Cell.
	
	
	/* ---- Setters ---- */
	// Take over from Cell.
	
	
	/* ---- Adders ---- */
	// Take over from Cell.
	
	
	/* ---- toString ---- */
	public String toString() {
		return "Wall: " + this.HP + ", " + super.toString();
	}
	
	
	/* ---- Others ---- */
	public void downgrade () {
		if(HP > 0)
			this.HP -= 1;
		//super.setPixelModel(null); // PixelModel.WALL[HP]
	}
}
