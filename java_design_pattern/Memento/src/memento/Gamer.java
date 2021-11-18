package memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Gamer {
	private int money;
	private ArrayList<String> fruits = new ArrayList<String>();
	private Random random = new Random();
	private static String[] fruitsname = {
		"���", "����", "�ٳ���", "��",	
	};
	
	public Gamer(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void bet() {
		int dice = random.nextInt(6) + 1;
		if(dice == 1) {
			money += 100;
			System.out.println("���� �����߽��ϴ�.");
		}else if(dice == 2) {
			money /= 2;
			System.out.println("���� ������ �پ����ϴ�.");
		}else if(dice == 6) {
			String f = getFruit();
			System.out.println("����("+f+")�� �޾ҽ��ϴ�.");
			fruits.add(f);
		}else {
			System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҽ��ϴ�.");
		}
		
	}
	
	public Memento createMemento() {
		Memento memento = new Memento(money);
		Iterator<String> fruit = fruits.iterator();
		
		while(fruit.hasNext()) {
			String name = fruit.next();
			if(name.startsWith("good~")) {
				memento.addFruit(name);
			}
		}
		return memento;
	}
	
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.fruits;
	}
	
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	
	private String getFruit() {
		String prefix = "";
		if(random.nextBoolean()) {
			prefix = "good~";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
