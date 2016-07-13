package Cell;

import java.awt.Color;



public class Player extends Cell {
	/* ---- Fields ---- */
	// Take over from Cell.
	
	/* ---- Constractors ---- */
	public Player (Coord coord, Color[][] pixelmodel) {
		super(coord, pixelmodel);
	}
	
	
	/* ---- Getters ---- */
	// Take over from Cell.
	
	
	/* ---- Setters ---- */
	// Take over from Cell.
	
	
	/* ---- Adders ---- */
	// Take over from Cell.
	
	
	/* ---- toString ---- */
	public String toString() {
		return "Player: " + super.toString();
	}
}
