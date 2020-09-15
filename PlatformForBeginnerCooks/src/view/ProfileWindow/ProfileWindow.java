package view.ProfileWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import controller.ToiToiController;
import controller.ButtonActions.RecipeImageButtonAction;
import model.Akter;
import model.CookBook;
import model.Equipment;
import model.Gender;
import model.ProductInfo;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.RecipeForm.RecipeForm;

public class ProfileWindow {


	private ToiToiController toitoiController;
	private User user;

	public ProfileWindow(Akter a, ToiToiController ttc) {
		super();
		this.toitoiController = ttc;
		if (a instanceof User)
			this.user = (User) a;
	}
	
	public JPanel createOtherUserProfilePage() throws IOException {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		BufferedImage img = null;
		if (!user.getImage().equals("")) {
			img = ImageIO.read(new File(user.getImage()));
		} else {
			if (user.getGender() == Gender.FEMALE)
				img = ImageIO.read(new File("./img/user-female.png"));
			else if (user.getGender() == Gender.MALE)
				img = ImageIO.read(new File("./img/user.png"));
			else
				img = ImageIO.read(new File("./img/accessibility2.png"));
		}
		
		Image image = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);

		JLabel profilePhoto = new JLabel(icon);
		profilePhoto.setBounds(30, 30, 50, 50);

		JLabel imePrezime = new JLabel(user.getName() + " " + user.getSurname());
		imePrezime.setFont(new Font("Serif", Font.PLAIN, 40));
		imePrezime.setBounds(100, 30, 200, 50);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 90, 650, 600);
		
		tabbedPane.addTab("Recipes", createRecipesPanel(false));
		tabbedPane.addTab("Cookbooks", createCookBookPanel(false));
		tabbedPane.addTab("Liked Recipes", createLikedRecipesPanel());

		panel.add(profilePhoto);
		panel.add(imePrezime);
		panel.add(tabbedPane);
		return panel;
	}


	public JPanel createMyProfilePage() throws IOException {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		BufferedImage img = null;
		if (!user.getImage().equals("")) {
			img = ImageIO.read(new File(user.getImage()));
		} else {
			if (user.getGender() == Gender.FEMALE)
				img = ImageIO.read(new File("./img/user-female.png"));
			else if (user.getGender() == Gender.MALE)
				img = ImageIO.read(new File("./img/user.png"));
			else
				img = ImageIO.read(new File("./img/accessibility2.png"));
		}
		Image image = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);

		JLabel profilePhoto = new JLabel(icon);
		profilePhoto.setBounds(30, 30, 50, 50);

		JLabel imePrezime = new JLabel(user.getName() + " " + user.getSurname());
		imePrezime.setFont(new Font("Serif", Font.PLAIN, 40));
		imePrezime.setBounds(100, 30, 200, 50);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 90, 650, 600);
		tabbedPane.addTab("Recipes", createRecipesPanel(true));
		tabbedPane.addTab("Cookbooks", createCookBookPanel(true));
		tabbedPane.addTab("Liked Recipes", createLikedRecipesPanel());
		tabbedPane.addTab("My Fridge", createMyFridgePanel());
		tabbedPane.addTab("My Equipment", createMyEquipmentPanel());
		tabbedPane.addTab("My info", createMyInfoPanel());

		panel.add(profilePhoto);
		panel.add(imePrezime);
		panel.add(tabbedPane);
		return panel;

	}
	
	private JPanel createLikedRecipesPanel() throws IOException {
		JPanel panel = new JPanel(new MigLayout());

		ImageIcon recipeIcon = new ImageIcon("./img/like.png");
		JLabel naslov = new JLabel("Liked Recipes");
		naslov.setIcon(recipeIcon);
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(naslov, "gapleft 200");

		ArrayList<JButton> dugmici = new ArrayList<JButton>();
		Font f = new Font("Serif", Font.ITALIC, 20);


		Color c = new Color(204, 255, 255);



		JPanel panel2 = new JPanel(new MigLayout());

		int brojac = 1;
		for (Recipe r : user.getLikedRecipes()) {
			
		
			BufferedImage img = ImageIO.read(new File(r.getImage()));
			Image image = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image);

			JButton dugmic = new JButton(icon);
			dugmici.add(dugmic); // mozda nece trebati
			dugmic.setBackground(c);

			dugmic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ovde se poziva funkcija za prikaz celog recepta!
				}
			
			});

			JLabel naziv = new JLabel(r.getName());
			naziv.setFont(f);

			JLabel br = new JLabel(brojac + ".");
			br.setFont(f);
			panel2.add(br, "gapleft 10");
			panel2.add(dugmic, "gapleft 30, gaptop 30");
			panel2.add(naziv, "gapleft 50, gaptop 30, wrap");
			brojac++;
			
		}
		
		panel.add(panel2, "span, wrap");
		return panel;
	}


	private JPanel createRecipesPanel(boolean trebaDugmic) throws IOException {

		JPanel panel = new JPanel(new MigLayout());

		ImageIcon recipeIcon = new ImageIcon("./img/recipe.png");
		JLabel naslov = new JLabel("My Recipes");
		naslov.setIcon(recipeIcon);
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(naslov, "gapleft 200");

		ArrayList<JButton> dugmici = new ArrayList<JButton>();
		Font f = new Font("Serif", Font.ITALIC, 20);


		Color c = new Color(255, 233, 255);
		
		if(trebaDugmic) {
			ImageIcon addIcon = new ImageIcon("./img/add.png");
			JButton dodaj = new JButton("Add recipe", addIcon);
			dodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RecipeForm rf = new RecipeForm(toitoiController);
					rf.setVisible(true);
				}
			});
			panel.add(dodaj, "gapleft 100, wrap");
		}
		else {
			panel.add(new JLabel(), "span, wrap");
		}


		JPanel panel2 = new JPanel(new MigLayout());

		int brojac = 1;
		for (Recipe r : user.getRecipes()) {
			
		
			BufferedImage img = ImageIO.read(new File(r.getImage()));
			Image image = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image);

			JButton dugmic = new JButton(icon);
			dugmici.add(dugmic); // mozda nece trebati
			dugmic.setBackground(c);
			
			/*RecipeImageButtonAction recAction1 = new RecipeImageButtonAction();
			recAction1.setTabIndex(3);///TODO dodaj currentTabIndex
			recAction1.setRecipe(r);
			dugmic.setMnemonic(KeyEvent.VK_ENTER);
			dugmic.addActionListener(recAction1);*/
			
			/*dugmic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ovde se poziva funkcija za prikaz celog recepta!
				}
			
			});*/

			JLabel naziv = new JLabel(r.getName());
			naziv.setFont(f);

			JLabel br = new JLabel(brojac + ".");
			br.setFont(f);
			panel2.add(br, "gapleft 10");
			panel2.add(dugmic, "gapleft 30, gaptop 30");
			panel2.add(naziv, "gapleft 50, gaptop 30, gapright 250, wrap");
			brojac++;
			
		}
		JScrollPane jsp = new JScrollPane(panel2);
		panel.add(jsp, "span, grow, wrap");
		return panel;
	}


	private JPanel createMyInfoPanel() throws IOException {
		JPanel panel = new JPanel(null);

		JLabel naslov = new JLabel("My Profile");
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		naslov.setBounds(250, 0, 200, 50);
		panel.add(naslov);

		ImageIcon icon = new ImageIcon("./img/editProfile.png");
		JButton edit = new JButton("Edit profile", icon);
		edit.setBounds(500, 10, 130, 40);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditProfile(user);
			}
		});

		ArrayList<JLabel> labels = new ArrayList<JLabel>();

		JLabel ime = new JLabel("Name:  " + user.getName());
		labels.add(ime);
		JLabel prezime = new JLabel("Surname:  " + user.getSurname());
		labels.add(prezime);
		JLabel mail = new JLabel("Mail:  " + user.getMail());
		labels.add(mail);
		JLabel korIme = new JLabel("Username:  " + user.getUsername());
		labels.add(korIme);
		JLabel loz = new JLabel("Password:  " + user.getPassword());
		labels.add(loz);
		JLabel pol = new JLabel("Gender:  " + user.getGender());
		labels.add(pol);
		JLabel adresa = new JLabel("Address:  " + user.getAddress());
		labels.add(adresa);
		JLabel brTel = new JLabel("Phone number:  " + user.getTelephone());
		labels.add(brTel);

		Font f = new Font("Serif", Font.PLAIN, 20);

		for (int i = 0; i < labels.size(); i++) {
			labels.get(i).setFont(f);
			labels.get(i).setBounds(50, 70 + (i * 40), 200, 40);
			panel.add(labels.get(i));
		}

		panel.add(edit);

		BufferedImage img = null;
		if (!user.getImage().equals("")) {
			img = ImageIO.read(new File(user.getImage()));
		} else {
			if (user.getGender() == Gender.FEMALE)
				img = ImageIO.read(new File("./img/user-female.png"));
			else if (user.getGender() == Gender.MALE)
				img = ImageIO.read(new File("./img/user.png"));
			else
				img = ImageIO.read(new File("./img/accessibility2.png"));
		}
		Image image = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon im = new ImageIcon(image);
		JLabel profilna = new JLabel(im);
		profilna.setBounds(400, 100, 100, 100);
		panel.add(profilna);
		return panel;
	}

	private JPanel createCookBookPanel(boolean trebaDugmic) throws IOException {

		JPanel panel = new JPanel(new MigLayout());

		ImageIcon recipeIcon = new ImageIcon("./img/cookbook.png");
		JLabel naslov = new JLabel("My CookBooks");
		naslov.setIcon(recipeIcon);
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(naslov, "gapleft 200");

		ArrayList<JButton> dugmici = new ArrayList<JButton>();
		Font f = new Font("Serif", Font.ITALIC, 20);


		Color c = new Color(204, 204, 255);

		
		if(trebaDugmic) {
			ImageIcon addIcon = new ImageIcon("./img/add.png");
			JButton dodaj = new JButton("Add cookbook", addIcon);
			dodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO : dugmic za dodavanje cookbook-a
				}
			});
			panel.add(dodaj, "gapleft 30, wrap");
		}
		else {
			panel.add(new JLabel(), "span, wrap");
		}

		JPanel panel2 = new JPanel(new MigLayout());
		int brojac = 1;
		
		for (CookBook r : user.getCookBooks()) {
			BufferedImage img = ImageIO.read(new File(r.getImage()));
			Image image = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image);

			JButton dugmic = new JButton(icon);
			dugmici.add(dugmic); // mozda nece trebati
			dugmic.setBackground(c);

			dugmic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ovde se poziva funkcija za prikaz celog recepta!
				}
			});

			JLabel naziv = new JLabel(r.getName());
			naziv.setFont(f);

			JLabel br = new JLabel(brojac + ".");
			br.setFont(f);
			panel2.add(br, "gapleft 10");
			panel2.add(dugmic, "gapleft 30, gaptop 30");
			panel2.add(naziv, "gapleft 50, gaptop 30, gapright 250, wrap");
			brojac++;

		}
		JScrollPane jsp = new JScrollPane(panel2);
		panel.add(jsp, "span, wrap");
		return panel;
	}

	private JPanel createMyFridgePanel() {
		JPanel panel = new JPanel(new MigLayout());

		ImageIcon icon = new ImageIcon("./img/myFridge.png");
		JLabel naslov = new JLabel("My Fridge");
		naslov.setIcon(icon);
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(naslov, "gapleft 200");

		ImageIcon addIcon = new ImageIcon("./img/add.png");
		JButton dodaj = new JButton("Add product", addIcon);
		dodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ovde se poziva funkcija za dodavanje proizvoda u frizider
			}
		});
		panel.add(dodaj, "gapleft 100, wrap");

		Font f = new Font("Serif", Font.PLAIN, 15);
		Color c1 = new Color(255, 51, 153);
		Color c2 = new Color(255, 234, 255);
		JPanel panel2 = new JPanel(new MigLayout());
		int brojac = 1;
		String[][] lista = new String[user.getGrocerie().size()][5];

		for (ProductInfo e : user.getGrocerie()) {

			lista[brojac - 1][0] = brojac + "";
			lista[brojac - 1][1] = e.getIngredient().getName();
			lista[brojac - 1][2] = e.getIngredient().getProducedBy();
			lista[brojac - 1][3] = e.getQuantity() + "";
			lista[brojac - 1][4] = e.getExpires().format(DateTimeFormatter.ofPattern("dd.MM.YYYY."));
			brojac++;

		}
		String[] kolone = { "", "Name", "Produced by", "Quantity", "Expire date" };
		JTable tabela = new JTable(lista, kolone);

		tabela.getColumn("").setPreferredWidth(3);
		tabela.getColumn("Name").setPreferredWidth(200);
		tabela.getColumn("Produced by").setPreferredWidth(100);
		tabela.getColumn("Quantity").setPreferredWidth(100);
		tabela.getColumn("Expire date").setPreferredWidth(100);

		tabela.setGridColor(c1);
		tabela.setFont(f);
		tabela.getTableHeader().setFont(f);
		tabela.getTableHeader().setBackground(c2);

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		tabela.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);

		JScrollPane jsp = new JScrollPane(tabela);
		jsp.setPreferredSize(new Dimension(700, 500));
		panel2.add(jsp, "span");
		panel.add(panel2, "span,gaptop 30, wrap");
		return panel;
	}

	private JPanel createMyEquipmentPanel() {

		JPanel panel = new JPanel(new MigLayout());

		ImageIcon icon = new ImageIcon("./img/myTools.png");
		JLabel naslov = new JLabel("My Equipment");
		naslov.setIcon(icon);
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(naslov, "gapleft 200");

		ImageIcon addIcon = new ImageIcon("./img/add.png");
		JButton dodaj = new JButton("Add equipment", addIcon);
		dodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ovde se poziva funkcija za dodavanje alata
			}
		});
		panel.add(dodaj, "gapleft 50, wrap");

		Font f = new Font("Serif", Font.PLAIN, 15);
		Color c1 = new Color(255, 51, 153);
		Color c2 = new Color(255, 234, 255);
		JPanel panel2 = new JPanel(new MigLayout());
		int brojac = 1;
		String[][] lista = new String[user.getEquipment().size()][5];

		for (Equipment e : user.getEquipment()) {

			lista[brojac - 1][0] = brojac + "";
			lista[brojac - 1][1] = e.getName();
			lista[brojac - 1][2] = e.getCompany();
			lista[brojac - 1][3] = e.getDescription();
			brojac++;

		}
		String[] kolone = { "", "Name", "Produced by", "Description" };
		JTable tabela = new JTable(lista, kolone);

		tabela.getColumn("").setPreferredWidth(3);
		tabela.getColumn("Name").setPreferredWidth(150);
		tabela.getColumn("Produced by").setPreferredWidth(150);
		tabela.getColumn("Description").setPreferredWidth(200);

		tabela.setGridColor(c1);
		tabela.setFont(f);
		tabela.getTableHeader().setFont(f);
		tabela.getTableHeader().setBackground(c2);

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		tabela.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		tabela.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);

		JScrollPane jsp = new JScrollPane(tabela);
		jsp.setPreferredSize(new Dimension(700, 500));
		panel2.add(jsp, "span");
		panel.add(panel2, "span,gaptop 30, wrap");
		return panel;
	}
}
