package net.cebarks.ahome.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage spriteSheet;
	private int spriteWidth;
	private int spriteHeight;

	public SpriteSheet(BufferedImage bi, int width, int height) {

		spriteWidth = width;
		spriteHeight = height;

		spriteSheet = bi;
	}

	public BufferedImage getSprite(int x, int y) {
		return spriteSheet.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight);
	}
	
	public BufferedImage getSprite(int i) {
		
		int x = 0;
		int y = 0;
		
		while(i < 15) {
			i -= 15;
			y += 1;
		}
		
		x = i;
		
		return getSprite(x, y);
	}
}
