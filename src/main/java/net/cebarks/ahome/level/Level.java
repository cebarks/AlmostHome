package net.cebarks.ahome.level;

import static net.cebarks.ahome.level.LTPopulator.plains;
import static net.cebarks.ahome.level.LTPopulator.swamp;
import static net.cebarks.ahome.level.LTPopulator.pond;

import java.util.ArrayList;
import java.util.Random;

import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.entity.Entity;
import net.cebarks.ahome.entity.EntityPlayer;
import net.cebarks.ahome.util.WeightedRandomizer;

public class Level {

	private long seed;
	private Random random;

	private EntityPlayer player;

	private ArrayList<Entity> entities = new ArrayList<Entity>();

	private LevelTile[][] levelTiles = new LevelTile[32][32];
	private LevelTile currentLevelTile;
	private AlmostHome game;

	public Level(AlmostHome almostHome, String ssed) {
		this.game = almostHome;
		seed = ssed.hashCode();
		System.out.println("Seed: " + seed);
		random = new Random(seed);
		player = new EntityPlayer(this, 240, 240);

		generate();

		currentLevelTile = getLevelTile(0, 0);
	}

	public void tick() {
		for (Entity e : entities) {
			if (e.isDead()) {
				if (e instanceof EntityPlayer)
					player = new EntityPlayer(this, 200, 200);
				gCollectEntity(e);
				return;
			}
			// if (e.tile == getCurrentLevelTile())
			e.tick();
		}
	}

	public void gCollectEntity(Entity e) {
		entities.remove(e);
		e = null;
		getGame().garbageCollect();
	}

	public void generate() {
		WeightedRandomizer<LTPopulator> wr = new WeightedRandomizer<LTPopulator>(random, new Object[] { 
				plains, 8,
				pond, 1, 
				swamp, 1 
		 });

		for (int x = 0; x < levelTiles.length; x++) {
			for (int y = 0; y < levelTiles.length; y++) {
				setLevelTile(x, y, new LevelTile(this, x, y, random, wr.getRandom()));
			}
		}
	}

	public LevelTile getLevelTile(int x, int y) {
		return levelTiles[x][y];
	}

	public void setLevelTile(int x, int y, LevelTile t) {
		levelTiles[x][y] = t;
	}

	public Random getRandom() {
		return random;
	}

	public ArrayList<Entity> getEntites() {
		return entities;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public EntityPlayer getPlayer() {
		return player;
	}

	public LevelTile getCurrentLevelTile() {
		return currentLevelTile;
	}

	public void setCurrentLevelTile(LevelTile lt) {
		this.currentLevelTile = lt;
	}

	public AlmostHome getGame() {
		return game;
	}
}
