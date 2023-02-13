package duck;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("이 객체는 날개를 가지고 날아다닙니다.");
	}

}
