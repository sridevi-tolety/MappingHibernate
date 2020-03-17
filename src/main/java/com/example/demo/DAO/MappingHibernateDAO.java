package com.example.demo.DAO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Hobby;
import com.example.demo.models.User;

@Repository
public class MappingHibernateDAO {
	
	@Autowired
	SessionFactory sf;
	
	public long addUser(){
		Session session;
		try {
			session = sf.getCurrentSession();
		}catch(HibernateException ex){}
		finally {
			session = sf.openSession();
		}	
		session.beginTransaction();
		System.out.println("In repo :::"+session);
		Hobby hb1 = new Hobby();
		Hobby hb2 = new Hobby();
		hb1.setHobbyname("hobby1");
		hb2.setHobbyname("hobby2");
		Set<Hobby> hbs = new HashSet();
		hbs.add(hb1);
		hbs.add(hb2);
		User us1 = new User();
		us1.setName("user1");
		us1.setHobbies(hbs);
		long ret = (long)session.save(us1);
		session.getTransaction().commit();
		return ret;
	}

	public long addHobby() {
		// TODO Auto-generated method stub
		Session session;
		try {
			session = sf.getCurrentSession();
		}catch(HibernateException ex){}
		finally {
			session = sf.openSession();
		}	
		session.beginTransaction();
		System.out.println("In repo :::"+session);
		Hobby hb1 = new Hobby();		
		hb1.setHobbyname("hobby3");		
		User us1 = new User();
		us1.setName("user3");
		User us2 = new User();
		us2.setName("user4");
		Set<User> users = new HashSet();
		users.add(us1);
		users.add(us2);
		hb1.setUsers(users);
		long ret = (long)session.save(hb1);
		session.getTransaction().commit();
		return ret;		
	}	
	
}

