package net.cebarks.ahome.gfx;

import static net.cebarks.ahome.AlmostHome.HEIGHT;
import static net.cebarks.ahome.AlmostHome.SCALE;
import static net.cebarks.ahome.AlmostHome.WIDTH;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import net.cebarks.ahome.AlmostHome;
import net.cebarks.ahome.gfx.gui.GuiDebug;
import net.cebarks.ahome.gfx.gui.GuiInGame;

public class RenderEngine implements Runnable {

	private LevelRenderer levelRenderer;
	private GuiInGame gameGui;
	private GuiDebug debugGui;
	private AlmostHome game;
	private int frames = 0;

	public RenderEngine(AlmostHome a) {
		this.game = a;
		levelRenderer = new LevelRenderer(a.getLevel());
		gameGui = new GuiInGame(a.getLevel());
		debugGui = new GuiDebug(a.getLevel());
	}

	public void run() {

		long lastTime = System.currentTimeMillis();

		int period = 30;

		while (true) {
			long now = System.currentTimeMillis();
			lastTime = now;
			
			render();
			frames++;

			int timeDiff = (int) (System.currentTimeMillis() - lastTime);
			
			int tts = period - timeDiff;
			
			if(tts <= 0)
				tts = 1;
			
			sleep(tts);
		}
	}

	public int getFrames() {
		return frames;
	}

	public void setFrames(int f) {
		frames = f;
	}

	public void sleep(long nsa) {
		try {
			Thread.sleep(nsa);
		} catch (InterruptedException e) {
		}
	}

	public void render() {
		BufferStrategy bs = game.getBufferStrategy();
		if (bs == null) {
			game.createBufferStrategy(2);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		levelRenderer.setGraphics((Graphics2D) g);
		gameGui.setGraphics((Graphics2D) g);
		debugGui.setGraphics((Graphics2D) g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

		if (game.isPlaying()) {
			levelRenderer.render();
			gameGui.render();
		}

		if (game.isDebug()) {
			debugGui.render();
		}

		g.setColor(Color.WHITE);

		g.dispose();
		bs.show();
	}
}
