package net.cebarks.ahome.level;

import java.util.Random;

import net.cebarks.ahome.WeightedRandomizer;
import net.cebarks.ahome.level.tile.Tile;

public class LTPopulatorPlains extends LTPopulator {

	@Override
	public int getId() {
		return plainsID;
	}

	@Override
	public void generate(Tile[][] tiles, Random random) {
		WeightedRandomizer<Tile> tr = new WeightedRandomizer<Tile>(new Object[] {
			Tile.grass, 49, Tile.dirt, 1	
		});
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles.length; y++) {
				tiles[x][y] = tr.getRandom();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Plains";
	}
}
