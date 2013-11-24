package net.cebarks.ahome.level.tile;

import java.awt.Color;

public class TileWater extends Tile {

	public TileWater(int id) {
		super(id);
	}

	
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	

	@Override
	public String getTexture() {
		return "water";
	}
}
