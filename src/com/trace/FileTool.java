package com.trace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class FileTool {
//	public static final String rootPath = "D:\\CrownInTool";
	public static final String iosOriginDir = "Tapatalk for  iPhone";
	public static final String iosFileName = "Localizable.strings";
	public static final String iosDestDir = "ios";

	public static final String androidOriginDir = "Tapatalk for Android";
	public static final String androidFileName = "strings.xml";
	public static final String androidDestDir = "android";
	
	public static final String filepath = "tapatalk-all";
	public static final String diliverFilepath = "newString";
	
	public void deliverFile() {
		String rootPath = getJarRootPath();
		LanguageConfigTool languageConfigTool = new LanguageConfigTool();
		languageConfigTool.getConfigList();
		ArrayList<LanguageBean> languageBeans = languageConfigTool
				.getLanguageBeans();
		for (int i = 0; i < languageBeans.size(); i++) {
			LanguageBean languageBean = languageBeans.get(i);
			String androidToFilePath = rootPath + "\\"+FileTool.diliverFilepath + "\\"
					+ FileTool.androidDestDir + "\\"
					+languageBean.getAndroidFileName();
			String iosToFilePath = rootPath + "\\"+FileTool.diliverFilepath + "\\"
					+ FileTool.iosDestDir + "\\" + languageBean.getIosFileName();
			File androidToFile = new File(androidToFilePath);
			if (!androidToFile.exists()) {
				androidToFile.mkdirs();
			}

			File iosToFile = new File(iosToFilePath);
			if (!iosToFile.exists()) {
				iosToFile.mkdirs();
			}

			String androidOriginalFileName =rootPath + "\\"+ FileTool.filepath + "\\"
					+ languageBean.getLanguage() + "\\"
					+ FileTool.androidOriginDir + "\\"
					+ FileTool.androidFileName;
			String androidToFileName = androidToFilePath + "\\"
					+ FileTool.androidFileName;

			String iosOriginalFileName = rootPath + "\\"+FileTool.filepath + "\\"
					+ languageBean.getLanguage() + "\\" + FileTool.iosOriginDir
					+ "\\" + FileTool.iosFileName;
			String iosToFileName = iosToFilePath + "\\" + FileTool.iosFileName;

			copyFile(androidOriginalFileName, androidToFileName);
			copyFile(iosOriginalFileName, iosToFileName);
			
			if(languageBean.getAndroidFiLeName2()!= null && !("").equals(languageBean.getAndroidFiLeName2())){
				String androidToFilePath2 = rootPath + "\\"+FileTool.diliverFilepath + "\\"
						+ FileTool.androidDestDir + "\\"
						+languageBean.getAndroidFiLeName2();
				File androidToFile2 = new File(androidToFilePath2);
				if (!androidToFile2.exists()) {
					androidToFile2.mkdirs();
				}
				String androidToFileName2 = androidToFilePath2 + "\\"
						+ FileTool.androidFileName;
				copyFile(androidOriginalFileName, androidToFileName2);
			}
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
	
	
	public static String getProjectPath() {
		java.net.URL url = Excute.class.getProtectionDomain().getCodeSource()
				.getLocation();
		String filePath = null;
		try {
			filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filePath.endsWith(".jar")){
			return getJarRootPath();
		}else{
			return getRuntimeRootPath();
		}
		
	}
	
	public static String getJarRootPath(){
		return getRealPath();
	}
	
	public static String getRuntimeRootPath(){
		String path = getRealPath();
		File cfile = new File(path);
		String fileName = cfile.getParent();
		return fileName;	
	}
	
	public static String getRealPath() {
		String realPath = Excute.class.getClassLoader().getResource("")
				.getFile();
		java.io.File file = new java.io.File(realPath);
		realPath = file.getAbsolutePath();
		try {
			realPath = java.net.URLDecoder.decode(realPath, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return realPath;
	}

}
