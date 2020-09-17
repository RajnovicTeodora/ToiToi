package controller.ButtonActions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import model.Recipe;
import view.MainFrame;
import view.CookBookPanel.CookBookPanel;
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
		else if(getCurrentTabIndex() == 2) {
			//updating recipe tab if changes occurred
			updateHomeTab();
			try {
				updateCookBookTab();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(getCurrentTabIndex() == 0) {
			updateRecipesTab();
			updateHomeTab();
		}
		else if(getCurrentTabIndex() == 3) {
			updateRecipesTab();
			updateHomeTab();
			if(MainFrame.getInstance().getAkter() != null) {
				JPanel panl=new JPanel();
				try {
					panl = MainFrame.pw.createMyProfilePage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MainFrame.getInstance().getTabbedPane().setComponentAt(3, panl);
			}else {
				JPanel panl=new JPanel();
				try {
					panl = MainFrame.getInstance().getProfileForVisitor().createOtherUserProfilePage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MainFrame.getInstance().getTabbedPane().setComponentAt(3, panl);
			}
		}else if(getCurrentTabIndex() == 4) {
			updateRecipesTab();
			updateHomeTab();
			JPanel panl=new JPanel();
			try {
				panl = MainFrame.getInstance().getProfileForVisitor().createOtherUserProfilePage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MainFrame.getInstance().getTabbedPane().setComponentAt(4, panl);
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
	
	public void updateCookBookTab() throws IOException {
		JPanel panl = CookBookPanel.createCookBookPanel(MainFrame.toiToiController.getCbController().sortByLikes(MainFrame.toiToiController.getToiToi().getCookBooks()));
		MainFrame.getInstance().setHomePanel(panl);
		MainFrame.getInstance().getTabbedPane().setComponentAt(2, panl);
		
	}
	
	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}
}
