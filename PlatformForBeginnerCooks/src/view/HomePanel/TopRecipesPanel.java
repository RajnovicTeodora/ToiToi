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
	private JLabel name1;
	private JLabel user1;
	private JLabel like1;

	protected JButton top2;
	private Recipe recipe2;
	private JLabel name2;
	private JLabel user2;
	private JLabel like2;

	protected JButton top3;
	private JLabel name3;
	private Recipe recipe3;
	private JLabel user3;
	private JLabel like3;

	public TopRecipesPanel(ArrayList<Recipe> recipes) {
		this.setSortedRecipes(recipes);
		this.setBackground(new Color(200, 221, 242));
		this.setLayout(new MigLayout("", "10 [] 10 [] 10 []", "[] 20 []"));

		ImageIcon like = new ImageIcon("./img/heart.png");

		Image dimg = new ImageIcon("img/cancel-2.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon addIcon = new ImageIcon(dimg);

		JPanel title = new JPanel();
		JLabel l1 = new JLabel("ToiToi recipe leadership!");
		title.add(l1);
		title.setBackground(new Color(200, 221, 242));
		add(title, "wrap");

		JPanel recipesPanel = new JPanel(new MigLayout());
		recipesPanel.setBackground(new Color(200, 221, 242));

		JPanel panel1 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel1.setBackground(new Color(200, 221, 242));
		if (recipes.size() >= 1) {
			recipe1 = recipes.get(0);

			Image img1 = new ImageIcon(recipe1.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon1 = new ImageIcon(img1);
			top1 = new JButton(addIcon1);
			name1 = new JLabel(recipe1.getName());
			user1 = new JLabel("By " + recipe1.getCreator().getUsername());
			like1 = new JLabel(recipe1.getLikes() + " Likes", like, JLabel.RIGHT);
		} else {
			top1 = new JButton(addIcon);
			name1 = new JLabel("None");
			user1 = new JLabel("None");
			like1 = new JLabel("0" + " Likes", like, JLabel.RIGHT);
		}

		top1.setContentAreaFilled(false);
		// top1.setBorderPainted(false);
		top1.setToolTipText("Go to recipe");
		top1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (recipes.size() >= 1) {
					// TODO recipe exits, so link it here
				}

			}

		});

		panel1.add(top1, "wrap");
		panel1.add(name1, "wrap");
		panel1.add(user1, "wrap");
		panel1.add(like1);

		JPanel panel2 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel2.setBackground(new Color(200, 221, 242));
		if (recipes.size() >= 2) {
			recipe2 = recipes.get(1);

			Image img2 = new ImageIcon(recipe2.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon2 = new ImageIcon(img2);
			top2 = new JButton(addIcon2);
			name2 = new JLabel(recipe2.getName());
			user2 = new JLabel("By " + recipe2.getCreator().getUsername());
			like2 = new JLabel(recipe2.getLikes() + " Likes", like, JLabel.RIGHT);
		} else {
			top2 = new JButton(addIcon);
			name2 = new JLabel("None");
			user2 = new JLabel("None");
			like2 = new JLabel("0" + " Likes", like, JLabel.RIGHT);
		}

		top2.setContentAreaFilled(false);
		// top2.setBorderPainted(false);
		top2.setToolTipText("Go to recipe"); // TODO link to recipe page
		top2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (recipes.size() >= 2) {
					// TODO recipe exits, so link it here
				}
			}

		});

		panel2.add(top2, "wrap");
		panel2.add(name2, "wrap");
		panel2.add(user2, "wrap");
		panel2.add(like2);

		JPanel panel3 = new JPanel(new MigLayout("", "", "[]10[][]"));
		panel3.setBackground(new Color(200, 221, 242));
		if (recipes.size() >= 3) {
			recipe3 = recipes.get(2);

			Image img3 = new ImageIcon(recipe3.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon3 = new ImageIcon(img3);
			top3 = new JButton(addIcon3);
			name3 = new JLabel(recipe3.getName());
			user3 = new JLabel("By " +  recipe3.getCreator().getUsername());
			like3 = new JLabel(recipe3.getLikes() + " Likes", like, JLabel.RIGHT);
		} else {
			top3 = new JButton(addIcon);
			name3 = new JLabel("None");
			user3 = new JLabel("None");
			like3 = new JLabel("0" + " Likes", like, JLabel.RIGHT);
		}

		top3.setContentAreaFilled(false);
		// top3.setBorderPainted(false);
		top3.setToolTipText("Go to recipe"); // TODO link to recipe page
		top3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (recipes.size() >= 3) {
					// TODO recipe exits, so link it here
				}
			}

		});
		panel3.add(top3, "wrap");
		panel3.add(name3, "wrap");
		panel3.add(user3, "wrap");
		panel3.add(like3);

		recipesPanel.add(panel1);
		recipesPanel.add(panel2);
		recipesPanel.add(panel3);

		add(recipesPanel);
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
