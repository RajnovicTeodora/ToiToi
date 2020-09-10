package TableModel;

import javax.swing.table.AbstractTableModel;

//TABLE CLASS for user equipment creation
public class MyEquipmentTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columns = { "Equipment", "Producer",  "Description", "in MyTools" };
	private static final Class<?>[] COLUMN_TYPES = new Class<?>[] { String.class, String.class, String.class, Boolean.class };
	private Object[][] equipment;

	public MyEquipmentTable(Object[][] equipmnet) {
		this.equipment = equipmnet;

	}

	public Object[][] getEquipment() {
		return equipment;
	}

	public void setEquipment(Object[][] equipment) {
		this.equipment = equipment;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		equipment[rowIndex][columnIndex] = aValue;
	}

	@Override
	public int getColumnCount() {

		return columns.length;
	}

	@Override
	public int getRowCount() {

		return equipment.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (equipment == null) {
			return null;
		}

		return equipment[rowIndex][columnIndex];

	}

	public Class<?> getColumnClass(int c) {
		return COLUMN_TYPES[c];
		// return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		if(col == 3) return true;
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

