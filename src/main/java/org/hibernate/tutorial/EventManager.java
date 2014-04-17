package org.hibernate.tutorial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {
	
	private Event event;
	
	public static void main(String[] args) {
		EventManager manager = new EventManager();
		manager.createAndStoreEvent("My Event-5", new Date());
		
		HibernateUtil.getSessionFactory().close();
		HibernateUtil.close();
	}
	
	public void createAndStoreEvent(String title, Date theDate){
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		event = new Event();
		event.setTitle(title);
		event.setDate(theDate);
		session.save(event);
		
		session.getTransaction().commit();
	}
	
}
