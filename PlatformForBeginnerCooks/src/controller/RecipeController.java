package controller;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import model.Comment;
import model.Equipment;
import model.NeededQuantity;
import model.Recipe;
import model.Tag;
import model.Taste;
import view.MainFrame;

public class RecipeController {

	private Recipe recipe;
	private String recipeFile;

	public RecipeController() {
		super();
	}

	public RecipeController(String file) {
		super();
		this.recipeFile = file;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getRecipeFile() {
		return recipeFile;
	}

	public void setRecipeFile(String recipeFile) {
		this.recipeFile = recipeFile;
	}

	public void writeRecipes(ArrayList<Recipe> recipeList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(recipeFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(recipeList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Recipe> readRecipes() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<Recipe> recipeList = null;
		try {
			FileInputStream fileIn = new FileInputStream(recipeFile);
			objectIn = new ObjectInputStream(fileIn);
			recipeList = (ArrayList<Recipe>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return recipeList;

	}

	public HashMap<Integer, Recipe> getHashMapRecipe() throws IOException {
//		ToiToiController toiToiController = new ToiToiController();
//		toiToiController.writteData();
//		toiToiController.readData();

		// ArrayList<Recipe> recipes = readRecipes();
		HashMap<Integer, Recipe> retval = new HashMap<Integer, Recipe>();
		for (Recipe recipe : MainFrame.toiToiController.getToiToi().getRecipe()) {
			retval.put(recipe.getRecipeID(), recipe);
		}
		return retval;
	}

	// the function returns the first available recepie ID
	public int findRecipieID(ArrayList<Recipe> recipes) {
		int i = 1;
		boolean found = true;
		while (true) {
			for (Recipe recipe : recipes) {
				if (recipe.getRecipeID() == i) {
					found = false;
					break;
				}
			}
			if (!found) {
				found = true;
				i++;
			} else {
				return i;
			}
		}

	}

	// sorts recipes by likes
	public ArrayList<Recipe> sortByLikes(ArrayList<Recipe> recipes) {
		recipes.sort(new Comparator<Recipe>() {

			@Override
			public int compare(Recipe o1, Recipe o2) {
				if (o1.getLikes() >= o2.getLikes())
					return -1;
				return 0;

			}
		});

		return recipes;
	}

	public Recipe makeRecipe(String name, String description, ArrayList<Tag> tags, ArrayList<Taste> taste,
			ArrayList<Equipment> equipment, ArrayList<NeededQuantity> neededProduct) throws Exception {
		Recipe r = null;
		// TODO add more mandatory fields?
		if (name.equals("") || description.contentEquals("") || taste.size() == 0 || neededProduct.size() == 0
				|| equipment.size() == 0)
			throw new Exception("Not all fields were filled out!");
		else {
			r = new Recipe(name, description, 0, LocalDate.now(), taste, tags, equipment, new ArrayList<Comment>(),
					neededProduct);
		}
		return r;
	}

	// find the first unused recipe id
	public int freeId(ArrayList<Recipe> recipes) {
		int i = 1;
		Boolean copy = false;
		while (true) {
			for (Recipe r : recipes) {
				if (r.getRecipeID() == i) {
					copy = true;
					break;
				}
			}
			if (copy) {
				i++;
				copy = false;
			} else {
				return i;
			}
		}
	}
}
