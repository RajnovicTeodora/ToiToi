package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import TableModel.CommentsToDeleteModel;
import TableModel.EditTasteModel;
import controller.Chosen.ChosenComment;
import controller.Chosen.ChosenProducts;
import controller.Chosen.ChosenTaste;
import controller.Chosen.ChosenTasteForEdit;
import model.Comment;
import model.Recipe;
import model.Tag;
import model.Taste;
import model.User;
import net.miginfocom.swing.MigLayout;

public class EditRecipeWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Recipe recipe;
	private CommentsToDeleteModel commsToDel;
	private JComboBox<String> tasteBox;
	private String tags="";
	private JTextArea tagsArea;
	private int currentTabIndex;
	
	public EditRecipeWindow(Recipe recipe) {
		super();
		this.recipe = recipe;
		tags ="";
		for (Tag tag : getRecipe().getTags()) {
			tags += "#"+ tag.getTag();
		}
	}

	
	public void run() {
		setTitle("Edit recipe");
		setSize(350,600);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new MigLayout());
		
		////////////////////////////TITLE//////////////////////////////////////////
		JLabel editingLbl = new JLabel("Editing:");
		JLabel titleLbl = new JLabel(getRecipe().getName());
		titleLbl.setFont(new Font("Serif", Font.PLAIN, 25));
				
		
		/////////////////INSTRUCTIONS////////////////////////////////////////////////
		JLabel textLbl = new JLabel("Instructions:");
		JTextArea jt = new JTextArea(getRecipe().getDescription());
		Font f = new Font("Serif", Font.ITALIC, 15); 
        jt.setFont(f);
        jt.setLineWrap(true);
        jt.setWrapStyleWord(true);
		JScrollPane instrAreaScrollPane = new JScrollPane(jt);
		instrAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		instrAreaScrollPane.setPreferredSize(new Dimension(300, 200));
		
		/////////////////COMMENTS///////////////////////////////////////////////////
		JLabel commLbl = new JLabel("Select comments to delete:");
		
		ChosenComment.setChosenComms(new ArrayList<Integer>());
		
		ArrayList<Comment>parentChildComms = new ArrayList<Comment>();
		for (Comment comment : getRecipe().getComment()) {
			
			parentChildComms.add(comment);
			if(!comment.getChild().isEmpty()) {
				for (Comment child : comment.getChild()) {
					
					parentChildComms.add(child);
					if(!child.getChild().isEmpty()) {
						for (Comment comment2 : child.getChild()) {
							parentChildComms.add(comment2);
						}
					}
				}
			}
		}
		commsToDel = new CommentsToDeleteModel(parentChildComms);
		JTable commTable = new JTable(commsToDel);
		commTable.setAutoCreateRowSorter(true);
		commTable.getColumn("").setPreferredWidth(3);
		//commTable.setGridColor(new Color(255, 51, 153));
		commTable.getTableHeader().setBackground(new Color(150, 0, 0, 30));
        JScrollPane commScrollPane = new JScrollPane(commTable);
        commScrollPane.setPreferredSize(new Dimension(300,200));
		
		///////////////////////TASTE///////////////////////////////////////////////
        JLabel tasteLbl = new JLabel("Select taste to add:");
       		
        for (Taste t : getRecipe().getTaste()) {
        	ChosenTasteForEdit.add_taste(t.toString());
		}
		List<Taste> tasteList = Arrays.asList(Taste.values());
		EditTasteModel tasteModel = new EditTasteModel(tasteList);
        JTable tasteTable = new JTable(tasteModel);
        tasteTable.getTableHeader().setBackground(new Color(150, 0, 0, 30));
        tasteTable.setAutoCreateRowSorter(true);
		JScrollPane tasteScrollPane = new JScrollPane(tasteTable);
		tasteScrollPane.setPreferredSize(new Dimension(300,200));
		
		///////////////////////////TAGS/////////////////////////////////////////
		JLabel tagsLbl = new JLabel("Write tag to add:");
		JTextField newTag = new JTextField(10);
		newTag.setColumns(25);
		JButton addtag = new JButton("Add");
		addtag.setMnemonic(KeyEvent.VK_ENTER);
				
		
		tagsArea = new JTextArea(getTags());
		tagsArea.setEditable(false);
		tagsArea.setLineWrap(true);
		tagsArea.setWrapStyleWord(true);
		
		addtag.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String content = newTag.getText();
				
				if(!content.isEmpty()) {
					tags += "#"+content;
					setTags(tags);
					
					getTagsArea().setText(getTags());
					
					run();
					
				}
				
			}
		});
		
		////////////////////////Servings////////////////////////////
		JLabel servLbl = new JLabel("Servings:");
		JTextField servTxt = new JTextField(10);
		servTxt.setText(String.valueOf(getRecipe().getServings()));
		servTxt.setColumns(8);
		
		///////////////////////Difficulty////////////////////////////
		JLabel diffLbl = new JLabel("Difficulty:");
		JSpinner diffSpin = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
		diffSpin.setValue(getRecipe().getDifficulty());
		
		////////////////////PrrepTime///////////////////////////////
		JLabel prepLbl = new JLabel("PrepTime:");
		JTextField prepTxt = new JTextField(50);
		prepTxt.setText(String.valueOf(getRecipe().getPrepTime()));
		prepTxt.setColumns(8);
		
		/////////////////CookTime//////////////////////////////////
		JLabel cookLbl = new JLabel("CookTime:");
		JTextField cookTxt = new JTextField(50);
		cookTxt.setText(String.valueOf(getRecipe().getCookTime()));
		cookTxt.setColumns(8);
		
		/////////////////Save/Cancel//////////////////////////
		JButton save =new JButton("Save");
		save.setPreferredSize(new Dimension(160,20));
		JButton cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(160,20));
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Recipe changedRecipe = getRecipe();
				
				String instr = jt.getText();
				
				for (int i = 0; i < commsToDel.getRowCount(); i++) {
					if ((boolean) commsToDel.getValueAt(i, 3) && !ChosenComment.containsComm((Integer) commsToDel.getValueAt(i, 0))) {
						ChosenComment.add_comm((Integer) commsToDel.getValueAt(i, 0));
					}else {
						ChosenComment.remove_comm( (Integer) commsToDel.getValueAt(i, 0));
					}
				}
				
				ArrayList<Comment> deleteTheseComms = new ArrayList<Comment>();
				
				if(ChosenComment.getChosenComms()!=null && !ChosenComment.getChosenComms().isEmpty()) {
					for (Integer it : ChosenComment.getChosenComms()) {
						deleteTheseComms.add(parentChildComms.get(it));
					}
				}
				
				ArrayList<Comment> newComms = new ArrayList<Comment>();
				
				if(deleteTheseComms.isEmpty()) {
					newComms=(ArrayList<Comment>) getRecipe().getComment();
				}
				
				for (Comment c : deleteTheseComms) {
					if(!changedRecipe.getComment().contains(c)) {
						Comment newParent = new Comment();
						newParent.setCommentator(c.getCommentator());
						newParent.setText(c.getText());
						newParent.setDate(c.getDate());
						
						for (Comment child : c.getChild()) {
							if(!changedRecipe.getComment().contains(child)) {
								Comment newChild = new Comment();
								newChild.setCommentator(child.getCommentator());
								newChild.setText(child.getText());
								newChild.setDate(child.getDate());
								
								for(Comment granch : child.getChild()) {
									if(!changedRecipe.getComment().contains(granch)) {
										Comment newGranch = new Comment();
										newGranch.setCommentator(granch.getCommentator());
										newGranch.setText(granch.getText());
										newGranch.setDate(granch.getDate());
										
										newChild.addChild(newGranch);
									}
								}
								
								newParent.addChild(newChild);
							}
						}
						newComms.add(newParent);
					}
									
				}
				
				
				ArrayList<Taste> changedTaste = new ArrayList<Taste>();
				for (int i = 0; i < tasteModel.getRowCount(); i++) {
					if ((boolean) tasteModel.getValueAt(i, 1)) {
						ChosenTasteForEdit.add_taste((String) tasteModel.getValueAt(i, 0));
					}else {
						ChosenTasteForEdit.remove_taste( (String) tasteModel.getValueAt(i, 0));
					}
				}
				
				if(ChosenTasteForEdit.getChosenTaste()!=(null) && !ChosenTasteForEdit.getChosenTaste().isEmpty()) {
					for (String taste : ChosenTasteForEdit.getChosenTaste()) {
						changedTaste.add(Taste.valueOf(taste));
					}
				}
				
				ArrayList<Tag> addedTags = new ArrayList<Tag>();
				if(getTags() != null && !getTags().equals("null") && !getTags().isEmpty()) {
					String[] withHashTag = getTags().split("#");
					for (String s : withHashTag) {
						if(!s.equals("null") && !s.equals("#")&& !s.equals("")) {
							Tag t = new Tag();
							t.setTag(s);
							addedTags.add(t);
						}
					}
				}
				
				int servings = Integer.parseInt(servTxt.getText());
				int prepTime = Integer.parseInt(prepTxt.getText());
				int cookTime = Integer.parseInt(cookTxt.getText());
				int difficulty = (int) diffSpin.getValue();
				
				
				changedRecipe.setDescription(instr);
				changedRecipe.setServings(servings);
				changedRecipe.setPrepTime(prepTime);
				changedRecipe.setCookTime(cookTime);
				changedRecipe.setDifficulty(difficulty);
				changedRecipe.setTags(addedTags);
				changedRecipe.setTaste(changedTaste);
				changedRecipe.setComment(newComms);
				
				User u = getRecipe().getCreator();
				u.removeRecipes(getRecipe());
				u.addRecipes(changedRecipe);
				MainFrame.getInstance().getToiToiController().getToiToi().replaceRecipe(getRecipe(), changedRecipe);
				MainFrame.getInstance().getToiToiController().getToiToi().replaceUser(u);
				
				setRecipe(changedRecipe);					
				dispose();
				try {
					MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(),  
							MainFrame.getInstance().getRecipeWindow().createUserRecipePage(getRecipe(), (User) MainFrame.getInstance().getAkter(), getCurrentTabIndex()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JPanel titlPnl = new JPanel(new MigLayout());
		JPanel instrPnl = new JPanel(new MigLayout());
		JPanel commPnl = new JPanel(new MigLayout());
		JPanel tastePnl = new JPanel(new MigLayout());
		JPanel tagPnl = new JPanel(new MigLayout());
		JPanel servPnl = new JPanel(new MigLayout());
		JPanel savePnl = new JPanel(new MigLayout());
		JPanel mainPnl = new JPanel(new MigLayout());
		
		titlPnl.add(editingLbl, "split");
		titlPnl.add(titleLbl,"growx");
		titlPnl.setBackground(new Color(150, 0, 0, 30));
		titlPnl.setPreferredSize(new Dimension(300,40));
		
		instrPnl.add(textLbl,"wrap");
		instrPnl.add(instrAreaScrollPane);
		instrPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		commPnl.add(commLbl,"wrap");
		commPnl.add(commScrollPane);
		commPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		tastePnl.add(tasteLbl,"wrap");
		tastePnl.add(tasteScrollPane);
		tastePnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		tagPnl.add(tagsLbl,"wrap");
		tagPnl.add(tagsArea,"growx,wrap");
		tagPnl.add(newTag, "split");
		tagPnl.add(addtag);
		tagPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		servPnl.add(prepLbl,"split");
		servPnl.add(prepTxt);
		servPnl.add(servLbl,"split");
		servPnl.add(servTxt,"wrap");
		servPnl.add(cookLbl,"split");
		servPnl.add(cookTxt);
		servPnl.add(diffLbl,"split");
		servPnl.add(diffSpin);
		servPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		savePnl.add(save,"split");
		savePnl.add(cancel,"growx");
		savePnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		savePnl.setPreferredSize(new Dimension(300,35));
		
		mainPnl.add(titlPnl,"wrap");
		mainPnl.add(instrPnl,"wrap");
		mainPnl.add(commPnl,"wrap");
		mainPnl.add(tastePnl,"wrap");
		mainPnl.add(tagPnl,"wrap");
		mainPnl.add(servPnl,"wrap");
		mainPnl.add(savePnl,"growx");
		mainPnl.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPnl.setPreferredSize(new Dimension(300,40));
		
		/*JScrollPane scrollPane = new JScrollPane(mainPnl,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		scrollPane.setPreferredSize(new Dimension(300,600));*/
		
		setContentPane(mainPnl);
		setVisible(true);
	}
	

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	public CommentsToDeleteModel getCommsToDel() {
		return commsToDel;
	}


	public void setCommsToDel(CommentsToDeleteModel commsToDel) {
		this.commsToDel = commsToDel;
	}


	public JComboBox<String> getTasteBox() {
		return tasteBox;
	}


	public void setTasteBox(JComboBox<String> tasteBox) {
		this.tasteBox = tasteBox;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public JTextArea getTagsArea() {
		return tagsArea;
	}


	public void setTagsArea(JTextArea tagsArea) {
		this.tagsArea = tagsArea;
	}


	public int getCurrentTabIndex() {
		return currentTabIndex;
	}


	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}



	
	
	
}
