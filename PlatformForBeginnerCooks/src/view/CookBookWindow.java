package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import controller.ToiToiController;
import controller.ButtonActions.BackButtonAction;
import controller.ButtonActions.CreatorButtonAction;
import controller.ButtonActions.DeleteCookBookButtonAction;
import controller.ButtonActions.RecipeImageButtonAction;
import model.Admin;
import model.Akter;
import model.Comment;
import model.Moderator;
import model.Recipe;
import model.CookBook;
import model.User;
import net.miginfocom.swing.MigLayout;

public class CookBookWindow {

	private ToiToiController toiToiController;
	private int currentTabIndex;
	private CookBook cookBook;

	public CookBookWindow(ToiToiController toiToiController) {

		this.setToiToiController(toiToiController);
	}

	public JPanel createVisitorCookBookPage(CookBook cookBook, int tabIndex) throws IOException {

		this.setCookBook(cookBook);
		setCurrentTabIndex(tabIndex);

		JPanel mainPanel = new JPanel(new MigLayout());
		JPanel centerPanel = new JPanel(new MigLayout("", "[] 10 []", ""));
		JPanel rightPanel = new JPanel(new MigLayout());
		JPanel leftPanel = new JPanel(new MigLayout());
		JPanel upperPanel = new JPanel(new MigLayout());
		JPanel bottomPanel = new JPanel(new MigLayout());

		/////////////////////////// BACK///////////////////////////////////
		BackButtonAction back = new BackButtonAction("Back");
		back.setCurrentTabIndex(getCurrentTabIndex());
		JButton backBttn = new JButton(back);
		backBttn.setMnemonic(KeyEvent.VK_ENTER);

		////////////////////////// DATE CREATOR////////////////////////////
		JLabel datelbl = new JLabel("  Created " + cookBook.getDate().toString() + " by:");

		ImageIcon userIcon = new ImageIcon("./img/smalluser.png");
		JButton creatorBtn = new JButton(
				"<HTML> <FONT color=\"#000099\">" + cookBook.getCreator().getUsername() + "</FONT></HTML>", userIcon);
		CreatorButtonAction cra = new CreatorButtonAction();
		cra.setRecipeCreator(cookBook.getCreator());
		cra.setCurrentTabIndex(getCurrentTabIndex());
		creatorBtn.addActionListener(cra);
		creatorBtn.setToolTipText("View user");
		creatorBtn.setContentAreaFilled(false);
		creatorBtn.setBorderPainted(false);



		////////////////////////// LIKES/////////////////////////////////////////
		ImageIcon like = new ImageIcon("./img/bigheart.png");
		JLabel likes = new JLabel(cookBook.getLikes() + " Likes", like, JLabel.RIGHT);

		/////////////////////////// IMAGE//////////////////////////////////////
		BufferedImage img = ImageIO.read(new File(cookBook.getImage()));
		Image image = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);

		////////////////////////// TITLE//////////////////////////////////////
		JLabel l2 = new JLabel(cookBook.getName());
		l2.setFont(new Font("Serif", Font.PLAIN, 40));
		l2.setPreferredSize(new Dimension(100, 50));

		/////////////////////////// COMMENTS///////////////////////////////////
		JLabel comsLabel = new JLabel("Comments");
		String coms = "";
		for (Comment it : cookBook.getComments()) {
			coms += "-> [" + it.getDate() + "] - " + it.getCommentator().getUsername() + ":\n";
			coms += it.getText() + "\n";
			for (Comment child : it.getChild()) {
				coms += "(Reply) --> [" + child.getDate().toString() + "] - " + child.getCommentator().getUsername()
						+ ":\n";
				coms += "	" + child.getText() + "\n";
				for (Comment granch : child.getChild()) {
					coms += "	(Reply)--> [" + granch.getDate().toString() + "] - "
							+ granch.getCommentator().getUsername() + ":\n";
					coms += "		" + granch.getText() + "\n";
				}
			}

		}
		JTextArea commentArea = new JTextArea(coms);
		commentArea.setEditable(false);
		commentArea.setFont(new Font("Serif", Font.ITALIC, 16));
		commentArea.setLineWrap(true);
		commentArea.setWrapStyleWord(true);
		JScrollPane commentAreaScrollPane = new JScrollPane(commentArea);
		commentAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		commentAreaScrollPane.setPreferredSize(new Dimension(700, 170));

		/////////////////////////// ADMIN DELETE BUTTON//////////////////////////

		DeleteCookBookButtonAction dlt = new DeleteCookBookButtonAction("Delete");
		dlt.setCurrentTabIndex(getCurrentTabIndex());
		dlt.setCookBookToDelete(cookBook);
		JButton delete = new JButton(dlt);
		delete.setMnemonic(KeyEvent.VK_ENTER);

		/////////////////////////// RECIPE SCROLL/////////////////////////////////

		JScrollPane sp = bottomPanel((ArrayList<Recipe>) this.cookBook.getRecipes());
		sp.setPreferredSize(new Dimension(420, 250));

		/////////////////////////// SET PANELS///////////////////////////////////

		leftPanel.add(lbl, "top,wrap");
		leftPanel.add(likes, "wrap");
		leftPanel.setBackground(new Color(255, 233, 248));

		rightPanel.add(sp);
		rightPanel.setBackground(new Color(255, 233, 248));

		centerPanel.add(leftPanel, "top, right");
		centerPanel.add(rightPanel, "top");
		centerPanel.setBackground(new Color(255, 233, 248));

		if (MainFrame.getInstance().getAkter() != null && MainFrame.getInstance().getAkter() instanceof Admin) {
			upperPanel.add(backBttn, "top, left, split");
			upperPanel.add(delete, "top");
		} else {
			upperPanel.add(backBttn, "top, left");
		}
		upperPanel.add(l2, "skip, wrap");

		upperPanel.add(datelbl, " split");
		upperPanel.add(creatorBtn);
		upperPanel.setBackground(new Color(200, 221, 242));

		bottomPanel.add(comsLabel, "wrap");
		bottomPanel.add(commentAreaScrollPane, "growx");
		bottomPanel.setBackground(new Color(248, 226, 255));

		mainPanel.add(upperPanel, "growx, wrap");
		mainPanel.add(centerPanel, "wrap");
		mainPanel.add(bottomPanel);

		return mainPanel;

	}

	public JPanel createUserCookBookPage(CookBook rec, Akter akter, int tabIndex) throws IOException {
		setCurrentTabIndex(tabIndex);

		JPanel mainPanel = new JPanel(new MigLayout());
		JPanel centerPanel = new JPanel(new MigLayout());
		JPanel rightPanel = new JPanel(new MigLayout());
		JPanel leftPanel = new JPanel(new MigLayout());
		JPanel upperPanel = new JPanel(new MigLayout());
		JPanel bottomPanel = new JPanel(new MigLayout());

		User user = (User) akter;

		/////////////////////////// BACK///////////////////////////////////
		BackButtonAction back = new BackButtonAction("Back");
		back.setCurrentTabIndex(getCurrentTabIndex());
		JButton backBttn = new JButton(back);
		backBttn.setMnemonic(KeyEvent.VK_ENTER);
		BackButtonAction bbc = new BackButtonAction("Back");
		bbc.setCurrentTabIndex(currentTabIndex);
		backBttn.addActionListener(bbc);

		////////////////////////// DATE CREATOR/////////////////////////////

		JLabel datelbl = new JLabel("  Created " + rec.getDate().toString() + " by");

		ImageIcon userIcon = new ImageIcon("./img/smalluser.png");

		JButton creatorBtn = new JButton(
				"<HTML> <FONT color=\"#000099\">" + rec.getCreator().getUsername() + "</FONT></HTML>", userIcon);
		

		CreatorButtonAction cra = new CreatorButtonAction();
		cra.setRecipeCreator(cookBook.getCreator());
		cra.setCurrentTabIndex(getCurrentTabIndex());
		creatorBtn.addActionListener(cra);
		creatorBtn.setContentAreaFilled(false);
		creatorBtn.setBorderPainted(false);
		creatorBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		  
		creatorBtn.setToolTipText("View user");


		////////////////////////// LIKES/////////////////////////////////////////
		Image heart = new ImageIcon("./img/bigheart.png").getImage();
		ImageIcon like = new ImageIcon(heart);
		JLabel likes = new JLabel(rec.getLikes() + " Likes");// , like, JLabel.RIGHT

		JButton likeBtn = new JButton(like);
		likeBtn.setContentAreaFilled(false);
		likeBtn.setBorderPainted(false);
		likeBtn.setToolTipText("Like");
		// TODO
		/*
		 * LikeButtonAction likeAction = new LikeButtonAction("Like", rec, user);
		 * likeAction.setCurrentTabIndex(getCurrentTabIndex());
		 * likeBtn.addActionListener(likeAction);
		 */
		/////////////////////////// IMAGE//////////////////////////////////////
		BufferedImage img = ImageIO.read(new File(rec.getImage()));
		Image image = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		JPanel panelIcon = new JPanel(new MigLayout());
		panelIcon.add(lbl, "top,wrap");
		panelIcon.add(likes);

		/////////////////////////// TITLE/////////////////////////////////////
		JLabel l2 = new JLabel("        " + rec.getName());
		l2.setFont(new Font("Serif", Font.PLAIN, 40));
		l2.setPreferredSize(new Dimension(100, 50));

		/////////////////////////// COMMENTS///////////////////////////////////
		JLabel comsLabel = new JLabel("Comments");
		String coms = "";
		for (Comment it : rec.getComments()) {
			coms += "-> [" + it.getDate() + "] - " + it.getCommentator().getUsername() + ":\n";
			coms += it.getText() + "\n";
			for (Comment child : it.getChild()) {
				coms += "(Reply)--> [" + child.getDate().toString() + "] - " + child.getCommentator().getUsername()
						+ ":\n";
				coms += "	" + child.getText() + "\n";
				for (Comment granch : child.getChild()) {
					coms += "	(Reply)--> [" + granch.getDate().toString() + "] - "
							+ granch.getCommentator().getUsername() + ":\n";
					coms += "		" + granch.getText() + "\n";
				}
			}
		}
		JTextArea commentArea = new JTextArea(coms);
		commentArea.setEditable(false);
		commentArea.setFont(new Font("Serif", Font.ITALIC, 16));
		commentArea.setLineWrap(true);
		commentArea.setWrapStyleWord(true);
		JScrollPane commentAreaScrollPane = new JScrollPane(commentArea);
		commentAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		commentAreaScrollPane.setPreferredSize(new Dimension(700, 500));

		Image commImg = new ImageIcon("./img/comment.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon comment = new ImageIcon(commImg);
		JButton commentBttn = new JButton(comment);
		commentBttn.setContentAreaFilled(false);
		commentBttn.setBorderPainted(false);
		commentBttn.setToolTipText("Add comment");

		// TODO
		/*
		 * CommentButtonAction commAct = new CommentButtonAction("Add comment");
		 * commAct.setCookBook(rec); commAct.setCurrentTabIndex(getCurrentTabIndex());
		 * commentBttn.addActionListener(commAct);
		 */

		////////////////////////// EDIT///////////////////////////////////////
		// TODO

		JButton edit = new JButton("Edit");
		edit.setToolTipText("Edit cookBook");
		/*
		 * EditCookBookButtonAction erba = new EditCookBookButtonAction();
		 * erba.setCurrentTabIndex(getCurrentTabIndex()); erba.setCookBook(rec);
		 * edit.addActionListener(erba);
		 */

		/////////////////////////// RECIPE SCROLL/////////////////////////////////

		JScrollPane sp = bottomPanel((ArrayList<Recipe>) this.cookBook.getRecipes());
		sp.setPreferredSize(new Dimension(420, 250));

		/////////////////////////// SET PANELS///////////////////////////////////

		leftPanel.add(panelIcon, "top, wrap");
		leftPanel.add(likeBtn, "split");
		leftPanel.add(likes, "wrap");
		leftPanel.setBackground(new Color(255, 233, 248));

		rightPanel.add(sp);
		rightPanel.setBackground(new Color(255, 233, 248));

		centerPanel.add(leftPanel, "top");
		centerPanel.add(rightPanel, "top");
		centerPanel.setBackground(new Color(255, 233, 248));

		if (user.getUsername().equals(rec.getCreator().getUsername()) || akter instanceof Moderator) {
			upperPanel.add(backBttn, "top, left, split");
			upperPanel.add(edit, "top");
		} else {
			upperPanel.add(backBttn, "top, left");
		}
		
		upperPanel.add(l2, "skip, wrap");

		upperPanel.add(datelbl, " split");
		upperPanel.add(creatorBtn);
		upperPanel.setBackground(new Color(200, 221, 242));

		bottomPanel.add(comsLabel, "wrap");
		bottomPanel.add(commentAreaScrollPane, "growx");
		bottomPanel.add(commentBttn, "right");
		bottomPanel.setBackground(new Color(248, 226, 255));

		mainPanel.add(upperPanel, "growx, wrap");
		mainPanel.add(centerPanel, "wrap");
		mainPanel.add(bottomPanel);

		return mainPanel;

	}

	public JScrollPane bottomPanel(ArrayList<Recipe> recipes) throws IOException {
		JPanel bottomPnl = new JPanel(new MigLayout());

		for (Recipe recipe : recipes) {

			JPanel tempPnl = new JPanel(new MigLayout());
			JPanel textPnl = new JPanel(new MigLayout());

			RecipeImageButtonAction recAction = new RecipeImageButtonAction();
			recAction.setTabIndex(1);
			recAction.setRecipe(recipe);
			Image image = new ImageIcon(recipe.getImage()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image);
			JButton imgBtn = new JButton(icon);
			imgBtn.addActionListener(recAction);
			imgBtn.setContentAreaFilled(false);
			imgBtn.setBorderPainted(false);
			imgBtn.setToolTipText("View recipe");
			imgBtn.setMnemonic(KeyEvent.VK_ENTER);

			JLabel recipeName = new JLabel(recipe.getName());
			recipeName.setFont(new Font("Serif", Font.PLAIN, 20));
			recipeName.setPreferredSize(new Dimension(50, 20));

			Image heart = new ImageIcon("./img/heart.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			ImageIcon like = new ImageIcon(heart);
			JLabel likes = new JLabel(recipe.getLikes() + " Likes", like, JLabel.RIGHT);

			JLabel datelbl = new JLabel(recipe.getDateCreated().toString());
			ImageIcon star = new ImageIcon("./img/star.png");
			JLabel diffLbl = new JLabel(" difficulty: " + recipe.getDifficulty(), star, JLabel.RIGHT);

			textPnl.add(datelbl, "left, wrap");
			textPnl.add(recipeName, "wrap");

			JPanel p = new JPanel();
			p.add(likes);
			p.add(diffLbl);
			p.setBackground(new Color(248, 226, 255));

			textPnl.setBackground(new Color(248, 226, 255));
			textPnl.add(p);

			tempPnl.add(imgBtn, "split");
			tempPnl.add(textPnl, "wrap");
			tempPnl.setBackground(new Color(248, 226, 255));
			tempPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			tempPnl.setPreferredSize(new Dimension(380, 100));

			bottomPnl.add(tempPnl, "wrap");

		}

		JScrollPane scrollPane = new JScrollPane(bottomPnl);
		scrollPane.setPreferredSize(new Dimension(600, 600));

		return scrollPane;
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public ToiToiController getToiToiController() {
		return toiToiController;
	}

	public void setToiToiController(ToiToiController toiToiController) {
		this.toiToiController = toiToiController;
	}

	public CookBook getCookBook() {
		return cookBook;
	}

	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}
}
