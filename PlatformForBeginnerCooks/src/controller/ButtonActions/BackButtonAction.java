package controller.ButtonActions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import model.Recipe;
import view.MainFrame;
import view.HomePanel.HomePanel;

public class BackButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	
	private int currentTabIndex;

	public BackButtonAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(getCurrentTabIndex() == 1) {
			//updating recipe tab if changes occurred
			updateHomeTab();
			updateRecipesTab();
		}
		else if(getCurrentTabIndex() == 0) {
			updateRecipesTab();
			updateHomeTab();
		}
	}

	public void updateHomeTab() {
		JPanel panl = new HomePanel(MainFrame.getInstance().getToiToiController());
		panl.setBackground(new Color(200, 221, 242));
		MainFrame.getInstance().setHomePanel(panl);
		MainFrame.getInstance().getTabbedPane().setComponentAt(0, panl);
	}
	
	public void updateRecipesTab() {
		ArrayList<Recipe>curr = MainFrame.getInstance().getRecipesTab().getCurrentRecipes();
		curr = MainFrame.getInstance().getToiToiController().getToiToi().updateMyRecipes(curr);
		MainFrame.getInstance().getRecipesTab().setCurrentRecipes(curr);
		
		JPanel pan = new JPanel();
		try {
			MainFrame.getInstance().getRecipesTab().setBottomPnl(curr);
			pan = MainFrame.getInstance().getRecipesTab().createMainPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance().getRecipesTab().setMainRecipeTab(pan);
		MainFrame.getInstance().getTabbedPane().setComponentAt(1, pan);
	}
	
	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}
}
