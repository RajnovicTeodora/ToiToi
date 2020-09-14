package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Comment;
import model.CookBook;
import model.Recipe;

public class CookBookController {
	
	private CookBook cookbook;
	private String cbFile;
	
	public CookBookController(String file) {
		super();
		this.cbFile = file;
	}

	public CookBook getCookbook() {
		return cookbook;
	}

	public void setCookbook(CookBook cookbook) {
		this.cookbook = cookbook;
	}

	public String getCbFile() {
		return cbFile;
	}

	public void setCbFile(String cbFile) {
		this.cbFile = cbFile;
	}

	public void writeCookBook(ArrayList<CookBook> cbList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(cbFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(cbList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<CookBook> readCookBook() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<CookBook> cbList = null;
		try {
			FileInputStream fileIn = new FileInputStream(cbFile);
			objectIn = new ObjectInputStream(fileIn);
			cbList = (ArrayList<CookBook>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return cbList;

	}
	
	public List<CookBook> sortByLikes(List<CookBook> cb) {
		cb.sort(new Comparator<CookBook>() {

			@Override
			public int compare(CookBook cb1, CookBook cb2) {
				if (cb1.getLikes()+cb1.getComments().size() >= cb2.getLikes()+cb2.getComments().size())
					return -1;
				return 0;

			}
		});

		return cb;
	}
	
	public List<CookBook> sortByName(List<CookBook> cb, String name) {
		cb.sort(new Comparator<CookBook>() {

			@Override
			public int compare(CookBook cb1, CookBook cb2) {
				if (cb1.getName().equalsIgnoreCase(name) && !cb2.getName().equalsIgnoreCase(name))
					return 0;
				return -1;

			}
		});

		return cb;
	}

}
