package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

import TableModel.EquipmentCheckBoxModel;
import TableModel.IngredientsCheckBoxModel;
import TableModel.TagsCheckBoxModel;
import TableModel.TasteCheckBoxModel;
import controller.ToiToiController;
import controller.ButtonActions.FilterButtonAction;
import controller.ButtonActions.OrderBy;
import controller.ButtonActions.RecipeImageButtonAction;
import controller.ButtonActions.SearchRecipesButtonAction;
import model.Product;
import model.Recipe;
import model.Taste;
import net.miginfocom.swing.MigLayout;

public class RecipesTab {
	
	//key je koliko je kompatibilan recept sa unesenim filterom, sto vise to bolje
	private	HashMap<Recipe, Integer> filterResults = new HashMap<Recipe, Integer>();
	private HashMap<Recipe, Integer> searchResults = new HashMap<Recipe, Integer>();
	private boolean filterClicked = false, searchClicked = false;
	private JTextField searchTxtField;
	private JTextField prepTimeField;
	private JTextField cookTimeField;
	private JCheckBox ckbx1, ckbx2, ckbx3, ckbx4, ckbx5;
	private boolean ck1, ck2, ck3, ck4, ck5;
	private IngredientsCheckBoxModel ingrModel;
	private TasteCheckBoxModel tasteModel;
	private EquipmentCheckBoxModel eqModel;
	private TagsCheckBoxModel tagsModel;
	private JComboBox orderByCombBox;
	private int selectedOrder=5 ;
	private String searchTerm="", placedPrepTime = "", placedCookTime="";
	
	private RecipeWindow recipeWindow;
	
	private ToiToiController toiToiController = null;
	
	private JScrollPane bottomPnl;
	
	private JPanel mainRecipeTab;

	public RecipesTab(ToiToiController toiToiController) {
		super();
		this.toiToiController = toiToiController;
		
	}
	
	

	public JPanel leftPanel() throws IOException {
		JPanel leftPanel = new JPanel(new MigLayout());
		
		JButton filterBttn = new JButton(new FilterButtonAction("Filter"));
		filterBttn.setMnemonic(KeyEvent.VK_ENTER);
		//MainFrame.getInstance().getRecipesTab()
		
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
		ingrModel = new IngredientsCheckBoxModel(ps);
		JTable ingrTable = new JTable(ingrModel);
		ingrTable.setAutoCreateRowSorter(true);
        JScrollPane ingrScrollPane = new JScrollPane(ingrTable);
        ingrScrollPane.setPreferredSize(new Dimension(210,200));
        
        List<Taste> tasteList = Arrays.asList(Taste.values());
        tasteModel = new TasteCheckBoxModel(tasteList);
        JTable tasteTable = new JTable(tasteModel);
        tasteTable.setAutoCreateRowSorter(true);
		JScrollPane tasteScrollPane = new JScrollPane(tasteTable);
		tasteScrollPane.setPreferredSize(new Dimension(210,200));
		
		tagsModel = new TagsCheckBoxModel(toiToiController.getTagController().readTags());
		JTable tagsTable = new JTable(tagsModel);
		tagsTable.setAutoCreateRowSorter(true);
        JScrollPane tagsScrollPane = new JScrollPane(tagsTable);
        tagsScrollPane.setPreferredSize(new Dimension(210,200));
		
		eqModel = new EquipmentCheckBoxModel(toiToiController.getEquipmentController().readEquipment());
		JTable eqTable = new JTable(eqModel);
		eqTable.setAutoCreateRowSorter(true);
        JScrollPane eqScrollPane = new JScrollPane(eqTable);
        eqScrollPane.setPreferredSize(new Dimension(210,200));
        
        prepTimeField = new JTextField(getPlacedPrepTime(), 10);
        //prepTimeField.setSize(new Dimension(20,20));
        
        cookTimeField = new JTextField(getPlacedCookTime(), 10);
        //cookTimeField.setSize(new Dimension(20,20));
        
        ckbx1 =new JCheckBox("1");
		ckbx2 =new JCheckBox("2");
		ckbx3 =new JCheckBox("3");
		ckbx4 =new JCheckBox("4");
		ckbx5 =new JCheckBox("5");
		
		ckbx1.setSelected(ck1);
		ckbx2.setSelected(ck2);
		ckbx3.setSelected(ck3);
		ckbx4.setSelected(ck4);
		ckbx5.setSelected(ck5);
		
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
		
		String[] cats = {"latest", "oldest", "likes", "easiest", "hardest", null};
		orderByCombBox = new JComboBox(cats);
		orderByCombBox.setSelectedIndex(getSelectedOrder());
		
		searchTxtField = new JTextField(getSearchTerm(), 300);
		JButton searchBttn = new JButton("Search");
		searchBttn.setMnemonic(KeyEvent.VK_ENTER);
		searchBttn.addActionListener(new SearchRecipesButtonAction("Search"));
		
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
			
			RecipeImageButtonAction recAction = new RecipeImageButtonAction();
			recAction.setTabIndex(1);
			recAction.setRecipe(recipe);
		    Image image = new ImageIcon(recipe.getImage()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        ImageIcon icon=new ImageIcon(image); 
	        JButton imgBtn = new JButton(icon);
	        imgBtn.addActionListener(recAction);
	        imgBtn.setContentAreaFilled(false);
	        imgBtn.setBorderPainted(false);
	        imgBtn.setToolTipText("View recipe");
	        imgBtn.setMnemonic(KeyEvent.VK_ENTER);
	        	        
	        JLabel recipeName = new JLabel(recipe.getName());
	        recipeName.setFont(new Font("Serif", Font.PLAIN, 20));
	        recipeName.setPreferredSize(new Dimension(50,20));
	        
	        Image heart = new ImageIcon("./img/heart.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		    ImageIcon like=new ImageIcon(heart); 
			JLabel likes = new JLabel(recipe.getLikes()+" Likes", like, JLabel.RIGHT);
			
			JLabel datelbl = new JLabel(recipe.getDateCreated().toString());
			ImageIcon star=new ImageIcon("./img/star.png"); 
			JLabel diffLbl = new JLabel(" difficulty: " + recipe.getDifficulty(), star, JLabel.RIGHT);
			
			textPnl.add(datelbl,"left, wrap");
			textPnl.add(recipeName,"wrap");
			textPnl.add(likes);
			textPnl.add(diffLbl, "right");
			
			tempPnl.add(imgBtn,"split");
			tempPnl.add(textPnl,"wrap");
			tempPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			
			bottomPnl.add(tempPnl,"wrap");
	        
		}
		
		//bottomPnl.setBackground(new Color(0, 0, 0, 10));//new Color(10, 0, 0, 20)
		JScrollPane scrollPane = new JScrollPane(bottomPnl );
		scrollPane.setPreferredSize(new Dimension(600,600));
		
		return scrollPane;
	}
	
	public JPanel createMainPanel() throws IOException {
		JPanel mainPnl= new JPanel(new MigLayout());
		JPanel top = topPanel();
		JPanel right = new JPanel(new MigLayout());
		JPanel left = leftPanel();
		
		right.add(top,"wrap");
		right.add(getBottomPnl());
		
		mainPnl.add(left);
		mainPnl.add(right);
		mainPnl.setBackground(Color.white);
		
		setMainRecipeTab(mainPnl);
		
		return mainPnl;
	}



	public JScrollPane getBottomPnl() {
		return bottomPnl;
	}



	public void setBottomPnl(ArrayList<Recipe>recipes) throws IOException {
		JScrollPane scrollPane = bottomPanel(recipes);
		this.bottomPnl = scrollPane;
	}
	
	public JTextField getPrepTimeField() {
		return prepTimeField;
	}



	public void setPrepTimeField(JTextField prepTimeField) {
		this.prepTimeField = prepTimeField;
	}



	public JTextField getCookTimeField() {
		return cookTimeField;
	}



	public void setCookTimeField(JTextField cookTimeField) {
		this.cookTimeField = cookTimeField;
	}



	public HashMap<Recipe, Integer> getFilterResults() {
		return filterResults;
	}



	public void setFilterResults(HashMap<Recipe, Integer> filterResults) {
		this.filterResults = filterResults;
	}
	
	
	

	public IngredientsCheckBoxModel getIngrModel() {
		return ingrModel;
	}



	public TasteCheckBoxModel getTasteModel() {
		return tasteModel;
	}



	public EquipmentCheckBoxModel getEqModel() {
		return eqModel;
	}



	public TagsCheckBoxModel getTagsModel() {
		return tagsModel;
	}



	public JPanel getMainRecipeTab() {
		return mainRecipeTab;
	}



	public void setMainRecipeTab(JPanel mainRecipeTab) {
		this.mainRecipeTab = mainRecipeTab;
	}


	

	public HashMap<Recipe, Integer> getSearchResults() {
		return searchResults;
	}



	public void setSearchResults(HashMap<Recipe, Integer> searchResults) {
		this.searchResults = searchResults;
	}
	
	
	public void combineSearchAndFilter() throws IOException {
		OrderBy o = new OrderBy(isFilterClicked(), isSearchClicked());
		o.setChosenOrder((String) orderByCombBox.getSelectedItem());
		o.setFilterList(getFilterResults());
		o.setSearchList(getSearchResults());
		setBottomPnl(o.orderAndArray());
		setSelectedOrder(orderByCombBox.getSelectedIndex());
		ck1 = (getCkbx1().isSelected());
		ck2 = (getCkbx2().isSelected());
		ck3 = (getCkbx3().isSelected());
		ck4 = (getCkbx4().isSelected());
		ck5 = getCkbx5().isSelected();
		placedPrepTime = prepTimeField.getText();
		placedCookTime = cookTimeField.getText();
		
		JPanel pan = MainFrame.getInstance().getRecipesTab().createMainPanel();
		MainFrame.getInstance().getRecipesTab().setMainRecipeTab(pan);
		MainFrame.getInstance().getTabbedPane().setComponentAt(1, pan);
	}



	public boolean isFilterClicked() {
		return filterClicked;
	}



	public void setFilterClicked(boolean filterClicked) {
		this.filterClicked = filterClicked;
	}



	public boolean isSearchClicked() {
		return searchClicked;
	}



	public void setSearchClicked(boolean searchClicked) {
		this.searchClicked = searchClicked;
	}



	public JTextField getSearchTxtField() {
		return searchTxtField;
	}



	public String getSearchTerm() {
		return searchTerm;
	}



	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}



	public RecipeWindow getRecipeWindow() {
		return recipeWindow;
	}



	public void setRecipeWindow(RecipeWindow recipeWindow) {
		this.recipeWindow = recipeWindow;
	}



	public JCheckBox getCkbx1() {
		return ckbx1;
	}



	public JCheckBox getCkbx2() {
		return ckbx2;
	}



	public JCheckBox getCkbx3() {
		return ckbx3;
	}



	public JCheckBox getCkbx4() {
		return ckbx4;
	}



	public JCheckBox getCkbx5() {
		return ckbx5;
	}



	public int getSelectedOrder() {
		return selectedOrder;
	}



	public void setSelectedOrder(int selectedOrder) {
		this.selectedOrder = selectedOrder;
	}



	public String getPlacedPrepTime() {
		return placedPrepTime;
	}



	public String getPlacedCookTime() {
		return placedCookTime;
	}

	
}
