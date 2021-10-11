package scheduler;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		System.out.println("��ȭ ��� �Ҵ� ����� ���� �ϼ���.");
		System.out.println("R : �Ѹ� ���ʷ� �Ҵ�");
		System.out.println("L : ���� �ְų� ��Ⱑ ���� ���� �������� �Ҵ�");
		System.out.println("P : �켱������ ���� ���� ������ ���� �Ҵ�");
		System.out.println("A : ������ ��� ��������");
		
		int ch = System.in.read();
		
		Scheduler scheduler = null;
		if(ch=='r' || ch =='R') {
			scheduler = new RoundRobin();
		}
		else if(ch=='l' || ch =='L') {
			scheduler = new LeastJob();
		}
		else if(ch=='p' || ch =='P') {
			scheduler = new PriorityAllocation();
		}
		else if(ch=='a' || ch =='A') {
			scheduler = new AgentGetCall();
		}
		else {
			System.out.println("not support");
			return;
		}
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}

}
