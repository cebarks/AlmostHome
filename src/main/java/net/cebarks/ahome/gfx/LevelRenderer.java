package net.cebarks.ahome.gfx;

import static net.cebarks.ahome.AlmostHome.SCALE;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import net.cebarks.ahome.ImageHelper;
import net.cebarks.ahome.entity.Entity;
import net.cebarks.ahome.level.Level;
import net.cebarks.ahome.level.LevelTile;
import net.cebarks.ahome.level.tile.Tile;

public class LevelRenderer {

	private Level level;
	private Graphics2D g;

	public static final int SPRITE_SIZE = 16;

	private HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();

	public LevelRenderer(Level l) {
		level = l;

		SpriteSheet ss = new SpriteSheet(ImageHelper.loadImage("spriteSheet.png"), SPRITE_SIZE, SPRITE_SIZE);

		images.put("stone", ss.getSprite(0, 0));
		images.put("grass", ss.getSprite(1, 0));
		images.put("dirt", ss.getSprite(2, 0));
		images.put("smoothStone", ss.getSprite(3, 0));
		images.put("heart", ss.getSprite(0, 1));
		images.put("halfheart", ss.getSprite(1, 1));
		images.put("water", ss.getSprite(4, 0));

		for (int i = 0; i < 8; i++)
			images.put("player" + i, ss.getSprite(i, 2));
	}

	public void setGraphics(Graphics2D g) {
		this.g = g;
	}

	public void render() {

		LevelTile lt = level.getCurrentLevelTile();

		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				drawTile(lt.getTile(x, y), x, y);
			}
		}

		for (Entity e : level.getEntites()) {
			if (e.shouldDraw()) {
				drawEntity(e);
			}
		}
	}

	public BufferedImage getImage(String image) {
		return images.get(image);
	}

	private void drawEntity(Entity e) {
		BufferedImage i = images.get(e.getTexture());

		int w = i.getWidth();
		int h = i.getHeight();

		g.drawImage(i.getScaledInstance(w * SCALE, h * SCALE, 0), e.x, e.y, null);
	}

	private void drawTile(Tile t, int x, int y) {
		BufferedImage bi = images.get(t.getTexture());

		int bw = bi.getWidth();
		int bh = bi.getHeight();

		Image i = bi.getScaledInstance(bw * SCALE, bh * SCALE, 0);

		int w = bw * SCALE;
		int h = bh * SCALE;

		g.drawImage(i, x * w, y * h, null);
	}
}
