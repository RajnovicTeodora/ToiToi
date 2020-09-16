package view.CookBookForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.ToiToiController;
import model.Comment;
import model.CookBook;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.ImageFilter;
import view.RecipeForm.TextEdit;

public class CookBookForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel mainPanel = new JPanel(new MigLayout());

	protected JPanel panel_1;

	protected JPanel panel_1_img;
	protected JTextField titleField;
	protected TextEdit textEdit = new TextEdit();
	private BufferedImage image = null;
	private ImageIcon icon = null;
	private File file = null;
	protected ArrayList<SingleRecipePanel> presentRecipes;

	private ArrayList<Recipe> recipes;
	private ToiToiController toiToiController;
	private User user;
	private CookBook cookBook = null;

	public CookBookForm(ToiToiController toiToiCntroller, User user) {

		this.setToiToiController(toiToiCntroller);
		this.setUser(user);
		this.setSize(780, 550);
		this.setTitle("Create CookBook");
		this.setIconImage(new ImageIcon("img/cookbook.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		getContentPane().setBackground(Color.WHITE);

		mainPanel.setBackground(Color.white);
		add(mainPanel);
		setVisible(true);

		panel_1 = new JPanel(new MigLayout("", "[] 30 []", "[] 10 [] "));
		panel_1.setBackground(Color.white);

		// =========IMAGE (TOP LEFT) PANEL=========================
		panel_1_img = new JPanel(new MigLayout("", "10[][]10", "10[][]"));
		panel_1_img.setBackground(Color.WHITE);

		Image dimg1 = new ImageIcon("img/addimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg1);
		JButton buttonAdd = new JButton(addIcon);
		buttonAdd.setContentAreaFilled(false);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setToolTipText("Add cookbook picture");

		Image dimg2 = new ImageIcon("img/removeimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon removeIcon = new ImageIcon(dimg2);
		JButton buttonRemove = new JButton(removeIcon);
		buttonRemove.setContentAreaFilled(false);
		buttonRemove.setBorderPainted(false);
		buttonRemove.setToolTipText("Remove cookbook picture");

		JPanel image_panel = new JPanel();
		image_panel.setPreferredSize(new Dimension(220, 220));

		Border border = BorderFactory.createTitledBorder("CookBook picture");
		image_panel.setBorder(border);
		image_panel.setBackground(Color.WHITE);

		Image dimg3 = new ImageIcon("img/profile.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon profileIcon = new ImageIcon(dimg3);

		JLabel label = new JLabel();
		label.setIcon(profileIcon);
		image_panel.add(label);

		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);

				int option = fileChooser.showOpenDialog(panel_1_img);

				if (option == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();

					try {
						if (file.exists()) {
							image = ImageIO.read(file);
							Image dimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
							icon = new ImageIcon(dimg);
							label.setIcon(icon);
						} else {
							JOptionPane.showMessageDialog(null, "No image was found!", "Error!",
									JOptionPane.ERROR_MESSAGE);

						}
					} catch (IOException ex) {

						ex.printStackTrace();
					}
				} else {
					label.setIcon(profileIcon);
				}
			}
		});

		buttonRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				image = null;
				icon = null;
				file = null;
				label.setIcon(profileIcon);
			}
		});

		panel_1_img.add(image_panel, "north");
		panel_1_img.add(buttonAdd, "center, left");
		panel_1_img.add(buttonRemove, "center, right");

		panel_1.add(panel_1_img, "top, center, wrap");

		JLabel nameLabel = new JLabel("CookBook name: ");
		titleField = new JTextField(18);
		titleField.setToolTipText("Enter name : ");
		titleField.setBackground(new Color(192, 229, 227));

		JPanel namePanel = new JPanel(new MigLayout());
		namePanel.add(nameLabel, "center, wrap");
		namePanel.add(titleField, "wrap");
		namePanel.setBackground(Color.white);

		panel_1.add(namePanel);
		mainPanel.add(panel_1);

		JPanel panel_1_2 = new JPanel(new MigLayout("", "", ""));
		panel_1_2.setBackground(Color.WHITE);

		try {
			panel_1_2.add(bottomPanel(user.getRecipes()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		mainPanel.add(panel_1_2, "wrap");

		JPanel bottom = new JPanel();
		JButton confirm = new JButton("Confirm");
		JButton cancel = new JButton("Cancel");

		bottom.add(cancel);
		bottom.add(confirm);

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmPressed();
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "All made progress will be lost.",
						"Are you sure you want to cancel?", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION)
					dispose();
			}
		});

		bottom.setBackground(Color.white);
		mainPanel.add(bottom);
	}

	public void confirmPressed() {
		if (image == null) {
			JOptionPane.showMessageDialog(null, "CookBook image is mandatory!", "Error!", JOptionPane.ERROR_MESSAGE);
		} else {

			String code = imageCode();
			while (!writeImg(code)) {
				code = imageCode();
			}
			String name = titleField.getText();
			for (CookBook cb : user.getCookBooks()) {
				if (cb.getName().toLowerCase().compareTo(name.toLowerCase()) == 0) {
					JOptionPane.showMessageDialog(null, "A CookBook with this name already exists in your CookBooks!",
							"Error!", JOptionPane.ERROR_MESSAGE);
				} else if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "CookBook name is mandatory!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					recipes = new ArrayList<Recipe>();
					for (SingleRecipePanel srp : presentRecipes) {
						if (srp.confirm()) {
							recipes.add(srp.getRecipe());
						}
					}
					cookBook = new CookBook(name, code, LocalDate.now(), 0, new ArrayList<Comment>(), recipes, user);
					dispose();
				}
			}
		}

	}

	public Boolean writeImg(String code) {
		BufferedImage bi = image;
		File outputfile = new File(code);
		try {
			ImageIO.write(bi, "png", outputfile);
			return true;

		} catch (IOException e) {
			return false;
		}
	}

	protected String imageCode() {
		Random r = new Random();
		int i = 100000 + r.nextInt(900000);

		return "data/RecipeImage/" + i + ".png";
	}

	public JScrollPane bottomPanel(ArrayList<Recipe> recipes) throws IOException {
		JPanel bottomPnl = new JPanel(new MigLayout());
		presentRecipes = new ArrayList<SingleRecipePanel>();

		for (Recipe recipe : recipes) {
			SingleRecipePanel tempPnl = new SingleRecipePanel(recipe);
			presentRecipes.add(tempPnl);
			bottomPnl.add(tempPnl, "wrap");

		}

		// bottomPnl.setBackground(new Color(0, 0, 0, 10));//new Color(10, 0, 0, 20)
		JScrollPane scrollPane = new JScrollPane(bottomPnl);
		scrollPane.setPreferredSize(new Dimension(600, 600));

		return scrollPane;
	}

	public ToiToiController getToiToiController() {
		return toiToiController;
	}

	public void setToiToiController(ToiToiController toiToiController) {
		this.toiToiController = toiToiController;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public CookBook getCookBook() {
		return cookBook;
	}

	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}

}
