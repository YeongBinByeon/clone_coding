package duck;

public abstract class Duck {
	
	protected FlyBehavior flyBehavior;
	
	protected void swim() {
		System.out.println("모든 오리는 수영할 수 있다.");
	}
	
	protected abstract void display();
	
	protected void performFly() throws Exception {
		if(this.flyBehavior == null) {
			throw new Exception("초기화 안 됨 에러");
		}
		this.flyBehavior.fly();
	}
	
	protected void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
}
