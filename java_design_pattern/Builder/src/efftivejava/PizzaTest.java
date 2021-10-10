package efftivejava;

import efftivejava.NyPizza.Size;
import efftivejava.Pizza.Topping;


//https://m.blog.naver.com/iq_up/220013622883
// static class�� �ν��Ͻ��� ��� �������� �ʴ�. ��Ȯ�� ������ �� �𸣰ڳ�..
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
