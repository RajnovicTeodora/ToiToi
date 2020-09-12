package view.RecipeForm;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class ExtraInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JFormattedTextField servingsField;
	protected JFormattedTextField prepField;
	protected JFormattedTextField cookField;
	protected JSpinner diffSpin;

	private int servings;
	private int prep;
	private int cook;
	private int diff;

	public ExtraInfoPanel() {

		setBackground(Color.white);
		setLayout(new MigLayout());

		JLabel cookLabel = new JLabel("Cooking time(min):");
		JLabel prepLabel = new JLabel("Preparation time(min):");
		JLabel servingsLabel = new JLabel("Number of servings:");
		JLabel difficultyLabel = new JLabel("Level of ifficulty:");

		servingsField = new JFormattedTextField(new DecimalFormat());
		servingsField.setColumns(2);
		servingsField.setValue(0);

		prepField = new JFormattedTextField(new DecimalFormat());
		prepField.setColumns(4);
		prepField.setValue(0);
		
		cookField = new JFormattedTextField(new DecimalFormat());
		cookField.setColumns(4);
		cookField.setValue(0);

		diffSpin = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

		JPanel p1 = new JPanel(new MigLayout("", "[][] 34 [][]", ""));
		p1.setBackground(Color.white);
		p1.add(servingsLabel);
		p1.add(servingsField);
		p1.add(difficultyLabel);
		p1.add(diffSpin);

		JPanel p2 = new JPanel(new MigLayout("", "[][] 20 [][]", ""));
		p2.setBackground(Color.white);
		p2.add(cookLabel);
		p2.add(cookField);
		p2.add(prepLabel);
		p2.add(prepField);

		add(p1, "wrap");
		add(p2);
	}

	public void confirm() {
		servings = Integer.parseInt(servingsField.getText());
		diff = (int) diffSpin.getValue();
		prep = Integer.parseInt(prepField.getText());
		cook = Integer.parseInt(cookField.getText());

		
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public int getPrep() {
		return prep;
	}

	public void setPrep(int prep) {
		this.prep = prep;
	}

	public int getCook() {
		return cook;
	}

	public void setCook(int cook) {
		this.cook = cook;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

}
