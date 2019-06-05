package 猜拳游戏版本5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author ywx
 * @ date 2019年6月4日
 */
public class GameLogin {
	
	public GameLogin() {
		init();
	}

	private void init() {
		JFrame frame = new JFrame("游戏登陆");
		//frame.setTitle("登陆界面");  等价于JFrame frame = new JFrame(String title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当窗口关闭时，退出程序
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);//设置窗体显示在居中位置
		frame.setLayout(new FlowLayout());//设置为流式布局
		
		JLabel L1 = new JLabel("账号：");
		JTextField te1 = new JTextField(48);//账号输入框 括号内是输入框长度
		
		JLabel L2 = new JLabel("密码：");
		JPasswordField te2 = new JPasswordField(48);//PasswordField 的使用  密码输入框
		te2.setEchoChar('*');//设置密码显示为*
		
		JLabel L = new JLabel();
		L.setIcon(new ImageIcon ("F:\\照片\\QQ_Images\\1494410166672.jpeg"));//将你的电脑里面的照片添加到L这个组件上来
		frame.add(L);//将其他组件都添加到窗体上面来
		frame.add(L1);
		frame.add(te1);
		frame.add(L2);
		frame.add(te2);
		
		JButton B1 = new JButton("登陆");
		ButtonListener li1 = new ButtonListener(te1, te2);//按钮监听事件             
		B1.addActionListener(li1);      //给登录按钮添加监听
		frame.add(B1);
		JButton B2 = new JButton("取消");
		frame.add(B2);
		frame.setVisible(true);         //窗体设置为可见
	}
	
	//自己定义一个类来实现接口
		public class ButtonListener implements ActionListener {//实现ActionListener
			    JTextField te1 = new JTextField();               
			    JPasswordField te2 = new JPasswordField();
			public ButtonListener(JTextField te1,JPasswordField te2) {//重载    窗体上的账号框，密码框传到监听上来
				this.te1 = te1;	
				this.te2 = te2;
			}
			public void actionPerformed(ActionEvent e) {            //捕获点击动作
				String name = te1.getText();                     //getText   用于获取输入框内的东西
				String password = String.valueOf(te2.getPassword());   //获得密码框内的东西
				if((name.equals("xx") == true) && (password.equals("123"))) {    //设置账号密码匹配
					new GameUI();
					//setVisible(false);
				}
				else System.out.println("账号或者密码错误");
			}
		}
		
	public static void main(String[] args) {
		new GameLogin();
	}
}

