package ��ȭ��Ϸ�汾5;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * @author ywx
 * @ date 2019��5��30��
 */
public class MyWindowEvent extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		
		GameUI gameUI = (GameUI)e.getSource();
		String result = gameUI.game.showResult();
		
		JOptionPane.showMessageDialog(null, result);
		System.out.println("���ڹ���");
	}
}
