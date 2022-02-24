package com.capg.user.mapstruct.dto;

public class UserDTO {

	private int id;
	private String name;
	private String email;
	private String city;
	private long contact;

	public UserDTO() {

	}

	public UserDTO(int id, String name, String email, String city, long contact) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

}
