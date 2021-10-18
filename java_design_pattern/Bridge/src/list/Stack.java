package list;

import impl.AbstractList;

public class Stack<T> extends List<T> {

	public Stack(AbstractList<T> list) {
		super(list);
		System.out.println("Stack�� �����մϴ�.");
	}
	
	public void push(T obj) {
		impl.insertElement(obj, 0);
	}
	
	public T pop() {
		return impl.deleteElement(0);
	}

}
