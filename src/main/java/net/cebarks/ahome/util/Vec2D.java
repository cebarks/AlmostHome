package net.cebarks.ahome.util;

public class Vec2D {
	private int x;
	private int y;

	private Vec2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vec2D get(int x, int y) {
		return new Vec2D(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Vec2D add(Vec2D v) {
		return new Vec2D(x + v.x, y + v.y);
	}
}
