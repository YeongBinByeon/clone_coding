package duck;

public abstract class Duck {
	
	protected FlyBehavior flyBehavior;
	
	protected void swim() {
		System.out.println("��� ������ ������ �� �ִ�.");
	}
	
	protected abstract void display();
	
	protected void performFly() throws Exception {
		if(this.flyBehavior == null) {
			throw new Exception("�ʱ�ȭ �� �� ����");
		}
		this.flyBehavior.fly();
	}
	
	protected void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
}
