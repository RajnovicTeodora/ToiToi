package view;

import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

import controller.ToiToiController;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainFrame() throws IOException {
		
		setSize(700,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
        
		ToiToiController toiToiController = new ToiToiController();
		RecipeWindow rw = new RecipeWindow();
		
        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        tabbedPane.setBounds(10,50,(int) screenSize.getWidth(), (int)screenSize.getHeight());
        tabbedPane.addTab( "", createPage1() );
        tabbedPane.addTab( "", rw.createUserRecipePage(1,"peraa", toiToiController) );
        tabbedPane.addTab( "", createPage2() );
        pan.add( tabbedPane, BorderLayout.CENTER );
        Font f = new Font("Serif", Font.PLAIN, 20);
	    Dimension d = new Dimension(150,30);
	    
	    JLabel lab1 = new JLabel("          Home");
	    lab1.setFont(f);
	    lab1.setPreferredSize(d);
	    tabbedPane.setTabComponentAt(0, lab1);
	    
	    JLabel lab2 = new JLabel("          Recipes");
	    lab2.setFont(f);
	    lab2.setPreferredSize(d);
	    tabbedPane.setTabComponentAt(1, lab2);
	    
	    JLabel lab3 = new JLabel("        Cookbooks");
	    lab3.setFont(f);
	    lab3.setPreferredSize(d);
	    tabbedPane.setTabComponentAt(2, lab3);
	    
	    JButton logInBttn = new JButton("Log in");
	    logInBttn.setSize(50,30);
	    JButton signUpBttn = new JButton("Sign up");
	    signUpBttn.setSize(50,30);	    
	    
	    JLabel title = new JLabel("         ToiToi");
	    title.setFont(new Font("Serif", Font.ITALIC, 50));
	    title.setPreferredSize(new Dimension(100,40));
	    
	    JPanel pan1 = new JPanel(new MigLayout("", "[][grow][]"));
	    pan1.add(title, "skip 1, center");
	    pan1.add(signUpBttn, "split");
	    pan1.add(logInBttn,"right");
	    
	    
	    JPanel masterPan = new JPanel();
	    masterPan.setLayout(new BorderLayout());
	    masterPan.add(pan, BorderLayout.CENTER);
	    masterPan.add(pan1, BorderLayout.NORTH);
	    getContentPane().add(masterPan);
	    	    
	    setVisible(true);
		
	}
	
	public JPanel createPage1() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel label = new JLabel("Form");

        JPanel tableButtonPanel = new JPanel();
        tableButtonPanel.add(new JButton("Add Thing"));
        tableButtonPanel.add(new JRadioButton("Delete Thing"));
        tableButtonPanel.add(new JButton("Modify Thing"));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(tableButtonPanel, gbc);
		
		return panel;
	}
	
	 public JPanel createPage2() throws IOException
	    {
		 
		 	JPanel breakfast = new JPanel();
	        breakfast.setLayout( new BorderLayout() );
	        breakfast.add( new JButton( "North" ), BorderLayout.NORTH );
	        breakfast.add( new JButton( "South" ), BorderLayout.SOUTH );
	        breakfast.add( new JButton( "East" ), BorderLayout.EAST );
	        breakfast.add( new JButton( "West" ), BorderLayout.WEST );
	        breakfast.add( new JButton( "Center" ), BorderLayout.CENTER );
	        return breakfast;
	    }

}
