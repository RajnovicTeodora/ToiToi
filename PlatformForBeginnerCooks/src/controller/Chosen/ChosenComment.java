package controller.Chosen;

import java.util.ArrayList;

public class ChosenComment {
	
	private static ArrayList<Integer> chosenComms = new ArrayList<Integer>();

	public static ArrayList<Integer> getChosenComms() {
		return chosenComms;
	}

	public static void setChosenComms(ArrayList<Integer> chosenComms) {
		ChosenComment.chosenComms = chosenComms;
	}
	
	public static void add_comm(Integer pId) {
		if(chosenComms == null) {
			chosenComms = new ArrayList<Integer>();
		}
		if(chosenComms.contains(pId)) {
			return;
		}
		chosenComms.add(pId);
		
	}
	
	public static void remove_comm(Integer pId) {
		if(chosenComms== null || !chosenComms.contains(pId)) {
			return;
		}
		chosenComms.remove(pId);
	}

	public static boolean containsComm(Integer pId) {
		boolean retval = false;
		if(chosenComms != null && chosenComms.contains(pId)) {
			retval = true;
		}
		return retval;
	}
	
}
