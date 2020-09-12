package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.MainFrame;

public class BackButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;

	public BackButtonAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getTabbedPane().setComponentAt(1,  
				MainFrame.getInstance().getRecipesTab().getMainRecipeTab());
	}
}
