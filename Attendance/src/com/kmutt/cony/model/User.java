package com.kmutt.cony.model;

import java.util.List;

public class User {
	private String userId;
    private String nickName;
    private String lastName;
    private String firstName;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String facebook;
    private String twitter;
    private String photo;
    private List<Group>registered;
	public User() {}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Group> getRegistered() {
		return registered;
	}
	public void setRegistered(List<Group> registered) {
		this.registered = registered;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName
				+ ", lastName=" + lastName + ", firstName=" + firstName
				+ ", gender=" + gender + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", facebook=" + facebook + ", twitter=" + twitter
				+ ", photo=" + photo + "]";
	}
	
    
}
