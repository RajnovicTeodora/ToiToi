package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import TableModel.EquipmentCheckBoxModel;
import TableModel.IngredientsCheckBoxModel;
import TableModel.TagsCheckBoxModel;
import TableModel.TasteCheckBoxModel;
import controller.ToiToiController;
import model.Product;
import model.Recipe;
import model.Taste;
import net.miginfocom.swing.MigLayout;

public class RecipesTab {
	
	private ToiToiController toiToiController = null;

	public RecipesTab(ToiToiController toiToiController) {
		super();
		this.toiToiController = toiToiController;
	}

	public JPanel leftPanel() throws IOException {
		JPanel leftPanel = new JPanel(new MigLayout());
		
		JButton filterBttn = new JButton("Filter");
		JLabel containsLbl = new JLabel("Contains:");
		JLabel tasteLbl = new JLabel("Taste:");
		JLabel tagsLbl = new JLabel("Tags:");
		JLabel equipLbl = new JLabel("Equipment:");
		JLabel preplbl = new JLabel("Prep time(max):");
		JLabel cookTimeLbl = new JLabel("Cook time(max):");
		JLabel minutes1 = new JLabel("minutes");
		JLabel diffcLbl = new JLabel("Difficulty:");
		JLabel minutes2 = new JLabel("minutes");
		
		ArrayList<Product> ps = toiToiController.getProductController().readProducts();
		IngredientsCheckBoxModel ingrModel = new IngredientsCheckBoxModel(ps);
		JTable ingrTable = new JTable(ingrModel);
		ingrTable.setAutoCreateRowSorter(true);
        JScrollPane ingrScrollPane = new JScrollPane(ingrTable);
        ingrScrollPane.setPreferredSize(new Dimension(210,200));
        
        List<Taste> tasteList = Arrays.asList(Taste.values());
        TasteCheckBoxModel tasteModel = new TasteCheckBoxModel(tasteList);
        JTable tasteTable = new JTable(tasteModel);
        tasteTable.setAutoCreateRowSorter(true);
		JScrollPane tasteScrollPane = new JScrollPane(tasteTable);
		tasteScrollPane.setPreferredSize(new Dimension(210,200));
		
		TagsCheckBoxModel tagsModel = new TagsCheckBoxModel(toiToiController.getTagController().readTags());
		JTable tagsTable = new JTable(tagsModel);
		tagsTable.setAutoCreateRowSorter(true);
        JScrollPane tagsScrollPane = new JScrollPane(tagsTable);
        tagsScrollPane.setPreferredSize(new Dimension(210,200));
		
		EquipmentCheckBoxModel eqModel = new EquipmentCheckBoxModel(toiToiController.getEquipmentController().readEquipment());
		JTable eqTable = new JTable(eqModel);
		eqTable.setAutoCreateRowSorter(true);
        JScrollPane eqScrollPane = new JScrollPane(eqTable);
        eqScrollPane.setPreferredSize(new Dimension(210,200));
        
        JTextField prepTimeField = new JTextField(10);
        //prepTimeField.setSize(new Dimension(20,20));
        
        JTextField cookTimeField = new JTextField(10);
        //cookTimeField.setSize(new Dimension(20,20));
        
        JCheckBox ckbx1 =new JCheckBox("1");
		JCheckBox ckbx2 =new JCheckBox("2");
		JCheckBox ckbx3 =new JCheckBox("3");
		JCheckBox ckbx4 =new JCheckBox("4");
		JCheckBox ckbx5 =new JCheckBox("5");
				
		JPanel levels = new JPanel(new FlowLayout());
		levels.add(ckbx1);
		levels.add(ckbx2);
		levels.add(ckbx3);
		levels.add(ckbx4);
		levels.add(ckbx5);
		
		leftPanel.add(filterBttn,"growx, wrap");
		leftPanel.add(containsLbl,"wrap");
		leftPanel.add(ingrScrollPane,"wrap");
		leftPanel.add(tasteLbl,"wrap");
		leftPanel.add(tasteScrollPane,"wrap");
		leftPanel.add(tagsLbl,"wrap");
		leftPanel.add(tagsScrollPane,"wrap");
		leftPanel.add(equipLbl,"wrap");
		leftPanel.add(eqScrollPane,"wrap");
		leftPanel.add(preplbl,"wrap");
		leftPanel.add(prepTimeField,"split");
		leftPanel.add(minutes1,"wrap");
		leftPanel.add(cookTimeLbl,"wrap");
		leftPanel.add(cookTimeField,"split");
		leftPanel.add(minutes2,"wrap");
		leftPanel.add(diffcLbl,"wrap");
		leftPanel.add(levels);
		
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		leftPanel.setBackground(new Color(170, 0, 0, 50));
		//panel.setBorder(LineBorder.createBlackLineBorder());
		return leftPanel;
	}
	
	public JPanel topPanel() {
		JPanel topPanel = new JPanel(new MigLayout());
		
		JLabel titleLbl = new JLabel("Search term:");
		JLabel orderByLbl = new JLabel("Order by:");
		
		Font f = new Font("Serif", Font.PLAIN, 20);
		Dimension d = new Dimension(150, 40);
		titleLbl.setFont(f);
		titleLbl.setPreferredSize(d);
		
		String[] cats = {"latest", "oldest", "likes", null};
		JComboBox orderByCombBox = new JComboBox(cats);
		orderByCombBox.setSelectedIndex(3);
		
		JTextField searchTxtField = new JTextField(300);
		JButton searchBttn = new JButton("Search");
		
		
		topPanel.add(titleLbl,"top");
		topPanel.add(orderByLbl, "top, split");;
		topPanel.add(orderByCombBox, "right, wrap");
		topPanel.add(searchTxtField, "growx");
		topPanel.add(searchBttn,"growx, right");
		
		topPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		topPanel.setBackground(new Color(150, 0, 0, 30));
		
		return topPanel;
	}
	
	public JScrollPane bottomPanel(ArrayList<Recipe>recipes) throws IOException {
		JPanel bottomPnl = new JPanel(new MigLayout());
		
		for (Recipe recipe : recipes) {
			JPanel tempPnl = new JPanel(new MigLayout());
			JPanel textPnl = new JPanel(new MigLayout());
			
			BufferedImage img=ImageIO.read(new File(recipe.getImage()));
		    Image image = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        ImageIcon icon=new ImageIcon(image);        
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        
	        JLabel recipeName = new JLabel(recipe.getName());
	        recipeName.setFont(new Font("Serif", Font.PLAIN, 40));
	        recipeName.setPreferredSize(new Dimension(50,20));
	        
	        Image heart = new ImageIcon("./img/heart.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		    ImageIcon like=new ImageIcon(heart); 
			JLabel likes = new JLabel(recipe.getLikes()+" Likes", like, JLabel.RIGHT);
			
			JLabel datelbl = new JLabel(recipe.getDateCreated().toString());
			
			textPnl.add(recipeName,"wrap");
			textPnl.add(likes);
			textPnl.add(datelbl,"right");
			
			tempPnl.add(lbl,"split");
			tempPnl.add(textPnl,"wrap");
			tempPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			
			bottomPnl.add(tempPnl,"wrap");
	        
		}
		
		bottomPnl.setBackground(new Color(0, 0, 0, 10));//new Color(10, 0, 0, 20)
		JScrollPane scrollPane = new JScrollPane(bottomPnl );
		scrollPane.setPreferredSize(new Dimension(600,600));
		return scrollPane;
	}
	
	public JPanel createMainPanel() throws IOException {
		JPanel mainPnl= new JPanel(new MigLayout());
		JPanel top = topPanel();
		JScrollPane scrollPane = bottomPanel(toiToiController.getRecipeController().readRecipes());
		JPanel right = new JPanel(new MigLayout());
		JPanel left = leftPanel();
		
		right.add(top,"wrap");
		right.add(scrollPane);
		
		mainPnl.add(left);
		mainPnl.add(right);
		mainPnl.setBackground(Color.white);
		
		return mainPnl;
	}
	
}
