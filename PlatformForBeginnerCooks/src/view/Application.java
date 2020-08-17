package view;

import controller.ToiToiController;

public class Application {
	
	public static void main(String args[]) {
		
		MainFrame mf = new MainFrame();
        mf.setVisible(true);
		
		ToiToiController toiToiController = new ToiToiController();
		toiToiController.writteData();
		toiToiController.readData();
		
		
	}
}
