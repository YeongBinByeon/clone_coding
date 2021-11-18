package memento;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento memento = gamer.createMemento();
		ArrayList<Memento> history = new ArrayList<Memento>();
		for(int i=0; i<100; i++) {
			System.out.println("==== " + i);
			System.out.println("�� ����: " + gamer); // ���� ���ΰ��� ���� ǥ��
			
			gamer.bet();
			
			System.out.println("����" + gamer.getMoney() +"���� �Ǿ����ϴ�.");
			
			if(gamer.getMoney() > memento.getMoney()) {
				System.out.println(" (���� ���� ���������� ��������) ");
				memento = gamer.createMemento();
				history.add(memento);
			}
			else if(gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println(" (���� ���� �پ����� �������� ) ");
				gamer.restoreMemento(memento);
			}
			
			//�ð��� ��ٸ�
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			System.out.println("");
		}
		
	}

}
