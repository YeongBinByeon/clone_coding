package state;

public abstract class PlayerLevel {
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	// 훅 메서드, 부가적인 기능을 추가할 수 있음. 반드시 필요한 기능이 아닐 경우
	// 필요에 따라 하위 클래스에서 확장서 있게 구현해서 쓸 수 있게 만드는 경우.
	public void fly() {}
	
	
	//final public void go(int count) {
		

	//}
	
}
