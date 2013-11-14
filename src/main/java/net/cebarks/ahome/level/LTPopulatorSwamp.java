package net.cebarks.ahome.level;

import java.util.Random;

import net.cebarks.ahome.WeightedRandomizer;
import net.cebarks.ahome.level.tile.Tile;

public class LTPopulatorSwamp extends LTPopulator {
	@Override
	public int getId() {
		return swampID;
	}

	@Override
	public void generate(Tile[][] tiles, Random random) {
		WeightedRandomizer<Tile> wr = new WeightedRandomizer<Tile>(new Object[] {
				Tile.grass, 2, Tile.water, 1
		});
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles.length; y++) {
				tiles[x][y] = wr.getRandom();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Swamp";
	}
}
