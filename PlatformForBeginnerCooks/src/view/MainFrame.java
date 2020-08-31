package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		
		setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
		
		JTextArea ta=new JTextArea(200,200);
	    JPanel p1=new JPanel();
	    p1.add(ta);
	    JPanel p2=new JPanel();
	    JPanel p3=new JPanel();
	    JTabbedPane tp=new JTabbedPane();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    tp.setBounds(10,50,(int) screenSize.getWidth(), (int)screenSize.getHeight());
	    tp.add("home",p1);
	    tp.add("recipes",p2);
	    tp.add("cookbook",p3);
	     
	    Font f = new Font("Serif", Font.PLAIN, 20);
	    Dimension d = new Dimension(150,30);
	    
	    JLabel lab1 = new JLabel("          Home");
	    lab1.setFont(f);
	    lab1.setPreferredSize(d);
	    tp.setTabComponentAt(0, lab1);
	    
	    JLabel lab2 = new JLabel("          Recipes");
	    lab2.setFont(f);
	    lab2.setPreferredSize(d);
	    tp.setTabComponentAt(1, lab2);
	    
	    JLabel lab3 = new JLabel("          Cookbooks");
	    lab3.setFont(f);
	    lab3.setPreferredSize(d);
	    tp.setTabComponentAt(2, lab3);
	    
	    JButton logInBttn = new JButton("Log in");
	    logInBttn.setSize(50,30);
	    JButton signUpBttn = new JButton("Sign up");
	    
	    con.insets = new Insets(10, 10, 10, 10);
	    con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = 2;
        con.fill = GridBagConstraints.BOTH;
        add(logInBttn, con);
	    
        con.gridy = 1;
        add(signUpBttn, con);
	    //add(tp);
	    
	    setVisible(true);
	    
	    setSize(screenSize);
	}
	
	

}
