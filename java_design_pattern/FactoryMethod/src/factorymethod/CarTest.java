package factorymethod;

public class CarTest {
	
	public static void main(String[] args) {
		CarFactory factory = new HyundaiCarFactory();
		Car newCar = factory.createCar("sonata");
		
		System.out.println(newCar);
		
		Car myCar = factory.returnCar("Tomas");
		Car hisCar = factory.returnCar("Tomas");
		
		//이름이 같으면 같은 인스턴스를 관리해서 리턴해준다는 것을 알 수 있다.
		System.out.println(myCar == hisCar);
	}

}
