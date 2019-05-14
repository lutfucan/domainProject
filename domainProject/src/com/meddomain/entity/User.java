package com.meddomain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String name;
	
	private String surname;
	
	private String userName;

	@OneToMany(mappedBy = "user")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private List<Domain> domainsOwned;
	
	private String password;
	
	private String email;
	
	private String phone;

	public User(String userName) {
		this.userName = userName;
	}

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Domain> getDomainsOwned() {
		return domainsOwned;
	}

	public void setDomainsOwned(List<Domain> domainsOwned) {
		this.domainsOwned = domainsOwned;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public void addDomain(Domain domain) {
		if (domainsOwned == null) {
			domainsOwned = new ArrayList<>();
			if (domain != null) {
				domainsOwned.add(domain);
				domain.setUser(this);
			}
		} else {
			domainsOwned.add(domain);
		}
	}

	@Override
	public String toString() {
		return name  + " " + surname ;
	}
	
	
	
}
