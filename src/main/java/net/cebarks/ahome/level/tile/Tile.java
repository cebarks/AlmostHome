package net.cebarks.ahome.level.tile;

import java.util.HashMap;

public class Tile {
	private int id;
	private boolean solid;

	public static HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();

	public static final Tile stone = new TileStone(1);
	public static final Tile grass = new TileGrass(2);
	public static final Tile dirt = new TileDirt(3);
	public static final Tile smoothStone = new TileSmoothStone(4);
	public static final Tile water = new TileWater(5);

	public Tile(int id) {
		this.id = id;
		tiles.put(id, this);
		setSolid(false);
	}

	/**
	 * Returns the id of this tile type
	 * 
	 * @return the id of this tile type
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the String representation of this Tile's stepsound
	 * 
	 * @return the string representation of this Tile's stepsound
	 */
	public String getStepSound() {
		return "generic";
	}

	/**
	 * 
	 * 	Returns the Tile object associated with the provided id
	 * 
	 * @param id of unknown tile
	 * @return the Tile object associated with provided id
	 */
	public static Tile getTileById(int id) {
		return tiles.get(id);
	}

	public String getTexture() {
		return null;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}
}
