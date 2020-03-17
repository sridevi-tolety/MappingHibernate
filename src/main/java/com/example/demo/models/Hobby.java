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
public class Hobby {
	
	@Id
	@GeneratedValue
	private long hobbyid;
	@Override
	public String toString() {
		return "Hobby [hobbyid=" + hobbyid + ", hobbyname=" + hobbyname + ", users=" + users + "]";
	}

	public Hobby(long hobbyid, String hobbyname, Set<User> user) {
		super();
		this.hobbyid = hobbyid;
		this.hobbyname = hobbyname;
		this.users = users;
	}
	
	public Hobby() {}

	public long getHobbyid() {
		return hobbyid;
	}

	public void setHobbyid(long hobbyid) {
		this.hobbyid = hobbyid;
	}

	private String hobbyname;
	
	//@ManyToMany(mappedBy = "hobbies")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_hobbies", joinColumns = { 
			@JoinColumn(name = "hobbyid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "userID", 
					nullable = false, updatable = false) })
	private Set<User> users;

		public String getHobbyname() {
		return hobbyname;
	}

	public void setHobbyname(String hobbyname) {
		this.hobbyname = hobbyname;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
