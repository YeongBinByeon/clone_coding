package state;

public class MainBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player player = new Player();

		player.play(1);
		
		PlayerLevel alevel = new AdvancedLevel();
		player.upgradeLevel(alevel);
		
		player.play(2);
		
		PlayerLevel slevel = new SuperLevel();
		player.upgradeLevel(slevel);
		player.play(5);
	}

}
