package net.cebarks.ahome.level.tile;

import java.awt.Color;

public class TileDirt extends Tile {

	public TileDirt(int id) {
		super(id);
	}
	
	@Override
	public Color getColor() {
		return Color.BLACK;
	};
	
	@Override
	public String getTexture() {
		return "dirt";
	}
}
