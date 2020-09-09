package view.RecipeForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

public class TagsList extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JList<String> tagList;
	protected JButton buttonIn, buttonOut;
	protected JTextField tagField = new JTextField(10);
	protected DefaultListModel<String> tags;
	//TODO add private conainer
	
	public TagsList() {
		setLayout(new MigLayout());
		tags = new DefaultListModel<String>();

		tagList = new JList<String>(tags);
		tagList.setVisibleRowCount(5);
		tagList.setFixedCellHeight(20);
		tagList.setFixedCellWidth(220);
		tagList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane list = new JScrollPane(tagList);

		// We create the buttons to be placed between the lists.
		JPanel buttonPanel = new JPanel();

		buttonIn = new JButton("Add");
		buttonIn.addActionListener(this);
		buttonPanel.add(buttonIn);

		buttonOut = new JButton("Remove");
		buttonOut.addActionListener(this);
		buttonPanel.add(buttonOut);

		add(list, "wrap");
		
		JPanel helper = new JPanel();
		helper.add(tagField);
		helper.add(buttonPanel);

		add(helper);
		setOpaque(true);

	}

	public void actionPerformed(ActionEvent e) {

		int i = 0;
		if (e.getSource() == buttonIn) {
			String tagSelected = tagField.getText();
			Boolean copy = false;
			for (; i < tags.size(); i++) {

				if (tags.get(i).toLowerCase().compareTo(tagSelected.toLowerCase()) == 0) {
					JOptionPane.showMessageDialog(null, "The tag has already been added to the list!", "Error!",
							JOptionPane.ERROR_MESSAGE);
					copy = true;
					break;
				}
			}
			if (!copy) {

				tags.addElement(tagSelected);
			}

		}

		else if (e.getSource() == buttonOut) {
			if (tagList.getSelectedIndex() != -1) {
				int toindex = tagList.getSelectedIndex();

				tags.remove(toindex);

			}

		}
	}
}
