package ��ȭ��Ϸ�汾5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ywx
 * @ date 2019��6��4��
 */
public class IOUtils {
	
	public static String readData() {
		StringBuffer data = null;
		    try {
		    	File file = new File("E:\\java\\���ʵ��\\src\\��ȭ��Ϸ�汾5\\guess.txt");
	            if(!file.exists()) {
	            	return "�ϴγɼ���0";
	            }
	            FileReader fr = new FileReader(file);
				//����ָ�������ַ������ȡ
	            char [] cs = new char[20];
	            data = new StringBuffer();
	            int len = -1;
	            while((len = fr.read(cs)) != -1) {//��ȡ�ļ�
	            	data.append(new String(cs, 0, len));
	            }
	            System.out.println("�ļ�����Ϊ��" + data);
	            fr.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();//�쳣��ӡ
			}
		return data.toString();
	}

	public static void writeData(String data2) {
	    try {
	    	File file = new File("E:\\java\\���ʵ��\\src\\��ȭ��Ϸ�汾5\\guess.txt");
            if(!file.exists()) {
            	file.createNewFile();
            }
            FileWriter fr = new FileWriter(file);
            fr.write(data2);
            fr.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
}
