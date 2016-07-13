package Cell;

import java.awt.Color;


public class Bullet extends Cell {
	/* ---- Fields ---- */
	// Take over from Cell.
	private Coord Direction;
	
	
	/* ---- Constractors ---- */
	public Bullet (Coord coord, Color[][] pixelmodel, Coord direction) {
		super(coord, pixelmodel);
		this.Direction = direction;
	}
	
	
	/* ---- Getters ---- */
	// Take over from Cell.
	
	
	/* ---- Setters ---- */
	// Take over from Cell.
	
	
	/* ---- Adders ---- */
	// Take over from Cell.
	
	
	/* ---- toString ---- */
	public String toString() {
		return "Bullet: " + super.toString();
	}
	
	
	/* ---- Others ---- */
	public Coord calcNext () {
		return Coord.add(getCoord(), Direction);
	}
	
	
	public void update () {
		addCoord(Direction);
	}
}
