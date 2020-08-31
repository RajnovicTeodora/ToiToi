package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.User;

public class UserController {

	private User user;

	private String userFile;

	public UserController(User user, String userFile) {
		super();
		this.user = user;
		this.userFile = userFile;
	}

	public UserController(String userFile) {
		super();
		this.userFile = userFile;
	}
	
	public UserController() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserFile() {
		return userFile;
	}

	public void setUserFile(String userFile) {
		this.userFile = userFile;
	}
	
	public void writeUsers(ArrayList<User> users)  {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(userFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(users);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				try {
					objectOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<User> readUsers(){
		ObjectInputStream objectIn = null;
		ArrayList<User> userList = null;
		try {
			FileInputStream fileIn = new FileInputStream(userFile);
			objectIn = new ObjectInputStream(fileIn);
			userList = (ArrayList<User>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				try {
					objectIn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return userList;
	}
	
}
