package adapter;

public class AirConditioner implements Electronic220V {

	@Override
	public void connect() {
		System.out.println("¿¡ÀÌÄÁ 220V on");
	}

}
