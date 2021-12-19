import adapter.AirConditioner;
import adapter.Cleaner;
import adapter.Electronic110V;
import adapter.HairDryer;
import adapter.SocketAdapter;

public class Main {

	public static void main(String[] args) {
		
		
		HairDryer hairDryer = new HairDryer();
		connect(hairDryer);
		
		Cleaner cleaner = new Cleaner();
		
		Electronic110V adapter = new SocketAdapter(cleaner);
		connect(adapter);
		
		AirConditioner airConditioner = new AirConditioner();
		Electronic110V adapter2 = new SocketAdapter(airConditioner);
		connect(adapter2);
	}
	
	public static void connect(Electronic110V electronic110V) {
		electronic110V.powerOn();
	}

}
