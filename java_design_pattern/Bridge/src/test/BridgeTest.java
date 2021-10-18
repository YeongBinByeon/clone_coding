package test;

import impl.ArrayImpl;
import impl.LinkedListImpl;
import list.Queue;
import list.Stack;

public class BridgeTest {
	
	public static void main(String[] args) {
		Stack<String> linkedListStack = new Stack<String>(new LinkedListImpl<String>());
		linkedListStack.push("aa");
		linkedListStack.push("bb");
		linkedListStack.push("cc");
		
		System.out.println(linkedListStack.toString());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println("===============================");
		
		
		Stack<String> arrayStack = new Stack<String>(new ArrayImpl<String>());
		arrayStack.push("aa");
		arrayStack.push("bb");
		arrayStack.push("cc");
		
		System.out.println(arrayStack.toString());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println("===============================");
		
		
		Queue<String> arrayQueue = new Queue<String>(new ArrayImpl<String>());
		arrayQueue.enQueue("aa");
		arrayQueue.enQueue("bb");
		arrayQueue.enQueue("cc");
		
		System.out.println(arrayQueue.toString());
		System.out.println(arrayQueue.deQueue());
		System.out.println(arrayQueue.deQueue());
		System.out.println(arrayQueue.deQueue());
		System.out.println("===============================");
		
		
		Queue<String> linkedQueue = new Queue<String>(new LinkedListImpl<String>());
		linkedQueue.enQueue("aa");
		linkedQueue.enQueue("bb");
		linkedQueue.enQueue("cc");
		
		System.out.println(linkedQueue.toString());
		System.out.println(linkedQueue.deQueue());
		System.out.println(linkedQueue.deQueue());
		System.out.println(linkedQueue.deQueue());
		System.out.println("===============================");
	}
}
