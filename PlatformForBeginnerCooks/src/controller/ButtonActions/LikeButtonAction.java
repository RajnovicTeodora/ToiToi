package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Recipe;
import model.User;
import view.MainFrame;

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
		if(user.getLikedRecipes().contains(recipe)) {
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do unlike?", "Unlike", JOptionPane.YES_NO_OPTION);
			if (choice ==JOptionPane.YES_OPTION) {
				recipe.setLikes(recipe.getLikes()-1);
				user.getLikedRecipes().remove(recipe);
				
				try {
					MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(),  
							MainFrame.getInstance().getRecipeWindow().createUserRecipePage(recipe, user, getCurrentTabIndex()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			recipe.setLikes(recipe.getLikes()+1);
			user.getLikedRecipes().add(recipe);
			
			try {
				MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(),  
						MainFrame.getInstance().getRecipeWindow().createUserRecipePage(recipe, user, getCurrentTabIndex()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
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

}
