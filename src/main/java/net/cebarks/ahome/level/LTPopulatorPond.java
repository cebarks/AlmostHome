package net.cebarks.ahome.level;

import java.util.Random;

import net.cebarks.ahome.level.tile.Tile;

public class LTPopulatorPond extends LTPopulator {

	@Override
	public int getId() {
		return pondID;
	}

	@Override
	public void generate(Tile[][] tiles, Random random) {
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles.length; y++) {
				tiles[x][y] = Tile.water;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Pond";
	}
}

