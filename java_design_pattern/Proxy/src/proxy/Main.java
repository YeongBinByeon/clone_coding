package proxy;

public class Main {

	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("������ �̸���" + p.getPrinterName() + "�Դϴ�.");
		p.setPrinterName("Bob");
		p.print("test");
		
		p.print("hello");
		p.setPrinterName("Tomas");
		p.print("world");
	}

}
