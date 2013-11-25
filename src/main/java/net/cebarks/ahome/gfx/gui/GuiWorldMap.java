package net.cebarks.ahome.gfx.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import net.cebarks.ahome.level.Level;
import net.cebarks.ahome.util.Input;
import net.cebarks.ahome.util.InputHandler;

public class GuiWorldMap extends GuiBase implements InputHandler {

	private BufferedImage map;
	private boolean shouldRender = false;

	public GuiWorldMap(Level level) {
		super(3, level);
		level.getGame().registerInputHandler(this);
		generateMap();
	}

	public void generateMap() {
		map = new BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < 32; x++) {
			for (int y = 0; y < 32; y++) {
				for (int i = 0; i < 16; i++) {
					for (int j = 0; j < 16; j++) {
						Color c = level.getLevelTile(x, y).getTile(i, j).getColor();
						map.getRaster().setPixel(x * i, y * j, new int[] { c.getRed(), c.getBlue(), c.getGreen(), c.getAlpha() });
					}
				}
			}
		}
	}

	@Override
	public void render() {
		if (shouldRender) {
			g.drawImage(map, 0, 0, null);
		}
	}

	public void handleInput(Input input) {
		if (input.isKeyDown(KeyEvent.VK_M)) {
			shouldRender = !shouldRender;
			System.out.println("Map!");
		}
	}
}
