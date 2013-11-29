package net.cebarks.ahome.level;

import java.util.Random;

import net.cebarks.ahome.level.tile.Tile;
import net.cebarks.ahome.util.Vec2D;

public class LTPopulatorPond extends LTPopulator {

	@Override
	public int getId() {
		return pondID;
	}

	@Override
	public void generate(Tile[][] tiles, Random random) throws ArrayIndexOutOfBoundsException {
		Vec2D lt = Vec2D.get(8, 8);

		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles.length; y++) {
				tiles[x][y] = Tile.grass;
			}
		}

		try {
			for (int i = 0; i < 96; i++) {
				tiles[lt.getX()][lt.getY()] = Tile.water;

				for (int x = -1; x <= 1; x++) {
					for (int y = -1; y <= 1; y++) {
						tiles[lt.getX() + x][lt.getY() + y] = Tile.water;
					}
				}

				lt = lt.add(Vec2D.get(random.nextInt(2) - 1, random.nextInt(2) - 1));

				if (random.nextInt(6) == 1) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
	}

	@Override
	public String toString() {
		return "Pond";
	}
}
