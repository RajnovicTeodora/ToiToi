package view.CookBookForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ButtonActions.RecipeImageButtonAction;
import model.Recipe;
import net.miginfocom.swing.MigLayout;

public class SingleRecipePanel extends JPanel {

	/**
	 * 
	 */
	protected JCheckBox cb;

	private static final long serialVersionUID = 1L;
	private Recipe recipe;

	public SingleRecipePanel(Recipe recipe) {

		this.setRecipe(recipe);
		this.setPreferredSize(new Dimension(450, 110));
		this.setLayout(new MigLayout());
		this.setBackground(new Color(248, 226, 255));
		
		JPanel textPnl = new JPanel(new MigLayout());
		textPnl.setBackground(new Color(248, 226, 255));
		
		RecipeImageButtonAction recAction = new RecipeImageButtonAction();
		recAction.setTabIndex(1);
		recAction.setRecipe(recipe);

		Image image = new ImageIcon(recipe.getImage()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		JButton imgBtn = new JButton(icon);
		imgBtn.addActionListener(recAction);
		imgBtn.setContentAreaFilled(false);
		imgBtn.setBorderPainted(false);
		imgBtn.setToolTipText("View recipe");
		imgBtn.setMnemonic(KeyEvent.VK_ENTER);

		JLabel recipeName = new JLabel(recipe.getName());
		recipeName.setFont(new Font("Serif", Font.PLAIN, 20));
		recipeName.setPreferredSize(new Dimension(50, 20));

		Image heart = new ImageIcon("./img/heart.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon like = new ImageIcon(heart);
		JLabel likes = new JLabel(recipe.getLikes() + " Likes", like, JLabel.LEFT);

		JLabel datelbl = new JLabel(recipe.getDateCreated().toString());
		ImageIcon star = new ImageIcon("./img/star.png");
		JLabel diffLbl = new JLabel(" difficulty: " + recipe.getDifficulty(), star, JLabel.LEFT);

		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(248, 226, 255));
		
		bottom.add(likes);
		bottom.add(diffLbl);

		textPnl.add(datelbl, "left, wrap");
		textPnl.add(recipeName, "wrap");
		textPnl.add(bottom, "wrap");

		cb = new JCheckBox();
		JLabel select = new JLabel("Select recipe: ");

		JPanel cbPanel = new JPanel();
		cbPanel.setBackground(new Color(248, 226, 255));
		
		cbPanel.add(select);
		cbPanel.add(cb);

		textPnl.add(cbPanel);

		this.add(imgBtn, "split");
		this.add(textPnl, "wrap");
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));

	}
	
	public Boolean confirm() {
		return cb.isSelected();
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
