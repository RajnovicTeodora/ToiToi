package view.RecipeForm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MyRecipeProductDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JFormattedTextField quantField;
	protected JCheckBox check;
	protected JCheckBox essentialCheck;
	protected JButton ok;
	protected JButton cancel;

	// entered data
	private Double value;
	private Boolean essential;
	private Boolean checked;

	public MyRecipeProductDialog(Double v, Boolean e, Boolean c) {
		value = v;
		checked = c;
		essential = e;

		this.setSize(370, 230);
		this.setTitle("Edit row");
		this.setIconImage(new ImageIcon("img/editrow.png").getImage());
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		setLayout(new MigLayout());

		getContentPane().setBackground(Color.WHITE);

		JLabel quantity = new JLabel("Quantity : ");
		quantField = new JFormattedTextField(new DecimalFormat());
		quantField.setColumns(10);
		quantField.setValue(value);

		JLabel inFridge = new JLabel("inMyFridge : ");
		check = new JCheckBox();
		check.setSelected(checked);
		check.setBackground(Color.WHITE);

		JLabel ess = new JLabel("Essential ingredient : ");
		essentialCheck = new JCheckBox();
		essentialCheck.setSelected(checked);
		essentialCheck.setBackground(Color.WHITE);

		JLabel notice = new JLabel("*no changes will be saved if the checkbox isnt selected");

		JPanel p1 = new JPanel(new MigLayout("", "[]20[]", ""));
		p1.add(quantity);
		p1.add(quantField, "wrap");
		p1.setBackground(Color.WHITE);

		JPanel p2 = new JPanel(new MigLayout());
		p2.add(ess);
		p2.add(essentialCheck, "wrap");
		p2.setBackground(Color.WHITE);

		JPanel p3 = new JPanel(new MigLayout("", "[]18[]", ""));
		p3.add(inFridge);
		p3.add(check, "wrap");
		p3.setBackground(Color.WHITE);

		add(p1, "wrap");
		add(p2, "wrap");
		add(p3, "wrap");
		add(notice, "wrap");
		ok = new JButton("Confirm");

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (check.isSelected()) {
					if (quantField.getText().compareTo("") == 0) {
						value = 0.0;
					} else {
						value = Double.parseDouble(quantField.getText());

					}
					if (essentialCheck.isSelected())
						essential = true;
					else {
						essential = false;
					}
					checked = true;

				} else {
					essential = false;
					value = 0.0;
					checked = false;
				}
				dispose();
			}
		});
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JPanel p4 = new JPanel(new MigLayout());
		p4.add(ok);
		p4.add(cancel);
		p4.setBackground(Color.WHITE);

		add(p4);
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getEssential() {
		return essential;
	}

	public void setEssential(Boolean essential) {
		this.essential = essential;
	}

}
