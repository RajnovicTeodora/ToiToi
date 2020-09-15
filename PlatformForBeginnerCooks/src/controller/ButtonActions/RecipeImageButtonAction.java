package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import model.Admin;
import model.Moderator;
import model.Recipe;
import model.User;
import view.MainFrame;

public class RecipeImageButtonAction  extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	private Recipe recipe;
	private int tabIndex;

	public RecipeImageButtonAction() {
		super();
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(MainFrame.getInstance().getAkter() == null || MainFrame.getInstance().getAkter() instanceof Admin) {
			 
				
				try {
					JPanel pan = MainFrame.getInstance().getRecipeWindow().createVisitorRecipePage(getRecipe(), getTabIndex());
					MainFrame.getInstance().getTabbedPane().setComponentAt(getTabIndex(), pan);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if(MainFrame.getInstance().getAkter() != null && (MainFrame.getInstance().getAkter() instanceof Moderator ||
				MainFrame.getInstance().getAkter() instanceof User)){
			try {
				JPanel pan = MainFrame.getInstance().getRecipeWindow().createUserRecipePage(getRecipe(), MainFrame.getInstance().getAkter(), getTabIndex());
				MainFrame.getInstance().getTabbedPane().setComponentAt(getTabIndex(), pan);
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

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	
	
	
}
