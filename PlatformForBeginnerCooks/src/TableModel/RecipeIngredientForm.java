package TableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import view.SignUpForm.MyFridgeProductDialog;

// TABLE CLASS for ingredients in recipe
public class RecipeIngredientForm extends AbstractTableModel {

	private static final long serialVersionUID = 6786717170579562972L;

	private String[] columns = { "Ingredient", "Producer", "Quantity", "Essential", "in MyRecipe", "" };
	private static final Class<?>[] COLUMN_TYPES = new Class<?>[] { String.class, String.class, Double.class,
			Boolean.class, Boolean.class, JButton.class };

	private Object[][] ingredients;

	public RecipeIngredientForm(Object[][] products) {
		this.ingredients = products;

	}

	public Object[][] getIngredients() {
		return ingredients;
	}

	public void setIngredients(Object[][] ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int getColumnCount() {

		return columns.length;
	}

	@Override
	public int getRowCount() {

		return ingredients.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (ingredients == null) {
			return null;
		} else {
			if (columnIndex == 5) {
				final JButton button = new JButton(columns[columnIndex]);
				button.setText("Edit");

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						//TODO CLASS INGREDIENTS MYRECIPEPRODUCTDIALOG
						MyFridgeProductDialog dialog = new MyFridgeProductDialog((Double) ingredients[rowIndex][2],
								(Boolean) ingredients[rowIndex][4], (LocalDate) ingredients[rowIndex][3]);
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
								ingredients[rowIndex][2] = dialog.getValue();
								ingredients[rowIndex][3] = dialog.getPickedDate();
								ingredients[rowIndex][4] = dialog.getChecked();
								fireTableRowsUpdated(rowIndex, rowIndex);
							}

							@Override
							public void windowActivated(WindowEvent e) {

							}
						});

					}
				});
				return button;
			}

			return ingredients[rowIndex][columnIndex];
		}
	}

	public Class<?> getColumnClass(int c) {
		return COLUMN_TYPES[c];
		// return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {

		return false;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;

	}

	public String getColumnName(int col) {
		return this.columns[col];
	}
}
