package net.cebarks.ahome.gfx.gui;

import static net.cebarks.ahome.AlmostHome.SCALE;
import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.level.Level;

public class GuiInGame extends GuiBase {

	public GuiInGame(Level level) {
		super(1, level);

		minX = AlmostHome.WIDTH * SCALE;
		maxX = AlmostHome.WIDTH * SCALE;
		minY = 0;
		maxY = AlmostHome.HEIGHT * SCALE;
	}

	@Override
	public void render() {
		int halfHearts = level.getPlayer().getHealth() % 2;
		int fullHearts = level.getPlayer().getHealth() - halfHearts;
		
		//g.drawString("hH: " + halfHearts, 10, 15);
		//g.drawString("fH: " + fullHearts, 10, 30);
	}
}
