package view.SignUpForm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

//TODO FOR MODERATOR
public class AddEquipmentFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JPanel p1 = new JPanel();
	protected JTextField tf1 = new JTextField(20);

	protected JPanel p2 = new JPanel();
	protected JTextField tf2 = new JTextField(20);

	protected JPanel p3 = new JPanel();
	protected JTextField tf3 = new JTextField(20);

	protected JPanel p4 = new JPanel();
	protected JButton confirm = new JButton("Confrim");
	protected JButton cancel = new JButton("Cancel");

	private String name = "";
	private String producer = "";
	private String description = "";

	public AddEquipmentFrame() {

		this.setSize(350, 250);
		this.setTitle("Add row");
		this.setIconImage(new ImageIcon("img/add-row.png").getImage());
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);

		setLayout(new MigLayout());

		getContentPane().setBackground(Color.WHITE);

		p1.setBackground(Color.white);
		p1.add(new JLabel("Product name: "));
		p1.add(tf1);

		p2.setBackground(Color.white);
		p2.add(new JLabel("Company name: "));
		p2.add(tf2);

		p3.setBackground(Color.white);
		p3.add(new JLabel("Description: "));
		p3.add(tf3);

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tryName = tf1.getText();

				if (tryName.equals("")) {
					JOptionPane.showMessageDialog(null, "Tool name is mandatory!", "Error!", JOptionPane.ERROR_MESSAGE);

				} else {
					name = tryName;
					producer = tf2.getText();
					setDescription(tf3.getText());
					dispose();
				}

			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		p4.setBackground(Color.white);
		p4.add(confirm);
		p4.add(cancel);

		add(p1, "wrap");
		add(p2, "wrap");
		add(p3, "wrap");
		add(p4);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
