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

import edu.uniandes.cct.serviceRequest.ServiceDeskManager;

public class UserDao {
	public List<User> getAllUsers(int id, String nombre, String descripcion, String cargo, String area) {
		List<User> userList = null;

		ServiceDeskManager sdm = new ServiceDeskManager();
		sdm.StartAsyncProcessing();

		String srid = sdm.CreateRequest(descripcion);

		User user = new User(id, nombre, cargo, srid);
		userList = new ArrayList<User>();
		userList.add(user);
		saveUserList(userList);

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