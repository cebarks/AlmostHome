package net.cebarks.ahome.entity;

import net.cebarks.ahome.level.Level;

public class EntityMob extends Entity {

	protected int targetX;
	protected int targetY;

	protected Entity target;

	public EntityMob(Level level, int x, int y) {
		super(level, level.getCurrentLevelTile(), x, y);
	}

	public void setTarget(Entity e) {
		target = e;
	}

	@Override
	public void tick() {
		if (target != null) {
			moveTowardsTarget();
		}
		super.tick();
	}

	public void moveTowardsTarget() {
		if (x > target.x)
			xToMove--;
		if (x < target.x)
			xToMove++;
		if (y > target.y)
			yToMove--;
		if (y < target.y)
			yToMove++;
	}
}
