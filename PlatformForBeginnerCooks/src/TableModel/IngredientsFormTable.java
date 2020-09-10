package TableModel;

import java.time.LocalDate;

import javax.swing.table.AbstractTableModel;

//TABLE CLASS for ingredients in user fridge editor
public class IngredientsFormTable extends AbstractTableModel {

	private static final long serialVersionUID = 6786717170579562972L;

	private String[] columns = { "Ingredient", "Producer", "Quantity", "Expiration date", "in MyFridge" };
	private static final Class<?>[] COLUMN_TYPES = new Class<?>[] { String.class, String.class, Double.class,
			LocalDate.class, Boolean.class };
	private Object[][] ingredients;

	public IngredientsFormTable(Object[][] products) {
		this.ingredients = products;

	}

	public Object[][] getIngredients() {
		return ingredients;
	}

	public void setIngredients(Object[][] ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ingredients[rowIndex][columnIndex] = aValue;
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
		}

		return ingredients[rowIndex][columnIndex];

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
