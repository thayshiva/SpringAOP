package org.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {
		try{
			//Create the session factory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Throwable ex){
			//Make sure you log this exception, as it might be swallowed.
			System.err.println("Initial SessionFactory creation failed."+ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void close(){
		if(serviceRegistry != null)
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
	}
}
