package ��ȭ��Ϸ�汾5;

/**
 * @author ywx
 * @ date 2019��5��30��
 */
public class Computer {
	
	//��װһ������
	private String name = "����";//����
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

	/**
	 * ���Գ�ȭ����
	 * @return ������1.���� 2.ʯͷ 3.��
	 */
	public int punches() {
		int show = (int)((Math.random() * 10) % 3 + 1);
		switch(show) {
		case 1:
			System.out.println("��ʾ,���Գ�ȭ: ����");
			break;
		case 2:
			System.out.println("��ʾ���Գ�ȭ: ʯͷ");
			break;
		case 3:
			System.out.println("��ʾ���Գ�ȭ: ��");
			break;
		}
		return show;//���س�ȭ������
	}
}
