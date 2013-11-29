package net.cebarks.ahome.gfx.gui;

import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.level.Level;

public class GuiDebug extends GuiBase {
	private long usedMemory;

	public GuiDebug(Level level) {
		super(2, level);
	}

	@Override
	public void render() {
		if (game.isDebug() || true) {
			AlmostHome a = level.getGame();

			if (level.getGame().getTickCount() % 50 == 0)
				usedMemory = (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / 1048576;

			g.drawString("FPS: " + a.getFPS() + ", TPS: " + a.getTPS(), 10, 20);
			g.drawString("Mem: " + usedMemory + "mb / " + Runtime.getRuntime().maxMemory() / 1048576 + "mb", 10, 50);
			g.drawString("TILE: " + level.getCurrentLevelTile().gridX + ", " + level.getCurrentLevelTile().gridY, 10, 65);
			g.drawString("B: " + level.getCurrentLevelTile().getPopulator(), 10, 80);
			g.drawString("E: " + level.getEntites().size(), 10, 95);
		}
	}
}
