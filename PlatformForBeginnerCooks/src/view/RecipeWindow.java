package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import TableModel.MissingEquipmentTable;
import TableModel.MissingIngredientsTable;
import TableModel.RecipeEquipmentTable;
import TableModel.RecipeIngredientsTable;
import controller.AkterController;
import controller.RecipeController;
import controller.ToiToiController;
import controller.ButtonActions.BackButtonAction;
import controller.ButtonActions.CommentButtonAction;
import controller.ButtonActions.CreatorButtonAction;
import controller.ButtonActions.DeleteRecipeButtonAction;
import controller.ButtonActions.EditRecipeButtonAction;
import controller.ButtonActions.LikeButtonAction;
import model.Admin;
import model.Akter;
import model.Comment;
import model.Equipment;
import model.Moderator;
import model.NeededQuantity;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;

public class RecipeWindow {

	private ToiToiController toiToiController = null;
	private int currentTabIndex;

	public RecipeWindow(ToiToiController toiToiController) {
		super();
		this.toiToiController = toiToiController;
	}

	
	public JPanel createVisitorRecipePage(Recipe recipe, int tabIndex) throws IOException {
		setCurrentTabIndex(tabIndex);
		JPanel mainPanel = new JPanel(new MigLayout());
		JPanel centerPanel = new JPanel(new MigLayout());
		JPanel rightPanel = new JPanel(new MigLayout());
		JPanel leftPanel = new JPanel(new MigLayout());
		JPanel upperPanel = new JPanel(new MigLayout());
		JPanel bottomPanel = new JPanel(new MigLayout());		
		
		///////////////////////////BACK///////////////////////////////////
		BackButtonAction back = new BackButtonAction("Back");
		back.setCurrentTabIndex(getCurrentTabIndex());
		JButton backBttn = new JButton(back);
		backBttn.setMnemonic(KeyEvent.VK_ENTER);
		
		//////////////////////////DATE CREATOR SERVINGS DIFFICULTY///////////////////////
		ImageIcon plate=new ImageIcon("./img/plate.png"); 
		JLabel servingsLbl = new JLabel(" servings: " + recipe.getServings(), plate, JLabel.RIGHT);
		
		JLabel datelbl = new JLabel("  created " + recipe.getDateCreated().toString() + " by:");
		
		ImageIcon userIcon =new ImageIcon("./img/smalluser.png");
		JButton creatorBtn = new JButton("<HTML> <FONT color=\"#000099\">"+recipe.getCreator().getUsername()+"</FONT></HTML>", userIcon);
		CreatorButtonAction cra = new CreatorButtonAction();
		cra.setRecipeCreator(recipe.getCreator());
		cra.setCurrentTabIndex(getCurrentTabIndex());
		creatorBtn.addActionListener(cra);
		//creatorBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		creatorBtn.setToolTipText("View user");
		creatorBtn.setContentAreaFilled(false);
		creatorBtn.setBorderPainted(false);
		
		ImageIcon star=new ImageIcon("./img/star.png"); 
		JLabel diffLbl = new JLabel(" difficulty: " + recipe.getDifficulty(), star, JLabel.RIGHT);
		
		//////////////////////////LIKES/////////////////////////////////////////
	    ImageIcon like=new ImageIcon("./img/bigheart.png"); 
		JLabel likes = new JLabel(recipe.getLikes()+" Likes", like, JLabel.RIGHT);
	    
	    ///////////////////////////IMAGE//////////////////////////////////////
		BufferedImage img=ImageIO.read(new File(recipe.getImage()));
	    Image image = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon=new ImageIcon(image);        
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
            
	    //////////////////////////TITLE//////////////////////////////////////
	    JLabel l2 = new JLabel(recipe.getName());
	    l2.setFont(new Font("Serif", Font.PLAIN, 40));
	    l2.setPreferredSize(new Dimension(100,50));
	  	    
	    ////////////////////PREPTIME COOKTIME/////////////////////////////////
	    ImageIcon prepImg=new ImageIcon("./img/time.png"); 
	    int p =0;
	    if(recipe.getPrepTime() != null) {
	    	p = recipe.getPrepTime();
	    }
	    
		JLabel prepLbl = new JLabel(" Prep time: "+ p +" min", prepImg, JLabel.RIGHT);
	    
		ImageIcon cookImg=new ImageIcon("./img/time.png"); 
		int i =0;
		if(recipe.getCookTime() != null) {
			i = recipe.getCookTime();
		}
		JLabel cookLbl = new JLabel(" Cook time: "+i+" min", cookImg, JLabel.RIGHT);
	    
	    ///////////////////////////INGREDIENTS/////////////////////////////////
	    RecipeIngredientsTable model = new RecipeIngredientsTable(recipe.getNeededProductQuantity()) {
	    	private static final long serialVersionUID = 1L;
	    	
	    };
	    JTable tabel = new JTable(model);
	    tabel.setAutoCreateRowSorter(true);
	    tabel.getTableHeader().setBackground(new Color(240, 210, 255));
	    tabel.getColumn("Essential").setPreferredWidth(2);
	    tabel.getColumn("Quantity").setPreferredWidth(3);

		JScrollPane sp = new JScrollPane(tabel);
		sp.setPreferredSize(new Dimension(400, 215));
		JPanel pnl = new JPanel(new BorderLayout());
		pnl.add(sp, BorderLayout.CENTER);
		

		//////////////////////////// DESCRIPTION////////////////////////////////
		JLabel l5 = new JLabel("Instructions: ");
		JTextArea textArea = new JTextArea(recipe.getDescription());
		textArea.setEditable(false);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(500, 250));

		/////////////////////////// COMMENTS///////////////////////////////////
		JLabel comsLabel = new JLabel("Comments");
		String coms = "";
		for (Comment it : recipe.getComment()) {
			coms += "-> [" + it.getDate() + "] - " + it.getCommentator().getUsername() + ":\n";
			coms += it.getText() + "\n";
			for (Comment child : it.getChild()) {
				coms += "(Reply) --> [" + child.getDate().toString() + "] - " + child.getCommentator().getUsername()
						+ ":\n";
				coms += "	" + child.getText() + "\n";
				for (Comment granch : child.getChild()) {
					coms += "	(Reply)--> [" + granch.getDate().toString() + "] - " + granch.getCommentator().getUsername()
							+ ":\n";
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

		///////////////////////////// EQUIPMENT////////////////////////////////
		RecipeEquipmentTable eqModel = new RecipeEquipmentTable((ArrayList<Equipment>) recipe.getEquipment());
		JTable eqTable = new JTable(eqModel);
		eqTable.getTableHeader().setBackground(new Color(240, 210, 255));
		eqTable.setAutoCreateRowSorter(true);
		JScrollPane eqSp = new JScrollPane(eqTable);
		eqSp.setPreferredSize(new Dimension(400, 215));
		JPanel eqPnl = new JPanel(new BorderLayout());
		eqPnl.add(eqSp, BorderLayout.CENTER);
		
		///////////////////////////ADMIN DELETE BUTTON//////////////////////////
		
		DeleteRecipeButtonAction dlt = new DeleteRecipeButtonAction("Delete");
		dlt.setCurrentTabIndex(getCurrentTabIndex());
		dlt.setRecipeToDelete(recipe);
		JButton delete = new JButton(dlt);
		delete.setMnemonic(KeyEvent.VK_ENTER);
		

		leftPanel.add(lbl, "top,wrap");
		leftPanel.add(likes, "wrap");
		leftPanel.add(prepLbl,"wrap");
		leftPanel.add(cookLbl, "wrap");
		leftPanel.add(diffLbl, "wrap");
		leftPanel.add(servingsLbl);
		
		rightPanel.add(pnl, " wrap");
		rightPanel.add(eqPnl, " wrap");
		rightPanel.add(l5, "wrap");
		rightPanel.add(areaScrollPane);

		centerPanel.add(leftPanel, "top, right");
		centerPanel.add(rightPanel, "top");
		centerPanel.setBackground(new Color(0, 0, 0, 10));

		if(MainFrame.getInstance().getAkter() != null && MainFrame.getInstance().getAkter() instanceof Admin) {
			upperPanel.add(backBttn, "top, left, split");
			upperPanel.add(delete,"top");
		}
		else {
			upperPanel.add(backBttn, "top, left");
		}	
		upperPanel.add(l2,"skip, wrap");
		
		upperPanel.add(datelbl," split");
		upperPanel.add(creatorBtn);
		upperPanel.setBackground(new Color(240, 210, 255));

		bottomPanel.add(comsLabel, "wrap");
		bottomPanel.add(commentAreaScrollPane, "growx");

		mainPanel.add(upperPanel, "growx, wrap");
		mainPanel.add(centerPanel, "wrap");
		mainPanel.add(bottomPanel);
		//mainPanel.setBackground(new Color(150, 0, 0, 30));

		return mainPanel;
	}

	public JPanel createUserRecipePage(Recipe rec, Akter akter, int tabIndex) throws IOException {
		setCurrentTabIndex(tabIndex);
		
		JPanel mainPanel = new JPanel(new MigLayout());
		JPanel centerPanel = new JPanel(new MigLayout());
		JPanel rightPanel = new JPanel(new MigLayout());
		JPanel leftPanel = new JPanel(new MigLayout());
		JPanel upperPanel = new JPanel(new MigLayout());
		JPanel bottomPanel = new JPanel(new MigLayout());
		
		User user = (User) akter;		
		
		///////////////////////////BACK///////////////////////////////////
		BackButtonAction back = new BackButtonAction("Back");
		back.setCurrentTabIndex(getCurrentTabIndex());
		JButton backBttn = new JButton(back);
		backBttn.setMnemonic(KeyEvent.VK_ENTER);

		
		//////////////////////////DATE CREATOR Servings DIFFICULTY///////////////////////
		ImageIcon plate=new ImageIcon("./img/plate.png"); 
		JLabel servingsLbl = new JLabel(" servings: " + rec.getServings(), plate, JLabel.RIGHT);
		
		JLabel datelbl = new JLabel("  created " + rec.getDateCreated().toString() + " by");
		
		ImageIcon userIcon =new ImageIcon("./img/smalluser.png");

		JButton creatorBtn = new JButton("<HTML> <FONT color=\"#000099\">"+rec.getCreator().getUsername()+"</FONT></HTML>", userIcon);
		CreatorButtonAction cra = new CreatorButtonAction();
		cra.setRecipeCreator(rec.getCreator());
		cra.setCurrentTabIndex(getCurrentTabIndex());
		creatorBtn.addActionListener(cra);
		creatorBtn.setContentAreaFilled(false);
		creatorBtn.setBorderPainted(false);
		//creatorBtn.setFont(new Font("Serif", Font.PLAIN, 16));

		creatorBtn.setToolTipText("View user");
		
		
		ImageIcon star=new ImageIcon("./img/star.png"); 
		JLabel diffLbl = new JLabel(" difficulty: " + rec.getDifficulty(), star, JLabel.RIGHT);
				
		////////////////////PREPTIME COOKTIME/////////////////////////////////
		ImageIcon prepImg=new ImageIcon("./img/time.png"); 
		int p =0;
		if(rec.getPrepTime() != null) {
		p = rec.getPrepTime();
		}
		
		JLabel prepLbl = new JLabel(" Prep time: "+ p +" min", prepImg, JLabel.RIGHT);
		
		ImageIcon cookImg=new ImageIcon("./img/time.png"); 
		int i =0;
		if(rec.getCookTime() != null) {
		i = rec.getCookTime();
		}
		JLabel cookLbl = new JLabel(" Cook time: "+i+" min", cookImg, JLabel.RIGHT);
		
		//////////////////////////LIKES/////////////////////////////////////////
	    Image heart = new ImageIcon("./img/bigheart.png").getImage();
	    ImageIcon like=new ImageIcon(heart); 
		JLabel likes = new JLabel(rec.getLikes()+" Likes");//, like, JLabel.RIGHT

		JButton likeBtn = new JButton(like);
		likeBtn.setContentAreaFilled(false);
		likeBtn.setBorderPainted(false);
		likeBtn.setToolTipText("Like");
		LikeButtonAction likeAction = new LikeButtonAction("Like", rec, user);
		likeAction.setCurrentTabIndex(getCurrentTabIndex());
		likeBtn.addActionListener(likeAction);
		
	    
	    ///////////////////////////IMAGE//////////////////////////////////////
	    BufferedImage img=ImageIO.read(new File(rec.getImage()));
	    Image image = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon=new ImageIcon(image);        
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        JPanel panelIcon = new JPanel(new MigLayout());
        panelIcon.add(lbl, "top,wrap");
        panelIcon.add(likes);
	    
	    ///////////////////////////TITLE/////////////////////////////////////
	    JLabel l2 = new JLabel(rec.getName());
	    l2.setFont(new Font("Serif", Font.PLAIN, 40));
	    l2.setPreferredSize(new Dimension(100,50));
	  	    
	    ///////////////////////////INGREDIENTS & ALERGIES/////////////////////////////////
	    JLabel ingr = new JLabel("Ingredients:");
	    MissingIngredientsTable model = new MissingIngredientsTable(rec.getNeededProductQuantity(), user.getAvailableGroceries(), user.getAlergies());
	    
	    JTable tabel = new JTable(model);
	    tabel.getColumn("Essential").setPreferredWidth(3);
	    tabel.getColumn("Quantity").setPreferredWidth(4);
	    tabel.getColumn("In MyFridge").setPreferredWidth(3);
	    tabel.getTableHeader().setBackground(new Color(240, 210, 255));
	    tabel.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);

				// Color row based on a cell value
				String type = (String) model.getValueAt(row, column);
				if (model.isAlergie(type)) {
					c.setBackground(model.getRowColour(row));
				} else {
					c.setBackground(Color.WHITE);
				}
				return c;

			}
		});
		tabel.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(tabel);
		sp.setPreferredSize(new Dimension(400, 215));
		JPanel pnl = new JPanel(new BorderLayout());
		pnl.add(sp, BorderLayout.CENTER);
		
		////////////////////////////DESCRIPTION////////////////////////////////
		JLabel l5 = new JLabel("Instructions: ");

		JTextArea textArea = new JTextArea(rec.getDescription());
		textArea.setEditable(false);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(500, 250));

		/////////////////////////// COMMENTS///////////////////////////////////
		JLabel comsLabel = new JLabel("Comments");
		String coms = "";
		for (Comment it : rec.getComment()) {
			coms += "-> [" + it.getDate() + "] - " + it.getCommentator().getUsername() + ":\n";
			coms += it.getText() + "\n";
			for (Comment child : it.getChild()) {
				coms += "(Reply)--> [" + child.getDate().toString() + "] - " + child.getCommentator().getUsername()
						+ ":\n";
				coms += "	" + child.getText() + "\n";
				for (Comment granch : child.getChild()) {
					coms += "	(Reply)--> [" + granch.getDate().toString() + "] - " + granch.getCommentator().getUsername()
							+ ":\n";
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
	    ImageIcon comment =new ImageIcon(commImg);
		JButton commentBttn = new JButton(comment);
		commentBttn.setContentAreaFilled(false);
		commentBttn.setBorderPainted(false);
		commentBttn.setToolTipText("Add comment");
		CommentButtonAction commAct = new CommentButtonAction("Add comment");
		commAct.setRecipe(rec);
		commAct.setCurrentTabIndex(getCurrentTabIndex());
		commentBttn.addActionListener(commAct);
		
		///////////////////////////// EQUIPMENT////////////////////////////////
		MissingEquipmentTable eqModel = new MissingEquipmentTable(rec.getEquipment(), user.getEquipment());
		JTable eqTabel = new JTable(eqModel);
		eqTabel.getTableHeader().setBackground(new Color(240, 210, 255));
		eqTabel.setAutoCreateRowSorter(true);
		eqTabel.getColumn("In MyTools").setPreferredWidth(3);
		JScrollPane eqSp = new JScrollPane(eqTabel);
		eqSp.setPreferredSize(new Dimension(400, 215));
		JLabel l3 = new JLabel("Equipment: ");

		/////////////////////////// ALERGIES///////////////////////////////////
		ImageIcon alert = new ImageIcon("./img/alert.png");

		JLabel alergies = new JLabel("Allergies are marked", alert, JLabel.RIGHT);
		
		//////////////////////////EDIT///////////////////////////////////////
		JButton edit = new JButton("Edit");
		edit.setToolTipText("Edit recipe");
		EditRecipeButtonAction erba = new EditRecipeButtonAction();
		erba.setCurrentTabIndex(getCurrentTabIndex());
		erba.setRecipe(rec);
		edit.addActionListener(erba);

		rightPanel.add(ingr);
		rightPanel.add(alergies, "right, wrap");
		rightPanel.add(pnl, "span, wrap");
		rightPanel.add(l3, "span, wrap");
		rightPanel.add(eqSp, "span, wrap");
		rightPanel.add(l5, "span,wrap");
		rightPanel.add(areaScrollPane,"span");
		
		leftPanel.add(panelIcon,"top, wrap");
		leftPanel.add(likeBtn,"split");
		leftPanel.add(likes,"wrap");
		leftPanel.add(prepLbl,"wrap");
		leftPanel.add(cookLbl,"wrap");
		leftPanel.add(diffLbl, "wrap");
		leftPanel.add(servingsLbl);
		
		centerPanel.add(leftPanel,"top");
		centerPanel.add(rightPanel, "top");
		centerPanel.setBackground(new Color(0, 0, 0, 10));
		
		if(user.getUsername().equals(rec.getCreator().getUsername()) || akter instanceof Moderator) {
			upperPanel.add(backBttn, "top, left, split");
			upperPanel.add(edit,"top");
		}
		else {
			upperPanel.add(backBttn, "top, left");
		}
		upperPanel.add(l2,"skip, wrap");		
		upperPanel.add(datelbl," split");
		upperPanel.add(creatorBtn);
		upperPanel.setBackground(new Color(240, 210, 255));
		
		bottomPanel.add(comsLabel, "wrap");
		bottomPanel.add(commentAreaScrollPane, "growx");
		bottomPanel.add(commentBttn,"right");

		mainPanel.add(upperPanel, "growx, wrap");
		mainPanel.add(centerPanel, "wrap");
		mainPanel.add(bottomPanel);
		//mainPanel.setBackground(new Color(170, 0, 0, 50));

		return mainPanel;
	}


	public int getCurrentTabIndex() {
		return currentTabIndex;
	}


	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}
}
