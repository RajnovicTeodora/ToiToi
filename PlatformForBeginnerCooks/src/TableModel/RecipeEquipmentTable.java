package TableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Equipment;
import model.NeededQuantity;

public class RecipeEquipmentTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6786717170579562972L;

	private String[] columns = {"Equipment", "Description", "Company"};
	
	private ArrayList<Equipment> eqs = new ArrayList<Equipment>();
	
	public RecipeEquipmentTable(ArrayList<Equipment> eqs) {
		this.eqs = eqs;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return eqs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(eqs==null) {
			return null;
		}
		Equipment e = (this.eqs).get(rowIndex);
		switch(columnIndex) {
		case 0:
			return e.getName();
		case 1:
			return e.getDescription();
		case 2:
			return e.getCompany();
		}
		
		return null;
	}
	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
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
