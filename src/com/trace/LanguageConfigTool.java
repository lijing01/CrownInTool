package com.trace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LanguageConfigTool {
	private ArrayList<LanguageBean> languageBeans = new ArrayList<LanguageBean>(); 
	
	public ArrayList<LanguageBean> getLanguageBeans() {
		return languageBeans;
	}

	public void getConfigList(){
		JSONArray jsonObj = getJsonFromConfigFile();
		if(jsonObj != null){
			System.out.println("JsonArray size is "+ jsonObj.size());
			for(int i=0; i<jsonObj.size(); i++){
				LanguageBean lgbean = new LanguageBean();
				JSONUtil jsonUtil = new JSONUtil((JSONObject)jsonObj.get(i));
				lgbean.setLanguage(jsonUtil.optString("code"));
				lgbean.setIosFileName(jsonUtil.optString("iosMapKey"));
				lgbean.setIosFileName2(jsonUtil.optString("iosMapKey2"));
				lgbean.setAndroidFileName(jsonUtil.optString("androidMapKey"));
				lgbean.setAndroidFiLeName2(jsonUtil.optString("androidMapKey2"));
				languageBeans.add(lgbean);
			}
		}
	}
	
	public LanguageBean getBeanByCode(String code){
		LanguageBean languageBean = null;
		for(int i=0; i<languageBeans.size(); i++){
			if(languageBeans.get(i).getLanguage().equals(code)){
				languageBean = languageBeans.get(i);
			}
		}
		return languageBean;
	}
	
	private JSONArray getJsonFromConfigFile(){
		String JSONString = getConfigString();
		if(JSONString != null && !"".equals(JSONString)){
			JSONArray jsonObj = JSONArray.fromObject(JSONString);
			return jsonObj;
		}
		return null;
	}
	
	private String getConfigString(){
		String fileName = "config.json";
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			String jsonString = "";
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
//				System.out.println("line " + line + ": " + tempString);
				jsonString += tempString;
				line++;
			}
			reader.close();
			
			System.out.println("jsonString is "+ jsonString);
			return jsonString;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return null;
	}
}
