package ��ȭ��Ϸ�汾5;

/**
 * @author ywx
 * @ date 2019��5��30��
 */
public class Game {
	
	//��װ����
	private User user;//�׷����
	private Computer computer;//�ҷ����
	private int gameCount = 0;//��ս����
	
	public Game(User user, Computer computer) {
		this.user = user;
		this.computer = computer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}

	//�þ����,0��� 1�û�Ӯ 2����Ӯ
	public int rule(int perFist, int compFist) {
		//�þ�ʤ��
	       if (perFist == compFist) {
				System.out.println("���:�;�,��˥���ٺ�,�����ư� !\n");  //ƽ��
				//1.���� �� 3.�� Ӯ��|| 2.ʯͷ �� 1.���� Ӯ��|| 3.�� �� 2.ʯͷ Ӯ��
			} else if ((perFist == 1 && compFist == 3) || 
					(perFist == 2  && compFist == 1) || (perFist == 3 && compFist == 2)) {
				System.out.println("����� ��ϲ�� ��Ӯ�ˣ�");  //�û�Ӯ
				int s = user.getScore() + 1;//���Լ�һ��
				user.setScore(s);
				return 1;
			} else {
				System.out.println("���˵:^_^,�����ˣ��汿!\n");  //�����Ӯ
				computer.setScore(computer.getScore() + 1);//���Լ�һ��
				return 2;
			}
	       return 0;
	}
	
	//������
	public int calcResult() {
		if (user.getScore() == computer.getScore()) {
			return 0; //ƽ��
		} else if (user.getScore() > computer.getScore()) {
			return 1; //�û�Ӯ
		} else {
			return 2; //�����Ӯ
	 	}  
	}
	
	//��ʾ���
	public String showResult() {
		/*��ʾ�����*/
		StringBuffer ss = new StringBuffer();
		ss.append("------------��ս���-----------");
		ss.append("\n ��ս���� ��" + this.gameCount);
		ss.append("\n" + user.getName() + "VS" + computer.getName());
		int result = calcResult();
		if(result == 0) {
			System.out.println("\n�;֣�");
		} else if(result == 1) {
			System.out.println("\n ���" + user.getName() + "Ӯ�ˣ�");
		} else {
			System.out.println("\n ����" + computer.getName() + "Ӯ�ˣ�");
		}
		return ss.toString();
//		String str = "------------��ս���-----------";
//		str += "\n ��ս���� ��" + this.gameCount;
//		str += "\n" + user.getName() + "VS" + computer.getName();
//		int result = calcResult();
//		if (result == 0) {
//			str += "\n�;֣�";
//		} else if (result == 1) {
//			str += "\n ���" + user.getName() + "Ӯ�ˣ�";
//		} else { 
//			str += "\n ����" + computer.getName() + "Ӯ�ˣ�";
//		}
//		str += "---------------------------";
//		return str;
	}
}
