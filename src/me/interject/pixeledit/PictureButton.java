package me.interject.pixeledit;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mshau on 04.09.2016.
 */
public class PictureButton extends JButton {
	private Image image;
	private Color backgroundColor = new Color(0, 0, 0);
	private boolean hasBackground = false;

	public PictureButton(Image image){
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
