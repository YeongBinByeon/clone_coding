package adapter;

public class Cleaner implements Electronic220V {

	@Override
	public void connect() {
		System.out.println("Ã»¼Ò±â 220v on");
	}

}
