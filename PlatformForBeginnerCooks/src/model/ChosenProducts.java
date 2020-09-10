package model;

import java.util.ArrayList;

public class ChosenProducts {

	private static ArrayList<Integer> chosenProducts;

	public static ArrayList<Integer> getChosenProducts() {
		return chosenProducts;
	}

	public static void setChosenProducts(ArrayList<Integer> chosenProducts) {
		ChosenProducts.chosenProducts = chosenProducts;
	}
	
	public static void add_product(Integer pId) {
		if(chosenProducts == null) {
			chosenProducts = new ArrayList<Integer>();
			if(chosenProducts.contains(pId)) {
				return;
			}
			chosenProducts.add(pId);
		}
	}
	
	public static void remove_product(Integer pId) {
		if(chosenProducts== null || !chosenProducts.contains(pId)) {
			return;
		}
		chosenProducts.remove(pId);
	}
}
