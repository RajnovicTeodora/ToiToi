package controller.ButtonActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Recipe;
import view.CommentWindow;
import view.MainFrame;

public class CommentButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	
	private Recipe recipe;
	
	private int currentTabIndex;

	public CommentButtonAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (!(MainFrame.getInstance().getCommentWindow() == null))
			MainFrame.getInstance().getCommentWindow().dispose();
		
		CommentWindow cw = new CommentWindow();
		cw.setRecipe(getRecipe());	
		cw.setCurrentTabIndex(getCurrentTabIndex());
		cw.run();
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
