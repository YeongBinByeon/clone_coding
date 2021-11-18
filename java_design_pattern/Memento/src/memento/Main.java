package memento;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento memento = gamer.createMemento();
		ArrayList<Memento> history = new ArrayList<Memento>();
		for(int i=0; i<100; i++) {
			System.out.println("==== " + i);
			System.out.println("현 상태: " + gamer); // 현재 주인공의 상태 표시
			
			gamer.bet();
			
			System.out.println("돈은" + gamer.getMoney() +"원이 되었습니다.");
			
			if(gamer.getMoney() > memento.getMoney()) {
				System.out.println(" (많은 돈이 증가했으니 저장하자) ");
				memento = gamer.createMemento();
				history.add(memento);
			}
			else if(gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println(" (많은 돈이 줄었으니 복원하자 ) ");
				gamer.restoreMemento(memento);
			}
			
			//시간을 기다림
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			System.out.println("");
		}
		
	}

}
