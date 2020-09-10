package TableModel;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.Equipment;
import model.Product;

public class MissingEquipmentTable extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"Tool","Description", "In MyTools"};
	
	private Collection<Equipment> eqs = new ArrayList<Equipment>();
	
	private Collection<Equipment> myTools = new ArrayList<Equipment>();
	
	
	
	public MissingEquipmentTable(Collection<Equipment> eqs, Collection<Equipment> myTools) {
		super();
		this.eqs = eqs;
		this.myTools = myTools;
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

	public boolean isInMyTools(Equipment p) {
		boolean retval = false;
		for (Equipment it : this.myTools) {
			if(p.getEquipmentID()==it.getEquipmentID()) {
				retval = true;
				break;
			}
		}
		
		return retval;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(eqs==null) {
			return null;
		}
		Equipment eq = ((ArrayList<Equipment>) this.eqs).get(rowIndex);
		switch(columnIndex) {
		case 0:
			return eq.getName();
		case 1:
			return eq.getDescription();
		case 2:
			if(isInMyTools(eq)) {
				ImageIcon tick=new ImageIcon("./img/tick.png");
				return tick;
			}else {
				ImageIcon tick=new ImageIcon("./img/blackclose.png");
				return tick;
			}
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
