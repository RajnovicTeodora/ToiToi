package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Akter;
import model.Gender;
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

	public void writeUsers(ArrayList<User> users) {
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
	public ArrayList<User> readUsers() {
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

	public User topUser(ArrayList<User> users) {
		for (User u : users)
			u.calculatePoints();
		users.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if (o1.getPoints() >= o2.getPoints())
					return -1;
				return 0;

			}
		});
		if (users.size() > 0)
			return users.get(0);
		return null;
	}
	

	public User createUser(String name, String surname, String password, String username, String mail, String gender,
			String telephone, String address, LocalDate birthday, List<Akter> users) throws Exception {

		if (name.equals("") || surname.equals("") || password.equals("") || username.equals("") || telephone.equals("")
				|| address.equals("") || mail.equals("") || birthday.equals(null))
			throw new Exception("Not all fields were filled out!");

		if (birthday.isAfter(LocalDate.now()) || birthday.isEqual(LocalDate.now())) {
			throw new Exception("Birthday isnt valid!");
		}
		for (Akter akter : users) {
			if (akter.getUsername().equals(username))
				throw new Exception("Username is already taken!");
		}
		if (password.length() < 8) {
			throw new Exception("Password must be atleast 8 characters long!");
		} else {
			gender = gender.toUpperCase();
			Gender g = Gender.valueOf(gender);
			User user = new User(name, surname, username, password, mail, g, birthday, address, telephone, 0, null,
					null, null);
			return user;
		}

	}
}
