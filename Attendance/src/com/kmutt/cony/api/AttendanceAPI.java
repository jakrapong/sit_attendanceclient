package com.kmutt.cony.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kmutt.cony.model.ClassSchedule;
import com.kmutt.cony.model.Course;
import com.kmutt.cony.model.StudentInfo;
import com.kmutt.cony.model.StudentStatistic;
import com.kmutt.cony.model.User;



public class AttendanceAPI {
	public static final String WEB_PATH="http://54.254.208.130";
	private static AttendanceAPI instance;
	private String username;
	private String password;
	private AttendanceAPI(){}
	public static AttendanceAPI getInstance(){
		if(instance==null)instance = new AttendanceAPI();
		return instance;
	}
	
	public AttendanceAPI setCredentail(String username,String password){
		this.username = username;
		this.password = password;
		return this;
	}
	private String getJson(String apiName,String method) throws Exception{
		return getJson(apiName,method,null);
	}
	private String getJson(String apiName,String method,List<Entry<String,Object>>params) throws Exception{
		URL url=new URL(WEB_PATH+apiName);        
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.setRequestMethod(method);	
        connection.setDoOutput(true);
        connection.setRequestProperty("charset","utf-8");
        if(username!=null&&password!=null){
        	String authStr = username+":"+password;
        	String authEncoded = Base64.encodeBase64String(authStr.getBytes());
        	connection.setRequestProperty("Authorization","Basic "+authEncoded);
        }if(params!=null&&!params.isEmpty()){
        	StringBuilder paramData=new StringBuilder();
        	for(Entry<String,Object>param:params){
        		if(paramData.length()!=0)paramData.append('&');
        		paramData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
        		paramData.append("=");
        		paramData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
        	}byte[]paramDataBytes=paramData.toString().getBytes("UTF-8");
        	connection.setRequestProperty("Content-Length",String.valueOf(paramDataBytes.length));
        	connection.getOutputStream().write(paramDataBytes);
        }
        try{
        	InputStream content=(InputStream)connection.getInputStream();
            BufferedReader in=new BufferedReader(new InputStreamReader(content));
            StringBuilder sb=new StringBuilder();
            String line;
            while((line=in.readLine())!=null)sb.append(line);
            return sb.toString();
        }catch(IOException ex){
        	String msg=ex.getMessage();
    		String s="HTTP response code: ";
    		int i=msg.indexOf(s);
    		if(i!=-1){
    			int j=msg.indexOf(" for URL: ");
        		throw new Exception(msg.substring(i+s.length(),j));
    		}else{
    			throw ex;
    		}
        }
	}
	
	public User getMyInfo() throws Exception{
		String apiName="/jsonService/getMyInfo";
		String method="GET";
		String json=getJson(apiName,method);
		return new Gson().fromJson(json,User.class);
	}
	public List<Course>getCourseList() throws Exception{
		String apiName="/jsonService/getCourseList";
		String method="GET";
		String json=getJson(apiName,method);
		return new Gson().fromJson(json,new TypeToken<List<Course>>(){}.getType());
	}
	public List<ClassSchedule>getClassSchedule(int groupId) throws Exception{
		String apiName="/jsonService/getClassSchedule";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(1);
		param.add(new SimpleEntry<String,Object>("groupId",groupId));
		String json=getJson(apiName,method,param);
		return new Gson().fromJson(json,new TypeToken<List<ClassSchedule>>(){}.getType());
	}
	public List<StudentStatistic>getStudentList(int groupId) throws Exception{
		String apiName="/jsonService/getStudentList";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(1);
		param.add(new SimpleEntry<String,Object>("groupId",groupId));
		String json=getJson(apiName,method,param);
		return new Gson().fromJson(json,new TypeToken<List<StudentStatistic>>(){}.getType());
	}
	public StudentInfo getStudentInfo(String studentId,Integer groupId) throws Exception{
		String apiName="/jsonService/getStudentInfo";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(1);
		param.add(new SimpleEntry<String,Object>("studentId",studentId));
		if(groupId!=null)param.add(new SimpleEntry<String,Object>("groupId",groupId));
		String json=getJson(apiName,method,param);
		return new Gson().fromJson(json,StudentInfo.class);
	}
	public StudentInfo getStudentInfo(String studentId) throws Exception{
		return getStudentInfo(studentId,null);
	}
        
	
}
