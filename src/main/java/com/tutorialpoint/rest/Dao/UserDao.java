package com.tutorialpoint.rest.Dao;

import java.util.ArrayList;
import java.util.List;

import com.tutorialpoint.rest.Bean.User;

public class UserDao {

	public List<User> getAllUsers() {
		List<User> userList = null;

		User user1 = new User(1, "Awinas", "Dev", "Team 1");
		User user2 = new User(2, "Tamil", "Designer", "Team 1");
		User user3 = new User(3, "Karthi", "finance", "Team 2");
		User user4 = new User(4, "Kamal", "Dev", "Team 1");
		User user5 = new User(5, "Gokul", "Dev", "Team 2");
		User user6 = new User(6, "Vignesh", "Dev", "Team 1");

		userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		System.out.println("User List Created");
		return userList;
	}

}
