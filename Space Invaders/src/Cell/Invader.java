package Cell;

import java.awt.Color;


public class Invader extends Cell {
	/* ---- Fields ---- */
	// Take over from Cell.
	private Coord Direction;
	
	
	/* ---- Constractors ---- */
	public Invader (Coord coord, Color[][] pixelmodel, Coord direction) {
		super(coord, pixelmodel);
		this.Direction = direction;
	}
	
	
	/* ---- Getters ---- */
	// Take over from Cell.
	
	
	/* ---- Setters ---- */
	// Take over from Cell.
	public void setDirection (Coord direction) {
		this.Direction = direction;
	}
	
	
	/* ---- Adders ---- */
	// Take over from Cell.
	
	
	/* ---- toString ---- */
	public String toString() {
		return "Invader: " + super.toString();
	}
	
	
	/* ---- Others ---- */
	public void reverseDirection () {
		this.Direction.reverse();
	}
	
	
	public Coord calcNext () {
		return Coord.add(getCoord(), Direction);
	}
	
	
	public void update () {
		addCoord(Direction);
	}
	
	
	/* Be Detonated */
	@Override
	public void detonate () {
		super.detonate();
		this.setPixelModel(PixelModel.DETONATION);
	}
}
