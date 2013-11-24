package net.cebarks.ahome.level.tile;

import java.awt.Color;

public class TileStone extends Tile {

	public TileStone(int id) {
		super(id);
	}

	@Override
	public Color getColor() {
		return Color.LIGHT_GRAY;
	}

	@Override
	public String getTexture() {
		return "stone";
	}
}
