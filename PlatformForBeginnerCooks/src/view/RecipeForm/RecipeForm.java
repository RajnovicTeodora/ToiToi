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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import controller.ToiToiController;
import model.Equipment;
import model.NeededQuantity;
import model.Recipe;
import net.miginfocom.swing.MigLayout;
import view.ImageFilter;

public class RecipeForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel mainPanel = new JPanel(new MigLayout());
	protected JScrollPane sp = new JScrollPane(mainPanel);

	protected TableRowSorter<AbstractTableModel> tableSorter = new TableRowSorter<AbstractTableModel>();
	protected TableRowSorter<AbstractTableModel> tableSorter2 = new TableRowSorter<AbstractTableModel>();
	
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

	protected JPanel panel_3; // description and tags
	protected TagsList tagsList;

	protected JPanel panel_4;
	protected EquipmentPanel equipmentPanel;
	
	protected JButton confirm = new JButton("Continue");
	protected JButton cancel = new JButton("Cancel");

	private Recipe recipe;
	private ToiToiController toiToiController;

	public RecipeForm(ToiToiController toiToiCntroller) {
		this.toiToiController = toiToiCntroller;
		this.setSize(600, 700);
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
		
		panel_1 = new JPanel(new MigLayout("", "[] 20 []", "[] 10 [] "));
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
		panel_1_2.add(new TasteList());

		panel_1.add(panel_1_2);

		mainPanel.add(panel_1, "wrap");

		// ============PANEL 2=================

		panel_2 = new IngredientsPanel(toiToiController);
		panel_2.setBackground(Color.white);

		mainPanel.add(panel_2, "wrap");

		// ============PANEL 3======================
		panel_3 = new JPanel(new MigLayout());
		panel_3.setBackground(Color.white);
		
		JPanel panel_3_desc = new JPanel(new MigLayout("", "[]20[]", "[]20[]"));

		panel_3_desc.add(textEdit);
		panel_3_desc.setBackground(Color.white);
		
		panel_3.add(panel_3_desc);
		
		JPanel panel_3_tags = new JPanel(new MigLayout());
		panel_3_tags.setBackground(Color.white);
		panel_3_tags.add(new JLabel("Enter serach tags:"), "wrap");
		panel_3_tags.add(new TagsList(), "wrap");

		panel_3.add(panel_3_tags);
		
		mainPanel.add(panel_3, "wrap");
		
		//=============PANEL 4======================
		panel_4 = new JPanel(new MigLayout());
		panel_4.setBackground(Color.white);
		equipmentPanel = new EquipmentPanel(toiToiController);
		panel_4.add(equipmentPanel);
		
		
		JPanel extraInfo = new JPanel(new MigLayout());
		//TODO
		mainPanel.add(panel_4, "wrap");
	}

}
