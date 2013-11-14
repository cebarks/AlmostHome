package net.cebarks.ahome.level;

import java.util.Random;

import net.cebarks.ahome.level.tile.Tile;

public class LevelTile {

	public int gridX;
	public int gridY;
	private boolean northEdge = false;
	private boolean southEdge = false;
	private boolean eastEdge = false;
	private boolean westEdge = false;

	private Random random;

	private Tile[][] tiles = new Tile[16][16];
	private boolean[][] solidTiles = new boolean[16][16];
	
	private Level level;
	private LTPopulator levelPopulator;

	public LevelTile(Level l, int x, int y, Random random, LTPopulator ltp) {
		gridX = x;
		gridY = y;
		level = l;
		levelPopulator = ltp;

		if (x == 0)
			northEdge = true;
		if (y == 0)
			eastEdge = true;
		if (x == 31)
			southEdge = true;
		if (y == 31)
			westEdge = true;

		this.random = random;
		
		levelPopulator.generate(tiles, this.random);
	}

	public LTPopulator getPopulator() {
		return levelPopulator;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	public void setTile(int x, int y, Tile t) {
		tiles[x][y] = t;
	}

	public void setTile(int x, int y, int id) {
		tiles[x][y] = Tile.getTileById(id);
	}

	public LevelTile getNorthTile() {
		if (gridY - 1 < 0)
			return this;
		return level.getLevelTile(gridX, gridY - 1);
	}

	public LevelTile getSouthTile() {
		if (gridY + 1 >= 32)
			return this;
		return level.getLevelTile(gridX, gridY + 1);
	}

	public LevelTile getEastTile() {
		if (gridX + 1 >= 32)
			return this;
		return level.getLevelTile(gridX + 1, gridY);
	}

	public LevelTile getWestTile() {
		if (gridX - 1 < 0)
			return this;
		return level.getLevelTile(gridX - 1, gridY);
	}

	public boolean isNorthEdge() {
		return northEdge;
	}

	public boolean isSouthEdge() {
		return southEdge;
	}

	public boolean isEastEdge() {
		return eastEdge;
	}

	public boolean isWestEdge() {
		return westEdge;
	}
}
