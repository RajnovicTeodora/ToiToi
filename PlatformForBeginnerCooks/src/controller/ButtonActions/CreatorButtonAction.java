package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import model.Akter;
import model.User;
import view.MainFrame;
import view.ProfileWindow.ButtonTabComponent;

import view.ProfileWindow.ProfileWindow;

public class CreatorButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	
	private User recipeCreator;

	private int currentTabIndex;
	
	public CreatorButtonAction() {
		super();
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(MainFrame.getInstance().getAkter() == null || !MainFrame.getInstance().getAkter().getUsername().equalsIgnoreCase(username)) {
			

			User user = MainFrame.toiToiController.getUserController().getUser();
			
			for(Akter u : MainFrame.toiToiController.getToiToi().getUsers()) {
				if(u.getUsername().equalsIgnoreCase(this.username)) {
					user = (User) u;
				}
			}
			
			ProfileWindow pw = new ProfileWindow(user, MainFrame.toiToiController);
			
			try {
				MainFrame.tabbedPane.add("", pw.createOtherUserProfilePage());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			MainFrame.tabbedPane.setTabComponentAt(MainFrame.tabbedPane.getTabCount()-1,  new ButtonTabComponent(MainFrame.tabbedPane, user.getName()+ " " +user.getSurname()));
			
		}
		else if(MainFrame.getInstance().getAkter().getUsername().equalsIgnoreCase(username)) {
			MainFrame.tabbedPane.setSelectedIndex(3);

		}
		
		
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public User getRecipeCreator() {
		return recipeCreator;
	}

	public void setRecipeCreator(User recipeCreator) {
		this.recipeCreator = recipeCreator;
	}

}
