package proxy;

public class Main {

	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("현재의 이름은" + p.getPrinterName() + "입니다.");
		p.setPrinterName("Bob");
		p.print("test");
		
		p.print("hello");
		p.setPrinterName("Tomas");
		p.print("world");
	}

}
