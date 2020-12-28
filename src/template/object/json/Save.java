package template.object.json;

public class Save {

	public double money;
	public int savePoint;
	public int time;
	public String playerName;
	
	public Save(double money, int savePoint, int time, String playerName) {
		this.money = money;
		this.savePoint = savePoint;
		this.time = time;
		this.playerName = playerName;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setPlayerName(String newPlayerName) {
		this.playerName = newPlayerName;
	}
}
