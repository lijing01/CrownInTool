package com.trace;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanguageConfigTool languageConfigTool = new LanguageConfigTool();
		languageConfigTool.getConfigList();
		ArrayList<LanguageBean> languageBeans = languageConfigTool.getLanguageBeans();
		
		FileTool fileTool = new FileTool();
		
		for(int i=0; i<languageBeans.size(); i++){
			LanguageBean languageBean = languageBeans.get(i);
			String androidOriginalFileName = FileTool.filepath + "\\" +languageBean.getLanguage() +"\\" + FileTool.androidFileName;
			String iosOriginalFileName = FileTool.diliverFilepath + "\\" +languageBean.getLanguage() +"\\" + FileTool.androidDestDir + "\\"+ FileTool.iosFileName;
			
			String androidToFileName = FileTool.filepath + "\\" +languageBean.getLanguage() +"\\" + FileTool.androidFileName;
			String iosToFileName = FileTool.diliverFilepath + "\\" +languageBean.getLanguage() +"\\" + FileTool.iosDestDir + "\\"+ FileTool.iosFileName;
			
			
			fileTool.copyFile(androidOriginalFileName, androidToFileName);
			fileTool.copyFile(iosOriginalFileName, iosToFileName);
		}
		
		
		
		
		
	}

}
