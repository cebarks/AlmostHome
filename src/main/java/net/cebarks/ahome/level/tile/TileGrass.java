package net.cebarks.ahome.level.tile;

import java.awt.Color;

public class TileGrass extends Tile {

	public TileGrass(int id) {
		super(id);
	}
	
	@Override
	public Color getColor() {
		return Color.GREEN;
	}
	
	@Override
	public String getTexture() {
		return "grass";
	}
}
