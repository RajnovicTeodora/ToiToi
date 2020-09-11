package view.HomePanel;

import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ToiToiController;
import model.Recipe;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel topRecipes; // recommended

	protected JPanel topUser;

	protected JPanel topCookbook;

	private ToiToiController toiToiController;

	public HomePanel(ToiToiController toiToiController) {

		this.toiToiController = toiToiController;
		ArrayList<Recipe> recipes = (ArrayList<Recipe>) toiToiController.getToiToi().getRecipe();
		recipes = toiToiController.getRecipeController().sortByLikes(recipes);
		
		topRecipes = new TopRecipesPanel(recipes);
		add(topRecipes);
	}

}
