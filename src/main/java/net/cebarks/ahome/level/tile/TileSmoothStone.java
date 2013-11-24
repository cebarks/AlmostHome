package net.cebarks.ahome.level.tile;

import java.awt.Color;

public class TileSmoothStone extends Tile {

	public TileSmoothStone(int id) {
		super(id);
		setSolid(true);
	}

	@Override
	public Color getColor() {
		return Color.DARK_GRAY;
	}

	@Override
	public String getTexture() {
		return "smoothStone";
	}
}
