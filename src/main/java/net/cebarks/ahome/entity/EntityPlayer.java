package net.cebarks.ahome.entity;

import net.cebarks.ahome.level.Level;

public class EntityPlayer extends Entity {

	public int turn = 0;

	public EntityPlayer(Level level, int x, int y) {
		super(level, level.getCurrentLevelTile(), x, y);
		moveSpeed = 1.2F;
	}

	@Override
	public String getTexture() {
		return "player" + turn;
	}

	@Override
	public void tick() {

		if (xToMove == 0 && yToMove < 0)
			turn = 0;
		if (xToMove > 0 && yToMove < 0)
			turn = 1;
		if (xToMove > 0 && yToMove == 0)
			turn = 2;
		if (xToMove > 0 && yToMove > 0)
			turn = 3;
		if (xToMove == 0 && yToMove > 0)
			turn = 4;
		if (xToMove < 0 && yToMove > 0)
			turn = 5;
		if (xToMove < 0 && yToMove == 0)
			turn = 6;
		if (xToMove < 0 && yToMove < 0)
			turn = 7;

		super.tick();
	}
}
