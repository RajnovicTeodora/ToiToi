package controller.ButtonActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Recipe;
import view.EditRecipeWindow;
import view.MainFrame;

public class EditRecipeButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	
	private int currentTabIndex;
	
	private Recipe recipe;

	public EditRecipeButtonAction() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!(MainFrame.getInstance().getEditRecipe() == null))
			MainFrame.getInstance().getEditRecipe().dispose();
		
		EditRecipeWindow editWindow = new EditRecipeWindow(getRecipe());
		editWindow.setCurrentTabIndex(getCurrentTabIndex());
		MainFrame.getInstance().setEditRecipe(editWindow);
		editWindow.run();
		
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	
	
}
