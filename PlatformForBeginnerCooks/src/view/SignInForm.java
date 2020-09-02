package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ToiToiController;
import model.Akter;
import net.miginfocom.swing.MigLayout;

public class SignInForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToiToiController toiToi;
	private Akter akter = null;

	protected JPanel panel;
	protected JLabel usernameLabel;
	protected JTextField usernameField;
	protected JLabel passwordLabel;
	protected JPasswordField passwordField;
	protected JButton confirm;
	protected JButton cancel;

	public SignInForm(ToiToiController tt) {

		this.toiToi = tt;
		initialize();
	}

	private void initialize() {
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("./img/signin.png").getImage());
		this.setTitle("Sing in");

		panel = new JPanel(new MigLayout("wrap 2", "", ""));

		usernameLabel = new JLabel("Username : ");
		usernameField = new JTextField(30);
		passwordLabel = new JLabel("Password : ");
		passwordField = new JPasswordField(30);
		confirm = new JButton("Confirm");
		cancel = new JButton("Cancel");

		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);

		panel.add(cancel);
		panel.add(confirm);

		this.add(panel);

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmPressed();

			}
		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}

	private void confirmPressed() {
		String username = usernameField.getText();
		String password = passwordField.getText();

		akter = toiToi.checkUser(password, username);

		if (akter == null) {
			JOptionPane.showMessageDialog(null, "The entered information isn correct!", "Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, akter.getUsername() + " , you have been loged in!", "Welcome!",
					JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
	}

	public Akter getAkter() {
		return akter;
	}

	public void setAkter(Akter akter) {
		this.akter = akter;
	}
}
