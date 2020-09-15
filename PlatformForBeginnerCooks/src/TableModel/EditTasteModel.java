package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import controller.Chosen.ChosenTasteForEdit;
import model.Taste;

public class EditTasteModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"Taste", ""};
	
	private Object[][] allTaste;
	
	

	public EditTasteModel(List<Taste> tasteList) {
		super();
		allTaste = new Object[tasteList.size()][2];
		int i = 0;
		for (Taste t : tasteList) {
			allTaste[i][0] = t.name();
			if(ChosenTasteForEdit.getChosenTaste() == null || ChosenTasteForEdit.getChosenTaste().isEmpty()) {
				allTaste[i][1] = false;
			}
			else {
				if(ChosenTasteForEdit.getChosenTaste().contains(t.name())) {
					allTaste[i][1] = true;
				}else
					allTaste[i][1] = false;
			}
			i++;
		}
	}

	
	
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return allTaste.length;
	}

	
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return allTaste[arg0][arg1];
	}
	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col != 1) {
			return false;
		} else {
			return true;
		}
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

	public void setValueAt(Object value, int row, int col) {
		allTaste[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
}
