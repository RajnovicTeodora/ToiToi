package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Admin;

public class AdminController {

	private String adminFile;
	
	private Admin admin;

	public AdminController(String adminFile, Admin admin) {
		super();
		this.adminFile = adminFile;
		this.admin = admin;
	}

	public AdminController(String adminFile) {
		super();
		this.adminFile = adminFile;
	}
	
	public String getAdminFile() {
		return adminFile;
	}

	public void setAdminFile(String adminFile) {
		this.adminFile = adminFile;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void writeAdmins(ArrayList<Admin> admins)  {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(adminFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(admins);

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
	public ArrayList<Admin> readAdmins(){
		ObjectInputStream objectIn = null;
		ArrayList<Admin> adminList = null;
		try {
			FileInputStream fileIn = new FileInputStream(adminFile);
			objectIn = new ObjectInputStream(fileIn);
			adminList = (ArrayList<Admin>) objectIn.readObject();

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
		return adminList;
	}
	
}
