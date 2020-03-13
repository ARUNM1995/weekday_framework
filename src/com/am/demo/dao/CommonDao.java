package com.am.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.am.demo.dto.Restaurant;

public class CommonDao {

	public void saveRestaurant(Restaurant restaurant) {
		Configuration configuration = new Configuration();
		configuration.configure();
		// configuration.addAnnotatedClass(Restaurant.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(restaurant);
		transaction.commit();
	}

	public Restaurant getRestaurantDetails(String name) {
		Configuration configuration = new Configuration();
		configuration.configure();
		// configuration.addAnnotatedClass(Restaurant.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Restaurant restaurant = (Restaurant) session.get(Restaurant.class, name);
		return restaurant;
	}

	public void updateRestaurantDetails(String name, double price) {
		Configuration configuration = new Configuration();
		configuration.configure();
		// configuration.addAnnotatedClass(Restaurant.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Restaurant restaurant = (Restaurant) session.get(Restaurant.class, name);
		if (restaurant != null) {
			restaurant.setPrice(price);
		} else {
			System.out.println("data does not exists");
		}
		session.save(restaurant);
		transaction.commit();
	}

	public void deleteByName(String name) {
		Configuration configuration = new Configuration();
		configuration.configure();
		// configuration.addAnnotatedClass(Restaurant.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Restaurant details = getRestaurantDetails(name);
		session.delete(name, details);
		transaction.commit();
	}

	public List<Restaurant> getRestaurants() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql = "from Restaurant";
		Query query = session.createQuery(hql);
		List<Restaurant> list = query.list();
		return list;
	}

	public Restaurant getRestaurantByName(String name) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql1 = "from Restaurant where name=:n";
		Query query1 = session.createQuery(hql1);
		query1.setParameter("n", name);
		Restaurant uniqueResult = (Restaurant) query1.uniqueResult();
		return uniqueResult;

	}
	
	public void updateMenuByName(String name,String menu) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql="update Restaurant set menu=:m where name=:n";
		Query query = session.createQuery(hql);
		query.setParameter("m", menu);
		query.setParameter("n", name);
		int update = query.executeUpdate();
		System.out.println("no of rows got updated"+update);
		
	}
	
	
	
	

}
