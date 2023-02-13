package duck;

public class MallardDuck extends Duck{
	
	MallardDuck(){
		this.flyBehavior = new FlyWithWings();
	}

	@Override
	protected
	void display() {
		
	}

}
