package me.interject.pixeledit;

import me.interject.gamma.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mshau on 04.09.2016.
 */
public class Ruler extends me.interject.gamma.Canvas {
	private Dimension size = new Dimension(800, 600);
	private int spacing = 15;
	public enum Orientation {
		VERTICAL,
		HORIZONTAL
	}
	public Ruler() {
		System.out.println(Toolkit.getDefaultToolkit().getScreenResolution());
	}

	@Override
	public void paint(Pixel p) {
		super.paint(p);
	}


	private void drawTicks(Graphics g) {
		g.setColor(Color.ORANGE);
		for(int i = 0; i < (int)Math.ceil(size.width/spacing); i += spacing) g.drawLine(0, i, 100, i);
	}



}
