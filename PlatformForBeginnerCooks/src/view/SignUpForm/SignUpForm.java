package view.SignUpForm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import TableModel.IngredientsFormTable;
import TableModel.JTableButtonMouseListener;
import TableModel.JTableButtonRenderer;
import controller.ToiToiController;
import model.Product;
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
		// TODO
		newUser = stepOne.getUser();
		if (newUser != null) {

			// newUser.setAlergies(stepTwo.getAlergies());
			newUser.setEquipment(stepTwo.getEquipment());
			toiToiController.getToiToi().addUsers(newUser);
			System.out.println(toiToiController.getToiToi().getUsers());
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
