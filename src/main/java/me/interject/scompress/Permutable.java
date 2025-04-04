package me.interject.scompress;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by michaelshaulskiy on 15.09.16.
 */
public interface Permutable<T> {
	Vector<T> permutate(Collection element);
}
