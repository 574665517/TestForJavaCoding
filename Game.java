package 猜拳游戏版本5;

/**
 * @author ywx
 * @ date 2019年5月30日
 */
public class Game {
	
	//封装属性
	private User user;//甲方玩家
	private Computer computer;//乙方玩家
	private int gameCount = 0;//对战次数
	
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

	//裁决结果,0打和 1用户赢 2电脑赢
	public int rule(int perFist, int compFist) {
		//裁决胜负
	       if (perFist == compFist) {
				System.out.println("结果:和局,真衰！嘿嘿,等着瞧吧 !\n");  //平局
				//1.剪刀 剪 3.布 赢；|| 2.石头 砸 1.剪刀 赢；|| 3.布 盖 2.石头 赢；
			} else if ((perFist == 1 && compFist == 3) || 
					(perFist == 2  && compFist == 1) || (perFist == 3 && compFist == 2)) {
				System.out.println("结果： 恭喜， 你赢了！");  //用户赢
				int s = user.getScore() + 1;//电脑加一分
				user.setScore(s);
				return 1;
			} else {
				System.out.println("结果说:^_^,你输了，真笨!\n");  //计算机赢
				computer.setScore(computer.getScore() + 1);//电脑加一分
				return 2;
			}
	       return 0;
	}
	
	//计算结果
	public int calcResult() {
		if (user.getScore() == computer.getScore()) {
			return 0; //平局
		} else if (user.getScore() > computer.getScore()) {
			return 1; //用户赢
		} else {
			return 2; //计算机赢
	 	}  
	}
	
	//显示结果
	public String showResult() {
		/*显示最后结果*/
		StringBuffer ss = new StringBuffer();
		ss.append("------------对战结果-----------");
		ss.append("\n 对战次数 ：" + this.gameCount);
		ss.append("\n" + user.getName() + "VS" + computer.getName());
		int result = calcResult();
		if(result == 0) {
			System.out.println("\n和局！");
		} else if(result == 1) {
			System.out.println("\n 玩家" + user.getName() + "赢了！");
		} else {
			System.out.println("\n 电脑" + computer.getName() + "赢了！");
		}
		return ss.toString();
//		String str = "------------对战结果-----------";
//		str += "\n 对战次数 ：" + this.gameCount;
//		str += "\n" + user.getName() + "VS" + computer.getName();
//		int result = calcResult();
//		if (result == 0) {
//			str += "\n和局！";
//		} else if (result == 1) {
//			str += "\n 玩家" + user.getName() + "赢了！";
//		} else { 
//			str += "\n 电脑" + computer.getName() + "赢了！";
//		}
//		str += "---------------------------";
//		return str;
	}
}
