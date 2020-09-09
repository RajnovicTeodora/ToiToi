package view;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.Akter;
import model.CookBook;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;

public class ProfileWindow {
	
	private User user;
	
	public ProfileWindow(Akter a) {
		super();
		this.user = (User)a;
	}
	
	public JPanel createMyProfilePage() throws IOException {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		ImageIcon icon = new ImageIcon("./img/myProfile.png");
		JLabel profilePhoto = new JLabel(icon);
		profilePhoto.setBounds(30, 30, 50, 50);
		
		JLabel imePrezime = new JLabel(user.getName()+" "+user.getSurname());
		imePrezime.setFont(new Font("Serif", Font.PLAIN, 40));
		imePrezime.setBounds(100, 30, 200, 50);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 90, 650, 600);
		tabbedPane.addTab("Recipes", createRecipesPanel());
		tabbedPane.addTab("Cookbooks", createCookBookPanel());
		tabbedPane.addTab("My info", createMyInfoPanel());
		
		panel.add(profilePhoto);
		panel.add(imePrezime);
		panel.add(tabbedPane);
		return panel;
		
	}
	
	private JPanel createRecipesPanel() throws IOException{
		JPanel panel = new JPanel(new MigLayout());

		ArrayList<JButton> dugmici = new ArrayList<JButton>();
		Font f = new Font("Serif", Font.ITALIC, 30);
		Color c = new Color(255, 233,  255);
		
		ImageIcon addIcon = new ImageIcon("./img/add.png");  
		JButton dodaj = new JButton("Add recipe", addIcon);
		dodaj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//ovde se poziva funkcija za dodavanje recepta
        	}
        });
		panel.add(dodaj, "gapleft 480, span, wrap");
		
		for(Recipe r : user.getRecipes()) {
			BufferedImage img=ImageIO.read(new File(r.getImage()));
		    Image image = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        ImageIcon icon=new ImageIcon(image);   
	        
	        JButton dugmic = new JButton(icon);
	        dugmici.add(dugmic); //mozda nece trebati
	        dugmic.setBackground(c);
	        
	        dugmic.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		//ovde se poziva funkcija za prikaz celog recepta!
	        	}
	        });
	        
	        JLabel naziv = new JLabel(r.getName());
	        naziv.setFont(f);
	        
	        panel.add(dugmic, "gapleft 50, gaptop 30");
	        panel.add(naziv, "gapleft 50, gaptop 30, wrap");
	        

		}
		return panel;
	}
	
	private JPanel createMyInfoPanel() throws IOException {
		JPanel panel = new JPanel(null);
		
		ImageIcon icon = new ImageIcon("./img/editProfile.png");  
		JButton edit = new JButton("Edit profile", icon);
		edit.setBounds(500, 0, 130, 30);
		edit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//ovde se poziva funkcija za edit profila
        	}
        });
		
		JLabel ime = new JLabel("Name:  " + user.getName());
		JLabel prezime = new JLabel("Surname:  " + user.getSurname());
		JLabel mail = new JLabel("Mail:  " + user.getMail());
		JLabel korIme = new JLabel("Username:  " + user.getUsername());
		JLabel loz = new JLabel("Password:  " + user.getPassword());
		JLabel pol = new JLabel("Gender:  " + user.getGender());
		JLabel adresa = new JLabel("Address:  " + user.getAddress());
		JLabel brTel = new JLabel("Phone number:  " + user.getTelephone());
		
		Font f = new Font("Serif", Font.PLAIN, 20);
		
		ime.setFont(f);
		prezime.setFont(f);
		pol.setFont(f);
		adresa.setFont(f);
		brTel.setFont(f);
		mail.setFont(f);
		korIme.setFont(f);
		loz.setFont(f);
		
		ime.setBounds(50, 20, 200, 40);
		prezime.setBounds(50, 70, 200, 40);
		pol.setBounds(50, 120, 200, 40);
		adresa.setBounds(50, 170, 200, 40);
		brTel.setBounds(50, 220, 200, 40);
		mail.setBounds(50, 270, 200, 40);
		korIme.setBounds(50, 320, 200, 40);
		loz.setBounds(50, 370, 200, 40);
		
		panel.add(ime);
		panel.add(prezime);
		panel.add(pol);
		panel.add(adresa);
		panel.add(brTel);
		panel.add(mail);
		panel.add(korIme);
		panel.add(loz);
		
		panel.add(edit);
		
		BufferedImage img=ImageIO.read(new File(user.getImage()));
		Image image = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon im = new ImageIcon(image);
		JLabel profilna = new JLabel(im);
		profilna.setBounds(400, 100, 100, 100);
		panel.add(profilna);
		return panel;
	}
	
	private  JPanel createCookBookPanel() throws IOException {
		JPanel panel = new JPanel(new MigLayout());

		ArrayList<JButton> dugmici = new ArrayList<JButton>();
		Font f = new Font("Serif", Font.ITALIC, 30);
		Color c = new Color(204, 204,  255);
		
		ImageIcon addIcon = new ImageIcon("./img/add.png");  
		JButton dodaj = new JButton("Add cookbook", addIcon);
		dodaj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//ovde se poziva funkcija za dodavanje cb
        	}
        });
		panel.add(dodaj, "gapleft 480, span, wrap");
		
		for(CookBook r : user.getCookBooks()) {
			BufferedImage img=ImageIO.read(new File(r.getImage()));
		    Image image = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        ImageIcon icon=new ImageIcon(image);   
	        
	        JButton dugmic = new JButton(icon);
	        dugmici.add(dugmic); //mozda nece trebati
	        dugmic.setBackground(c);
	        
	        dugmic.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		//ovde se poziva funkcija za prikaz celog recepta!
	        	}
	        });
	        
	        JLabel naziv = new JLabel(r.getName());
	        naziv.setFont(f);
	        
	        panel.add(dugmic, "gapleft 50, gaptop 30");
	        panel.add(naziv, "gapleft 50, gaptop 30, wrap");
	        

		}
		
		return panel;
	}
}
