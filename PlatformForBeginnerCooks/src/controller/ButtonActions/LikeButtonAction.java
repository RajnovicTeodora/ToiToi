package controller.ButtonActions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Recipe;
import model.User;
import view.MainFrame;
import view.HomePanel.HomePanel;
import view.ProfileWindow.ProfileWindow;

public class LikeButtonAction extends AbstractAction{
	
	private static final long serialVersionUID = 7344829217204344593L;
	private Recipe recipe;
	private User user;
	private int currentTabIndex;

	public LikeButtonAction(String name, Recipe recipe, User user) {
		super(name);
		this.recipe =recipe;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		boolean contains = false;
		for (Recipe it : user.getLikedRecipes()) {
			if(it.getRecipeID() == getRecipe().getRecipeID()) {
				contains = true;
			}
		}
		if(contains) {
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do unlike?", "Unlike", JOptionPane.YES_NO_OPTION);
			if (choice ==JOptionPane.YES_OPTION) {
				Recipe temp = getRecipe();
				temp.setLikes(getRecipe().getLikes()-1);
				User tmpUser = user;
				for (Recipe it : tmpUser.getLikedRecipes()) {
					if(it.getRecipeID() == getRecipe().getRecipeID()) {
						tmpUser.getLikedRecipes().remove(it);
						break;
					}
				}
				
				
				MainFrame.getInstance().getToiToiController().getToiToi().replaceRecipe(getRecipe(), temp);
				setRecipe(temp);
				MainFrame.getInstance().getToiToiController().getToiToi().replaceUser(tmpUser);
				MainFrame.getInstance().setAkter(tmpUser);
				setUser(tmpUser);
				updateHomeTab();
				updateProfiletab();
				
				try {
					MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(),  
							MainFrame.getInstance().getRecipeWindow().createUserRecipePage(getRecipe(), getUser(), getCurrentTabIndex()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			Recipe temp = getRecipe();
			temp.setLikes(getRecipe().getLikes()+1);
			User tmpUser = user;
			tmpUser.getLikedRecipes().add(recipe);
			
			MainFrame.getInstance().getToiToiController().getToiToi().replaceRecipe(getRecipe(), temp);
			setRecipe(temp);
			MainFrame.getInstance().getToiToiController().getToiToi().replaceUser( tmpUser);
			MainFrame.getInstance().setAkter(tmpUser);
			setUser(tmpUser);
			updateHomeTab();
			updateProfiletab();
			
			try {
				
				MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(),  
						MainFrame.getInstance().getRecipeWindow().createUserRecipePage(getRecipe(), getUser(), getCurrentTabIndex()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void updateHomeTab() {
		JPanel panl = new HomePanel(MainFrame.getInstance().getToiToiController());
		panl.setBackground(new Color(200, 221, 242));
		MainFrame.getInstance().setHomePanel(panl);
		MainFrame.getInstance().getTabbedPane().setComponentAt(0, panl);
	}
	
	
	public void updateProfiletab() {
		ProfileWindow pw = new ProfileWindow(MainFrame.getInstance().getAkter(), MainFrame.getInstance().getToiToiController());
		JPanel pan = new JPanel();
		try {
			pan = pw.createMyProfilePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance().getTabbedPane().setComponentAt(3, pan);
		
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
