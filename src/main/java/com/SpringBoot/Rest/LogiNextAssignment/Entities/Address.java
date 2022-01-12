package com.SpringBoot.Rest.LogiNextAssignment.Entities;

public class Address {
private String zipcode;
private String street;
private String suite;
private String city;


public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getSuite() {
	return suite;
}
public void setSuite(String suite) {
	this.suite = suite;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Address(String zipcode, String street, String suite, String city) {
	super();
	this.zipcode = zipcode;
	this.street = street;
	this.suite = suite;
	this.city = city;
}


}
