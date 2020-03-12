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

	public Restaurant getRestaurantDetails(String name) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Restaurant.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Restaurant restaurant = (Restaurant) session.get(Restaurant.class, name);
		return restaurant;
	}
	
	
	public void updateRestaurantDetails(String name,double price) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Restaurant.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Restaurant restaurant = (Restaurant) session.get(Restaurant.class, name);
		if(restaurant!=null) {
			restaurant.setPrice(price);
		}else {
			System.out.println("data does not exists");
		}
		session.save(restaurant);
		transaction.commit();
	}
	
	

}
