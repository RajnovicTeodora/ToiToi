package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Akter;
import model.User;

public class AkterController {
	
	private Akter akter;

	private String akterFile;

	public AkterController(String akterFile) {
		super();
		this.akterFile = akterFile;
	}

	public String getAkterFile() {
		return akterFile;
	}

	public void setAkterFile(String akterFile) {
		this.akterFile = akterFile;
	}
	
	public void writeAkters(ArrayList<Akter> akters)  {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(akterFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(akters);

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
	public ArrayList<Akter> readAkters(){
		ObjectInputStream objectIn = null;
		ArrayList<Akter> akterList = null;
		try {
			FileInputStream fileIn = new FileInputStream(akterFile);
			objectIn = new ObjectInputStream(fileIn);
			akterList = (ArrayList<Akter>) objectIn.readObject();

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
		return akterList;
	}
}
