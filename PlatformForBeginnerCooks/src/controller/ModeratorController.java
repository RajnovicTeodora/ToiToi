package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Moderator;

public class ModeratorController {

	private String moderatorFile;
	
	private Moderator moderator;

	public ModeratorController(String moderatorFile, Moderator moderator) {
		super();
		this.moderatorFile = moderatorFile;
		this.moderator = moderator;
	}
	
	public ModeratorController(String moderatorFile) {
		super();
		this.moderatorFile = moderatorFile;
	}

	public String getModeratorFile() {
		return moderatorFile;
	}

	public void setModeratorFile(String moderatorFile) {
		this.moderatorFile = moderatorFile;
	}

	public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	
	public void writeModerators(ArrayList<Moderator> moderators)  {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(moderatorFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(moderators);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				try {
					objectOut.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Moderator> readModerators(){
		ObjectInputStream objectIn = null;
		ArrayList<Moderator> moderatorList = null;
		try {
			FileInputStream fileIn = new FileInputStream(moderatorFile);
			objectIn = new ObjectInputStream(fileIn);
			moderatorList = (ArrayList<Moderator>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				try {
					objectIn.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		return moderatorList;
	}
}
