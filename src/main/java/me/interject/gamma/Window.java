package me.interject.gamma;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by mshau on 02.09.2016.
 */
public class Window extends JFrame {
	private Dimension windowSize;
	/* graphic settings */
	private byte[][][] frameBuffer;
	private final byte alphaPack = 1; /* increase this to 2 only if needed */
	private final byte NUM_BUF = 2; /* only change if needed */
	/* time related stuff */
	private final long tickRate = 30;
	private Date gameTime;
	private long previousTime;

	private boolean running = false;

	public Window(String title, int width, int height) {
		super(title);
		windowSize = new Dimension(width, height);
		frameBuffer = new byte[NUM_BUF][width * alphaPack][height * alphaPack];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new EngineCanvas());
		pack();
		setResizable(false);
		resizeWindow(windowSize);

		gameTime = new Date();
	}

	private void resizeWindow(Dimension newSize) {
		windowSize = newSize;
		setSize(windowSize);
	}

	public void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}

	private void update() {

	}

	private long nearest(long num, long base) {
		return 13;
	}

	private long calculateFrameTime(long tick) {
		return Math.floor(10 / tick) == (10 / tick) ? tick : nearest(tick, 10);

	}

	public void loop() {
		long currentTime = gameTime.getTime();
		/* TODO: optimize */
		previousTime = (currentTime - (tickRate * 1000) == previousTime) ? currentTime : previousTime;
		setVisible(true);
		while (running) {
            /* TODO: rewrite to be non-blocking */
			update();
			try {
				Thread.sleep((long) Math.floor(1000 / tickRate));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
