package net.cebarks.ahome.gfx.gui;

import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.entity.EntityPlayer;
import net.cebarks.ahome.level.Level;

public class GuiDebug extends GuiBase {
	private long usedMemory;

	public GuiDebug(Level level) {
		super(2, level);
	}

	@Override
	public void render() {
		AlmostHome a = level.getGame();
		EntityPlayer p = level.getPlayer();

		if (level.getGame().getTickCount() % 50 == 0)
			usedMemory = (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);

		g.drawString("FPS: " + a.getFPS() + ", TPS: " + a.getTPS(), 10, 20);
		g.drawString("RL: " + p.x + ", " + p.y, 10, 35);
		g.drawString("Mem: " + usedMemory + "mb", 10, 50);
		g.drawString("TILE: " + level.getCurrentLevelTile().gridX + ", " + level.getCurrentLevelTile().gridY, 10, 65);
		g.drawString("B: " + level.getCurrentLevelTile().getPopulator(), 10, 80);
		g.drawString("E: " + level.getEntites().size(), 10, 95);
	}
}
