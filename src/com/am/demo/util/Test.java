package com.am.demo.util;

import com.am.demo.dao.CommonDao;
import com.am.demo.dto.Restaurant;

public class Test {

	public static void main(String[] args) {

			Restaurant restaurant = new Restaurant();
			restaurant.setName("udupi uphar");
			restaurant.setContact(108);
			restaurant.setMenu("masala dosa");
			restaurant.setPrice(45.5);
			restaurant.setAddress("murgeshpalya");
			
			CommonDao dao = new CommonDao();
			dao.saveRestaurant(restaurant);
			System.out.println("data saved");
	}

}
