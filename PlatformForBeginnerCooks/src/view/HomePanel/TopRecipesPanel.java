package view.HomePanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Recipe;
import net.miginfocom.swing.MigLayout;

public class TopRecipesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Recipe> sortedRecipes;

	protected JButton top1;
	private Recipe recipe1;

	protected JButton top2;
	private Recipe recipe2;

	protected JButton top3;
	private Recipe recipe3;

	public TopRecipesPanel(ArrayList<Recipe> recipes) {
		this.setSortedRecipes(recipes);
		this.setBackground(new Color(244, 226, 255));

		Image dimg = new ImageIcon("img/cancel-2.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg);

		JPanel title = new JPanel();
		JLabel l1 = new JLabel("ToiToi recipe leadership!");
		l1.setSize(100, 30);

		JPanel recipesPanel = new JPanel(new MigLayout());

		JPanel panel1 = new JPanel(new MigLayout());
		if (recipes.size() >= 1) {
			recipe1 = recipes.get(0);

			Image img1 = new ImageIcon(recipe1.getImage()).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon addIcon1 = new ImageIcon(img1);
			top1 = new JButton(addIcon1);
		} else {
			top1 = new JButton(addIcon);
		}

		top1.setContentAreaFilled(false);
		top1.setBorderPainted(false);
		top1.setToolTipText("Go to recipe"); // TODO link to recipe page
		top1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (recipes.size() >= 1) {
					// TODO recipe exits, so link it here
				}

			}

		});

		JPanel panel2 = new JPanel(new MigLayout());
		if (recipes.size() >= 2) {
			recipe2 = recipes.get(2);

			Image img2 = new ImageIcon(recipe2.getImage()).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon addIcon2 = new ImageIcon(img2);
			top2 = new JButton(addIcon2);
		} else {
			top2 = new JButton(addIcon);
		}

		top2.setContentAreaFilled(false);
		top2.setBorderPainted(false);
		top2.setToolTipText("Go to recipe"); // TODO link to recipe page
		top2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (recipes.size() >= 2) {
					// TODO recipe exits, so link it here
				}
			}

		});

		JPanel panel3 = new JPanel(new MigLayout());
		if (recipes.size() >= 3) {
			recipe3 = recipes.get(2);

			Image img3 = new ImageIcon(recipe1.getImage()).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon addIcon3 = new ImageIcon(img3);
			top3 = new JButton(addIcon3);
		} else {
			top3 = new JButton(addIcon);
		}

		top3.setContentAreaFilled(false);
		top3.setBorderPainted(false);
		top3.setToolTipText("Go to recipe"); // TODO link to recipe page
		top3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (recipes.size() >= 3) {
					// TODO recipe exits, so link it here
				}
			}

		});
		add(top1);
		add(top2);
		add(top3);

	}

	public ArrayList<Recipe> getSortedRecipes() {
		return sortedRecipes;
	}

	public void setSortedRecipes(ArrayList<Recipe> sortedRecipes) {
		this.sortedRecipes = sortedRecipes;
	}

	public Recipe getRecipe1() {
		return recipe1;
	}

	public void setRecipe1(Recipe recipe1) {
		this.recipe1 = recipe1;
	}

	public Recipe getRecipe2() {
		return recipe2;
	}

	public void setRecipe2(Recipe recipe2) {
		this.recipe2 = recipe2;
	}

	public Recipe getRecipe3() {
		return recipe3;
	}

	public void setRecipe3(Recipe recipe3) {
		this.recipe3 = recipe3;
	}

}
