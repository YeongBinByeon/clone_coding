package coffee;

public class CoffeeTest {

	public static void main(String[] args) {
		Coffee KeyaCoffee = new KeyaCoffee();
		KeyaCoffee.brewing();
		
		System.out.println();
		
		Coffee KeyaLatte = new Latte(KeyaCoffee);
		KeyaLatte.brewing();
		
		System.out.println();
		Coffee mochaKeya = new MochaCoffee(new Latte(new KeyaCoffee()));
		mochaKeya.brewing();
		
		System.out.println("");
		Coffee etiopiaCoffee = new MochaCoffee(new Latte(new EtiopiaCoffee()));
		etiopiaCoffee.brewing();
	}

}
