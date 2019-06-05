package 猜拳游戏版本5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ywx
 * @ date 2019年6月4日
 */
public class IOUtils {
	
	public static String readData() {
		StringBuffer data = null;
		    try {
		    	File file = new File("E:\\java\\编程实例\\src\\猜拳游戏版本5\\guess.txt");
	            if(!file.exists()) {
	            	return "上次成绩：0";
	            }
	            FileReader fr = new FileReader(file);
				//设置指定长度字符数组读取
	            char [] cs = new char[20];
	            data = new StringBuffer();
	            int len = -1;
	            while((len = fr.read(cs)) != -1) {//读取文件
	            	data.append(new String(cs, 0, len));
	            }
	            System.out.println("文件内容为：" + data);
	            fr.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();//异常打印
			}
		return data.toString();
	}

	public static void writeData(String data2) {
	    try {
	    	File file = new File("E:\\java\\编程实例\\src\\猜拳游戏版本5\\guess.txt");
            if(!file.exists()) {
            	file.createNewFile();
            }
            FileWriter fr = new FileWriter(file);
            fr.write(data2);
            fr.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
