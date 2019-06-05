package 猜拳游戏版本5;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author ywx
 * @ date 2019年5月30日
 */
public class User {
	
	//封装一下属性
	private String name = "森哥";//名字
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

	public int punches(GameUI gameUI, JButton btnObj) {
		int perFist = 0;
		if (btnObj == gameUI.jdbtn) {//用户出剪刀
			perFist = 1;
			ImageIcon perImg2 = new ImageIcon("src/猜拳游戏版本3/图片素材/j.png");
			gameUI.preqlbl.setIcon(perImg2);
		} if (btnObj == gameUI.stbtn) {//用户出石头
			perFist = 2;
			ImageIcon perImg2 = new ImageIcon("src/猜拳游戏版本3/图片素材/q.png");
			gameUI.preqlbl.setIcon(perImg2);
		} if (btnObj == gameUI.bubtn) {//用户出布
			perFist = 3;
			ImageIcon perImg2 = new ImageIcon("src/猜拳游戏版本3/图片素材/b.png");
			gameUI.preqlbl.setIcon(perImg2);
		}
		return perFist;
	}
}
