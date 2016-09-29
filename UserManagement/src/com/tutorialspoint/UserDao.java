package com.tutorialspoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDao {
	public List<User> getAllUsers(int id, String nombre, String descripcion, String cargo, String area) {
		List<User> userList = null;
		Random r = new Random();
		int ticketNumber = r.nextInt(1000000) + 1;
		System.out.println(ticketNumber);

//		try {
//			File file = new File("Users.dat");
//			if (!file.exists()) {
				User user = new User(id, nombre, cargo, Integer.toString(ticketNumber));
				userList = new ArrayList<User>();
				userList.add(user);
				saveUserList(userList);
/*
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
*/
		return userList;
	}

	private void saveUserList(List<User> userList) {
		try {
			File file = new File("Users.dat");
			FileOutputStream fos;

			fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}