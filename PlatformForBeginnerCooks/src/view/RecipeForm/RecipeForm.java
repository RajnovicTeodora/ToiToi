package view.RecipeForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import controller.ToiToiController;
import model.Comment;
import model.Equipment;
import model.NeededQuantity;
import model.Recipe;
import model.Tag;
import model.Taste;
import net.miginfocom.swing.MigLayout;
import view.ImageFilter;

public class RecipeForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel mainPanel = new JPanel(new MigLayout());
	protected JScrollPane sp = new JScrollPane(mainPanel);

	protected JPanel panel_1;

	protected JPanel panel_1_img;
	protected JTextField titleField;
	protected TextEdit textEdit = new TextEdit();
	private BufferedImage image = null;
	private ImageIcon icon = null;
	private File file = null;

	protected JPanel panel_1_2; // top, right
	protected TasteList tasteList;

	protected JPanel panel_2; // ingredient table
	protected IngredientsPanel ingredientsPanel;

	protected JPanel panel_3; // description and tags
	protected TagsList tagsList;

	protected JPanel panel_4;
	protected EquipmentPanel equipmentPanel;

	protected JPanel panel_5;
	protected JButton confirm = new JButton("Continue");
	protected JButton cancel = new JButton("Cancel");

	private Recipe recipe = null;
	private ToiToiController toiToiController;

	public RecipeForm(ToiToiController toiToiCntroller) {

		this.toiToiController = toiToiCntroller;
		this.setSize(640, 700);
		this.setTitle("Create recipe");
		this.setIconImage(new ImageIcon("img/create-new.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		getContentPane().setBackground(Color.WHITE);

		setVisible(true);
		add(sp);
		makePanel1();

	}

	private void makePanel1() {

		mainPanel.setBackground(Color.WHITE);

		panel_1 = new JPanel(new MigLayout("", "[] 50 []", "[] 10 [] "));
		panel_1.setBackground(Color.white);

		// =========IMAGE (TOP LEFT) PANEL=========================
		panel_1_img = new JPanel(new MigLayout("", "20[][]20", "20[][]20"));
		panel_1_img.setBackground(Color.WHITE);

		Image dimg1 = new ImageIcon("img/addimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg1);
		JButton buttonAdd = new JButton(addIcon);
		buttonAdd.setContentAreaFilled(false);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setToolTipText("Add recipe picture");

		Image dimg2 = new ImageIcon("img/removeimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon removeIcon = new ImageIcon(dimg2);
		JButton buttonRemove = new JButton(removeIcon);
		buttonRemove.setContentAreaFilled(false);
		buttonRemove.setBorderPainted(false);
		buttonRemove.setToolTipText("Remove recipe picture");

		JPanel image_panel = new JPanel();
		image_panel.setPreferredSize(new Dimension(220, 220));

		Border border = BorderFactory.createTitledBorder("Recipe picture");
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

		panel_1.add(panel_1_img, "top, left");
		// ==========TOP RIGHT INFORMATION=========================

		panel_1_2 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel_1_2.setBackground(Color.WHITE);

		JLabel nameLabel = new JLabel("Recipe name: ");
		titleField = new JTextField(16);
		titleField.setToolTipText("Enter name");
		titleField.setBackground(new Color(192, 229, 227));

		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(titleField, "wrap");
		namePanel.setBackground(Color.white);

		panel_1_2.add(namePanel, "wrap");
		panel_1_2.setBackground(Color.white);
		panel_1_2.add(new JLabel("Select taste profiles:"), "wrap");
		tasteList = new TasteList();

		panel_1_2.add(tasteList, "center");

		panel_1.add(panel_1_2);

		mainPanel.add(panel_1, "wrap");

		// ============PANEL 2=================

		JSeparator sep1 = new JSeparator();
		sep1.setOrientation(SwingConstants.HORIZONTAL);
		sep1.setBackground(Color.pink);
		sep1.setPreferredSize(new Dimension(600, 5));
		mainPanel.add(sep1, "wrap");

		ingredientsPanel = new IngredientsPanel(toiToiController);
		ingredientsPanel.setBackground(new Color(255, 233, 248));

		JPanel temp = new JPanel(new MigLayout());
		temp.add(ingredientsPanel);
		temp.setBackground(new Color(255, 233, 248));

		panel_2 = new JPanel(new MigLayout("", " 30[]", ""));
		panel_2.add(temp);
		panel_2.setBackground(new Color(255, 233, 248));
		panel_2.setPreferredSize(new Dimension(600, 200));

		mainPanel.add(panel_2, "wrap");

		// ============PANEL 3======================
		JSeparator sep2 = new JSeparator();
		sep2.setOrientation(SwingConstants.HORIZONTAL);
		sep2.setBackground(Color.pink);
		sep2.setPreferredSize(new Dimension(600, 5));
		mainPanel.add(sep2, "wrap");

		panel_3 = new JPanel(new MigLayout());
		panel_3.setBackground(Color.white);

		JSeparator sep2_1 = new JSeparator();
		sep2_1.setOrientation(SwingConstants.VERTICAL);
		sep2_1.setBackground(Color.pink);
		sep2_1.setPreferredSize(new Dimension(5, 250));
		mainPanel.add(sep2_1, "wrap");

		JPanel panel_3_desc = new JPanel(new MigLayout("", "[]10[]10[]", "[]30[]"));

		panel_3_desc.add(textEdit);
		panel_3_desc.setBackground(Color.white);

		panel_3.add(panel_3_desc);

		panel_3.add(sep2_1);

		JPanel panel_3_tags = new JPanel(new MigLayout());
		panel_3_tags.setBackground(Color.white);
		panel_3_tags.add(new JLabel("Enter serach tags:"), "wrap");
		tagsList = new TagsList();
		panel_3_tags.add(tagsList, "wrap");

		panel_3.add(panel_3_tags);

		mainPanel.add(panel_3, "wrap");

		// =============PANEL 4======================
		JSeparator sep3 = new JSeparator();
		sep3.setOrientation(SwingConstants.HORIZONTAL);
		sep3.setBackground(Color.pink);
		sep3.setPreferredSize(new Dimension(600, 5));
		mainPanel.add(sep3, "wrap");

		panel_4 = new JPanel(new MigLayout("", " 30[]", ""));
		panel_4.setBackground(new Color(255, 233, 248));
		panel_4.setPreferredSize(new Dimension(600, 200));

		equipmentPanel = new EquipmentPanel(toiToiController);
		equipmentPanel.setBackground(new Color(255, 233, 248));

		panel_4.add(equipmentPanel);
		mainPanel.add(panel_4, "wrap");
		// ==============PANEL 5==========================
		JSeparator sep4 = new JSeparator();
		sep4.setOrientation(SwingConstants.HORIZONTAL);
		sep4.setBackground(Color.pink);
		sep4.setPreferredSize(new Dimension(600, 5));
		mainPanel.add(sep4, "wrap");

		panel_5 = new JPanel(new MigLayout());

		JPanel extraInfo = new JPanel(new MigLayout());
		// TODO

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
		panel_5.add(confirm);
		panel_5.add(cancel);

		mainPanel.add(panel_5);
	}

	public void confirmPressed() {
		String name = titleField.getText();
		String description = textEdit.confirm();
		ArrayList<Tag> tags = tagsList.confirm();
		ArrayList<Taste> taste = tasteList.confirm();
		ArrayList<Equipment> equipment = equipmentPanel.confirm();
		ArrayList<NeededQuantity> neededProductQuantity = ingredientsPanel.confirm();

		if (image == null) {
			JOptionPane.showMessageDialog(null, "Recipe image is mandatory!", "Error!", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				recipe = toiToiController.getRecipeController().makeRecipe(name, description, tags, taste, equipment,
						neededProductQuantity);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
				recipe = null;
			}

			if (recipe != null) {
				String code = imageCode();
				while (!writeImg(code)) {
					code = imageCode();
				}
				int id = toiToiController.getRecipeController()
						.findRecipieID((ArrayList<Recipe>) toiToiController.getToiToi().getRecipe());

				recipe.setRecipeID(id);
				recipe.setImage(code);
				toiToiController.getToiToi().addRecipe(recipe);
				System.out.println(toiToiController.getToiToi().getRecipe());
				dispose();
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

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	protected String imageCode() {
		Random r = new Random();
		int i = 100000 + r.nextInt(900000);

		return "data/RecipeImage/" + i + ".png";
	}
}
