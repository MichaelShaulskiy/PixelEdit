package me.interject.gamma;

import java.awt.Color;

/**
 * Created by mshau on 03.09.2016.
 */
public class Pixel {
	private Color color;
	private int[] position = new int[2];

	public Pixel(){
		color = new Color(0, 0 ,0);
		position[0] = 0;
		position[1] = 0;
	}

	public Pixel(Color color, int x, int y){
		this.color = color;
		position[0] = x;
		position[1] = y;
 	}

 	public Color getColor(){
 		return color;
	}

	public int getX(){
		return position[0];
	}

	public int getY(){
		return position[1];
	}
}
