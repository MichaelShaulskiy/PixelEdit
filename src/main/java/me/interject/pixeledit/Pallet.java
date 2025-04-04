package me.interject.pixeledit;

import java.awt.Color;

/**
 * Created by mshau on 03.09.2016.
 */
public class Pallet {
	private int size;
	private Color[] colors;

	public Pallet(int size){
		this.size = size;
		colors = new Color[size];
	}


	/* TODO: generate color palletes procedually */
	public void generatePallete(int base, int offset){
		int tempOffset = offset;
		int currentColor = 0;
		for(int tempBase = base; tempBase < (base + Math.pow(2, offset)); tempBase += offset){
			colors[currentColor] = new Color(tempBase % 255, (int)(tempBase + Math.pow(2, tempBase)) % 255, (int)(Math.abs(tempBase - Math.pow(tempBase, 2))) % 255);
		}
	}
}
