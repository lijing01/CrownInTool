package com.trace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class FileTool {
	public static final String iosOriginDir = "Tapatalk for  iPhone";
	public static final String iosFileName = "Localizable.strings";
	public static final String iosDestDir = "ios";

	public static final String androidOriginDir = "Tapatalk for Android";
	public static final String androidFileName = "strings.xml";
	public static final String androidDestDir = "android";
	
	public static final String filepath = "D:\\工具文件\\配置文件\\tapatalk-all";
	public static final String diliverFilepath = "D:\\工具文件\\配置文件\\newString";
	
	public void deliverFile() {
		LanguageConfigTool languageConfigTool = new LanguageConfigTool();
		languageConfigTool.getConfigList();
		ArrayList<LanguageBean> languageBeans = languageConfigTool
				.getLanguageBeans();
		for (int i = 0; i < languageBeans.size(); i++) {
			LanguageBean languageBean = languageBeans.get(i);
			String androidToFilePath = FileTool.diliverFilepath + "\\"
					+ FileTool.androidDestDir + "\\"
					+ languageBean.getLanguage();
			String iosToFilePath = FileTool.diliverFilepath + "\\"
					+ FileTool.iosDestDir + "\\" + languageBean.getLanguage();
			File androidToFile = new File(androidToFilePath);
			if (!androidToFile.exists()) {
				androidToFile.mkdirs();
			}

			File iosToFile = new File(iosToFilePath);
			if (!iosToFile.exists()) {
				iosToFile.mkdirs();
			}

			String androidOriginalFileName = FileTool.filepath + "\\"
					+ languageBean.getLanguage() + "\\"
					+ FileTool.androidOriginDir + "\\"
					+ FileTool.androidFileName;
			String androidToFileName = androidToFilePath + "\\"
					+ FileTool.androidFileName;

			String iosOriginalFileName = FileTool.filepath + "\\"
					+ languageBean.getLanguage() + "\\" + FileTool.iosOriginDir
					+ "\\" + FileTool.iosFileName;
			String iosToFileName = iosToFilePath + "\\" + FileTool.iosFileName;

			copyFile(androidOriginalFileName, androidToFileName);
			copyFile(iosOriginalFileName, iosToFileName);
		}
	}
	
	public void copyFile(String oldPath, String newPath) {
		File toFile = new File(newPath);
		File path = new File(toFile.getPath());
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
					// System.out.println(bytesum);
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
