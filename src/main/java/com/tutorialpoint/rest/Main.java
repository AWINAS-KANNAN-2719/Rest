package com.tutorialpoint.rest;

import com.tutorialpoint.rest.Dao.UserDao;

public class Main {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		System.out.println(dao.getAllUsers());
		

	}

}
