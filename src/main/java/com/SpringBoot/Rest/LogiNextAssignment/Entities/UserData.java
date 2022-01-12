package com.SpringBoot.Rest.LogiNextAssignment.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
 * Hierarchy of mongoDb is {Cluster -> Database -> Collections}
 */

//This annotation is telling mongoDb that in what collection(table) we have to save our UserData modules.
@Document("mydb")


public class UserData {
	
 @Id
 private String id;
 
 private boolean like = false;
 private String name;
 private String username;
 private String email;
 private String phone;
 private String website;
 private Company company;
 private Address address;



 
 
public boolean isLike() {
	return like;
}

public void setLike(boolean like) {
	this.like = like;
}
 
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

//Parameterized Constructor
public UserData(String id, String name, String username, String email, String phone, String website,
		Company company, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.username = username;
	this.email = email;
	this.phone = phone;
	this.website = website;
	this.company = company;
	this.address = address;
}

}

