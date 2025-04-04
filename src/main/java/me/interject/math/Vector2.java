package me.interject.math;

/**
 * Created by mshau on 03.09.2016.
 */
public class Vector2<T> {
	private T[] elements = (T[])new Object[2];

	Vector2(T x, T y) {
		elements[0] = x;
		elements[1] = y;
	}

	public T getX(){
		return elements[0];
	}

	public T getY(){
		return elements[1];
	}

	public Vector2<T> get(){
		return this;
	}
}
