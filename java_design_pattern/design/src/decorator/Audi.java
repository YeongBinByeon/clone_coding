package decorator;

public class Audi implements ICar{

	private int price;
	
	public Audi(int price) {
		this.price = price;
	}
	
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void showPrice() {
		System.out.println("audi�� ������ " + this.price +"�� �Դϴ�.");
	}

}
