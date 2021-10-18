package coffee;

public class MochaCoffee extends Decorator {

	public MochaCoffee(Coffee coffee) {
		super(coffee);
		// TODO Auto-generated constructor stub
	}
	
	public void brewing() {
		super.brewing();
		System.out.println("Adding Mocha Syrup");
	}

}
