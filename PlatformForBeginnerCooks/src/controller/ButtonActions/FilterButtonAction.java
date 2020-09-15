package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import TableModel.EquipmentCheckBoxModel;
import TableModel.IngredientsCheckBoxModel;
import TableModel.TagsCheckBoxModel;
import TableModel.TasteCheckBoxModel;
import controller.Chosen.ChosenEquipment;
import controller.Chosen.ChosenProducts;
import controller.Chosen.ChosenTags;
import controller.Chosen.ChosenTaste;
import model.Recipe;
import model.Tag;
import model.Taste;
import view.MainFrame;

public class FilterButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;

	public FilterButtonAction(String name) {
		super(name);
	}

	public HashMap<Recipe, Integer> containsResult(Recipe recipe, HashMap<Recipe, Integer> searchResults) {
		if(searchResults.containsKey(recipe)) {
			searchResults.replace(recipe, searchResults.get(recipe), searchResults.get(recipe)+1);
		}
		else if(!searchResults.containsKey(recipe)) {
			searchResults.put(recipe, 1);
		}
		return searchResults;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//key je koliko je kompatibilan recept sa unesenim filterom, sto vise to bolje
		MainFrame.getInstance().getRecipesTab().setFilterClicked(true);
		HashMap<Recipe, Integer> searchResults = new HashMap<Recipe, Integer>();
		
		String cookTime = MainFrame.getInstance().getRecipesTab().getCookTimeField().getText();
		String prepTime = MainFrame.getInstance().getRecipesTab().getPrepTimeField().getText();
		
		boolean ckbx1 = MainFrame.getInstance().getRecipesTab().getCkbx1().isSelected();
		boolean ckbx2 = MainFrame.getInstance().getRecipesTab().getCkbx2().isSelected();
		boolean ckbx3 = MainFrame.getInstance().getRecipesTab().getCkbx3().isSelected();
		boolean ckbx4 = MainFrame.getInstance().getRecipesTab().getCkbx4().isSelected();
		boolean ckbx5 = MainFrame.getInstance().getRecipesTab().getCkbx5().isSelected();
		
		ArrayList<String>diffChosen  = new ArrayList<String>();
		if(ckbx1) {
			diffChosen.add("1");
		}if(ckbx2) {
			diffChosen.add("2");
		}if(ckbx3) {
			diffChosen.add("3");
		}if(ckbx4) {
			diffChosen.add("4");
		}if(ckbx5) {
			diffChosen.add("5");
		}
		
		
		IngredientsCheckBoxModel ingrModel = MainFrame.getInstance().getRecipesTab().getIngrModel();
		for (int i = 0; i < ingrModel.getRowCount(); i++) {
			if ((boolean) ingrModel.getValueAt(i, 2) && !ChosenProducts.containsProduct((Integer) ingrModel.getValueAt(i, 0))) {
				ChosenProducts.add_product((Integer) ingrModel.getValueAt(i, 0));
			}else {
				ChosenProducts.remove_product((Integer) ingrModel.getValueAt(i, 0));
			}
		}
		
		EquipmentCheckBoxModel eqModel = MainFrame.getInstance().getRecipesTab().getEqModel();
		for (int i = 0; i < eqModel.getRowCount(); i++) {
			if ((boolean) eqModel.getValueAt(i, 3)) {
				ChosenEquipment.add_product((Integer) eqModel.getValueAt(i, 0));
			}else {
				ChosenEquipment.remove_product((Integer) eqModel.getValueAt(i, 0));
			}
		}
		
		TagsCheckBoxModel tagsModel = MainFrame.getInstance().getRecipesTab().getTagsModel();
		for (int i = 0; i < tagsModel.getRowCount(); i++) {
			if ((boolean) tagsModel.getValueAt(i, 1)) {
				ChosenTags.add_product( (String) tagsModel.getValueAt(i, 0));
			}else {
				ChosenTags.remove_product((String) tagsModel.getValueAt(i, 0));
			}
		}
		
		TasteCheckBoxModel tasteModel = MainFrame.getInstance().getRecipesTab().getTasteModel();
		for (int i = 0; i < tasteModel.getRowCount(); i++) {
			if ((boolean) tasteModel.getValueAt(i, 1)) {
				ChosenTaste.add_taste( (String) tasteModel.getValueAt(i, 0));
			}else {
				ChosenTaste.remove_taste((String) tasteModel.getValueAt(i, 0));
			}
			
		}
		
		
		if(!diffChosen.isEmpty() ||
				!ChosenTaste.getChosenTaste().isEmpty() || 
				!ChosenProducts.getChosenProducts().isEmpty() || 
				!ChosenEquipment.getChosenEqs().isEmpty() ||
				!ChosenTags.getChosenTags().isEmpty() ||
				!cookTime.isEmpty() || !prepTime.isEmpty()) {	
			
			ArrayList<Recipe>all = (ArrayList<Recipe>) MainFrame.getInstance().getToiToiController().getToiToi().getRecipe();	
			
			for (Recipe recipe : all) {
				
				//ide od vecih nivoa i ako je difficulty trenutnog recepta veci od oznacenog nivoa onda preskace taj recept
				if(!diffChosen.isEmpty()) {
					
					for (int i = diffChosen.size()-1;i >=0; i--) {
						int temp = Integer.parseInt(diffChosen.get(i));
						if( recipe.getDifficulty() > temp) {							
							break;
						}
						if(recipe.getDifficulty() <= temp) {
							if(!searchResults.containsKey(recipe)) {
								searchResults.put(recipe, 1);
							}							
						}
					}
				}
				
				if(!cookTime.isEmpty() && (recipe.getCookTime() > Integer.parseInt(cookTime))) {
					continue;
				}
				
				if(!cookTime.isEmpty() &&  (recipe.getCookTime() <= Integer.parseInt(cookTime))) {
					searchResults = containsResult(recipe, searchResults);
				}
				
				if(!prepTime.isEmpty() && (recipe.getPrepTime() > Integer.parseInt(prepTime))) {
					continue;
				}
				if(!prepTime.isEmpty() &&  (recipe.getPrepTime() <= Integer.parseInt(prepTime))) {
					searchResults = containsResult(recipe, searchResults);
				}
				if(ChosenTaste.getChosenTaste()!=(null)) {
					for (String taste : ChosenTaste.getChosenTaste()) {
						boolean contains = false;
						for (Taste t : recipe.getTaste()) {
							if(t.equals(Taste.valueOf(taste))) {
								contains =true;
							}
						}
						if(!contains) {
							continue;
						}
						
						searchResults = containsResult(recipe, searchResults);
					}
				}
				
				if(ChosenTags.getChosenTags()!=(null)) {
					for (String tag : ChosenTags.getChosenTags()) {
						boolean contains = false;
						for (Tag t : recipe.getTags()) {
							if(t.getTag().equals(tag)) {
								contains =true;
							}
						}
						if(!contains) {
							continue;
						}
						searchResults = containsResult(recipe, searchResults);
					}
				}
				
				if(ChosenProducts.getChosenProducts()!=(null)) {
					for (Integer productId : ChosenProducts.getChosenProducts()) {
						if(!recipe.getProductIds().contains(productId)) {
							continue;
						}
						searchResults = containsResult(recipe, searchResults);
					}
				}
				if(ChosenEquipment.getChosenEqs()!=(null)) {
					for (Integer equipmentId : ChosenEquipment.getChosenEqs()) {
						if(!recipe.getEquipmentIds().contains(equipmentId)) {
							continue;
						}						
						searchResults = containsResult(recipe, searchResults);
						
					}
				}		
			}
			
			
			MainFrame.getInstance().getRecipesTab().setFilterResults(searchResults);
			try {
				MainFrame.getInstance().getRecipesTab().combineSearchAndFilter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			try {
				for (Recipe recipe : (ArrayList<Recipe>) MainFrame.getInstance().getToiToiController().getToiToi().getRecipe()) {
					searchResults.put(recipe, 0);				
				}
				MainFrame.getInstance().getRecipesTab().setFilterResults(searchResults);
				MainFrame.getInstance().getRecipesTab().combineSearchAndFilter();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}
