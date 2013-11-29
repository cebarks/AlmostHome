package net.cebarks.ahome.gfx.gui;

import java.awt.Graphics2D;

import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.level.Level;

public class GuiBase {
	
	private int id;
	protected Level level;
	protected Graphics2D g;
	protected AlmostHome game;
	
	protected int minX;
	protected int maxX;
	protected int minY;
	protected int maxY;
	
	public GuiBase(int id, Level level) {
		this.id = id;
		this.level = level;
		this.game = level.getGame();
	}
	
	public void render() {}
	
	public void setGraphics(Graphics2D g2) {
		this.g = g2;
	}
	
	public int getId() {
		return id;
	}
	
}
