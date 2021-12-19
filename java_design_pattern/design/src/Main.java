import java.util.concurrent.atomic.AtomicLong;

import adapter.AirConditioner;
import adapter.Cleaner;
import adapter.Electronic110V;
import adapter.HairDryer;
import adapter.SocketAdapter;
import aop.AopBrowser;
import observer.Button;
import observer.IButtonListener;
import proxy.Browser;
import proxy.BrowserProxy;
import proxy.IBrowser;

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
		
		
		// proxy
		
		IBrowser borwser = new Browser("www.naver.com");
		borwser.show();
		borwser.show();
		borwser.show();
		borwser.show();
		
		IBrowser borwser1 = new BrowserProxy("www.naver.com");
		borwser1.show();
		borwser1.show();
		borwser1.show();
		borwser1.show();
		
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();
		
		IBrowser aopBorwser = new AopBrowser("www.naver.com",
				()->{
					System.out.println("before");
					start.set(System.currentTimeMillis());
				}
				,
				()->{
					end.set(System.currentTimeMillis() - start.get());
				}
				);
		aopBorwser.show();
		System.out.println("loading time : "+ end.get());
		aopBorwser.show();
		System.out.println("loading time : "+ end.get());
		
		// observer
		Button button = new Button("버튼");
		
		button.addListener(new IButtonListener() {
			public void clickEvent(String event) {
				System.out.println(event);
			}
		});
		button.click("메시지 전달: click1");
		button.click("메시지 전달: click2");
		button.click("메시지 전달: click3");
		button.click("메시지 전달: click4");
		
		
	}
	
	public static void connect(Electronic110V electronic110V) {
		electronic110V.powerOn();
	}

}
