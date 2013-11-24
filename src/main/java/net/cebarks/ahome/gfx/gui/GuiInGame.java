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
		
	}
}
