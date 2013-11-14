package net.cebarks.ahome.level.tile;

public class TileSmoothStone extends Tile {

	public TileSmoothStone(int id) {
		super(id);
		setSolid(true);
	}
	
	@Override
	public String getTexture() {
		return "smoothStone";
	}
}
