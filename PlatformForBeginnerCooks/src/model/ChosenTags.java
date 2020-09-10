package model;

import java.util.ArrayList;

public class ChosenTags {

	private static ArrayList<String> chosenTags;

	public static ArrayList<String> getChosenTags() {
		return chosenTags;
	}

	public static void setChosenProducts(ArrayList<String> chosenTags) {
		ChosenTags.chosenTags = chosenTags;
	}
	
	public static void add_product(String pId) {
		if(chosenTags == null) {
			chosenTags = new ArrayList<String>();
			if(chosenTags.contains(pId)) {
				return;
			}
			chosenTags.add(pId);
		}
	}
	
	public static void remove_product(String pId) {
		if(chosenTags== null || !chosenTags.contains(pId)) {
			return;
		}
		chosenTags.remove(pId);
	}
	
}
