package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Equipment;

public class EquipmentController {

	private Equipment equipment;

	private String equipmentFile;

	public EquipmentController(String equipmentfile) {

		super();
		this.equipmentFile = equipmentfile;

	}

	public void writeEquipment(ArrayList<Equipment> equipmentList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(equipmentFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(equipmentList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Equipment> readEquipment() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<Equipment> equipmentList = null;
		try {
			FileInputStream fileIn = new FileInputStream(equipmentFile);
			objectIn = new ObjectInputStream(fileIn);
			equipmentList = (ArrayList<Equipment>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return equipmentList;

	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	// find the first unused recipe id
	public int freeId(List<Equipment> equipment) {
		int i = 1;
		Boolean copy = false;
		while (true) {
			for (Equipment e : equipment) {
				if (e.getEquipmentID() == i) {
					copy = true;
					break;
				}
			}
			if (copy) {
				i++;
				copy = false;
			} else {
				return i;
			}
		}
	}
}
