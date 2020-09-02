package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ToiToiController;
import model.User;
import net.miginfocom.swing.MigLayout;

public class SignUpForm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToiToiController toiToiController;
	private User newUser = null;

	protected JPanel panel_1;
	protected JTextField nameField;
	protected JTextField surnameField;
	protected JTextField usernameField;
	protected JPasswordField passwordField;
	protected JTextField addressField;
	protected JTextField telephoneField;
	protected JTextField emailField;

	UtilDateModel model;
	JDatePanelImpl panel1;
	protected JDatePickerImpl date;

	protected JButton confirm;
	protected JButton cancel;

	protected JPanel ingredientPanel;

	protected JPanel equipmentPanel;

	protected JPanel alergiesPanel;

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

		initialize();
	}

	private void initialize() {

		panel_1 = new JPanel(new MigLayout("wrap 4", "[] 5 [] [] 5 []", ""));

		JLabel nameLabel = new JLabel("Name : ");
		nameField = new JTextField(20);
		nameField.setToolTipText("Enter name");
		panel_1.add(nameLabel, "cell 0 0");
		panel_1.add(nameField, "cell 1 0");

		JLabel surnameLabel = new JLabel("Surname :");
		surnameField = new JTextField(20);
		surnameField.setToolTipText("Enter surname");
		panel_1.add(surnameLabel, "cell 2 0");
		panel_1.add(surnameField, "cell 3 0");

		JLabel usernameLabel = new JLabel("Username :");
		usernameField = new JTextField(20);
		usernameField.setToolTipText("Enter username");
		panel_1.add(usernameLabel, "cell 0 1");
		panel_1.add(usernameField, "cell 1 1");

		JLabel passwordLabel = new JLabel("Password :");
		passwordField = new JPasswordField(20);
		passwordField.setToolTipText("Enter password");
		panel_1.add(passwordLabel, "cell 2 1");
		panel_1.add(passwordField, "cell 3 1");

		JLabel addressLabel = new JLabel("Address :");
		addressField = new JTextField(40);
		addressField.setToolTipText("Enter address");
		panel_1.add(addressLabel, "cell 0 2");
		panel_1.add(addressField, "cell 1 2");

		JLabel telephoneLabel = new JLabel("Telephone :");
		telephoneField = new JTextField(40);
		telephoneField.setToolTipText("Enter telephone");
		panel_1.add(telephoneLabel, "cell 0 3");
		panel_1.add(telephoneField, "cell 1 3");

		JLabel emailLabel = new JLabel("Email :");
		emailField = new JTextField(40);
		emailField.setToolTipText("Enter email");
		panel_1.add(emailLabel, "cell 0 4");
		panel_1.add(emailField, "cell 1 4");

		JLabel dat = new JLabel("Birthday :");
		Properties prop = new Properties();
		prop.put("text.today", "Today");
		prop.put("text.month", "Month");
		prop.put("text.year", "Year");

		model = new UtilDateModel();
		panel1 = new JDatePanelImpl(model, prop);
		date = new JDatePickerImpl(panel1, new DataLabelFormatter());
		panel_1.add(dat);
		panel_1.add(date, "span 3");

		this.add(panel_1);

		confirm = new JButton("Confirm");
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

		panel_1.add(confirm);
		panel_1.add(cancel);
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
				setNewUser(toiToiController.createUser(name, surname, password, username, email, telephone, address,
						birthday));
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					panel_1.setVisible(false);
					pickIngredients();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);

			}
		} else {
			JOptionPane.showMessageDialog(null, "The birthday wasnt selected!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void pickIngredients() {

	}

	private void pickAlergies() {

	}

	private void pickEquipment() {

	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

}
