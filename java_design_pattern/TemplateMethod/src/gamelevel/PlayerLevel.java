package gamelevel;

public abstract class PlayerLevel {
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	// 훅 메서드, 부가적인 기능을 추가할 수 있음. 반드시 필요한 기능이 아닐 경우
	// 필요에 따라 하위 클래스에서 확장서 있게 구현해서 쓸 수 있게 만드는 경우.
	public void fly() {}
	
	// 템플릿 메서드 패턴은 정해진 시나리오를 (변하면 안됨, 그래서 final로 선언) 하위 클래스에서 기능 구현을 시키기 위함.
	// 아래 go() 메서드가 템플릿 메서드라고 부를 수 있다.
	final public void go(int count) {
		
		run();
		
		for(int i=0; i<count; i++) {
			jump();
		}
		
		turn();
		
		fly();
	}
	
}
