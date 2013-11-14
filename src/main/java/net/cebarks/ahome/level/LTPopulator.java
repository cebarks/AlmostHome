package net.cebarks.ahome.level;

import java.util.HashMap;
import java.util.Random;

import net.cebarks.ahome.level.tile.Tile;

public class LTPopulator {

	public static final int plainsID = 1;
	public static final int pondID = 2;
	public static final int swampID = 3;
	
	public static final HashMap<Integer, LTPopulator> lts = new HashMap<Integer, LTPopulator>();
	
	public static final LTPopulator plains = new LTPopulatorPlains();
	public static final LTPopulator pond = new LTPopulatorPond();
	public static final LTPopulator swamp = new LTPopulatorSwamp();
	
	public LTPopulator() {
		lts.put(getId(), this);
	}

	public int getId() {
		return 0;
	}

	public void generate(Tile[][] tiles, Random random) {}
	
	public static LTPopulator getPopulatorByID(int id) {
		return lts.get(id);
	}
}
