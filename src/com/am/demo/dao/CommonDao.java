package com.am.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.am.demo.dto.Restaurant;

public class CommonDao {

	
	public void saveRestaurant(Restaurant restaurant) {
				Configuration configuration = new Configuration();
				configuration.configure();
				configuration.addAnnotatedClass(Restaurant.class);
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(restaurant);
				transaction.commit();
	}
}
