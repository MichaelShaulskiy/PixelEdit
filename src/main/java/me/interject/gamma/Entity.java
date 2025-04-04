package me.interject.gamma;

import java.awt.*;

/**
 * Created by mshau on 02.09.2016.
 */
public abstract class Entity {
	private Renderable sprite;
	private Dimension size;
	private Dimension position;
	private Dimension collision;
	private long z_index;

	public Entity() {

	}
}
