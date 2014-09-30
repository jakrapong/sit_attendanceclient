package com.kmutt.cony.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kmutt.cony.model.zombie.Course;
import com.kmutt.cony.model.zombie.User;
import com.kmutt.cony.model.zombie.StudentAttendance;
import com.kmutt.cony.model.zombie.StudentInfo;
import com.kmutt.cony.model.zombie.StudentStat;

public class AttendanceAPIZombie {
	public static final String WEB_PATH = "http://gala.cs.iastate.edu:3000";

	private static String credentialFile = "credential.dat";
	private static String credentialFilePath = ".";
	private static AttendanceAPIZombie instance;

	private String username;
	private String password;

	private User instructor;
	
	Gson GSON;
	
	private HashMap<String, Object> cache;
	
	private AttendanceAPIZombie() {
		username = null;
		password = null;
		GSON = new GsonBuilder().create();
		cache = new HashMap<String, Object>();
	}
	public void setPath(String path){
		credentialFilePath = path;
	}
	public boolean restoreUser(){
		try{
			Scanner f = new Scanner(new File(credentialFilePath, credentialFile));
			username = f.nextLine();
			password = f.nextLine();
			f.close();
			getMyInfo();
			return true;
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	private void save(){
		try {
			
			FileWriter f = new FileWriter(new File(credentialFilePath, credentialFile));
			f.write(username);
			f.write("\r\n");
			f.write(password);			
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized static AttendanceAPIZombie getInstance() {
		if (instance == null)
			instance = new AttendanceAPIZombie();
		return instance;
	}

	public AttendanceAPIZombie setCredentail(String username, String password) {
		this.username = username;
		this.password = password;
		return this;
	}

//	private String getJson(String apiName, String method) throws Exception {
//		return getJson(apiName, method, null);
//	}
	private boolean hasCache(String url,List<Entry<String, Object>> param) throws UnsupportedEncodingException{
		return cache.containsKey(url + toParamString(param));
	}
	private Object getCache(String url,List<Entry<String, Object>> param) throws UnsupportedEncodingException{
		return cache.get(url + toParamString(param));
	}
	private void saveCache(String url, List<Entry<String, Object>> param, Object obj) throws UnsupportedEncodingException{
		cache.put(url + toParamString(param), obj);
	}
	private String toParamString(List<Entry<String, Object>> params) throws UnsupportedEncodingException{
		StringBuilder paramData = new StringBuilder();
		paramData.append('{');
		for (Entry<String, Object> param : params) {					
			
			if (paramData.length() > 1)
				paramData.append(',');
			
			paramData.append("\"").append(URLEncoder.encode(param.getKey(), "UTF-8")).append("\"");
			paramData.append(":");
			paramData.append("\"").append(URLEncoder.encode(
					String.valueOf(param.getValue()), "UTF-8")).append("\"");
		}
		paramData.append('}');
		return paramData.toString();
	}
	private String getJson(String apiName, String method,
			List<Entry<String, Object>> params) throws Exception {
		URL url = new URL(WEB_PATH + apiName);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		connection.setDoOutput(true);
		connection.setRequestProperty("charset", "utf-8");
		if (username != null && password != null) {
			String authStr = username + ":" + password;
			String authEncoded = new String(Base64.encodeBase64(authStr
					.getBytes()));
			connection.setRequestProperty("Authorization", "Basic "
					+ authEncoded);
		}
		
		System.out.print("\ncall " + apiName);
		
		if (params != null) {
			String paramData = toParamString(params);

			System.out.println(", data:" + paramData);
//			byte[] paramDataBytes = paramData.toString().getBytes("UTF-8");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Content-Length",""+paramData.getBytes().length);
			
			connection.setDoOutput(true);
			
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(paramData);
			out.flush();
			out.close();
		}
		InputStream content = null;
		try {
			content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					content));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null)
				sb.append(line);
			return sb.toString();
		} catch (IOException ex) {
			
//			ex.printStackTrace();
			
			String msg = ex.getMessage();
			String s = "HTTP response code: ";
			int i = msg.indexOf(s);
			if (i != -1) {
				int j = msg.indexOf(" for URL: ");
				throw new Exception(msg.substring(i + s.length(), j));
			} else {
				throw ex;
			}
		}finally{
			if(content != null)
				content.close();
			connection.disconnect();
		}
	}
	
	private void checkLogin() throws Exception{
		if(instructor == null || instructor.getType() != User.TYPE_INSTRUCTOR)
			getMyInfo();
	}
	public boolean isLogin(){
		return instructor != null;
	}

	public void logout(){
		instructor = null;
		username = null;
		password = null;
		cache.clear();
		File f = new File(credentialFilePath, credentialFile);
		f.delete();
	}
	
	public User getMyInfo() throws Exception {
		return getMyInfo(true);
	}
	public User getMyInfo(boolean cache) throws Exception {
		String apiName = "/jsonresponse/get_user_info";
		String method = "POST";
		
		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
		
		//caching
		if(cache && hasCache(apiName, param)){
			return (User) getCache(apiName, param);
		}
		
		String json = getJson(apiName, method, param);
		
		instructor = GSON.fromJson(json, User.class);
		
		if(instructor == null)// || instructor.getType() != User.TYPE_INSTRUCTOR)
			throw new Exception("401");
		
		save();
		saveCache(apiName, param, instructor);
		return instructor;
	}

	public List<Course> getCourseList() throws Exception {
		return getCourseList(true);
	}
	public List<Course> getCourseList(boolean cache) throws Exception {
		String apiName = "/jsonresponse/get_instructor_groups/";
		String method = "POST";
		
		checkLogin();
		
		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
		param.add(new SimpleEntry<String,Object>("instructor_id", instructor.getUserId()));
		
		//caching
		if(cache && hasCache(apiName, param)){
			return (List<Course>) getCache(apiName, param);
		}
				
		String json = getJson(apiName, method, param);
		
		List<Course> list = GSON.fromJson(json, new TypeToken<List<Course>>() {}.getType());
		saveCache(apiName, param, list);
		return list;
	}

	public List<com.kmutt.cony.model.zombie.Class> getClassSchedule(int groupId) throws Exception {
		return getClassSchedule(groupId, true);
	}
	public List<com.kmutt.cony.model.zombie.Class> getClassSchedule(int groupId, boolean cache) throws Exception {
		String apiName = "/jsonresponse/get_group_classes/";
		String method = "POST";
		
		checkLogin();
		
		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
		param.add(new SimpleEntry<String,Object>("group_id",groupId));
		
		//caching
		if(cache && hasCache(apiName, param)){
			return (List<com.kmutt.cony.model.zombie.Class>) getCache(apiName, param);
		}
				
		String json = getJson(apiName, method, param);
		List<com.kmutt.cony.model.zombie.Class> list = GSON.fromJson(json, new TypeToken<List<com.kmutt.cony.model.zombie.Class>>() {
		}.getType());
		
		saveCache(apiName, param, list);
		return list;
	}

	public List<StudentAttendance> getClassScheduleCheckIn(int groupId, int classScheduleId) throws Exception {
		return getClassScheduleCheckIn( groupId, classScheduleId, true);
	}
	public List<StudentAttendance> getClassScheduleCheckIn(int groupId, int classScheduleId, boolean cache) throws Exception {
		String apiName = "/jsonresponse/get_class_attendance/";
		String method = "POST";
		
		checkLogin();
		
		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
		param.add(new SimpleEntry<String,Object>("group_id",groupId));
		param.add(new SimpleEntry<String,Object>("class_id",classScheduleId));
		
		//caching
		if(cache && hasCache(apiName, param)){
			return (List<StudentAttendance>) getCache(apiName, param);
		}
				
		String json = getJson(apiName, method, param);
		List<StudentAttendance> list =  GSON.fromJson(json, new TypeToken<List<StudentAttendance>>() {
		}.getType());
		
		saveCache(apiName, param, list);
		return list;
	}

	public List<StudentStat> getStudentList(int groupId) throws Exception {
		return getStudentList(groupId, true);
	}
	public List<StudentStat> getStudentList(int groupId, boolean cache) throws Exception {
		String apiName = "/jsonresponse/get_group_students/";
		String method = "POST";
		
		checkLogin();
		
		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
		param.add(new SimpleEntry<String,Object>("group_id",groupId));
		
		//caching
		if(cache && hasCache(apiName, param)){
			return (List<StudentStat>) getCache(apiName, param);
		}
				
		String json = getJson(apiName, method, param);
		List<StudentStat> list =  GSON.fromJson(json, new TypeToken<List<StudentStat>>() {
		}.getType());
		
		saveCache(apiName, param, list);
		return list;
	}
	
	public StudentInfo getStudentInfo(int groupId, int studentId) throws Exception{
		return getStudentInfo(groupId, studentId, true);
	}
	
	public StudentInfo getStudentInfo(int groupId, int studentId, boolean cache)
			throws Exception {
		
		String apiName = "/jsonresponse/get_student_info/";
		String method = "POST";
		
		checkLogin();
		
		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
		param.add(new SimpleEntry<String,Object>("group_id",groupId));
		param.add(new SimpleEntry<String,Object>("student_id",studentId));
		
		//caching
		if(cache && hasCache(apiName, param)){
			return (StudentInfo) getCache(apiName, param);
		}
				
		String json = getJson(apiName, method, param);
		StudentInfo obj = GSON.fromJson(json, StudentInfo.class);
		
		saveCache(apiName, param, obj);
		return obj;
	}
	
//	public List<Course> getRegisteredCourse(int studentId) throws Exception {
//		String apiName = "/jsonresponse/get_student_registered_courses/";
//		String method = "POST";
//		List<Entry<String,Object>>param = new ArrayList<Entry<String,Object>>();
//		param.add(new SimpleEntry<String,Object>("student_id",studentId));
//		
//		String json = getJson(apiName, method, param);
//		return GSON.fromJson(json, new TypeToken<List<Course>>() {
//		}.getType());
//	}
	
//
//	public Student getStudentInfo(String studentId) throws Exception {
//		String apiName = "/jsonService/getStudentInfo";
//		String method = "POST";
//		List<Entry<String, Object>> param = new ArrayList<Entry<String, Object>>(
//				1);
//		param.add(new SimpleEntry<String, Object>("studentId", studentId));
//		String json = getJson(apiName, method, param);
//		return GSON.fromJson(json, Student.class);
//	}
//
//	public ClassSchedule getCurrentClassSchedule(String date, String time)
//			throws Exception {
//		String apiName = "/jsonService/getCurrentClassSchedule";
//		String method = "POST";
//		List<Entry<String, Object>> param = new ArrayList<Entry<String, Object>>(
//				2);
//		param.add(new SimpleEntry<String, Object>("date", date));
//		param.add(new SimpleEntry<String, Object>("time", time));
//		String json = getJson(apiName, method, param);
//		return GSON.fromJson(json, ClassSchedule.class);
//	}
//
//	public User getUserInfo(String faceId) throws Exception {
//		String apiName = "/GetUserInfo";
//		String method = "POST";
//		List<Entry<String, Object>> param = new ArrayList<Entry<String, Object>>(
//				1);
//		param.add(new SimpleEntry<String, Object>("faceId", faceId));
//		String json = getJson(apiName, method, param);
//		return GSON.fromJson(json, User.class);
//	}
}
