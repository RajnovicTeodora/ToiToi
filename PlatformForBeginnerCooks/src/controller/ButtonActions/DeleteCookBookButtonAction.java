package controller.ButtonActions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.CookBook;
import model.User;
import view.MainFrame;
import view.HomePanel.HomePanel;

public class DeleteCookBookButtonAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	
	private int currentTabIndex;
	
	private CookBook cookBookToDelete;

	public DeleteCookBookButtonAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent arg0) {
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete?", "Delete cookBook", JOptionPane.YES_NO_OPTION);
		if (choice ==JOptionPane.YES_OPTION) {
			if(getCurrentTabIndex() == 1) {
								
				User u = getCookBookToDelete().getCreator();
				u.deleteCookBook(getCookBookToDelete().getName());
								
				MainFrame.getInstance().getToiToiController().getToiToi().removeCookBooks(getCookBookToDelete());
				MainFrame.getInstance().getToiToiController().getToiToi().replaceUser( u);
				
				
				///////////////////////UPDATE HOME TAB/////////////////////////////////////////
				updateHomeTab();
				
				//////////////////////UPDATE COOK BOOK TAB////////////////////////////////////
				//updateCookBooksTab();
			}
			else if(getCurrentTabIndex() == 0) {
				User u = getCookBookToDelete().getCreator();
				u.deleteCookBook(getCookBookToDelete().getName());
				
				MainFrame.getInstance().getToiToiController().getToiToi().replaceUser(u);
				MainFrame.getInstance().getToiToiController().getToiToi().removeCookBooks(getCookBookToDelete());
				
				//////////////////////UPDATE COOK BOOK TAB////////////////////////////////////
				//updateCookBooksTab();
				
				///////////////////////UPDATE HOME TAB/////////////////////////////////////////
				updateHomeTab();
			}
		}
	}
	
	public void updateHomeTab() {
		JPanel panl = new HomePanel(MainFrame.getInstance().getToiToiController());
		panl.setBackground(new Color(200, 221, 242));
		MainFrame.getInstance().setHomePanel(panl);
		MainFrame.getInstance().getTabbedPane().setComponentAt(0, panl);
	}
	
	/*
	public void updateCookBooksTab() {
		ArrayList<CookBook>curr = MainFrame.getInstance().getCookBooks.getCurrentCookBooks();
		curr = MainFrame.getInstance().getToiToiController().getToiToi().updateMyCookBooks(curr);
		MainFrame.getInstance().getCookBooksTab().setCurrentCookBooks(curr);
		
		JPanel pan = new JPanel();
		try {
			MainFrame.getInstance().getCookBooksTab().setBottomPnl(curr);
			pan = MainFrame.getInstance().getCookBooksTab().createMainPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance().getCookBooksTab().setMainCookBookTab(pan);
		MainFrame.getInstance().getTabbedPane().setComponentAt(1, pan);
	}*/

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public CookBook getCookBookToDelete() {
		return cookBookToDelete;
	}

	public void setCookBookToDelete(CookBook cookBookToDelete) {
		this.cookBookToDelete = cookBookToDelete;
	}
	
	
	
}
