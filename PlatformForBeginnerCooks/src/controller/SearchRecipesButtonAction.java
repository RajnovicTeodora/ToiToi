package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import model.Recipe;
import view.MainFrame;

public class SearchRecipesButtonAction extends AbstractAction{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;

	public SearchRecipesButtonAction(String name) {
		super(name);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getRecipesTab().setSearchClicked(true);
		ArrayList<Recipe> searchResults = new ArrayList<Recipe>();
		
		String searchTerm = MainFrame.getInstance().getRecipesTab().getSearchTxtField().getText();
		
		if(searchTerm.isEmpty()) {
			try {
				searchResults = MainFrame.getInstance().getToiToiController().getRecipeController().readRecipes();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			//TODO
		}
		
	}

}
