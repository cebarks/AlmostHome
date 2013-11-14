package net.cebarks.ahome.entity;

import net.cebarks.ahome.level.Level;

public class EntityNPC extends EntityMob {

	public EntityNPC(Level level, int x, int y) {
		super(level, x, y);
		setTarget(level.getPlayer());
	}

	@Override
	public void tick() {
		if(hasCollided(target)) {
			target.setDead(true);
			setDead(true);
		}
		super.tick();
	}
	
	@Override
	public String getTexture() {
		return "heart";
	}
}
