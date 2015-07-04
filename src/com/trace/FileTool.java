package com.trace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileTool {
	public static final String iosOriginDir = "Tapatalk for  iPhone";
	public static final String iosFileName = "Localizable.strings";
	public static final String iosDestDir = "ios";

	public static final String androidOriginDir = "Tapatalk for Android";
	public static final String androidFileName = "strings.xml";
	public static final String androidDestDir = "android";
	
	public static final String filepath = "D:\\配置文件backup\\tapatalk-all";
	public static final String diliverFilepath = "D:\\配置文件backup\\newString";
	
	public void deliverFile(String path) {
		File file = new File(filepath);
		String[] filelist = file.list();
		for (int i = 0; i < filelist.length; i++) {
			File readfile = new File(filepath + "\\" + filelist[i]);
			if (readfile.isDirectory()) {
				System.out.println("filename=" + readfile.getName());
				String[] childFilelist = readfile.list();
				for(int j=0; j<childFilelist.length; j++){
					System.out.println("cfilename=" + childFilelist[j]);
				}
			}
		}
	}
	
	public void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("error  ");
			e.printStackTrace();
		}
	}  
}
