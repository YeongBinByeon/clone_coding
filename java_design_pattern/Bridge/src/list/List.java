package list;

import impl.AbstractList;

public abstract class List<T> {
	
	AbstractList<T> impl;
	
	public List(AbstractList<T> list) {
		impl = list;
	}
	
	public void add(T obj) {
		impl.addElement(obj);
	}
	
	public T remove(int i) {
		return impl.deleteElement(i);
	}
	
	public T get(int i) {
		return impl.getElement(i);
	}
	
	public int getSize() {
		return impl.getElementSize();
	}
	
	public String toString() {
		return impl.toString();
	}
	
}
