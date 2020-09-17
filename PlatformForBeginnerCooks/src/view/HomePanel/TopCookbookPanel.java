package view.HomePanel;

import java.awt.Color;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ButtonActions.CookBookImageButtonAction;
import model.CookBook;
import net.miginfocom.swing.MigLayout;


public class TopCookbookPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<CookBook> sortedCookBooks;

	protected JButton top1;
	private CookBook cookBook1 = null;
	private JLabel name1;
	private JLabel user1;
	private JLabel like1;

	protected JButton top2;
	private CookBook cookBook2 = null;
	private JLabel name2;
	private JLabel user2;
	private JLabel like2;

	protected JButton top3;
	private JLabel name3;
	private CookBook cookBook3 = null;
	private JLabel user3;
	private JLabel like3;

	public TopCookbookPanel(ArrayList<CookBook> cookBooks) {
		this.setSortedCookBooks(cookBooks);
		this.setBackground(new Color(248, 226, 255));
		this.setLayout(new MigLayout("", "10 [] 10 [] 10 []", "[] 20 []"));

		ImageIcon like = new ImageIcon("./img/heart.png");

		Image dimg = new ImageIcon("img/cancel-2.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg);

		JPanel title = new JPanel();
		JLabel l1 = new JLabel("ToiToi CookBook leadership!");
		title.add(l1);
		title.setBackground(new Color(248, 226, 255));
		add(title, "wrap");

		JPanel cookBooksPanel = new JPanel(new MigLayout());
		cookBooksPanel.setBackground(new Color(248, 226, 255));

		JPanel panel1 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel1.setBackground(new Color(248, 226, 255));
		if (cookBooks.size() >= 1) {
			cookBook1 = cookBooks.get(0);

			Image img1 = new ImageIcon(cookBook1.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon1 = new ImageIcon(img1);
			top1 = new JButton(addIcon1);
			name1 = new JLabel(cookBook1.getName());
			user1 = new JLabel("By " + cookBook1.getCreator().getUsername());
			like1 = new JLabel(cookBook1.getLikes() + " Likes", like, JLabel.RIGHT);
		} else {
			top1 = new JButton(addIcon);
			name1 = new JLabel("None");
			user1 = new JLabel("None");
			like1 = new JLabel("0" + " Likes", like, JLabel.RIGHT);
		}
		top1.setContentAreaFilled(false);

		top1.setToolTipText("Go to cookBook");

		if (cookBook1 != null) {
			CookBookImageButtonAction cbAction1 = new CookBookImageButtonAction();
			cbAction1.setTabIndex(2);
			cbAction1.setCookBook(cookBook1);
			top1.setMnemonic(KeyEvent.VK_ENTER);
			top1.addActionListener(cbAction1);
		}

		panel1.add(top1, "wrap");
		panel1.add(name1, "wrap");
		panel1.add(user1, "wrap");
		panel1.add(like1);

		JPanel panel2 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel2.setBackground(new Color(248, 226, 255));
		if (cookBooks.size() >= 2) {
			cookBook2 = cookBooks.get(1);

			Image img2 = new ImageIcon(cookBook2.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon2 = new ImageIcon(img2);
			top2 = new JButton(addIcon2);
			name2 = new JLabel(cookBook2.getName());
			user2 = new JLabel("By " + cookBook2.getCreator().getUsername());
			like2 = new JLabel(cookBook2.getLikes() + " Likes", like, JLabel.RIGHT);
		} else {
			top2 = new JButton(addIcon);
			name2 = new JLabel("None");
			user2 = new JLabel("None");
			like2 = new JLabel("0" + " Likes", like, JLabel.RIGHT);
		}

		top2.setContentAreaFilled(false);
		top2.setToolTipText("Go to cookBook");

		if (cookBook2 != null) {
			CookBookImageButtonAction cbAction2 = new CookBookImageButtonAction();
			cbAction2.setTabIndex(2);
			cbAction2.setCookBook(cookBook2);
			top2.setMnemonic(KeyEvent.VK_ENTER);
			top2.addActionListener(cbAction2);
		}

		panel2.add(top2, "wrap");
		panel2.add(name2, "wrap");
		panel2.add(user2, "wrap");
		panel2.add(like2);

		JPanel panel3 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel3.setBackground(new Color(248, 226, 255));
		if (cookBooks.size() >= 3) {
			cookBook3 = cookBooks.get(2);

			Image img3 = new ImageIcon(cookBook3.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon3 = new ImageIcon(img3);
			top3 = new JButton(addIcon3);
			name3 = new JLabel(cookBook3.getName());
			user3 = new JLabel("By " + cookBook3.getCreator().getUsername());
			like3 = new JLabel(cookBook3.getLikes() + " Likes", like, JLabel.RIGHT);
		} else {
			top3 = new JButton(addIcon);
			name3 = new JLabel("None");
			user3 = new JLabel("None");
			like3 = new JLabel("0" + " Likes", like, JLabel.RIGHT);
		}

		top3.setContentAreaFilled(false);

		top3.setToolTipText("Go to cookBook");

		if (cookBook3 != null) {
			CookBookImageButtonAction cbAction3 = new CookBookImageButtonAction();
			cbAction3.setTabIndex(2);
			cbAction3.setCookBook(cookBook3);
			top3.setMnemonic(KeyEvent.VK_ENTER);
			top3.addActionListener(cbAction3);
		}

		panel3.add(top3, "wrap");
		panel3.add(name3, "wrap");
		panel3.add(user3, "wrap");
		panel3.add(like3);

		cookBooksPanel.add(panel1);
		cookBooksPanel.add(panel2);
		cookBooksPanel.add(panel3);

		add(cookBooksPanel);

	}

	public ArrayList<CookBook> getSortedCookBooks() {
		return sortedCookBooks;
	}

	public void setSortedCookBooks(ArrayList<CookBook> sortedCookBooks) {
		this.sortedCookBooks = sortedCookBooks;
	}

	public CookBook getCookBook1() {
		return cookBook1;
	}

	public void setCookBook1(CookBook cookBook1) {
		this.cookBook1 = cookBook1;
	}

	public CookBook getCookBook2() {
		return cookBook2;
	}

	public void setCookBook2(CookBook cookBook2) {
		this.cookBook2 = cookBook2;
	}

	public CookBook getCookBook3() {
		return cookBook3;
	}

	public void setCookBook3(CookBook cookBook3) {
		this.cookBook3 = cookBook3;
	}

}
