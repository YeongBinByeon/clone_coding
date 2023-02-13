package duck;

public class main {

	public static void main(String[] args) throws Exception {
		Duck duck = new MallardDuck();
		duck.performFly();
		duck.setFlyBehavior(new FlyNoWay());
		duck.performFly();

	}

}
