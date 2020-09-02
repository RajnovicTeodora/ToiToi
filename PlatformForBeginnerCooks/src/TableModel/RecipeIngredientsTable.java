package TableModel;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import model.NeededQuantity;

public class RecipeIngredientsTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6786717170579562972L;

	private String[] columns = {"Ingredient", "Quantity", "Essential"};
	
	private Collection<NeededQuantity> nqs = new ArrayList<NeededQuantity>();
	
	public RecipeIngredientsTable(ArrayList<NeededQuantity> nqss) {
		this.nqs =  new ArrayList<NeededQuantity>();
		for (NeededQuantity neededQuantity : nqss) {
			this.nqs.add(neededQuantity);
		}
		
	}

	public Collection<NeededQuantity> getNqs() {
		return nqs;
	}

	public void setNqs(ArrayList<NeededQuantity> nqs) {
		this.nqs = nqs;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return nqs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(nqs==null) {
			return null;
		}
		NeededQuantity nq = ((ArrayList<NeededQuantity>) this.nqs).get(rowIndex);
		switch(columnIndex) {
		case 0:
			return nq.getIngredient().getName();
		case 1:
			return nq.getQuantity();
		case 2:
			if(nq.isEssential()==true) {
				return "YES";
			}else
				return "NO";
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
