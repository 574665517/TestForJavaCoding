package ��ȭ��Ϸ�汾5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * @author ywx
 * @ date 2019��5��30��
 */
public class GameUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1198437963899035702L;
	
	public JLabel preqlbl;//�û���ȭ��ʾ
	private JLabel comqlbl;//���Գ�ȭ��ʾ
	public JButton jdbtn;//����
	public JButton stbtn;//ʯͷ
	public JButton bubtn;//��
	private JLabel tiplbl;//�����ʾ
	
//	private static int computerScore = 0;//��ʾ���Ե÷�
//	private static int personScore = 0;//��ʾ��ҵ÷�
	private static int gameCount = 0;//��ʾ��������
	
	private User user;
	private Computer computer;
	Game game;
	
	public GameUI() {
		init();
		this.setVisible(true);//���ô��ڿɼ�
	}

	private void init() {
		//�ڴ˴����Ե��õ�¼�������û������û�����ѡ���ս�Ľ�ɫ
		user = new User();//��ʼ��
		computer = new Computer();//��ʼ�����캯��
		game = new Game(user, computer);//��ʼ��
		
		this.setSize(550, 500);//���ô��ڴ�С
		//��ӱ���
		this.setTitle("��ȭ��Ϸ");
		ImageIcon icon = new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/icon.jpg");
		this.setIconImage(icon.getImage());
		//���ó������
		this.setLocationRelativeTo(null);
		//���ô��ڹرճ���Ƚ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڵĲ���
		this.setLayout(null);//�ղ��֣����Զ�λ����
		//�ҵ�ͼƬ·��
		ImageIcon miImg = new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/m1.png");
		
		JLabel m1lbl = new JLabel();
		m1lbl.setIcon(miImg);//��ͼƬ��ӵ��ؼ�
		m1lbl.setBounds(27, 40, 85, 80);
		this.add(m1lbl);
		
		//�û���ȭ��ʾ
		preqlbl = new JLabel();
		preqlbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/b.png"));//��ͼƬ��ӵ��ؼ�
		preqlbl.setBounds(125, 46, 50, 50);
		this.add(preqlbl);
		
		//vs
		JLabel vslbl = new JLabel();
		vslbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/vs1.png"));//��ͼƬ��ӵ��ؼ�
		vslbl.setBounds(230, 45, 70, 45);
		this.add(vslbl);
		
		//���Գ�ȭ
		comqlbl = new JLabel();
		comqlbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/j.png"));//��ͼƬ��ӵ��ؼ�
		comqlbl.setBounds(350, 40, 85, 80);
		this.add(comqlbl);
		
		JLabel m2lbl = new JLabel();
		m2lbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/m2.png"));//��ͼƬ��ӵ��ؼ�
		m2lbl.setBounds(420, 40, 85, 80);
		this.add(m2lbl);
		
		jdbtn = new JButton();
		jdbtn.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/j.png"));
		jdbtn.setBounds(40, 150, 50, 50);
		this.add(jdbtn);
		
		stbtn = new JButton();
		stbtn.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/q.png"));
		stbtn.setBounds(40, 260, 50, 50);
		this.add(stbtn);
		
		bubtn = new JButton();
		bubtn.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/b.png"));
		bubtn.setBounds(40, 370, 50, 50);
		this.add(bubtn);
		
		tiplbl = new JLabel();
		tiplbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/w.png"));//��ͼƬ��ӵ��ؼ�
		tiplbl.setBounds(160, 130, 230, 125);
		this.add(tiplbl);
		
		JLabel vs2lbl = new JLabel();
		vs2lbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/vs.png"));//��ͼƬ��ӵ��ؼ�
		vs2lbl.setBounds(125, 255, 330, 190);
		this.add(vs2lbl);
		
		jdbtn.addActionListener(this);
		stbtn.addActionListener(this);
		bubtn.addActionListener(this);
		
//		this.addWindowListener(new MyWindowEvent());
	
		this.addWindowListener(new WindowAdapter() {
		
			//���ڹر�ǰ�¼�
			@Override
			public void windowClosing(WindowEvent e) {
				//�����û�����
				System.out.println("�����û�����:" + user.getScore());
//				try {
					String data = "���ֳɼ�" + user.getScore();
					//�����û�����
					System.out.println("�����û�����" + user.getScore());
					String str = IOUtils.readData();//֮ǰ�ɼ���ȡ
					IOUtils.writeData(data);//��ǰ������д���ļ�
					JOptionPane.showConfirmDialog(null, "�����\n�ϴ�" + str + "\n" + data, "�رմ���", 
							JOptionPane.YES_NO_CANCEL_OPTION);
//					File file = new File("E:\\java\\���ʵ��\\src\\��ȭ��Ϸ�汾5\\guess.txt");
//				    if(!file.exists()) {
//					    file.createNewFile();
//					}
//				    FileWriter fw = new FileWriter(file);
//				    fw.write("�û��ɼ���" + user.getScore());
//				    fw.close();
//				} catch (IOException e1) {
//						e1.printStackTrace();
//					}
			}
		});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnObj = (JButton) e.getSource();//�õ�ʱ��Դ
		//�û���ȭ
		int perFist = user.punches(this, btnObj);
		//���Գ�ȭ
		int comFist = comShowFist();
		gameCount++;
		game.setGameCount(gameCount);
		//��ʾ���
		showResult(perFist, comFist);
		
	}
	
	//���Գ�ȭ���
		private int comShowFist() { 
			int i = computer.punches();
			switch (i) {
			case 1://���Գ�����
				comqlbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/j.png"));
				break;
			case 2://���Գ�ʯͷ
				comqlbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/q.png"));
				break;
			case 3://���Գ���
				comqlbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/b.png"));
				break;
			}
			return i;
		}	
		
		//��ʾ��ս���
		private void showResult(int perFist, int comFist) {
			System.out.println("��ս������" + gameCount);
			
			int rule = game.rule(perFist, comFist);
			//���ݲþ�������ı����
			if (rule == 0) {
				tiplbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/z.png"));
			} else if (rule == 1) {
				//�û�Ӯ ����ʤ�� ʯͷʤ���� ��ʤ����
				tiplbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/h.png"));
			} else {
				tiplbl.setIcon(new ImageIcon("src/��ȭ��Ϸ�汾3/ͼƬ�ز�/w.png"));
			}
		}
}
