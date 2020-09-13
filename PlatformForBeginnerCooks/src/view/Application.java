package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import controller.ToiToiController;

public class Application {
	
	public static void main(String args[]) throws IOException {
		ToiToiController toiToiController = new ToiToiController();
		toiToiController.readData();
		
		
		MainFrame mf = new MainFrame(toiToiController);
        mf.setVisible(true);
		
		mf.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				toiToiController.writteData();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
				
			}
		});
		
		
	}
}
