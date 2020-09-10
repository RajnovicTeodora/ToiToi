package model;

import java.util.ArrayList;

public class ChosenEquipment {

	private static ArrayList<Integer> chosenEqs;

	public static ArrayList<Integer> getChosenEqs() {
		return chosenEqs;
	}

	public static void setChosenEqs(ArrayList<Integer> chosenEqs) {
		ChosenEquipment.chosenEqs = chosenEqs;
	}
	
	public static void add_product(Integer pId) {
		if(chosenEqs == null) {
			chosenEqs = new ArrayList<Integer>();
			if(chosenEqs.contains(pId)) {
				return;
			}
			chosenEqs.add(pId);
		}
	}
	
	public static void remove_product(Integer pId) {
		if(chosenEqs== null || !chosenEqs.contains(pId)) {
			return;
		}
		chosenEqs.remove(pId);
	}
	
}
