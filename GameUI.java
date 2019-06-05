package 猜拳游戏版本5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * @author ywx
 * @ date 2019年5月30日
 */
public class GameUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1198437963899035702L;
	
	public JLabel preqlbl;//用户出拳提示
	private JLabel comqlbl;//电脑出拳提示
	public JButton jdbtn;//剪刀
	public JButton stbtn;//石头
	public JButton bubtn;//布
	private JLabel tiplbl;//结果提示
	
//	private static int computerScore = 0;//表示电脑得分
//	private static int personScore = 0;//表示玩家得分
	private static int gameCount = 0;//表示比赛次数
	
	private User user;
	private Computer computer;
	Game game;
	
	public GameUI() {
		init();
		this.setVisible(true);//设置窗口可见
	}

	private void init() {
		//在此处可以调用登录界面让用户输入用户名和选择对战的角色
		user = new User();//初始化
		computer = new Computer();//初始化构造函数
		game = new Game(user, computer);//初始化
		
		this.setSize(550, 500);//设置窗口大小
		//添加标题
		this.setTitle("猜拳游戏");
		ImageIcon icon = new ImageIcon("src/猜拳游戏版本3/图片素材/icon.jpg");
		this.setIconImage(icon.getImage());
		//设置程序居中
		this.setLocationRelativeTo(null);
		//设置窗口关闭程序既结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的布局
		this.setLayout(null);//空布局，绝对定位布局
		//找到图片路径
		ImageIcon miImg = new ImageIcon("src/猜拳游戏版本3/图片素材/m1.png");
		
		JLabel m1lbl = new JLabel();
		m1lbl.setIcon(miImg);//将图片添加到控件
		m1lbl.setBounds(27, 40, 85, 80);
		this.add(m1lbl);
		
		//用户出拳提示
		preqlbl = new JLabel();
		preqlbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/b.png"));//将图片添加到控件
		preqlbl.setBounds(125, 46, 50, 50);
		this.add(preqlbl);
		
		//vs
		JLabel vslbl = new JLabel();
		vslbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/vs1.png"));//将图片添加到控件
		vslbl.setBounds(230, 45, 70, 45);
		this.add(vslbl);
		
		//电脑出拳
		comqlbl = new JLabel();
		comqlbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/j.png"));//将图片添加到控件
		comqlbl.setBounds(350, 40, 85, 80);
		this.add(comqlbl);
		
		JLabel m2lbl = new JLabel();
		m2lbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/m2.png"));//将图片添加到控件
		m2lbl.setBounds(420, 40, 85, 80);
		this.add(m2lbl);
		
		jdbtn = new JButton();
		jdbtn.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/j.png"));
		jdbtn.setBounds(40, 150, 50, 50);
		this.add(jdbtn);
		
		stbtn = new JButton();
		stbtn.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/q.png"));
		stbtn.setBounds(40, 260, 50, 50);
		this.add(stbtn);
		
		bubtn = new JButton();
		bubtn.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/b.png"));
		bubtn.setBounds(40, 370, 50, 50);
		this.add(bubtn);
		
		tiplbl = new JLabel();
		tiplbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/w.png"));//将图片添加到控件
		tiplbl.setBounds(160, 130, 230, 125);
		this.add(tiplbl);
		
		JLabel vs2lbl = new JLabel();
		vs2lbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/vs.png"));//将图片添加到控件
		vs2lbl.setBounds(125, 255, 330, 190);
		this.add(vs2lbl);
		
		jdbtn.addActionListener(this);
		stbtn.addActionListener(this);
		bubtn.addActionListener(this);
		
//		this.addWindowListener(new MyWindowEvent());
	
		this.addWindowListener(new WindowAdapter() {
		
			//窗口关闭前事件
			@Override
			public void windowClosing(WindowEvent e) {
				//保存用户数据
				System.out.println("保存用户数据:" + user.getScore());
//				try {
					String data = "本轮成绩" + user.getScore();
					//保存用户数据
					System.out.println("保存用户数据" + user.getScore());
					String str = IOUtils.readData();//之前成绩读取
					IOUtils.writeData(data);//当前的数据写到文件
					JOptionPane.showConfirmDialog(null, "结果：\n上次" + str + "\n" + data, "关闭窗口", 
							JOptionPane.YES_NO_CANCEL_OPTION);
//					File file = new File("E:\\java\\编程实例\\src\\猜拳游戏版本5\\guess.txt");
//				    if(!file.exists()) {
//					    file.createNewFile();
//					}
//				    FileWriter fw = new FileWriter(file);
//				    fw.write("用户成绩：" + user.getScore());
//				    fw.close();
//				} catch (IOException e1) {
//						e1.printStackTrace();
//					}
			}
		});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnObj = (JButton) e.getSource();//得到时间源
		//用户出拳
		int perFist = user.punches(this, btnObj);
		//电脑出拳
		int comFist = comShowFist();
		gameCount++;
		game.setGameCount(gameCount);
		//显示结果
		showResult(perFist, comFist);
		
	}
	
	//电脑出拳情况
		private int comShowFist() { 
			int i = computer.punches();
			switch (i) {
			case 1://电脑出剪刀
				comqlbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/j.png"));
				break;
			case 2://电脑出石头
				comqlbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/q.png"));
				break;
			case 3://电脑出布
				comqlbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/b.png"));
				break;
			}
			return i;
		}	
		
		//显示对战结果
		private void showResult(int perFist, int comFist) {
			System.out.println("对战次数：" + gameCount);
			
			int rule = game.rule(perFist, comFist);
			//根据裁决结果来改变表情
			if (rule == 0) {
				tiplbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/z.png"));
			} else if (rule == 1) {
				//用户赢 剪刀胜布 石头胜剪刀 布胜剪刀
				tiplbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/h.png"));
			} else {
				tiplbl.setIcon(new ImageIcon("src/猜拳游戏版本3/图片素材/w.png"));
			}
		}
}
