package view.SignUpForm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

public class AlergieList extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JList<String> alergieList;
	protected JButton buttonIn, buttonOut;
	protected JTextField alergyField = new JTextField(10);
	protected DefaultListModel<String> alergies;

	private ArrayList<String> alergieAL = new ArrayList<String>();

	public AlergieList() {
		setBackground(Color.white);
		setLayout(new MigLayout());
		alergies = new DefaultListModel<String>();

		alergieList = new JList<String>(alergies);
		alergieList.setVisibleRowCount(5);
		alergieList.setFixedCellHeight(20);
		alergieList.setFixedCellWidth(200);
		alergieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane list = new JScrollPane(alergieList);

		// We create the buttons to be placed between the lists.
		JPanel buttonPanel = new JPanel();

		buttonPanel.add(alergyField);
		buttonPanel.setBackground(Color.white);

		buttonIn = new JButton("Add");
		buttonIn.addActionListener(this);
		buttonPanel.add(buttonIn);

		buttonOut = new JButton("Remove");
		buttonOut.addActionListener(this);
		buttonPanel.add(buttonOut);

		add(list, "center, wrap");

		add(buttonPanel);

		setOpaque(true);

	}

	public void actionPerformed(ActionEvent e) {

		int i = 0;
		if (e.getSource() == buttonIn) {
			String alergySelected = alergyField.getText();
			Boolean copy = false;
			for (; i < alergies.size(); i++) {

				if (alergies.get(i).toLowerCase().compareTo(alergySelected.toLowerCase()) == 0) {
					JOptionPane.showMessageDialog(null, "The alery has already been added to the list!", "Error!",
							JOptionPane.ERROR_MESSAGE);
					copy = true;
					break;
				}
			}
			if (!copy) {
				alergieAL.add(alergySelected);
				alergies.addElement(alergySelected);
			}

		}

		else if (e.getSource() == buttonOut) {
			if (alergieList.getSelectedIndex() != -1) {
				int toindex = alergieList.getSelectedIndex();
				alergieAL.remove(alergieList.getSelectedValue());
				alergies.remove(toindex);

			}

		}
	}

	public ArrayList<String> getAlergieAL() {
		return alergieAL;
	}

	public void setAlergieAL(ArrayList<String> alergieAL) {
		this.alergieAL = alergieAL;
	}

}