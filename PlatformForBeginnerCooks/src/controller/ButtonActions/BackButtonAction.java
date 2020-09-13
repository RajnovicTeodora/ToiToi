package controller.ButtonActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import view.MainFrame;

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
			JPanel pan = MainFrame.getInstance().getRecipesTab().getMainRecipeTab();
			MainFrame.getInstance().getTabbedPane().setComponentAt(1, pan);
		}
		else if(getCurrentTabIndex() == 0) {
			JPanel pan = MainFrame.getInstance().getHomePanel();
			MainFrame.getInstance().getTabbedPane().setComponentAt(0, pan);
		}
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}
}
