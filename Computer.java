package 猜拳游戏版本5;

/**
 * @author ywx
 * @ date 2019年5月30日
 */
public class Computer {
	
	//封装一下属性
	private String name = "掐死";//名字
	private int score;//积分
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * 电脑出拳方法
	 * @return 出的是1.剪刀 2.石头 3.布
	 */
	public int punches() {
		int show = (int)((Math.random() * 10) % 3 + 1);
		switch(show) {
		case 1:
			System.out.println("显示,电脑出拳: 剪刀");
			break;
		case 2:
			System.out.println("显示电脑出拳: 石头");
			break;
		case 3:
			System.out.println("显示电脑出拳: 布");
			break;
		}
		return show;//返回出拳的数字
	}
}
