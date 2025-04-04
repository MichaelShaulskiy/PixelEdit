package me.interject.gamma;

import java.util.List;
import java.awt.Dimension;
import java.util.LinkedList;
/**
 * Created by mshau on 07.09.2016.
 */
public interface Renderable {
	List<Pixel> draw();
	List<Pixel> transpose();
	void setOpacity(int alpha);
	int getOpacity();
	Dimension getSize();
	void setSize(Dimension size);
	/* TODO: move this to Entity */
	default List<Renderable> depthSort(Renderable... rend) {
		for (Renderable renderable : rend) {

		}
		/* temporary solution for compilation */
		return new LinkedList<Renderable>();
	}

	default List<Renderable> sizeSort(Renderable... rend) {
		/* temporary solution for compilation */
		return new LinkedList<Renderable>();
	}
}