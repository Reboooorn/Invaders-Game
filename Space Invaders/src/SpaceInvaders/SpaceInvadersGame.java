package SpaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Cell.Bullet;
import Cell.Coord;
import Cell.Invader;
import Cell.PixelModel;
import Cell.Player;
import Cell.Wall;

public class SpaceInvadersGame {
	/* ---- Fields ---- */
	private final Coord eUp = new Coord(-1, 0);
	private final Coord eDown = new Coord(1, 0);
	private final Coord eLeft = new Coord(0, -1);
	private final Coord eRight = new Coord(0, 1);
	
	private final Coord eLeft2 = new Coord(0, -2);
	private final Coord eRight2 = new Coord(0, 2);
	
	private Color SpaceColor = new Color(0, 0, 0);
	public int Height;
	public int Width;
	public int CellSize;
	private Coord MinCoord;
	private Coord MaxCoord;
	
	private Player Player;
	private ArrayList<Invader> Invaders;
	private ArrayList<Bullet> Bullets;
	private ArrayList<Wall> Walls;


	/* ---- Constractors ---- */
	public SpaceInvadersGame (int height, int width, int cell) {
		this.Height = height;
		this.Width = width;
		this.CellSize = cell;
		this.MinCoord = new Coord(0, 0);
		this.MaxCoord = new Coord(width - 1, height - 1);
		
		this.Player = new Player(new Coord(height - 1, 0), PixelModel.PLAYER);
		
		this.Invaders = new ArrayList<Invader>();
		this.Invaders.add(new Invader(new Coord(0, 0), PixelModel.INVADER_SKY, new Coord(eRight)));
		this.Invaders.add(new Invader(new Coord(0, 1), PixelModel.INVADER_SKY, new Coord(eRight)));
		this.Invaders.add(new Invader(new Coord(0, 2), PixelModel.INVADER_SKY, new Coord(eRight)));
		this.Invaders.add(new Invader(new Coord(0, 3), PixelModel.INVADER_SKY, new Coord(eRight)));
		
		this.Bullets = new ArrayList<Bullet>();
	}
	
	
	public boolean canPlace (Coord coord) {
		if (coord.isContainedIn(MinCoord, MaxCoord))
			return ! exist(coord);
		else
			return false;
	}
	
	
	private boolean exist (Coord coord) {
		for (Invader invader : this.Invaders)
			if (invader.getCoord().equals(coord))
				return true;
		for (Bullet bullet : this.Bullets)
			if (bullet.getCoord().equals(coord))
				return true;
		if (this.Player.getCoord().equals(coord))
			return true;
		return false;
	}
	
	
	private void detonate (Coord coord) {
		for (Invader invader : this.Invaders)
			if (invader.getCoord().equals(coord))
				invader.detonate();
		for (Bullet bullet : this.Bullets)
			if (bullet.getCoord().equals(coord))
				bullet.detonate();
		if (this.Player.getCoord().equals(coord))
			this.Player.detonate();
	}
	

	/* ---- Operations (Player) ---- */
	public void up () {
		if (canPlace(Coord.add(Player.getCoord(), eUp)))
			Player.addCoord(eUp);
	}
	
	public void down () {
		if (canPlace(Coord.add(Player.getCoord(), eDown)))
			Player.addCoord(eDown);
	}
	
	public void left () {
		if (canPlace(Coord.add(Player.getCoord(), eLeft)))
			Player.addCoord(eLeft);
	}

	public void right () {
		if (canPlace(Coord.add(Player.getCoord(), eRight)))
			Player.addCoord(eRight);
	}

	public void fire () {
		//Bullets.add(new Bullet(Coord.add(Player.getCoord(), eUp), PixelModel.BULLET, eUp));
		Bullets.add(new Bullet(new Coord(Player.getCoord()), PixelModel.BULLET, eUp));
	}
	
	public void fire2 () {
		//Bullets.add(new Bullet(Coord.add(Player.getCoord(), eUp), PixelModel.BULLET, Coord.add(eUp, eUp)));
		Bullets.add(new Bullet(new Coord(Player.getCoord()), PixelModel.BULLET, Coord.add(eUp, eUp)));
	}
	
	
	/* ---- Update Bullets ---- */
	public void updateBullet () {
		for(int i = 0; i < Bullets.size();)
			if (canPlace(Coord.add(Bullets.get(i).getCoord(), eUp)))
				Bullets.get(i++).update();
			else {
				detonate(Coord.add(Bullets.get(i).getCoord(), eUp));
				Bullets.remove(i);
			}
	}
	
	
	/* ---- Update Invaders ---- */
	public void updateInvaders () {
		for (int i = 0; i < Invaders.size();)
			if (Invaders.get(i).getDetonated())
				Invaders.remove(i);
			else
				i++;
		
		boolean flag = true;
		
		for (int i = 0; i < Invaders.size(); i++)
			if (!canPlace(Invaders.get(i).calcNext()) && ! exist(Invaders.get(i).calcNext()))
				flag = false;
		
		if (flag)
			for (int i = 0; i < Invaders.size(); i++)
				Invaders.get(i).update();
		
		else {
			flag = true;
			for (int i = 0; i < Invaders.size(); i++)
				if (Invaders.get(i).getCoord().getX() >= Height - 10)
					flag = false;
			
			for (int i = 0; i < Invaders.size(); i++)
				Invaders.get(i).reverseDirection();
			
			if (flag) {
				for (int i = 0; i < Invaders.size(); i++)
					Invaders.get(i).addCoord(eDown);
			}
			else
				for (int i = 0; i < Invaders.size(); i++)
					Invaders.get(i).update();
		}
	}
	
	
	/* ---- Draw ---- */
	public void draw (Graphics g) {
		int cellsize = 10;
		drawSpace(g);
		for (Invader invader : this.Invaders)
			invader.draw(g, CellSize);
		for (Bullet bullet : this.Bullets)
			bullet.draw(g, CellSize);
		this.Player.draw(g, CellSize);
	}
	
	public void drawSpace (Graphics g) {
		int cellsize = CellSize;
		g.setColor(this.SpaceColor);
		for (int i = 0; i < Height; i++)
			for (int j = 0; j < Width; j++)
				g.fillRect(j * cellsize, i * cellsize, cellsize, cellsize);
	}
}
