package scheduler;

public class AgentGetCall implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("������ ���� ��ȭ ��û.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("������ ��ȭ ����� ���������ϴ�.");
	}

}
