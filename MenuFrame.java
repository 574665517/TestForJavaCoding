package ��ȭ��Ϸ�汾5;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MenuFrame {
	String data,save;//������Ŷ�Ӧ���ַ���
	ArrayList l = new ArrayList();//������С�ɱ����飬Ϊ��������
	MyAction ma = new MyAction();// �����Զ����¼����������
	JFrame f = new JFrame("��ӭ������ȭ��Ϸ");// ����������Ĵ���
	JTextArea ta = new JTextArea(30, 60);// �����ض���С����ʾ���ı��Ķ�������
	JScrollPane jsp = new JScrollPane(ta);// �������������ҽ��ı���������������
	JFileChooser jfc = new JFileChooser();// ����ѡ���ļ�
	JMenuBar mb = new JMenuBar();// �˵�����ʵ��
	
	JMenu mf = new JMenu("�ļ�(F)");
	JMenuItem mfnew = new JMenuItem("��¼");
	JMenuItem mfopen = new JMenuItem("��");
	JMenuItem mfsave = new JMenuItem("����");
	JMenuItem mfsaveas = new JMenuItem("���Ϊ");
	JMenuItem mfquit = new JMenuItem("�˳�");

	JMenu me = new JMenu("�༭(E)");
	JMenuItem meback = new JMenuItem("����");
	JMenuItem mecut = new JMenuItem("����");
	JMenuItem mecopy = new JMenuItem("����");
	JMenuItem mepaste = new JMenuItem("ճ��");
	JMenuItem medelete = new JMenuItem("ɾ��");
	JMenuItem mesearch = new JMenuItem("���Һ��滻");
	JMenuItem medate = new JMenuItem("����");
	JMenu mg = new JMenu("��ʽ(O)");

	JMenuItem mgtransiton = new JMenuItem("�Զ�ת��");
	JMenuItem mgfont = new JMenuItem("����");// �����˵���Ҫ���������

	JDialog ctd = new JDialog(f, "���Һ��滻");// �����Զ���ĶԻ���
	JTextField cttc = new JTextField(15);// �����༭�����ı����������
	JTextField cttt = new JTextField(15);
	JLabel ctlc = new JLabel("��������");// ������ʾ��
	JLabel ctlt = new JLabel("�滻Ϊ");
	JLabel ctle = new JLabel();
	JButton ctb = new JButton("������һ��");// ������ť
	JButton ctb1 = new JButton("�滻");
	JButton ctb2 = new JButton("ȫ���滻");
	JButton ctb3 = new JButton("ȡ��");

	JFrame font = new JFrame("����");// ������һ������ѡ����
	JPanel fpn = new JPanel(new GridLayout(1, 3, 5, 5));// ����������ʾ���������������Ϊ1��3�е����񲼾�
	JPanel fpc = new JPanel(new BorderLayout());//�߿򲼾�
	JPanel fpcc = new JPanel(new GridLayout(1 , 3 , 5 , 5 ));
	JPanel fpcn = new JPanel(new GridLayout(1 , 3 , 5 , 5 ));
	JPanel fpe = new JPanel(new GridLayout(3 , 1 , 5 , 5 ));
	JLabel lp1 = new JLabel("����");
	JLabel lpc = new JLabel("����");
	JLabel lpr = new JLabel("��С");
	JTextField tpl = new JTextField();
	JTextField tpc = new JTextField();
	JTextField tpr = new JTextField();
	JList lil = new JList();//������ʾ�����б���ʾ�������
	JScrollPane jspl = new JScrollPane(lil);//����������������
	String[] zx = {"����","����","б��","��б��"};
	JList lic = new JList(zx);//������ʾ�����б���ʾ�������
	String[] dx = {"15","20","25","30","35","40","45","50"};
	JList lir = new JList(dx);//������ʾ�����б���ʾ��С����
	JButton bs = new JButton("ȷ��"); JButton be = new JButton("ȡ��");
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] flil = ge.getAvailableFontFamilyNames();//�������������ļ���
	
	
	public MenuFrame() {//���캯��
		jfc.setCurrentDirectory(//Ϊѡ���ļ����ƶ�������Ŀ¼
				new File("E:/"));//�������ļ������ƶ�Ŀ¼
		f.setSize(300, 300);
		f.setLocation(150, 150);
		// ���ò˵���
		f.add(jsp, BorderLayout.CENTER);
		f.setJMenuBar(mb);
		// �������������
		mb.add(mf);
		mb.add(me);
		mb.add(mg);
		// �����ļ��˵�
		mf.add(mfnew);
		mf.add(mfopen);
		mf.add(mfsave);
		mf.add(mfsaveas);
		mf.add(mfquit);
		// ���ñ༭�˵�
		me.add(meback);
		me.add(mecut);
		me.add(mecopy);
		me.add(mepaste);
		me.add(medate);
		me.add(mesearch);
		me.add(medate);
		// �༭��ʽ�˵�
		mg.add(mgtransiton);
		mg.add(mgfont);
		// ���á����Һ��滻���Ի������
		ctd.setLayout(new GridLayout(3, 3, 5, 5));
		ctd.add(ctlc);
		ctd.add(cttc);
		ctd.add(ctb);
		ctd.add(ctlt);
		ctd.add(cttt);
		ctd.add(ctb1);
		ctd.add(ctb2);
		ctd.add(ctle);
		ctd.add(ctb3);
		
		//�������崰�ڽ���
		jspl.setHorizontalScrollBarPolicy(//ȷ�������ˮƽ��������ʱ��ʾ�ڹ���������
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);//���ò���ʾˮƽ������
		font.setBounds(300,300,400,300);//�趨����ѡ������ֵ�λ�ú͵������С
		font.add(fpc);//��������������������ѡ����
		fpc.add(fpcn , BorderLayout.NORTH);//�������������Ƕ�������������
		fpc.add(fpcc , BorderLayout.CENTER);font.add(fpcc , BorderLayout.NORTH);
		font.add(fpe , BorderLayout.EAST);
		
		//����Ӧ���������ӿؼ�
		fpn.add(lp1);fpn.add(lpc);fpn.add(lpr);fpcn.add(tpl);fpcn.add(tpc);
		fpcn.add(tpr);fpcc.add(jspl);fpcc.add(lic);fpcc.add(lir);fpe.add(bs);
		fpe.add(be);
		DefaultBoundedRangeModel fontModel = new DefaultBoundedRangeModel();//�����������ݶ���
		for(int i = 0; i < flil.length; i++) {
			
		}

		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		mfnew.addActionListener(ma);
		mfopen.addActionListener(ma);
		mfsave.addActionListener(ma);
		mfsaveas.addActionListener(ma);
		mfquit.addActionListener(ma);
		lil.addListSelectionListener(ma);lic.addListSelectionListener(ma);
		lir.addListSelectionListener(ma);bs.addActionListener(ma);
		be.addActionListener(ma);

	}
/**
 * ��Ӹ����¼�������
 */
	class MyAction implements ActionListener, ListSelectionListener {
		int returnVal, i, ft;
		File file;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mfnew) {// ��¼
				new GameLogin();
			} else if (e.getSource() == mfopen) {// ���ļ�
				returnVal = jfc.showOpenDialog(f);
				file = jfc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					ta.setText(openFile(file));
					f.setTitle(jfc.getName(file) + "-���±�");
				}
			} else if (e.getSource() == mfsave) {// �����ļ�
				if(f.getTitle() == "�ޱ��� - ���±�") {
					data = ta.getText();returnVal = jfc.showOpenDialog(f);
					file = jfc.getSelectedFile();
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						saveFile(file,data);
						f.setTitle(jfc.getName(file) + "- ���±�");
					}
				}else {
					data = ta.getText();
					if(file != null) {
						saveFile(file,data);
					}
				}

			}else if(e.getSource() == mfsaveas) {//���Ϊ
				data = ta.getText();
				returnVal = jfc.showSaveDialog(f);
				file = jfc.getSelectedFile();
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					saveFile(file , data);
					f.setTitle(jfc.getName(file) + "- ���±�");
				}
			}else if(e.getSource() == mfquit) {//�˳�
				System.exit(0);
			}else if(e.getSource() == meback) {//����
				if(l.size() > 0) {
					save = (String) l.get(l.size() - 1);
					l.remove(l.size() - 1);ta.setText(save);
				}
			}
				

		}

		public void valueChanged(ListSelectionEvent e) {
			// TODO �Զ����ɵķ������

		}
		public void saveFile(File f,String data) {//�����ļ�
			
		}

		private String openFile(File f) {// ���ļ�
			return null;
		}

	}

	public static void main(String[] args) {
		new MenuFrame();
	}
}
