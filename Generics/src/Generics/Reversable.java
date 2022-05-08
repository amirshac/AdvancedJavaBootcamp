package Generics;

import java.util.List;

public interface Reversable<T> {
	public List<T> reverse(List<T> source);
}
