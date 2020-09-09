package view.RecipeForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import TableModel.IngredientsFormTable;
import TableModel.JTableButtonMouseListener;
import TableModel.MyEquipmentTable;
import controller.ToiToiController;
import model.Equipment;
import model.Product;
import net.miginfocom.swing.MigLayout;
import view.SignUpForm.AddEquipmentFrame;
import view.SignUpForm.MyFridgeProductDialog;

public class EquipmentPanel extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
	protected ToiToiController toiToiController;
	
	protected TableRowSorter<AbstractTableModel> tableSorter2 = new TableRowSorter<AbstractTableModel>();
	protected JPanel myEquipmentPanel = new JPanel(new MigLayout());
	protected JTable myEquipmentTable;
	protected JTextField tfSearch2 = new JTextField(15);
	protected JScrollPane sp2;
	
	private Object[][] equipmentObj;
	private ArrayList<Equipment> equipment;

	
	public EquipmentPanel(ToiToiController ttc) {
		this.toiToiController = ttc;
		
		setBackground(Color.white);
		createInfo((ArrayList<Equipment>) toiToiController.getToiToi().getEquipment());
	
		MyEquipmentTable met = new MyEquipmentTable(equipmentObj);

		myEquipmentTable = new JTable(met);
		myEquipmentTable.setBackground(Color.white);
		myEquipmentTable.addMouseListener(new JTableButtonMouseListener(myEquipmentTable));
		myEquipmentTable.getTableHeader().setReorderingAllowed(false);
		tableSorter2.setModel((AbstractTableModel) myEquipmentTable.getModel());
		myEquipmentTable.setRowSorter(tableSorter2);

		myEquipmentPanel.setBackground(Color.white);

		sp2 = new JScrollPane(myEquipmentTable);
		sp2.setPreferredSize(new Dimension(300, 150));

		JPanel bottomTable2 = new JPanel();
		myEquipmentPanel.add(new JLabel("Please select needed tools : "), "top, wrap");
		myEquipmentPanel.add(sp2, "wrap");

		bottomTable2.add(new JLabel("Search:"));
		bottomTable2.add(tfSearch2);
		bottomTable2.setBackground(Color.white);

		// BUTTONS
		JButton edit2 = new JButton("Add tool");

		edit2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddEquipmentFrame addEquipment = new AddEquipmentFrame();
				addEquipment.setVisible(true);
				addEquipment.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
					}

					@Override
					public void windowIconified(WindowEvent e) {
					}

					@Override
					public void windowDeiconified(WindowEvent e) {

					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						String name = addEquipment.getName();
						String prod = addEquipment.getProducer();
						String desc = addEquipment.getDescription();

						Boolean c1 = false;
						Boolean c2 = false;
						Boolean c3 = false;
						ArrayList<Equipment> equip = (ArrayList<Equipment>) toiToiController.getToiToi().getEquipment();
						for (Equipment tool : equip) {
							c1 = false;
							c2 = false;
							c3 = false;

							String n = tool.getName().toLowerCase();
							String p = tool.getCompany().toLowerCase();
							String d = tool.getDescription().toLowerCase();

							if (name.toLowerCase().compareTo(n) == 0)
								c1 = true;
							if (prod.toLowerCase().compareTo(p) == 0)
								c2 = true;
							if (desc.toLowerCase().compareTo(d) == 0)
								c3 = true;
							if (c1 && c2 && c3)
								break;
						}
						if (c1 && c2 && c3) {
							JOptionPane.showMessageDialog(null, "The product already exists!", "Error!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							Equipment newEquipment = new Equipment(-1, name, prod, desc);
							toiToiController.getToiToi().addEquipment(newEquipment);
							refreshEquipment();

						}

					}

					@Override
					public void windowClosing(WindowEvent e) {

					}

					@Override
					public void windowClosed(WindowEvent e) {
					}

					@Override
					public void windowActivated(WindowEvent e) {

					}
				});

			}
		});

		bottomTable2.add(edit2);

		myEquipmentPanel.add(bottomTable2, "center, bottom");

		tfSearch2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				changedUpdate(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changedUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (tfSearch2.getText().trim().length() == 0) {
					tableSorter2.setRowFilter(null);
				} else {
					tableSorter2.setRowFilter(RowFilter.regexFilter("(?i)" + tfSearch2.getText().trim()));
				}
			}
		});

		myEquipmentTable.getTableHeader().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = myEquipmentTable.getTableHeader().columnAtPoint(arg0.getPoint());
				sortEquipment(index);
			}

		});
		add(myEquipmentPanel, "wrap");

	}


	private void createInfo(ArrayList<Equipment> e) {
		equipmentObj = new Object[e.size()][4];

		for (int i = 0; i < e.size(); i++) {
			Equipment eq = e.get(i);
			equipmentObj[i][0] = eq.getName();
			equipmentObj[i][1] = eq.getCompany();
			equipmentObj[i][2] = eq.getDescription();
			equipmentObj[i][3] = new Boolean(false);

		}
	}
	@SuppressWarnings("serial")
	private Map<Integer, Integer> sortOrderEqu = new HashMap<Integer, Integer>() {
		{
			put(0, 1);
			put(1, 1);
			put(2, 1);
		}
	};

	protected void sortEquipment(int index) {

		toiToiController.getToiToi().getEquipment().sort(new Comparator<Equipment>() {

			@Override
			public int compare(Equipment o1, Equipment o2) {
				int retVal = 0;
				switch (index) {
				case 0:
					retVal = o1.getName().compareTo(o2.getName());
					return retVal * sortOrderEqu.get(index);
				case 1:
					retVal = (o1.getCompany()).compareTo(o2.getCompany());
					return retVal * sortOrderEqu.get(index);
				case 2:
					retVal = (o1.getDescription()).compareTo(o2.getDescription());
					return retVal * sortOrderEqu.get(index);
				default:
					return 0;
				}

			}
		});
		if (index <= 1) {
			sortOrderEqu.put(index, sortOrderEqu.get(index) * -1);
			refreshEquipment();
		}
	}
	public void refreshEquipment() {

		createInfo((ArrayList<Equipment>) toiToiController.getToiToi().getEquipment());
		MyEquipmentTable met = (MyEquipmentTable) this.myEquipmentTable.getModel();
		met.setEquipment(equipmentObj);
		met.fireTableDataChanged();
	}


	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}


	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}

	
	
}
