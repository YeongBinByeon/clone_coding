package factorymethod;

import java.util.HashMap;

public class HyundaiCarFactory extends CarFactory{
	
	HashMap<String, Car> carMap = new HashMap<String, Car>();

	@Override
	public Car createCar(String name) {
		Car car = null;
		
		if (name == "sonata") {
			car = new Sonata();
		}
		else if (name == "santafe") {
			car = new Santafe();
		}
		
		return car;
	}
	
	//팩토리 패턴에서 아래와 같이 이미 생성된 인스턴스는 저장하여 관리하고, 없는 인스턴스만 생성하는 방식으로 사용할 수 있다.
	public Car returnCar(String name) {
		Car car = carMap.get(name);
		
		if(car == null) {
			if(name.equals("Tomas")) {
				car = new Sonata();
			}
			else if(name.equals("James"))
			{
				car = new Santafe();
			}
			carMap.put(name, car);
		}
		return car;
	}

}
