package TableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.Chosen.ChosenComment;
import controller.Chosen.ChosenEquipment;
import model.Comment;
import model.Equipment;

public class CommentsToDeleteModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"","Comment", "By", "Delete"};
	
	private Object[][] allComms;

	public CommentsToDeleteModel(ArrayList<Comment> comms) {
		super();
		allComms = new Object[comms.size()][4];
		int i = 0;
		for (Comment e : comms) {
			allComms[i][0] = i;
			allComms[i][1] = e.getText();
			allComms[i][2] = e.getCommentator().getUsername();
			if(ChosenComment.getChosenComms() == null || ChosenComment.getChosenComms().isEmpty()) {
				allComms[i][3] = false;
			}
			else {
				if(ChosenComment.getChosenComms().contains(i)) {
					allComms[i][3] = true;
				}else
					allComms[i][3] = false;
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
		return allComms.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return allComms[arg0][arg1];
	}
	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col != 3) {
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
		allComms[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
}
