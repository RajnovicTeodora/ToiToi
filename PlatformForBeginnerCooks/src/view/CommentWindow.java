package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Comment;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;

public class CommentWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Recipe recipe;
	
	private String chosen;
	
	private int currentTabIndex;
	
	
	public CommentWindow() {
		super();
	}
	
	public void run() {
		setTitle("Comment");
		setSize(300,400);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		
		JLabel textLbl = new JLabel("Text:");
		JTextArea jt = new JTextArea();
		Font f = new Font("Serif", Font.ITALIC, 15); 
        jt.setFont(f);
        jt.setLineWrap(true);
        jt.setWrapStyleWord(true);
		JScrollPane commentAreaScrollPane = new JScrollPane(jt);
		commentAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		commentAreaScrollPane.setPreferredSize(new Dimension(300, 200));
        
        JButton addBttn = new JButton("Add");
        
        JButton cancelBttn = new JButton("Cancel");
		 
		ArrayList<Comment> allComm = new ArrayList<Comment>();
        
		int n = getRecipe().getComment().size();
		ArrayList<String> commentsToReply  = new ArrayList<String>();
		for (Comment comment : getRecipe().getComment()) {
			int lenght = comment.getText().length();
			if(lenght>20) {
				lenght=20;
			}
			commentsToReply.add(comment.getText().substring(0,lenght) +"...by: "+ getRecipe().getCreator().getUsername());
			allComm.add(comment);
			for (Comment child : comment.getChild()) {
				int l = child.getText().length();
				if(l>20) {
					l=20;
				}
				commentsToReply.add(child.getText().substring(0,l)+"...by: "+ getRecipe().getCreator().getUsername());
				allComm.add(child);
			}
			
		}
		
		JLabel addLbl = new JLabel("Comment type:");
		String[] type = new String[commentsToReply.size()+1];
		type[0] = "New Comment";
		int i=1;
		for (String string : commentsToReply) {
			type[i] = "Reply to: " + string;
			i++;
		}
		JComboBox commType = new JComboBox(type);
		commType.setSelectedIndex(0);
		
		addBttn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sel = commType.getSelectedIndex();
				
				String text = jt.getText();
								
				if(sel==0) {//new comment
					Comment c = new Comment();
					c.setText(text);
					c.setCommentator((User) MainFrame.getInstance().getAkter());
					c.setDate(LocalDate.now());
					
					Recipe r = getRecipe();
					MainFrame.getInstance().getToiToiController().getToiToi().removeRecipe(getRecipe());
					r.addComment(c);
					MainFrame.getInstance().getToiToiController().getToiToi().addRecipe(r);
					setRecipe(r);
					dispose();
					try {
						MainFrame.getInstance().getTabbedPane().setComponentAt(getCurrentTabIndex(),  
								MainFrame.getInstance().getRecipeWindow().createUserRecipePage(getRecipe(), (User) MainFrame.getInstance().getAkter(), getCurrentTabIndex()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {//reply
					/*
					 * Comment parent = allComm.get(sel-1); Comment child = new Comment();
					 * child.setDate(LocalDate.now()); child.setCommentator((User)
					 * MainFrame.getInstance().getAkter()); child.setText(text);
					 * 
					 * 
					 * Recipe r = getRecipe();
					 * MainFrame.getInstance().getToiToiController().getToiToi().removeRecipe(
					 * getRecipe()); for (Comment c : r.getComment()) { if(c.equals(parent)) {
					 * c.addChild(child); }else { for (Comment c1 : c.getChild()) {
					 * if(c1.equals(parent)) { c1.addChild(child); } } } }
					 * MainFrame.getInstance().getToiToiController().getToiToi().addRecipe(r);
					 * setRecipe(r);
					 */
					//TODO dubina komentara?
				}
				
			}
		});
		
		cancelBttn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "All made progress will be lost.",
						"Are you sure you want to cancel?", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION)
					dispose();
				
			}
		});
		
		JPanel panel = new JPanel(new MigLayout());
		panel.add(addLbl, "split");
		panel.add(commType, "growx, wrap");
		panel.add(textLbl, "wrap");
		panel.add(commentAreaScrollPane, "growx, wrap");
		panel.add(addBttn, "growx, split");
		panel.add(cancelBttn,"growx");
		
		getContentPane().add(panel,BorderLayout.CENTER);
		setVisible(true);
	}
	
	

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getChosen() {
		return chosen;
	}

	public void setChosen(String chosen) {
		this.chosen = chosen;
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}


	
}
