package responsibility;

public class Trouble {
	private int number; // Ʈ���� ��ȣ
	public Trouble(int number) { // Ʈ������ ����
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public String toString() {
		return "[Trouble " + number + "]";
	}

}
