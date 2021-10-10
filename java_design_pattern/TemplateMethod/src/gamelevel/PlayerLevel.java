package gamelevel;

public abstract class PlayerLevel {
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	// �� �޼���, �ΰ����� ����� �߰��� �� ����. �ݵ�� �ʿ��� ����� �ƴ� ���
	// �ʿ信 ���� ���� Ŭ�������� Ȯ�弭 �ְ� �����ؼ� �� �� �ְ� ����� ���.
	public void fly() {}
	
	// ���ø� �޼��� ������ ������ �ó������� (���ϸ� �ȵ�, �׷��� final�� ����) ���� Ŭ�������� ��� ������ ��Ű�� ����.
	// �Ʒ� go() �޼��尡 ���ø� �޼����� �θ� �� �ִ�.
	final public void go(int count) {
		
		run();
		
		for(int i=0; i<count; i++) {
			jump();
		}
		
		turn();
		
		fly();
	}
	
}
