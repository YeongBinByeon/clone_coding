package state;

public abstract class PlayerLevel {
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	// �� �޼���, �ΰ����� ����� �߰��� �� ����. �ݵ�� �ʿ��� ����� �ƴ� ���
	// �ʿ信 ���� ���� Ŭ�������� Ȯ�弭 �ְ� �����ؼ� �� �� �ְ� ����� ���.
	public void fly() {}
	
	
	//final public void go(int count) {
		

	//}
	
}
