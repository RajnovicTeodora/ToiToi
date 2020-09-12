package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

import model.Recipe;
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

	public void calculatePoints(User user) {
		int points = 0;
			for (Recipe r : user.getRecipe()) {
				points += r.getLikes() * 2;
			}
			points += user.getLikedRecipes().size();
			// TODO for cookbooks
			if (!user.getImage().equals(""))
				points += 5;
		user.setPoints(points);
			
	}
	public User topUser(ArrayList<User> users) {
		for(User u : users)
			calculatePoints(u);
		users.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if (o1.getPoints() >= o2.getPoints())
					return -1;
				return 0;

			}
		});
		if(users.size() > 0)
			return users.get(0);
		return null;
	}
}
