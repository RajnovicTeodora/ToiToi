package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ToiToiController;
import model.User;
import net.miginfocom.swing.MigLayout;

public class SignUpForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToiToiController toiToiController;
	private User newUser = null;

	protected JScrollPane scrollPane;

	protected JPanel panel_1;
	protected JTextField nameField;
	protected JTextField surnameField;
	protected JTextField usernameField;
	protected JPasswordField passwordField;
	protected JComboBox genderBox;

	protected JPanel panel_2;
	protected JTextField addressField;
	protected JTextField telephoneField;
	protected JTextField emailField;

	UtilDateModel model;
	JDatePanelImpl panel_2_date;
	protected JDatePickerImpl date;

	protected JPanel panel_4;
	protected JButton confirm;
	protected JButton cancel;

	protected JPanel informationPanel;
	protected JPanel ingredientPanel;
	protected JPanel equipmentPanel;
	protected JPanel alergiesPanel;

	// FOR IMAGE
	private BufferedImage image = null;
	private ImageIcon icon = null;
	private File file = null;

	public SignUpForm(ToiToiController toiToi) {
		this.toiToiController = toiToi;
		signupFrame();

	}

	private void signupFrame() {

		this.setSize(700, 700);
		this.setTitle("Sign up");
		this.setIconImage(new ImageIcon("img/signup.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		// this.setLayout(new MigLayout());

		getContentPane().setBackground(Color.WHITE);
		initialize();

	}

	private void initialize() {
		informationPanel = new JPanel(new MigLayout());
		informationPanel.setBackground(Color.WHITE);

		panel_1 = new JPanel(new MigLayout("", "[] 20 []", " "));
		panel_1.setBackground(Color.WHITE);
		// =========IMAGE (TOP LEFT) PANEL=========================
		JPanel panel_1_img = new JPanel(new MigLayout("", "20[][]20", "20[][]20"));
		panel_1_img.setBackground(Color.WHITE);

		Image dimg1 = new ImageIcon("img/addimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg1);
		JButton buttonAdd = new JButton(addIcon);
		buttonAdd.setContentAreaFilled(false);
		// buttonAdd.setFocusPainted(false);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setToolTipText("Add profile picture");

		Image dimg2 = new ImageIcon("img/removeimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon removeIcon = new ImageIcon(dimg2);
		JButton buttonRemove = new JButton(removeIcon);
		buttonRemove.setContentAreaFilled(false);
		// buttonRemove.setFocusPainted(false);
		buttonRemove.setBorderPainted(false);
		buttonRemove.setToolTipText("Remove profile picture");

		JPanel image_panel = new JPanel();
		image_panel.setPreferredSize(new Dimension(220, 220));

		Border border = BorderFactory.createTitledBorder("Profile picture");
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
				label.setIcon(profileIcon);
			}
		});

		panel_1_img.add(image_panel, "north");
		panel_1_img.add(buttonAdd, "center, left");
		panel_1_img.add(buttonRemove, "center, right");

		panel_1.add(panel_1_img, "top, left");
		// ==========TOP RIGHT INFORMATION=========================

		JPanel panel_1_1 = new JPanel(new MigLayout("", "", "[]30[]30[]30[]"));
		panel_1_1.setBackground(Color.WHITE);

		JLabel nameLabel = new JLabel("Name : ");
		nameField = new JTextField(20);
		nameField.setToolTipText("Enter name");
		nameField.setBackground(new Color(192, 229, 227));

		panel_1_1.add(nameLabel, "cell 0 0");
		panel_1_1.add(nameField, "cell 1 0");

		JLabel surnameLabel = new JLabel("Surname :");
		surnameField = new JTextField(20);
		surnameField.setToolTipText("Enter surname");
		surnameField.setBackground(new Color(192, 229, 227));

		panel_1_1.add(surnameLabel, "cell 0 1");
		panel_1_1.add(surnameField, "cell 1 1");

		JLabel usernameLabel = new JLabel("Username :");
		usernameField = new JTextField(20);
		usernameField.setToolTipText("Enter username");
		usernameField.setBackground(new Color(192, 229, 227));

		panel_1_1.add(usernameLabel, "cell 0 2");
		panel_1_1.add(usernameField, "cell 1 2");

		JLabel passwordLabel = new JLabel("Password :");
		passwordField = new JPasswordField(20);
		passwordField.setToolTipText("Enter password");
		passwordField.setBackground(new Color(192, 229, 227));
		panel_1_1.add(passwordLabel, "cell 0 3");
		panel_1_1.add(passwordField, "cell 1 3");

		JLabel genderLabel = new JLabel("Gender :");
		String[] gender = { "Female", "Male", "Other" };
		genderBox = new JComboBox<String>(gender);
		panel_1_1.add(genderLabel, "cell 0 4");
		panel_1_1.add(genderBox, "cell 1 4");

		panel_1.add(panel_1_1, "east");

		// ==============MIDLE PANEL=================
		panel_2 = new JPanel(new MigLayout("", "", "[]10[]10[]10[]10[]"));
		panel_2.setBackground(Color.WHITE);

		JLabel addressLabel = new JLabel("Address :");
		addressField = new JTextField(40);
		addressField.setToolTipText("Enter address");
		addressField.setBackground(new Color(192, 229, 227));

		panel_2.add(addressLabel, "cell 0 0");
		panel_2.add(addressField, "cell 1 0");

		JLabel telephoneLabel = new JLabel("Telephone :");
		telephoneField = new JTextField(40);
		telephoneField.setToolTipText("Enter telephone");
		telephoneField.setBackground(new Color(192, 229, 227));

		panel_2.add(telephoneLabel, "cell 0 1");
		panel_2.add(telephoneField, "cell 1 1");

		JLabel emailLabel = new JLabel("Email :");
		emailField = new JTextField(40);
		emailField.setToolTipText("Enter email");
		emailField.setBackground(new Color(192, 229, 227));

		panel_2.add(emailLabel, "cell 0 2");
		panel_2.add(emailField, "cell 1 2");

		JLabel dat = new JLabel("Birthday :");
		Properties prop = new Properties();
		prop.put("text.today", "Today");
		prop.put("text.month", "Month");
		prop.put("text.year", "Year");

		model = new UtilDateModel();
		panel_2_date = new JDatePanelImpl(model, prop);
		panel_2_date.setBackground(new Color(192, 229, 227));

		date = new JDatePickerImpl(panel_2_date, new DataLabelFormatter());
		date.setBackground(new Color(192, 229, 227));
		// 229, 191, 193
		panel_2.add(dat, "cell 0 3");
		panel_2.add(date, "cell 1 3");

		// =========================================

		confirm = new JButton("Continue");

		cancel = new JButton("Cancel");

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				confirmPressed();

			}
		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		panel_4 = new JPanel(new MigLayout());
		panel_4.setBackground(Color.WHITE);

		panel_4.add(confirm);
		panel_4.add(cancel);

		informationPanel.add(panel_1, "top, right, wrap");
		informationPanel.add(panel_2, "center, wrap");
		informationPanel.add(panel_4, "bottom");
		add(informationPanel);
	}

	private void confirmPressed() {

		String username = usernameField.getText();
		String password = passwordField.getText();
		String name = nameField.getText();
		String surname = surnameField.getText();
		String telephone = telephoneField.getText();
		String address = addressField.getText();
		String email = emailField.getText();
		LocalDate birthday = null;

		int day = model.getDay();
		int month = model.getMonth() + 1;
		int year = model.getYear();

		String gender = (String) genderBox.getSelectedItem();
		if (model.isSelected()) {

			String date;
			if (day < 10 && month < 10)
				date = "0" + day + "-" + "0" + month + "-" + year;
			else if (day < 10) {
				date = "0" + day + "-" + month + "-" + year;
			} else if (month < 10)
				date = day + "-" + "0" + month + "-" + year;

			else
				date = day + "," + month + "," + year;

			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			birthday = LocalDate.parse(date, format);

			try {
				setNewUser(toiToiController.createUser(name, surname, password, username, email, gender, telephone,
						address, birthday));
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue to the next step?", "Confirm",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					panel_1.setVisible(false);
					informationPanel.setVisible(false);
					myFridge();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);

			}

		} else {
			JOptionPane.showMessageDialog(null, "Not all field were selected!", "Error!", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void myFridge() {

	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

}
