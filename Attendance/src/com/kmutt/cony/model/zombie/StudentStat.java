
package com.kmutt.cony.model.zombie;

import java.io.Serializable;


public class StudentStat implements Serializable{
	private int userId;
	private String predefinedId;
	private String nickname;
	private int type;
	private String lastName;
	private String firstName;
	private int gender;
	private String photo;
	private String telephone;
	private String facebook;
	private String address;
    private String twitter;
    private String email;
    private int na;
    private int present;
    private int late;
   	private int absent;
   	
 	public int getAbsent(){
		return this.absent;
	}
	public void setAbsent(int absent){
		this.absent = absent;
	}
 	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
 	public int getGender(){
		return this.gender;
	}
	public void setGender(int gender){
		this.gender = gender;
	}
 	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
 	public int getLate(){
		return this.late;
	}
	public void setLate(int late){
		this.late = late;
	}
 	public String getPhoto(){
		return this.photo;
	}
	public void setPhoto(String photo){
		this.photo = photo;
	}
 	public int getPresent(){
		return this.present;
	}
	public void setPresent(int present){
		this.present = present;
	}
 	public int getUserId(){
		return this.userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return telephone;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.telephone = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getPredefinedId() {
		return predefinedId;
	}
	public void setPredefinedId(String predefinedId) {
		this.predefinedId = predefinedId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getNa() {
		return na;
	}
	public void setNa(int na) {
		this.na = na;
	}
	
	
}
