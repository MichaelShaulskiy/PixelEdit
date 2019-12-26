package me.interject.pixeledit;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mshau on 04.09.2016.
 */
public class RadialControl extends JPanel{
	public RadialControl(){
		super();
		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(100,100,100,100);
		g.setColor(new Color(12, 0, 255));
		g.fillOval(100,100,100,100);
	}
}
