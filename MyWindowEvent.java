package 猜拳游戏版本5;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * @author ywx
 * @ date 2019年5月30日
 */
public class MyWindowEvent extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		
		GameUI gameUI = (GameUI)e.getSource();
		String result = gameUI.game.showResult();
		
		JOptionPane.showMessageDialog(null, result);
		System.out.println("窗口关了");
	}
}
