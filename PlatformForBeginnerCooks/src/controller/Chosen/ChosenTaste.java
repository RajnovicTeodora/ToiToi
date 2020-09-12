package controller.Chosen;

import java.util.ArrayList;

public class ChosenTaste {

	private static ArrayList<String> chosenTaste = new ArrayList<String>();

	public static ArrayList<String> getChosenTaste() {
		return chosenTaste;
	}

	public static void setChosenTaste(ArrayList<String> chosenTaste) {
		ChosenTaste.chosenTaste = chosenTaste;
	}
	
	public static void add_taste(String t) {
		if(chosenTaste == null) {
			chosenTaste = new ArrayList<String>();
		}
		if(chosenTaste.contains(t)) {
			return;
		}
		chosenTaste.add(t);
		
	}
	
	public static void remove_taste(String t) {
		if(chosenTaste == null || !chosenTaste.contains(t)) {
			return;
		}
		chosenTaste.remove(t);
	}
	
}
