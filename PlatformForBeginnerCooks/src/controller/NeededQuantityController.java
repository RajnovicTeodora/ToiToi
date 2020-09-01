package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.NeededQuantity;

public class NeededQuantityController {

	private NeededQuantity nq;

	private String nqFile;

	public NeededQuantityController(String nqFile) {
		super();
		this.nqFile = nqFile;
	}

	
	
	public NeededQuantityController() {
		super();
	}

	

	public NeededQuantity getNq() {
		return nq;
	}


	public void setNq(NeededQuantity nq) {
		this.nq = nq;
	}


	public String getNqFile() {
		return nqFile;
	}


	public void setNqFile(String nqFile) {
		this.nqFile = nqFile;
	}


	public void writeNQ(ArrayList<NeededQuantity> nqs)  {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(nqFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(nqs);

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
	public ArrayList<NeededQuantity> readNQs(){
		ObjectInputStream objectIn = null;
		ArrayList<NeededQuantity> nqs = null;
		try {
			FileInputStream fileIn = new FileInputStream(nqFile);
			objectIn = new ObjectInputStream(fileIn);
			nqs = (ArrayList<NeededQuantity>) objectIn.readObject();

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
		return nqs;
	}
	
}
