package 猜拳游戏版本5;

import java.awt.Font;

import javax.swing.*;

/**
 * @author ywx
 * @ date 2019年6月5日
 */
public class StartUI extends JFrame {

	private static final long serialVersionUID = -5510850814373052722L;
	
	private JButton button;
	
	public StartUI() {
		init();
		this.setVisible(true);//设置窗口可见
	}
	
	public void init() {
		this.setSize(550, 500);
		button = new JButton("5");
		button.setFont(new Font("", Font.BOLD, 208));
		this.add(button);
		//启动
		ButtonAction t = new ButtonAction();
		t.start();
		
		//设置窗口关闭程序既结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//设置居中
	}

	public static void main(String[] args) {
		new StartUI().init();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new GameLogin();
		}
	}
	
	class ButtonAction extends Thread {
		int num = 100;
		
		@Override
		public void run() {
			while(num != 0) {
				try {
					button.setText(num + "");
					sleep(100);
					num--;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
