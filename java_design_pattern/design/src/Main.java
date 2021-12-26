import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import adapter.AirConditioner;
import adapter.Cleaner;
import adapter.Electronic110V;
import adapter.HairDryer;
import adapter.SocketAdapter;
import aop.AopBrowser;
import decorator.A3;
import decorator.A4;
import decorator.A5;
import decorator.Audi;
import decorator.AudiDecorator;
import decorator.ICar;
import decorator.LowerCaseInputStream;
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
		
		
		// decorator
		ICar audi = new Audi(1000);
		audi.showPrice();
		
		//a3
		ICar audi3 = new A3(audi,"A3");
		audi3.showPrice();
		//a4
		ICar audi4 = new A4(audi,"A4");
		audi4.showPrice();
		
		//a5
		ICar audi5 = new A5(audi,"A5");
		audi5.showPrice();
		
		int c;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			while((c=in.read())>=0) {
				System.out.print((char)c);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void connect(Electronic110V electronic110V) {
		electronic110V.powerOn();
	}

}
