package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import view.MainFrame;

public class CreatorButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	
	private String username;

	public CreatorButtonAction(String username) {
		super(username);
		this.username = username;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(MainFrame.getInstance().getAkter() == null) {
			
			JPanel pan = new JPanel();
			///////////////napravi odgovarajuci panel i iskoristi ovo dole da se prikaze u Recipes/////////////////////
			MainFrame.getInstance().getTabbedPane().setComponentAt(1, pan);
			
		}
		else if(MainFrame.getInstance().getAkter().getUsername() == username) {
			//TODO
		}
		
	}

}
