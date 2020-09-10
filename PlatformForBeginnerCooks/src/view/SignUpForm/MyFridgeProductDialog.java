package view.SignUpForm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import net.miginfocom.swing.MigLayout;
import view.DataLabelFormatter;

public class MyFridgeProductDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JDatePanelImpl panel_date;

	protected JDatePickerImpl date;
	protected UtilDateModel model;
	protected JFormattedTextField quantField;
	protected JCheckBox check;
	protected JButton ok;
	protected JButton cancel;

	// entered data
	private Double value;
	private Boolean checked;
	private LocalDate pickedDate;

	public MyFridgeProductDialog(Double v, Boolean c, LocalDate p) {
		value = v;
		checked = c;
		pickedDate = p;

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

		JLabel dat = new JLabel("Expiration date : ");
		Properties prop = new Properties();
		prop.put("text.today", "Today");
		prop.put("text.month", "Month");
		prop.put("text.year", "Year");

		model = new UtilDateModel();
		panel_date = new JDatePanelImpl(model, prop);
		panel_date.setBackground(new Color(192, 229, 227));
		if (pickedDate != null)
			model.setValue(Date.valueOf(pickedDate));

		date = new JDatePickerImpl(panel_date, new DataLabelFormatter());
		date.setBackground(new Color(192, 229, 227));

		JLabel notice = new JLabel("*no changes will be saved if the checkbox isnt selected");

		JPanel p1 = new JPanel(new MigLayout("", "[]20[]", ""));
		p1.add(quantity);
		p1.add(quantField, "wrap");
		p1.setBackground(Color.WHITE);

		JPanel p2 = new JPanel(new MigLayout());
		p2.add(dat);
		p2.add(date, "wrap");
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
					pickedDate = null;

					if (model.isSelected()) {
						int day = model.getDay();
						int month = model.getMonth() + 1;
						int year = model.getYear();

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
						pickedDate = LocalDate.parse(date, format);
					}
					checked = true;

				} else {
					model.setSelected(false);
					model.setValue(null);
					pickedDate = null;
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

	public LocalDate getPickedDate() {
		return pickedDate;
	}

	public void setPickedDate(LocalDate pickedDate) {
		this.pickedDate = pickedDate;
	}

}
