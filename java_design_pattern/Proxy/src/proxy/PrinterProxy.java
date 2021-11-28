package proxy;

public class PrinterProxy implements Printable{
	private String name; //�̸�
	private Printer real; // "����"
	public PrinterProxy() {
		
	}
	
	public PrinterProxy(String name) { // ������
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		System.out.println("proxy : getName() ");
		return name;
	}

	@Override
	public void setPrinterName(String name) {
		if(real!=null) {
			real.setPrinterName(name);
		}
		System.out.println("proxy : setName() ");
		this.name = name;
	}

	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}
	
	public synchronized void realize() {
		if(real == null) {
			real = new Printer(name);
		}
	}
}
