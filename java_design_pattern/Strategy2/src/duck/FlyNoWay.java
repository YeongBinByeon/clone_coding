package duck;

public class FlyNoWay implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("이 객체는 날 수 없습니다.");
	}

}
