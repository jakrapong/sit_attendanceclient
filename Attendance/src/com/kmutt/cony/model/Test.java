/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmutt.cony.model;


import com.kmutt.cony.api.AttendanceAPI;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) throws Exception {
    	String username="kmutt";
    	String password="cony";
    	AttendanceAPI api=AttendanceAPI.getInstance().setCredentail(username, password);
    	System.out.print(api.getStudentInfo("1"));
    }
}
