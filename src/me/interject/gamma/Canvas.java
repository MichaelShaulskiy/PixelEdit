package me.interject.gamma;

import javax.swing.*;
import java.awt.*;


/**
 * Created by michaelshaulskiy on 12.09.16.
 */
public abstract class Canvas extends JPanel {
	protected Color[] colors = new Color[2];
	private long canvasSize;
	protected int width = 800;
	protected int height = 600;
	protected int pixelSize = 1;
	//private Dimension boundingBox;
	protected int scale;
	//private ScriptEngine shaderScript;
	protected long renderOptions = 0x0L;

	public Canvas(){
		colors[0] = new Color(0, 0, 0);
		colors[1] = new Color(255, 255, 255);
		canvasSize = width * height;
	}

	private void clear() {
		repaint();
	}

	public void setForegroundColor(Color color){
		colors[1] = color;
	}

	public void setBackgroundColor(Color color){
		colors[0] = color;
	}

	public long getPixelSize(){
		return pixelSize;
	}

	public void setPixelSize(int size){
		pixelSize = size;
	}

	public void paint(Pixel p){
		repaint();
	}

	public void windowSizeChanged(Dimension size){
		setSize(size);
		width = size.width;
		height = size.height;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
