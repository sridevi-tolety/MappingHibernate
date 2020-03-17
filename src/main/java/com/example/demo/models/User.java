package com.example.demo.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long userid;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_hobbies", joinColumns = { 
			@JoinColumn(name = "userid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "hobbyID", 
					nullable = false, updatable = false) })
	private Set<Hobby> hobbies;

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", hobbies=" + hobbies + "]";
	}

	public User(long userid, String name, Set<Hobby> hobbies) {
		super();
		this.userid = userid;
		this.name = name;
		this.hobbies = hobbies;
	}
	
	

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public User() {}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
