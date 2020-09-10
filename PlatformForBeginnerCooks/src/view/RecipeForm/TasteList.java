package view.RecipeForm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Taste;
import net.miginfocom.swing.MigLayout;

public class TasteList extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JList<String> tasteList;
	protected JButton buttonIn, buttonOut;
	protected JComboBox<String> tasteBox;
	protected DefaultListModel<String> tastes;
	// TODO add private conainer

	public TasteList() {
		setLayout(new MigLayout());
		setBackground(Color.white);
		
		tastes = new DefaultListModel<String>();

		tasteList = new JList<String>(tastes);
		tasteList.setVisibleRowCount(7);
		tasteList.setFixedCellHeight(20);
		tasteList.setFixedCellWidth(180);
		tasteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane list = new JScrollPane(tasteList);

		// We create the buttons to be placed between the lists.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		
		buttonIn = new JButton("Add");
		buttonIn.addActionListener(this);
		buttonPanel.add(buttonIn);

		buttonOut = new JButton("Remove");
		buttonOut.addActionListener(this);
		buttonPanel.add(buttonOut);

		String[] taste = new String[Taste.values().length];
		int i = 0;
		for (Taste t : Taste.values()) {
			taste[i] = t.toString();
			i++;
		}
		tasteBox = new JComboBox<String>(taste);

		add(list, "wrap");
		JPanel helper = new JPanel();
		helper.add(tasteBox);
		helper.add(buttonPanel);
		helper.setBackground(Color.white);
		add(helper);

		setOpaque(true);

	}

	public void actionPerformed(ActionEvent e) {

		int i = 0;
		if (e.getSource() == buttonIn) {
			String alergySelected = (String) tasteBox.getSelectedItem();
			Boolean copy = false;
			for (; i < tastes.size(); i++) {

				if (tastes.get(i).toLowerCase().compareTo(alergySelected.toLowerCase()) == 0) {
					JOptionPane.showMessageDialog(null, "The taste has already been added to the list!", "Error!",
							JOptionPane.ERROR_MESSAGE);
					copy = true;
					break;
				}
			}
			if (!copy) {

				tastes.addElement(alergySelected);
			}

		}

		else if (e.getSource() == buttonOut) {
			if (tasteList.getSelectedIndex() != -1) {
				int toindex = tasteList.getSelectedIndex();

				tastes.remove(toindex);

			}

		}
	}
}