package Cell;

import java.awt.Color;
import java.awt.Graphics;


public class Cell {
	/* ---- Fields ---- */
	private Coord Coord;
	private Color[][] PixelModel; // 10 x 10
	private boolean Detonated;
	
	
	/* ---- Constractors ---- */
	public Cell (Coord coord, Color[][] pixelmodel) {
		this.Coord = coord;
		this.PixelModel = pixelmodel;
		this.Detonated = false;
	}
	
	
	/* ---- Getters ---- */
	public Coord getCoord () {
		return this.Coord;
	}
	
	public Color[][] getPicelModel () {
		return this.PixelModel;
	}
	
	public boolean getDetonated () {
		return this.Detonated;
	}
	
	
	/* ---- Setters ---- */
	public void setCoord (int x, int y) {
		this.Coord.set(x, y);
	}
	
	public void setCoord (Coord aCoord) {
		this.Coord.set(aCoord);
	}
	
	public void setPixelModel (Color[][] pixelmodel) {
		this.PixelModel = pixelmodel;
	}
	
	public void detonate () {
		this.Detonated = true;
	}


	/* ---- Adders ---- */
	public void addCoord (int x, int y) {
		this.Coord.add(x, y);
	}
	
	public void addCoord (Coord aCoord) {
		this.Coord.add(aCoord);
	}
	
	
	/* ---- toString ---- */
	public String toString() {
		return this.Coord.toString();
	}
	
	
	/* ---- Draw this cell's PixelModel ---- */
	public void draw (Graphics g, int cellsize) {
		int pixelsize = cellsize / 10;
		int y = this.Coord.getY() * cellsize;
		int x = this.Coord.getX() * cellsize;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				g.setColor(this.PixelModel[i][j]);
				g.fillRect(y + j * pixelsize, x + i * pixelsize, pixelsize, pixelsize);
			}
	}
}