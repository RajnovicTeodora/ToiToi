package TableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.ChosenTags;
import model.ChosenTaste;
import model.Tag;
import model.Taste;

public class TagsCheckBoxModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"Tag", ""};
	
	private Object[][] allTags;
	
	

	public TagsCheckBoxModel(ArrayList<Tag> tags) {
		super();
		allTags = new Object[tags.size()][2];
		int i = 0;
		for (Tag t : tags) {
			allTags[i][0] = t.getTag();
			if(ChosenTags.getChosenTags() == null || ChosenTags.getChosenTags().isEmpty()) {
				allTags[i][1] = false;
			}
			else {
				if(ChosenTags.getChosenTags().contains(t.getTag())) {
					allTags[i][1] = true;
				}else
					allTags[i][1] = false;
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
		return allTags.length;
	}

	
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return allTags[arg0][arg1];
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
		allTags[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	

}
