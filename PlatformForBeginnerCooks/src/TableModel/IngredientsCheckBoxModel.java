package TableModel;

import java.util.ArrayList;

import model.ChosenProducts;
import model.Product;
import javax.swing.table.AbstractTableModel;

public class IngredientsCheckBoxModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"Ingredient", "Company", ""};
	
	private Object[][] allProducts;
	
	

	public IngredientsCheckBoxModel(ArrayList<Product> products) {
		super();
		allProducts = new Object[products.size()][3];
		int i = 0;
		for (Product product : products) {
			allProducts[i][0] = product.getName();
			allProducts[i][1] = product.getProducedBy();
			if(ChosenProducts.getChosenProducts() == null || ChosenProducts.getChosenProducts().isEmpty()) {
				allProducts[i][2] = false;
			}
			else {
				if(ChosenProducts.getChosenProducts().contains(product.getProductID())) {
					allProducts[i][2] = true;
				}else
					allProducts[i][2] = false;
			}
			i++;
		}
	}

	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return allProducts.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return allProducts[arg0][arg1];
	}
	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col != 2) {
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
		allProducts[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
}
