
package com.kmutt.cony.model.zombie;


public class Instructor{
   	private String firstName;
   	private int gender;
   	private String lastName;
   	private String photo;
   	private int userId;

    private String address;
    private String telephone;
    private String email;
    private String facebook;
    private String twitter;
    
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
 	public String getPhoto(){
		return this.photo;
	}
	public void setPhoto(String photo){
		this.photo = photo;
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
}
