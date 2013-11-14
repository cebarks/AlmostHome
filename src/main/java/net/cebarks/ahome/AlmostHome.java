package net.cebarks.ahome;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.cebarks.ahome.gfx.RenderEngine;
import net.cebarks.ahome.gfx.SpriteSheet;
import net.cebarks.ahome.level.Level;

public class AlmostHome extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private Dimension perfDim = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

	public static final int WIDTH = 256;
	public static final int HEIGHT = 256;
	public static final int SCALE = 2;
	public static final String NAME = "AlmostHome Alpha";

	private Input input;
	private int mouseX;
	private int mouseY;

	private JFrame frame;

	private Level level;

	public SpriteSheet spriteSheet;

	@SuppressWarnings(value = "unused")
	private Options options = new Options(AlmostHome.class.getResource("config.txt").getPath());
	private Version version = new Version(AlmostHome.class.getResource("version.txt").getPath());

	private boolean running;
	private boolean playing;

	private int fps;
	private int tps;
	public long tickCount;

	private boolean debug;
	private boolean garbageCollect;

	private RenderEngine renderEngine;

	public AlmostHome() {
		setMinimumSize(perfDim);
		setMaximumSize(perfDim);
		setPreferredSize(perfDim);

		frame = new JFrame(NAME + " " + version.getVersion());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		input = new Input();

		frame.addKeyListener(input);
		
		frame.requestFocus();
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void run() {
		debug = Boolean.parseBoolean(JOptionPane.showInputDialog("Debug mode?"));

		long t = System.currentTimeMillis();
		
		level = new Level(this, "anten");

		System.out.println("level generated in " + (System.currentTimeMillis() - t) + "ms");

		renderEngine = new RenderEngine(this);
		new Thread(renderEngine).start();
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 50D;
		
		int ticks = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		playing = true;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
			}

			if (System.currentTimeMillis() - lastTimer >= 500) {
				lastTimer += 1000;

				fps = renderEngine.getFrames();
				tps = ticks;

				renderEngine.setFrames(0);
				ticks = 0;
			}
		}
	}

	public void tick() {
		level.tick();

		handleInput();
		updateMouseCoords();

		if (tickCount % 100 == 0) {
			garbageCollect();
		}

		if (tickCount % 25 == 0 && shouldGarbageCollect()) {
			System.gc();
		}
		
		if(!frame.hasFocus())
			requestFocus();

		tickCount++;
	}
	
	public void sleep(long ms, int ns) {
		try {
			Thread.sleep(ms, ns);
		} catch (InterruptedException e) {
		}
	}

	public void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

	private void updateMouseCoords() {
		try {
			mouseX = getMousePosition().x;
			mouseY = getMousePosition().y;
		} catch (NullPointerException e) {
		}
	}

	private void handleInput() {
		if (input.isKeyDown(KeyEvent.VK_W))
			level.getPlayer().yToMove -= 2 * level.getPlayer().moveSpeed;
		if (input.isKeyDown(KeyEvent.VK_S))
			level.getPlayer().yToMove += 2 * level.getPlayer().moveSpeed;
		if (input.isKeyDown(KeyEvent.VK_A))
			level.getPlayer().xToMove -= 2 * level.getPlayer().moveSpeed;
		if (input.isKeyDown(KeyEvent.VK_D))
			level.getPlayer().xToMove += 2 * level.getPlayer().moveSpeed;
	}

	public RenderEngine getRenderer() {
		return renderEngine;
	}

	public void endGame() {
		playing = false;
	}

	public long getTickCount() {
		return tickCount;
	}

	public int getFPS() {
		return fps;
	}

	public int getTPS() {
		return tps;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public boolean shouldGarbageCollect() {
		return garbageCollect;
	}

	public void garbageCollect() {
		garbageCollect = true;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public boolean isPlaying() {
		return playing;
	}

	public static void main(String[] args) {
		new AlmostHome().start();
	}
}
