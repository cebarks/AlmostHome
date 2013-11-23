package net.cebarks.ahome.entity;

import java.awt.Rectangle;

import net.cebarks.ahome.level.Level;
import net.cebarks.ahome.level.LevelTile;

public class Entity {
	
	public int x;
	public int y;
	public int yToMove = 0;
	public int xToMove = 0;
	public LevelTile tile;
	protected Level level;
	public float moveSpeed;
	protected int health;
	protected boolean dead;

	protected Rectangle hitBox;

	public Entity(Level level, LevelTile lt, int x, int y) {
		this.level = level;
		this.tile = lt;
		this.x = x;
		this.y = y;
		this.moveSpeed = 1F;
		this.health = 20;
		this.hitBox = new Rectangle(x + 2, y + 2, 30, 30);

		level.addEntity(this);
	}

	public String getTexture() {
		return null;
	}

	public void tick() {

		if (!isDead()) {
			/**
			if(x < 0 && !tile.isWestEdge())
				this.tile = tile.getWestTile();
			if(x > 512 && !tile.isEastEdge())
				this.tile = tile.getEastTile();
			if(y < 0 && !tile.isNorthEdge())
				this.tile = tile.getNorthTile();
			if(y > 512 && !tile.isSouthEdge())
				this.tile = tile.getSouthTile();
			**/

			//hitBox = new Rectangle(ltx + 2, lty + 2, 30, 30);
			hitBox = new Rectangle(x + 2, y + 2, 30, 30);

			if (xToMove != 0 && yToMove != 0) {
				xToMove *= 1;
				yToMove *= 1;
			}

			this.x += xToMove;
			this.y += yToMove;

			xToMove = 0;
			yToMove = 0;

			if (health < 0)
				setDead(true);
		}
	}

	public void setDead(boolean b) {
		dead = b;
		health = 0;
	}

	public boolean isDead() {
		return dead;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int h) {
		health = h;
	}

	public boolean hasCollided(Entity e) {
		return e.hitBox.intersects(this.hitBox);
	}

	public boolean shouldDraw() {
		if (!isDead() && (level.getCurrentLevelTile() == tile))
			return true;
		return false;
	}

	public boolean shouldRemove() {
		if (isDead())
			return true;
		return false;
	}
}
