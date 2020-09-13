package view.SignUpForm;

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
import model.ProductInfo;
import net.miginfocom.swing.MigLayout;

public class SignUpStepTwo extends JPanel {

	private static final long serialVersionUID = 1L;

	protected TableRowSorter<AbstractTableModel> tableSorter = new TableRowSorter<AbstractTableModel>();
	protected TableRowSorter<AbstractTableModel> tableSorter2 = new TableRowSorter<AbstractTableModel>();

	protected JPanel myFridgePanel = new JPanel(new MigLayout("", "[]10[]", "[]10[]"));
	protected JTable tableMyFridge;
	protected JTextField tfSearch1 = new JTextField(20);
	protected JScrollPane scrollPane1;

	protected JPanel myAlergiesPanel = new JPanel(new MigLayout());
	protected AlergieList alergieList;

	protected JPanel myEquipmentPanel = new JPanel(new MigLayout());
	protected JTable myEquipmentTable;
	protected JTextField tfSearch2 = new JTextField(15);
	protected JScrollPane scrollPane2;

	private ToiToiController toiToiController;
	private Object[][] productInfo;
	private ArrayList<ProductInfo> products;
	private Object[][] equipmentObj;
	private ArrayList<Equipment> equipment;
	private ArrayList<String> alergies;

	public SignUpStepTwo(ToiToiController toiToiController) {

		this.toiToiController = toiToiController;
		setBackground(Color.white);
		setLayout(new MigLayout());

		// =====MY FRIDGE PANEL========================

		createInfo((ArrayList<Product>) toiToiController.getToiToi().getProducts());
		IngredientsFormTable ift = new IngredientsFormTable(productInfo);

		tableMyFridge = new JTable(ift);
		// tableMyFridge.setBackground(new Color(192, 229, 250));
		tableMyFridge.setBackground(Color.white);
		tableMyFridge.setGridColor(new Color(185, 108, 209));
		tableMyFridge.getTableHeader().setBackground(new Color(248, 226, 255));
		tableMyFridge.addMouseListener(new JTableButtonMouseListener(tableMyFridge));
		tableMyFridge.getTableHeader().setReorderingAllowed(false);
		tableSorter.setModel((AbstractTableModel) tableMyFridge.getModel());
		tableMyFridge.setRowSorter(tableSorter);

		myFridgePanel.setBackground(Color.white);

		JScrollPane sp = new JScrollPane(tableMyFridge);
		sp.setPreferredSize(new Dimension(500, 200));

		JPanel bottomTable1 = new JPanel();
		myFridgePanel.add(new JLabel("Please select available ingredients : "), "top, wrap");
		myFridgePanel.add(sp, "wrap");

		bottomTable1.add(new JLabel("Search:"));
		bottomTable1.add(tfSearch1);
		bottomTable1.setBackground(Color.white);

		// BUTTONS
		JButton edit1 = new JButton("Edit");

		bottomTable1.add(edit1);

		edit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = tableMyFridge.getSelectedRow();
				if (selected == -1) {
					JOptionPane.showMessageDialog(null, "Please select a product!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} else {

					MyFridgeProductDialog dialog = new MyFridgeProductDialog((Double) ift.getValueAt(selected, 2),
							(Boolean) ift.getValueAt(selected, 4), (LocalDate) ift.getValueAt(selected, 3));
					dialog.setVisible(true);

					dialog.addWindowListener(new WindowListener() {

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

						}

						@Override
						public void windowClosing(WindowEvent e) {

						}

						@Override
						public void windowClosed(WindowEvent e) {
							ift.setValueAt(dialog.getValue(), selected, 2);
							ift.setValueAt(dialog.getPickedDate(), selected, 3);
							ift.setValueAt(dialog.getChecked(), selected, 4);

							ift.fireTableRowsUpdated(selected, selected);
						}

						@Override
						public void windowActivated(WindowEvent e) {

						}
					});
				}
			}
		});

		myFridgePanel.add(bottomTable1, "center, bottom");

		tfSearch1.getDocument().addDocumentListener(new DocumentListener() {

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
				if (tfSearch1.getText().trim().length() == 0) {
					tableSorter.setRowFilter(null);
				} else {
					tableSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tfSearch1.getText().trim()));
				}
			}
		});

		tableMyFridge.getTableHeader().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tableMyFridge.getTableHeader().columnAtPoint(arg0.getPoint());
				sort(index);
			}

		});
		add(myFridgePanel, "center, wrap");

		JPanel bottom = new JPanel(new MigLayout());
		bottom.setBackground(Color.white);
		// =============ALERGIES PANEL===========================

		alergieList = new AlergieList();
		myAlergiesPanel.add(new JLabel("Enter present alergies:"), "wrap");
		myAlergiesPanel.add(alergieList);
		myAlergiesPanel.setBackground(Color.white);
		bottom.add(myAlergiesPanel);

		// ================EQUIPMENT TABLE=========================

		createInfoEquipment((ArrayList<Equipment>) toiToiController.getToiToi().getEquipment());

		MyEquipmentTable met = new MyEquipmentTable(equipmentObj);

		myEquipmentTable = new JTable(met);
		myEquipmentTable.setBackground(Color.white);
		myEquipmentTable.setGridColor(new Color(185, 108, 209));
		myEquipmentTable.getTableHeader().setBackground(new Color(248, 226, 255));
		myEquipmentTable.addMouseListener(new JTableButtonMouseListener(myEquipmentTable));
		myEquipmentTable.getTableHeader().setReorderingAllowed(false);
		tableSorter2.setModel((AbstractTableModel) myEquipmentTable.getModel());
		myEquipmentTable.setRowSorter(tableSorter2);

		myEquipmentPanel.setBackground(Color.white);

		JScrollPane sp2 = new JScrollPane(myEquipmentTable);
		sp2.setPreferredSize(new Dimension(300, 150));

		JPanel bottomTable2 = new JPanel();
		myEquipmentPanel.add(new JLabel("Please select available tools : "), "top, wrap");
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
		bottom.add(myEquipmentPanel, "wrap");

		add(bottom);
	}

	private void createInfo(ArrayList<Product> products) {
		productInfo = new Object[products.size()][5];
		for (int i = 0; i < products.size(); i++) {
			Product prod = products.get(i);

			productInfo[i][0] = prod.getName();
			productInfo[i][1] = prod.getProducedBy();
			productInfo[i][2] = 0.0;
			productInfo[i][3] = null;
			productInfo[i][4] = new Boolean(false);

		}
	}

	private void createInfoEquipment(ArrayList<Equipment> e) {

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
	private Map<Integer, Integer> sortOrder = new HashMap<Integer, Integer>() {
		{
			put(0, 1);
			put(1, 1);

		}
	};

	@SuppressWarnings("serial")
	private Map<Integer, Integer> sortOrderEqu = new HashMap<Integer, Integer>() {
		{
			put(0, 1);
			put(1, 1);
			put(2, 1);
		}
	};

	protected void sort(int index) {

		toiToiController.getToiToi().getProducts().sort(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				int retVal = 0;
				switch (index) {
				case 0:
					retVal = o1.getName().compareTo(o2.getName());
					return retVal * sortOrder.get(index);
				case 1:
					retVal = (o1.getProducedBy()).compareTo(o2.getProducedBy());
					return retVal * sortOrder.get(index);
				default:
					return 0;
				}
			}
		});
		if (index <= 1) {
			sortOrder.put(index, sortOrder.get(index) * -1);
			refreshData();
		}
	}

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

	public void refreshData() {
		createInfo((ArrayList<Product>) toiToiController.getToiToi().getProducts());
		IngredientsFormTable ift = (IngredientsFormTable) this.tableMyFridge.getModel();
		ift.fireTableDataChanged();
	}

	public void refreshEquipment() {

		createInfoEquipment((ArrayList<Equipment>) toiToiController.getToiToi().getEquipment());
		MyEquipmentTable met = (MyEquipmentTable) this.myEquipmentTable.getModel();
		met.setEquipment(equipmentObj);
		met.fireTableDataChanged();
	}

	public void confirmPressed() {
		products = new ArrayList<ProductInfo>();
		for (int i = 0; i < productInfo.length; i++) {
			if ((Boolean) productInfo[i][4] == true) {

				Product foundProd = null;
				for (Product p : toiToiController.getToiToi().getProducts()) {
					if ((p.getName().compareTo((String) productInfo[i][0]) == 0)
							&& (p.getProducedBy().compareTo((String) productInfo[i][1]) == 0)) {
						foundProd = p;
						break;
					}
				}
				ProductInfo pi = new ProductInfo((Double) productInfo[i][2], (LocalDate) productInfo[i][3], foundProd);
				products.add(pi);
			}
		}

		equipment = new ArrayList<Equipment>();
		for (int i = 0; i < equipmentObj.length; i++) {
			if ((Boolean) equipmentObj[i][3] == true) {
				String n = (String) equipmentObj[i][0];
				String c = (String) equipmentObj[i][1];
				String d = (String) equipmentObj[i][2];
				for (Equipment e : toiToiController.getToiToi().getEquipment()) {
					if ((e.getName().compareTo(n) == 0) && (e.getCompany().compareTo(c) == 0)
							&& (e.getDescription().compareTo(d) == 0)) {
						if (e.getEquipmentID() == -1) {
							int id = toiToiController.getEquipmentController()
									.freeId((ArrayList<Equipment>) toiToiController.getToiToi().getEquipment());
							e.setEquipmentID(id);
						}
						equipment.add(e);
						toiToiController.getToiToi().addEquipment(e);
						break;
					}
				}
			}
		}
		alergies = alergieList.getAlergieAL();

	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}

	public ArrayList<ProductInfo> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductInfo> products) {
		this.products = products;
	}

	public ArrayList<String> getAlergies() {
		return alergies;
	}

	public void setAlergies(ArrayList<String> alergies) {
		this.alergies = alergies;
	}
}
