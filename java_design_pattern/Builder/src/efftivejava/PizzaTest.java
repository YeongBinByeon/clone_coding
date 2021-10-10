package efftivejava;

import efftivejava.NyPizza.Size;
import efftivejava.Pizza.Topping;


//https://m.blog.naver.com/iq_up/220013622883
// static class의 인스턴스는 모두 동일하지 않다. 정확한 이유는 잘 모르겠네..
public class PizzaTest {
	public static void main(String[] args) {
		Pizza pizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE)
				.addTopping(Topping.ONION).build();
		Pizza pizza1 = new NyPizza.Builder(Size.SMALL).addTopping(Topping.PEPPER)
				.addTopping(Topping.MUSHROOM).build();
		
		Pizza calzone = new Calzone.Builder().addTopping(Topping.HAM).addTopping(Topping.PEPPER)
				.sauceInside().build();
		
		System.out.println(pizza);
		System.out.println(pizza1);
		System.out.println(calzone);
	}
}
