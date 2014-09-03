/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmutt.cony.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class User {
    private String userId;
    private int userType;
    private String nickName;
    private String lastName;
    private String firstName;
    private Integer gender;
    private String address;
    private String phoneNumber;
    private String facebook;
    private String photo;
    private List<TimeAttendance> attendaces;

    public static final int TEACHER=0;
    public static final int STUDENT=1;
    public static final int MALE=0;
    public static final int FEMALE=1;
    public User() {
    }
    
    public User(String userId, int userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public User(String userId, int userType, String firstName, String lastName) {
        this.userId = userId;
        this.userType = userType;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<TimeAttendance> getAttendaces() {
        return attendaces;
    }

    public void setAttendaces(List<TimeAttendance> attendaces) {
        this.attendaces = attendaces;
    }
    
    public boolean addAttendance(TimeAttendance attendace){
        if(attendaces==null)attendaces=new ArrayList<TimeAttendance>();
        return attendaces.add(attendace);
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType
				+ ", nickName=" + nickName + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", gender=" + gender
				+ ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", facebook=" + facebook + ", photo=" + photo
				+ ", attendaces=" + attendaces + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((attendaces == null) ? 0 : attendaces.hashCode());
		result = prime * result
				+ ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + userType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (attendaces == null) {
			if (other.attendaces != null)
				return false;
		} else if (!attendaces.equals(other.attendaces))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}
    
    
}
