package view;

import java.io.IOException;

import controller.ToiToiController;

public class Application {
	
	public static void main(String args[]) throws IOException {
		ToiToiController toiToiController = new ToiToiController();
		toiToiController.writteData();
		toiToiController.readData();
		
		MainFrame mf = new MainFrame(toiToiController);
        mf.setVisible(true);
		
		
		
		
	}
}
