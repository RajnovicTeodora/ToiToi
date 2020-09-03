package TableModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.NeededQuantity;
import model.Product;
import model.ProductInfo;

public class MissingIngredientsTable extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"Ingredient", "Quantity", "Essential", "In MyFridge"};
	
	private Collection<NeededQuantity> nqs = new ArrayList<NeededQuantity>();
	
	private Collection<Product> myFridge = new ArrayList<Product>();
	
	private Collection<Product> alergies = new ArrayList<Product>();
	
	private List<Color> rowColours = Arrays.asList(
			new Color(255, 0, 0, 100),
			new Color(255, 0, 0, 100),
			new Color(255, 0, 0, 100)
	    );

	public Collection<NeededQuantity> getNqs() {
		return nqs;
	}

	public void setNqs(Collection<NeededQuantity> nqs) {
		this.nqs = nqs;
	}

	public Collection<Product> getMyFridge() {
		return myFridge;
	}

	public void setMyFridge(Collection<Product> myFridge) {
		this.myFridge = myFridge;
	}

	public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }
	
	public Color getRowColour(int row) {
        return rowColours.get(row);
    }
	
	
	@Override
	public void fireTableRowsUpdated(int firstRow, int lastRow) {
		// TODO Auto-generated method stub
		super.fireTableRowsUpdated(firstRow, lastRow);
	}

	public MissingIngredientsTable( Collection<NeededQuantity> nqs, Collection<ProductInfo> myFridge,Collection<Product> alergies ) {
		super();
		this.nqs = nqs;
		this.alergies = alergies;
		for (ProductInfo productInfo : myFridge) {
			this.myFridge.add(productInfo.getIngredient());
		}
		
	}
	
	public boolean isAlergie(String productName) {
		boolean retval = false;
		for (Product it : alergies) {
			if(productName.equals(it.getName())) {
				retval = true;
				break;
			}
		}
		
		return retval;
	}
	
	public boolean isInMyFridge(Product p) {
		boolean retval = false;
		for (Product it : this.myFridge) {
			if(p.getProductID()==it.getProductID()) {
				retval = true;
				break;
			}
		}
		
		return retval;
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
			return nq.getQuantity().toString();
		case 2:
			if(nq.isEssential()==true) {
				return "YES";
			}else
				return "NO";
		case 3:
			if(isInMyFridge(nq.getIngredient())) {
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

	public Collection<Product> getAlergies() {
		return alergies;
	}

	public void setAlergies(Collection<Product> alergies) {
		this.alergies = alergies;
	}
	
	

}
