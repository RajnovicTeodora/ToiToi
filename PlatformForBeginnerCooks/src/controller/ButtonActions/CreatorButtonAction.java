package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import model.User;
import view.MainFrame;
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
		
		if(MainFrame.getInstance().getAkter() == null) {
			
			ProfileWindow pw = new ProfileWindow(getRecipeCreator(), MainFrame.getInstance().getToiToiController());
			JPanel pan = new JPanel();
			try {
				pan = pw.createOtherUserProfilePage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(), pan);
			
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
