package 猜拳游戏版本5;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MenuFrame {
	String data,save;//变量存放对应的字符串
	ArrayList l = new ArrayList();//创建大小可变数组，为撤销所用
	MyAction ma = new MyAction();// 创建自定义事件处理类对象
	JFrame f = new JFrame("欢迎来到猜拳游戏");// 创建带标题的窗体
	JTextArea ta = new JTextArea(30, 60);// 创建特定大小以显示纯文本的多行区域
	JScrollPane jsp = new JScrollPane(ta);// 创建滚动条，且将文本区域对象放入其中
	JFileChooser jfc = new JFileChooser();// 创建选择文件
	JMenuBar mb = new JMenuBar();// 菜单栏的实现
	
	JMenu mf = new JMenu("文件(F)");
	JMenuItem mfnew = new JMenuItem("登录");
	JMenuItem mfopen = new JMenuItem("打开");
	JMenuItem mfsave = new JMenuItem("保存");
	JMenuItem mfsaveas = new JMenuItem("另存为");
	JMenuItem mfquit = new JMenuItem("退出");

	JMenu me = new JMenu("编辑(E)");
	JMenuItem meback = new JMenuItem("撤销");
	JMenuItem mecut = new JMenuItem("剪切");
	JMenuItem mecopy = new JMenuItem("复制");
	JMenuItem mepaste = new JMenuItem("粘贴");
	JMenuItem medelete = new JMenuItem("删除");
	JMenuItem mesearch = new JMenuItem("查找和替换");
	JMenuItem medate = new JMenuItem("日期");
	JMenu mg = new JMenu("格式(O)");

	JMenuItem mgtransiton = new JMenuItem("自动转换");
	JMenuItem mgfont = new JMenuItem("字体");// 创建菜单需要的组件对象

	JDialog ctd = new JDialog(f, "查找和替换");// 创建自定义的对话框
	JTextField cttc = new JTextField(15);// 创建编辑单行文本的组件对象
	JTextField cttt = new JTextField(15);
	JLabel ctlc = new JLabel("查找内容");// 创建显示区
	JLabel ctlt = new JLabel("替换为");
	JLabel ctle = new JLabel();
	JButton ctb = new JButton("查找下一个");// 创建按钮
	JButton ctb1 = new JButton("替换");
	JButton ctb2 = new JButton("全部替换");
	JButton ctb3 = new JButton("取消");

	JFrame font = new JFrame("字体");// 创建另一个字体选择窗体
	JPanel fpn = new JPanel(new GridLayout(1, 3, 5, 5));// 创建用于显示的面板容器，定义为1行3列的网格布局
	JPanel fpc = new JPanel(new BorderLayout());//边框布局
	JPanel fpcc = new JPanel(new GridLayout(1 , 3 , 5 , 5 ));
	JPanel fpcn = new JPanel(new GridLayout(1 , 3 , 5 , 5 ));
	JPanel fpe = new JPanel(new GridLayout(3 , 1 , 5 , 5 ));
	JLabel lp1 = new JLabel("字体");
	JLabel lpc = new JLabel("字形");
	JLabel lpr = new JLabel("大小");
	JTextField tpl = new JTextField();
	JTextField tpc = new JTextField();
	JTextField tpr = new JTextField();
	JList lil = new JList();//创建显示对象列表，显示字体对象
	JScrollPane jspl = new JScrollPane(lil);//将对象放入滚动条中
	String[] zx = {"常规","粗体","斜体","粗斜体"};
	JList lic = new JList(zx);//创建显示对象列表，显示字体对象
	String[] dx = {"15","20","25","30","35","40","45","50"};
	JList lir = new JList(dx);//创建显示对象列表，显示大小对象
	JButton bs = new JButton("确定"); JButton be = new JButton("取消");
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] flil = ge.getAvailableFontFamilyNames();//获得字体类别对象的集合
	
	
	public MenuFrame() {//构造函数
		jfc.setCurrentDirectory(//为选择文件机制对象设置目录
				new File("E:/"));//并创建文件对象制定目录
		f.setSize(300, 300);
		f.setLocation(150, 150);
		// 设置菜单栏
		f.add(jsp, BorderLayout.CENTER);
		f.setJMenuBar(mb);
		// 将组件添加入框中
		mb.add(mf);
		mb.add(me);
		mb.add(mg);
		// 设置文件菜单
		mf.add(mfnew);
		mf.add(mfopen);
		mf.add(mfsave);
		mf.add(mfsaveas);
		mf.add(mfquit);
		// 设置编辑菜单
		me.add(meback);
		me.add(mecut);
		me.add(mecopy);
		me.add(mepaste);
		me.add(medate);
		me.add(mesearch);
		me.add(medate);
		// 编辑格式菜单
		mg.add(mgtransiton);
		mg.add(mgfont);
		// 设置“查找和替换”对话框界面
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
		
		//设置字体窗口界面
		jspl.setHorizontalScrollBarPolicy(//确定字体的水平滚动条何时显示在滚动窗格上
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);//设置不显示水平滚动条
		font.setBounds(300,300,400,300);//设定字体选择窗体出现的位置和调整其大小
		font.add(fpc);//面板容器对象添加入字体选择窗体
		fpc.add(fpcn , BorderLayout.NORTH);//在面板容器中又嵌套其他面板容器
		fpc.add(fpcc , BorderLayout.CENTER);font.add(fpcc , BorderLayout.NORTH);
		font.add(fpe , BorderLayout.EAST);
		
		//给相应面板容器添加控件
		fpn.add(lp1);fpn.add(lpc);fpn.add(lpr);fpcn.add(tpl);fpcn.add(tpc);
		fpcn.add(tpr);fpcc.add(jspl);fpcc.add(lic);fpcc.add(lir);fpe.add(bs);
		fpe.add(be);
		DefaultBoundedRangeModel fontModel = new DefaultBoundedRangeModel();//创建字体数据对象
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
 * 添加各种事件处理方法
 */
	class MyAction implements ActionListener, ListSelectionListener {
		int returnVal, i, ft;
		File file;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mfnew) {// 登录
				new GameLogin();
			} else if (e.getSource() == mfopen) {// 打开文件
				returnVal = jfc.showOpenDialog(f);
				file = jfc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					ta.setText(openFile(file));
					f.setTitle(jfc.getName(file) + "-记事本");
				}
			} else if (e.getSource() == mfsave) {// 保存文件
				if(f.getTitle() == "无标题 - 记事本") {
					data = ta.getText();returnVal = jfc.showOpenDialog(f);
					file = jfc.getSelectedFile();
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						saveFile(file,data);
						f.setTitle(jfc.getName(file) + "- 记事本");
					}
				}else {
					data = ta.getText();
					if(file != null) {
						saveFile(file,data);
					}
				}

			}else if(e.getSource() == mfsaveas) {//另存为
				data = ta.getText();
				returnVal = jfc.showSaveDialog(f);
				file = jfc.getSelectedFile();
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					saveFile(file , data);
					f.setTitle(jfc.getName(file) + "- 记事本");
				}
			}else if(e.getSource() == mfquit) {//退出
				System.exit(0);
			}else if(e.getSource() == meback) {//撤销
				if(l.size() > 0) {
					save = (String) l.get(l.size() - 1);
					l.remove(l.size() - 1);ta.setText(save);
				}
			}
				

		}

		public void valueChanged(ListSelectionEvent e) {
			// TODO 自动生成的方法存根

		}
		public void saveFile(File f,String data) {//保存文件
			
		}

		private String openFile(File f) {// 打开文件
			return null;
		}

	}

	public static void main(String[] args) {
		new MenuFrame();
	}
}
