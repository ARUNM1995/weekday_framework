package com.am.demo.util;

import java.util.List;

import com.am.demo.dao.CommonDao;
import com.am.demo.dto.Restaurant;

public class Test {

	public static void main(String[] args) {
		/*
			Restaurant restaurant = new Restaurant();
			restaurant.setName("leela palace");
			restaurant.setContact(102);
			restaurant.setMenu("buffet");
			restaurant.setPrice(100.4);
			restaurant.setAddress("manipals");
			*/
			CommonDao dao = new CommonDao();
			dao.updateMenuByName("Hyderbadi biryani", "ice cream");
		/*
		 * Restaurant restaurant = dao.getRestaurantByName("Hyderbadi biryani");
		 * System.out.println(restaurant);
		 */
		/*
		 * List<Restaurant> restaurants = dao.getRestaurants(); restaurants.forEach(a->{
		 * System.out.println(a); });
		 * 
		 */
			//dao.deleteByName("udupi uphar");
			//dao.updateRestaurantDetails("udupi uphar", 450.5);
			//Restaurant restaurant = dao.getRestaurantDetails("taj west end");
			//System.out.println(restaurant);
		//	dao.saveRestaurant(restaurant);
			//System.out.println("data saved");
	}

}
