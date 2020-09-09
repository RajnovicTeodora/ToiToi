package view.SignUpForm;

import java.awt.Color;

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
		JScrollPane sp = new JScrollPane(mainPanel);
		add(sp);
		
		stepOne = new SignUpStepOne(toiToiController);
		stepTwo = new SignUpStepTwo(toiToiController);

		mainPanel.add(stepOne, "wrap");
		mainPanel.add(stepTwo);


	}
	public void confirm() {
		stepOne.confirmPressed();
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

}
