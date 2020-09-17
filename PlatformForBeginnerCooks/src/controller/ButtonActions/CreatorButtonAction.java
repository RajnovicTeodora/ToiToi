package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
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
		
//		if(MainFrame.getInstance().getAkter() == null || !MainFrame.getInstance().getAkter().getUsername().equalsIgnoreCase(recipeCreator.getUsername())) {
//			
//
//			User user = MainFrame.getInstance().getToiToiController().getUserController().getUser();
//			
//			for(Akter u : MainFrame.getInstance().getToiToiController().getToiToi().getUsers()) {
//				if(u.getUsername().equalsIgnoreCase(recipeCreator.getUsername())) {
//					user = (User) u;
//				}
//			}
//			int i = MainFrame.getInstance().getTabbedPane().getTabCount();  //samo 3 jer zbog 1.if ne upadaju ulogovani  
//			if(i != 3 && MainFrame.getInstance().getProfileForVisitor()!=null) {
//				MainFrame.getInstance().setProfileForVisitor(new ProfileWindow(user, MainFrame.toiToiController));
//				
//				MainFrame.getInstance().getTabbedPane().setTabComponentAt(MainFrame.tabbedPane.getTabCount()-1,
//						new ButtonTabComponent(MainFrame.tabbedPane, user.getName()+ " " +user.getSurname()));
//				try {
//					MainFrame.getInstance().getTabbedPane().setComponentAt(MainFrame.tabbedPane.getTabCount()-1, 
//							MainFrame.getInstance().getProfileForVisitor().createOtherUserProfilePage());
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else {
//				MainFrame.getInstance().setProfileForVisitor(new ProfileWindow(user, MainFrame.toiToiController));
//				MainFrame.getInstance().getProfileForVisitor().setCurrentTabIndex(MainFrame.tabbedPane.getTabCount());
//				try {
//					MainFrame.getInstance().getTabbedPane().add("", MainFrame.getInstance().getProfileForVisitor().createOtherUserProfilePage());
//					
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//				MainFrame.getInstance().getTabbedPane().setTabComponentAt(MainFrame.tabbedPane.getTabCount()-1,
//						new ButtonTabComponent(MainFrame.tabbedPane, user.getName()+ " " +user.getSurname()));
//			}
//			
//			
//			
//			
//		}
//		else if(MainFrame.getInstance().getAkter().getUsername().equalsIgnoreCase(recipeCreator.getUsername())) {
//			MainFrame.tabbedPane.setSelectedIndex(3);
//
//		}
		
		if (recipeCreator != null) {

			if (MainFrame.getInstance().getAkter() != null && MainFrame.getInstance().getAkter().getUsername().equalsIgnoreCase(recipeCreator.getUsername())) {
				MainFrame.tabbedPane.setSelectedIndex(3);
			} 
			else {
				ProfileWindow pw = new ProfileWindow(recipeCreator, MainFrame.toiToiController);
				
				try {
					MainFrame.tabbedPane.add("", pw.createOtherUserProfilePage());

				} catch (IOException e) {
					e.printStackTrace();
				}

				MainFrame.tabbedPane.setTabComponentAt(MainFrame.tabbedPane.getTabCount() - 1, new ButtonTabComponent(MainFrame.tabbedPane, recipeCreator.getName() + " " + recipeCreator.getSurname()));
				MainFrame.tabbedPane.setSelectedIndex(MainFrame.tabbedPane.getTabCount() - 1);
				pw.setCurrentTabIndex(MainFrame.tabbedPane.getTabCount() - 1);
			}

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
