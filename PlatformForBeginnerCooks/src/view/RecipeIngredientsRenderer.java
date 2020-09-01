package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;

import TableModel.RecipeIngredientsTable;

public class RecipeIngredientsRenderer  extends DefaultCellEditor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7702682064070443433L;

	private RecipeIngredientsTable model;
	private int row, col;
    private JTable table;
    private JButton button;
    private String label;
    private boolean clicked;
	
	public RecipeIngredientsRenderer(JCheckBox checkBox, RecipeIngredientsTable model) {
		super(checkBox);
			this.model = model;
	      button = new JButton();
	      button.setOpaque(true);
	      button.addActionListener(new ActionListener()
	      {
	        public void actionPerformed(ActionEvent e)
	        {
	          fireEditingStopped();
	        }
	      });
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
      this.table = table;
      this.row = row;
      this.col = column;

      button.setForeground(Color.black);
      button.setBackground(UIManager.getColor("Button.background"));
      label = (value == null) ? "" : value.toString();
      button.setText(label);
      clicked = true;
      return button;
    }
    public Object getCellEditorValue()
    {
       //OVDE DODATI AKO POLJA BUDU DUGMAD
      clicked = false;
      return new String(label);
    }
	
	public boolean stopCellEditing()
    {
      clicked = false;
      return super.stopCellEditing();
    }

    protected void fireEditingStopped()
    {
      super.fireEditingStopped();
    }
}
