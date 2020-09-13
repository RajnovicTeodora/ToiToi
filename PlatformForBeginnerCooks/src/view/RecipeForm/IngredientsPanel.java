package view.RecipeForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

import TableModel.JTableButtonMouseListener;
import TableModel.RecipeIngredientForm;
import controller.ToiToiController;
import model.NeededQuantity;
import model.Product;
import net.miginfocom.swing.MigLayout;

public class IngredientsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected TableRowSorter<AbstractTableModel> tableSorter = new TableRowSorter<AbstractTableModel>();
	protected JPanel ingredientsPanel = new JPanel(new MigLayout("", "[]10[]", "[]10[]"));

	protected JTable tableRecipeIngredients;
	protected JTextField tfSearch1 = new JTextField(20);
	protected JScrollPane scrollPane1;

	private ToiToiController toiToiController;
	private Object[][] productInfo;
	private ArrayList<NeededQuantity> products;

	public IngredientsPanel(ToiToiController toiToiController) {
		this.toiToiController = toiToiController;
		setBackground(Color.white);
		setLayout(new MigLayout());

		// =====MY Ingredients PANEL========================

		createInfo((ArrayList<Product>) toiToiController.getToiToi().getProducts());
		RecipeIngredientForm rif = new RecipeIngredientForm(productInfo);

		tableRecipeIngredients = new JTable(rif);
		tableRecipeIngredients.setBackground(Color.white);
		tableRecipeIngredients.setGridColor(new Color(157, 157, 222));
		tableRecipeIngredients.getTableHeader().setBackground(new Color(200, 221, 242));
		tableRecipeIngredients.addMouseListener(new JTableButtonMouseListener(tableRecipeIngredients));
		tableRecipeIngredients.getTableHeader().setReorderingAllowed(false);
		tableSorter.setModel((AbstractTableModel) tableRecipeIngredients.getModel());
		tableRecipeIngredients.setRowSorter(tableSorter);

		ingredientsPanel.setBackground(new Color(255, 233, 248));

		JScrollPane sp = new JScrollPane(tableRecipeIngredients);
		sp.setPreferredSize(new Dimension(500, 150));

		JPanel bottomTable1 = new JPanel();
		ingredientsPanel.add(new JLabel("Please select required ingredients : "), "top, wrap");
		ingredientsPanel.add(sp, "wrap");

		bottomTable1.add(new JLabel("Search:"));
		bottomTable1.add(tfSearch1);
		bottomTable1.setBackground(new Color(255, 233, 248));

		// BUTTONS
		JButton edit1 = new JButton("Edit");

		bottomTable1.add(edit1);

		edit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = tableRecipeIngredients.getSelectedRow();
				if (selected == -1) {
					JOptionPane.showMessageDialog(null, "Please select a product!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} else {

					MyRecipeProductDialog dialog = new MyRecipeProductDialog((Double) rif.getValueAt(selected, 2),
							(Boolean) rif.getValueAt(selected, 4), (Boolean) rif.getValueAt(selected, 3));
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
							rif.setValueAt(dialog.getValue(), selected, 2);
							rif.setValueAt(dialog.getEssential(), selected, 3);
							rif.setValueAt(dialog.getChecked(), selected, 4);

							rif.fireTableRowsUpdated(selected, selected);
						}

						@Override
						public void windowActivated(WindowEvent e) {

						}
					});
				}
			}
		});

		ingredientsPanel.add(bottomTable1, "center, bottom");

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

		tableRecipeIngredients.getTableHeader().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tableRecipeIngredients.getTableHeader().columnAtPoint(arg0.getPoint());
				sort(index);
			}

		});
		add(ingredientsPanel, "center, wrap");

		JPanel bottom = new JPanel(new MigLayout());
		bottom.setBackground(Color.white);
	}

	public void refreshData() {
		createInfo((ArrayList<Product>) toiToiController.getToiToi().getProducts());
		RecipeIngredientForm rif = (RecipeIngredientForm) this.tableRecipeIngredients.getModel();
		rif.fireTableDataChanged();
	}

	private void createInfo(ArrayList<Product> products) {
		productInfo = new Object[products.size()][5];
		for (int i = 0; i < products.size(); i++) {
			Product prod = products.get(i);

			productInfo[i][0] = prod.getName();
			productInfo[i][1] = prod.getProducedBy();
			productInfo[i][2] = 0.0;
			productInfo[i][3] = new Boolean(false);
			productInfo[i][4] = new Boolean(false);

		}
	}

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

	@SuppressWarnings("serial")
	private Map<Integer, Integer> sortOrder = new HashMap<Integer, Integer>() {
		{
			put(0, 1);
			put(1, 1);

		}
	};
	
	public ArrayList<NeededQuantity> confirm(){
		products = new ArrayList<NeededQuantity>();
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
				NeededQuantity nq = new NeededQuantity((Double) productInfo[i][2], (Boolean)productInfo[i][3], foundProd);
				products.add(nq);
			}
		}

		return products;
	}
}
