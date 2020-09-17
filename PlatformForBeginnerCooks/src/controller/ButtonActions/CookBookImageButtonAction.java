package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import model.Admin;
import model.CookBook;
import model.Moderator;
import model.User;
import view.MainFrame;

public class CookBookImageButtonAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;
	private CookBook cookBook;
	private int tabIndex;

	public CookBookImageButtonAction() {
		super();

	}

	public void actionPerformed(ActionEvent arg0) {

		if (MainFrame.getInstance().getAkter() == null || MainFrame.getInstance().getAkter() instanceof Admin) {

			try {
				JPanel pan = MainFrame.getInstance().getCookBookWindow().createVisitorCookBookPage(getCookBook(), getTabIndex());
				MainFrame.getInstance().getTabbedPane().setComponentAt(getTabIndex(), pan);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
		else if (MainFrame.getInstance().getAkter() != null && (MainFrame.getInstance().getAkter() instanceof Moderator || MainFrame.getInstance().getAkter() instanceof User)) {
			try {
				JPanel pan = MainFrame.getInstance().getCookBookWindow().createUserCookBookPage(getCookBook(), MainFrame.getInstance().getAkter(), getTabIndex());
				MainFrame.getInstance().getTabbedPane().setComponentAt(getTabIndex(), pan);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public CookBook getCookBook() {
		return cookBook;
	}

	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

}
