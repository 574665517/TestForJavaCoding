package ��ȭ��Ϸ�汾5;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author ywx
 * @ date 2019��5��30��
 */
public class User {
	
	//��װһ������
	private String name = "ɭ��";//����
	private int score;//����
	
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
		if (btnObj == gameUI.jdbtn) {//�û�������
			perFist = 1;
			ImageIcon perImg2 = new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/j.png");
			gameUI.preqlbl.setIcon(perImg2);
		} if (btnObj == gameUI.stbtn) {//�û���ʯͷ
			perFist = 2;
			ImageIcon perImg2 = new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/q.png");
			gameUI.preqlbl.setIcon(perImg2);
		} if (btnObj == gameUI.bubtn) {//�û�����
			perFist = 3;
			ImageIcon perImg2 = new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/b.png");
			gameUI.preqlbl.setIcon(perImg2);
		}
		return perFist;
	}
}
