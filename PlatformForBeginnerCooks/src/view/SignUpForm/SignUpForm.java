package view.SignUpForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
	private JPanel mainPanel;
	private SignUpStepOne stepOne;
	private SignUpStepTwo stepTwo;

	protected JPanel panel_buttons;
	protected JButton confirm = new JButton("Continue");
	protected JButton cancel = new JButton("Cancel");

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

		getContentPane().setBackground(Color.WHITE);
		run();

	}

	public void run() {
		mainPanel = new JPanel(new MigLayout());
		mainPanel.setBackground(Color.white);
		JScrollPane sp = new JScrollPane(mainPanel);
		add(sp);

		stepOne = new SignUpStepOne(toiToiController);
		stepTwo = new SignUpStepTwo(toiToiController);

		mainPanel.add(stepOne, "center, top, wrap");

		JSeparator sep1 = new JSeparator();
		sep1.setOrientation(SwingConstants.HORIZONTAL);
		sep1.setBackground(Color.cyan);
		sep1.setPreferredSize(new Dimension(690, 5));
		mainPanel.add(sep1, "wrap");

		mainPanel.add(new JLabel("To customize your search we offer you some optional fields..."), "wrap");
		mainPanel.add(new JLabel(), "wrap");
		mainPanel.add(stepTwo, "wrap");

		JPanel buttons = new JPanel();
		buttons.add(confirm);
		buttons.add(cancel);
		buttons.setBackground(Color.white);

		mainPanel.add(buttons, "bottom, right");

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirm();
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
	}

	public void confirm() {
		stepOne.confirmPressed();
		stepTwo.confirmPressed();
		newUser = stepOne.getUser();

		if (newUser != null) {

			newUser.setAlergies(stepTwo.getAlergies());
			newUser.setEquipment(stepTwo.getEquipment());
			newUser.setGrocerie(stepTwo.getProducts());
			toiToiController.getToiToi().addUsers(newUser);
			//System.out.println(toiToiController.getToiToi().getUsers());
			dispose();
		}
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

}
