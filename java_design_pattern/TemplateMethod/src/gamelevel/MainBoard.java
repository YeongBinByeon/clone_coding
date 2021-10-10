package gamelevel;

public class MainBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player player = new Player();

		player.play(1);
		
		PlayerLevel level = new AdvancedLevel();
		player.upgradeLevel(level);
		
		player.play(2);
		
		level = new SuperLevel();
		player.upgradeLevel(level);
		player.play(5);
	}

}
