package controller.Chosen;

import java.util.ArrayList;

public class ChosenTasteForEdit {
	
	private static ArrayList<String> chosenTaste = new ArrayList<String>();

	public static ArrayList<String> getChosenTaste() {
		return chosenTaste;
	}

	public static void setChosenTaste(ArrayList<String> chosenTaste) {
		ChosenTasteForEdit.chosenTaste = chosenTaste;
	}
	
	public static void add_taste(String object) {
		if(chosenTaste == null) {
			chosenTaste = new ArrayList<String>();
		}
		if(chosenTaste.contains(object)) {
			return;
		}
		chosenTaste.add(object);
		
	}
	
	public static void remove_taste(String object) {
		if(chosenTaste == null || !chosenTaste.contains(object)) {
			return;
		}
		chosenTaste.remove(object);
	}
}
