package net.cebarks.ahome.level;

import static net.cebarks.ahome.level.LTPopulator.plains;
import static net.cebarks.ahome.level.LTPopulator.swamp;

import java.util.ArrayList;
import java.util.Random;

import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.WeightedRandomizer;
import net.cebarks.ahome.entity.Entity;
import net.cebarks.ahome.entity.EntityNPC;
import net.cebarks.ahome.entity.EntityPlayer;

public class Level {

	private long seed;
	private Random random;

	private EntityPlayer player;

	private ArrayList<Entity> entities = new ArrayList<Entity>();

	private LevelTile[][] levelTiles = new LevelTile[32][32];
	private LevelTile currentLevelTile;
	private AlmostHome game;

	public Level(AlmostHome almostHome, String sed) {
		this.game = almostHome;
		seed = sed.hashCode();
		random = new Random(seed);

		player = new EntityPlayer(this, 240, 240);
		new EntityNPC(this, 100, 100);

		generate();

		currentLevelTile = getLevelTile(0, 0);
	}

	public void tick() {
		if (player.x < -16) {
			if (!currentLevelTile.isNorthEdge())
				player.x = 496;
			else
				player.x = -16;
			setCurrentLevelTile(currentLevelTile.getWestTile());
		}
		if (player.x > 496) {
			if (!currentLevelTile.isSouthEdge())
				player.x = -16;
			else
				player.x = 496;
			setCurrentLevelTile(currentLevelTile.getEastTile());
		}
		if (player.y < -16) {
			if (!currentLevelTile.isEastEdge())
				player.y = 496;
			else
				player.y = -16;
			setCurrentLevelTile(currentLevelTile.getNorthTile());
		}
		if (player.y > 496) {
			if (!currentLevelTile.isWestEdge())
				player.y = -16;
			else
				player.y = 496;
			setCurrentLevelTile(currentLevelTile.getSouthTile());
		}

		for (Entity e : entities) {
			if (e.isDead()) {
				if (e instanceof EntityPlayer)
					player = new EntityPlayer(this, 200, 200);
				gCollectEntity(e);
				return;
			}
			//if (e.tile == getCurrentLevelTile())
				e.tick();
		}
	}

	public void gCollectEntity(Entity e) {
		entities.remove(e);
		e = null;
		getGame().garbageCollect();
	}

	public void generate() {
		WeightedRandomizer<LTPopulator> wr = new WeightedRandomizer<LTPopulator>(new Object[] { plains, 9, swamp, 1 });

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
