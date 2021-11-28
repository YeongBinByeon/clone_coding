package responsibility;

public class Trouble {
	private int number; // 트러블 번호
	public Trouble(int number) { // 트러블의 생성
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public String toString() {
		return "[Trouble " + number + "]";
	}

}
