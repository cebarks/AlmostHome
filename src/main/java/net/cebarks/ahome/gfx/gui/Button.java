package net.cebarks.ahome.gfx.gui;

import java.awt.image.BufferedImage;

public class Button {

	private int x;
	private int y;
	private BufferedImage image;

	public Button(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}

	public int getCenterX() {
		return (int) x - (image.getWidth() / 2);
	}

	public int getCenterY() {
		return (int) y - (image.getHeight() / 2);
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public boolean isWithinBounds(int mouseX, int mouseY) {
		if ((mouseY > getY() && mouseY < (getY() + getHeight())) && (mouseX > getX() && mouseX < (getX() + getWidth())))
			return true;
		return false;
	}
}
