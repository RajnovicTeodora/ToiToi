package view.RecipeForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

	protected JPanel panel_1;
	protected JTextField titleField;
	protected TextEdit textEdit = new TextEdit();
	private BufferedImage image = null;
	private ImageIcon icon = null;
	private File file = null;

	protected JPanel panel_2;
	protected TasteList tasteList;
	protected TagsList tagsList;

	protected JPanel panel_4;
	protected JButton confirm = new JButton("Continue");
	protected JButton cancel = new JButton("Cancel");

	private Recipe recipe;
	private ToiToiController toiToiController;

	public RecipeForm(ToiToiController toiToiCntroller) {
		this.toiToiController = toiToiCntroller;

		setLocationRelativeTo(null);
		setSize(600, 600);
		setVisible(true);
		add(sp);
		makePanel1();

	}

	private void makePanel1() {

		panel_1 = new JPanel(new MigLayout("", "[] 20 []", "[] 10 [] "));
		panel_1.setBackground(Color.CYAN); // TODO

		// =========IMAGE (TOP LEFT) PANEL=========================
		JPanel panel_1_img = new JPanel(new MigLayout("", "20[][]20", "20[][]20"));
		panel_1_img.setBackground(Color.WHITE);

		Image dimg1 = new ImageIcon("img/addimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg1);
		JButton buttonAdd = new JButton(addIcon);
		buttonAdd.setContentAreaFilled(false);
		// buttonAdd.setFocusPainted(false);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setToolTipText("Add recipe picture");

		Image dimg2 = new ImageIcon("img/removeimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon removeIcon = new ImageIcon(dimg2);
		JButton buttonRemove = new JButton(removeIcon);
		buttonRemove.setContentAreaFilled(false);
		// buttonRemove.setFocusPainted(false);
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

		JPanel panel_1_1 = new JPanel(new MigLayout());
		panel_1_1.setBackground(Color.WHITE);

		JLabel nameLabel = new JLabel("Recipe name: ");
		titleField = new JTextField(20);
		titleField.setToolTipText("Enter name");
		titleField.setBackground(new Color(192, 229, 227));

		panel_1_1.add(nameLabel);
		panel_1_1.add(titleField, "wrap");

		JPanel panel_1_desc = new JPanel(new MigLayout("", "", "[]20[]5[]"));

		panel_1_desc.add(panel_1_1, "wrap");
		panel_1_desc.add(new JLabel("Description:"), "wrap");
		panel_1_desc.add(textEdit, "wrap");
		panel_1_desc.setBackground(Color.white);

		panel_1.add(panel_1_desc);

		mainPanel.add(panel_1, "wrap");

		// ============PANEL 2=================

		panel_2 = new JPanel(new MigLayout("", "[]30[]", ""));
		panel_2.add(new TasteList());
		panel_2.add(new TagsList(), "wrap");

		mainPanel.add(panel_2);

	}
	
}
