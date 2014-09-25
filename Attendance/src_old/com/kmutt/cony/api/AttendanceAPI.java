package com.kmutt.cony.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kmutt.cony.model.ClassSchedule;
import com.kmutt.cony.model.Course;
import com.kmutt.cony.model.Statistic;
import com.kmutt.cony.model.Student;
import com.kmutt.cony.model.Teacher;
import com.kmutt.cony.model.User;



public class AttendanceAPI {
	public static final Gson GSON=new GsonBuilder().setDateFormat("YYYY-MM-dd HH:mm XXX").create();
	public static final String WEB_PATH="http://gala.cs.iastate.edu:3000";
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
//	private String getJson(String apiName,String method,List<Entry<String,Object>>params) throws Exception{
//		URL url=new URL(WEB_PATH+apiName);        
//        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
//        connection.setRequestMethod(method);	
//        connection.setDoOutput(true);
//        connection.setRequestProperty("charset","utf-8");
//        if(username!=null&&password!=null){
//        	String authStr = username+":"+password;
//        	String authEncoded = Base64.encodeBase64String(authStr.getBytes());
//        	connection.setRequestProperty("Authorization","Basic "+authEncoded);
//        }if(params!=null&&!params.isEmpty()){
//        	StringBuilder paramData=new StringBuilder();
//        	for(Entry<String,Object>param:params){
//        		if(paramData.length()!=0)paramData.append('&');
//        		paramData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
//        		paramData.append("=");
//        		paramData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
//        	}byte[]paramDataBytes=paramData.toString().getBytes("UTF-8");
//        	connection.setRequestProperty("Content-Length",String.valueOf(paramDataBytes.length));
//        	connection.getOutputStream().write(paramDataBytes);
//        }
//        try{
//        	InputStream content=(InputStream)connection.getInputStream();
//            BufferedReader in=new BufferedReader(new InputStreamReader(content));
//            StringBuilder sb=new StringBuilder();
//            String line;
//            while((line=in.readLine())!=null)sb.append(line);
//            return sb.toString();
//        }catch(IOException ex){
//        	String msg=ex.getMessage();
//    		String s="HTTP response code: ";
//    		int i=msg.indexOf(s);
//    		if(i!=-1){
//    			int j=msg.indexOf(" for URL: ");
//        		throw new Exception(msg.substring(i+s.length(),j));
//    		}else{
//    			throw ex;
//    		}
//        }
//	}
	
	private String getJson(String apiName,String method,List params) throws Exception{
		StringBuilder paramData=new StringBuilder();
		if(params!=null&&!params.isEmpty()){
        	for(int i=0;i<params.size();i++)
        		paramData.append('/').append(String.valueOf(params.get(i)));
        }URL url=new URL(WEB_PATH+apiName+paramData.toString());        
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.setRequestMethod(method);	
        connection.setDoOutput(true);
        connection.setRequestProperty("charset","utf-8");
        if(username!=null&&password!=null){
        	String authStr = username+":"+password;
        	String authEncoded = Base64.encodeBase64String(authStr.getBytes());
        	connection.setRequestProperty("Authorization","Basic "+authEncoded);
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
	
	
	public Teacher getInstructorInfo(int instructorId) throws Exception{
		String apiName="/jsonresponse/get_instructor_info";
		String method="GET";
		List params=new ArrayList();
		params.add(instructorId);
		String json=getJson(apiName,method,params);
		return GSON.fromJson(json,Teacher.class);
	}
	public List<Course>getInstructorGroups(int instructorId) throws Exception{
		String apiName="/jsonresponse/get_instructor_groups";
		String method="GET";
		List params=new ArrayList();
		params.add(instructorId);
		String json=getJson(apiName,method,params);
		return GSON.fromJson(json,new TypeToken<List<Course>>(){}.getType());
	}
	public List<ClassSchedule>getGroupClasses(int groupId) throws Exception{
		String apiName="/jsonresponse/get_group_classes";
		String method="GET";
		List params=new ArrayList();
		params.add(groupId);
		String json=getJson(apiName,method,params);
		return GSON.fromJson(json,new TypeToken<List<ClassSchedule>>(){}.getType());
	}
	public ClassSchedule getClassAttendance(int groupId,int classId) throws Exception{
		String apiName="/jsonresponse/get_class_attendance";
		String method="GET";
		List params=new ArrayList();
		params.add(groupId);
		params.add("class");
		params.add(classId);
		String json=getJson(apiName,method,params);
		return GSON.fromJson(json,ClassSchedule.class);
	}
	public List<Statistic>getStudentList(int groupId) throws Exception{
		String apiName="/jsonService/getStudentList";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(1);
		param.add(new SimpleEntry<String,Object>("groupId",groupId));
		String json=getJson(apiName,method,param);
		return GSON.fromJson(json,new TypeToken<List<Statistic>>(){}.getType());
	}
	public Statistic getStudentInfo(String studentId,Integer groupId) throws Exception{
		String apiName="/jsonService/getStudentInfo";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(2);
		param.add(new SimpleEntry<String,Object>("studentId",studentId));
		param.add(new SimpleEntry<String,Object>("groupId",groupId));
		String json=getJson(apiName,method,param);
		return GSON.fromJson(json,Statistic.class);
	}
	public Student getStudentInfo(String studentId) throws Exception{
		String apiName="/jsonService/getStudentInfo";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(1);
		param.add(new SimpleEntry<String,Object>("studentId",studentId));
		String json=getJson(apiName,method,param);
		return GSON.fromJson(json,Student.class);
	}
	public ClassSchedule getCurrentClassSchedule(String date,String time) throws Exception{
		String apiName="/jsonService/getCurrentClassSchedule";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(2);
		param.add(new SimpleEntry<String,Object>("date",date));
		param.add(new SimpleEntry<String,Object>("time",time));
		String json=getJson(apiName,method,param);
		return GSON.fromJson(json,ClassSchedule.class);
	}
	public User getUserInfo(String faceId) throws Exception{
		String apiName="/GetUserInfo";
		String method="GET";
		List<Entry<String,Object>>param=new ArrayList<Entry<String,Object>>(1);
		param.add(new SimpleEntry<String,Object>("faceId",faceId));
		String json=getJson(apiName,method,param);
		return GSON.fromJson(json,User.class);
	}
}
