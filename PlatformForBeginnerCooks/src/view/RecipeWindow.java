package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import TableModel.RecipeIngredientsTable;
import controller.RecipeController;
import model.Comment;
import model.Equipment;
import model.Recipe;
import net.miginfocom.swing.MigLayout;

public class RecipeWindow {
	
	public RecipeWindow() {
		super();
	}

	public JPanel createRecipePage(Integer recipeID) throws IOException {
		JPanel mainPanel = new JPanel(new MigLayout());
		JPanel centerPanel = new JPanel(new MigLayout());
		JPanel rightPanel = new JPanel(new MigLayout());
		JPanel upperPanel = new JPanel(new MigLayout());
		JPanel bottomPanel = new JPanel(new MigLayout());
		
		RecipeController rc = new RecipeController();
		
		HashMap<Integer, Recipe> recipes = rc.getHashMapRecipe();
	    Recipe rec = recipes.get(recipeID);
		
		//////////////////////////LIKES/////////////////////////////////////////
	    ImageIcon like=new ImageIcon("./img/heart.png"); 
		JLabel likes = new JLabel(rec.getLikes()+" Likes", like, JLabel.RIGHT);
	    
	    ///////////////////////////IMAGE//////////////////////////////////////
	    BufferedImage img=ImageIO.read(new File(rec.getImage()));
        ImageIcon icon=new ImageIcon(img);        
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        JPanel panelIcon = new JPanel(new MigLayout());
        panelIcon.add(lbl, "top,wrap");
        panelIcon.add(likes);
	    
	    
	    JLabel l2 = new JLabel(rec.getName());
	    l2.setFont(new Font("Serif", Font.PLAIN, 40));
	    l2.setPreferredSize(new Dimension(100,50));
	  	    
	    ///////////////////////////INGREDIENTS/////////////////////////////////
	    String[][] data = {{"orange","black","blue"}};
	      String[] columnNames = {"Col1","Col2","Col3"};
	    RecipeIngredientsTable model = new RecipeIngredientsTable(rec.getNeededProductQuantity()) {
	    	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	    };
	    JTable tabel = new JTable(data, columnNames);
	    tabel.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(tabel);
		JPanel pnl = new JPanel(new BorderLayout());
		pnl.add(sp, BorderLayout.CENTER);
		
		////////////////////////////DESCRIPTION////////////////////////////////
		JLabel l5 = new JLabel("Description: ");
		JTextArea textArea = new JTextArea(rec.getDescription());
		textArea.setEditable(false);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(500, 250));
	    
		///////////////////////////COMMENTS///////////////////////////////////
		JLabel comsLabel = new JLabel("Comments");
		String coms = "";
		for (Comment it : rec.getComment()) {
			coms+= "-> [" + it.getDate() +"] - "+ it.getCommentator().getUsername()+":\n";
			coms+= it.getText() +"\n";
			for (Comment child : it.getChild()) {
				coms+= "  (Reply) --> [" +child.getDate().toString() +"] - "+ child.getCommentator().getUsername()+":\n";
				coms+= "	"+child.getText() +"\n";
			}
			coms+="\n";
		}
		JTextArea commentArea = new JTextArea(coms);
		commentArea.setEditable(false);
		commentArea.setFont(new Font("Serif", Font.ITALIC, 16));
		commentArea.setLineWrap(true);
		commentArea.setWrapStyleWord(true);
		JScrollPane commentAreaScrollPane = new JScrollPane(commentArea);
		commentAreaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		commentAreaScrollPane.setPreferredSize(new Dimension(700, 500));
		
		/////////////////////////////EQUIPMENT////////////////////////////////
		String eq="";
		for (Equipment it : rec.getEquipment()) {
			eq+=it.getName()+", ";
			
		}
		eq = eq.substring(0, eq.length()-2);
		JLabel l3 = new JLabel("Equipment: ");
		JLabel l4 = new JLabel(eq);
		
				
		rightPanel.add(pnl, " wrap");
		rightPanel.add(l3, " split");
		rightPanel.add(l4, " wrap");
		rightPanel.add(l5, "wrap");
		rightPanel.add(areaScrollPane);
		
		centerPanel.add(panelIcon,"top, right");
		centerPanel.add(rightPanel, "top");
		
		upperPanel.add(l2, " right");
		
		bottomPanel.add(comsLabel, "wrap");
		bottomPanel.add(commentAreaScrollPane, "growx");
		
		mainPanel.add(upperPanel, "center, wrap");
		mainPanel.add(centerPanel, "wrap");
		mainPanel.add(bottomPanel);
		
              
		return mainPanel;
	}
}
