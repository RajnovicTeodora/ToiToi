package view;

import net.miginfocom.swing.MigLayout;
import view.CookBookPanel.CookBookPanel;
import view.HomePanel.HomePanel;
import view.ProfileWindow.ProfileWindow;
import view.SignUpForm.SignUpForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.ToiToiController;
import model.Admin;
import model.Akter;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainFrame instance;
	public static ToiToiController toiToiController;
	private Akter akter = null;
	private RecipesTab recipesTab;
	private RecipeWindow recipeWindow;
	public static JTabbedPane tabbedPane;
	private JPanel homePanel;
	private CommentWindow commentWindow;
	private EditRecipeWindow editRecipe;
	
	private JPanel pan1;
	public static ProfileWindow pw;
	private JButton logInBttn;
	private JButton signUpBttn;
	private JButton logOutBttn;
	
	protected SignUpForm signUp = null;
	protected SignInForm signIn = null;

	@SuppressWarnings("static-access")
	public MainFrame(ToiToiController tc) throws IOException {
		MainFrame.instance = this;
		MainFrame.toiToiController = tc;
		initialize();
	}



	private void initialize() {
		this.setSize(700, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		ImageIcon icon = new ImageIcon("./img/logo.png");
		this.setIconImage(icon.getImage());

		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		
		pan1 = new JPanel(new MigLayout());
		

		recipeWindow = new RecipeWindow(toiToiController);
		recipesTab = new RecipesTab(toiToiController);

		tabbedPane = new JTabbedPane();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		tabbedPane.setBounds(10, 50, (int) screenSize.getWidth(), (int) screenSize.getHeight());
		tabbedPane.addTab("", createPage1());
		
		try {

			recipesTab.setBottomPnl(toiToiController.getRecipeController().readRecipes());
			recipesTab.setCurrentRecipes(toiToiController.getRecipeController().readRecipes());
			tabbedPane.addTab("", recipesTab.createMainPanel() );


		} catch (IOException e) {

			e.printStackTrace();
		}
		tabbedPane.addTab("", CookBookPanel.createCookBookPanel(toiToiController.getCbController().sortByLikes(toiToiController.getToiToi().getCookBooks())));
		
		
		pan.add(tabbedPane, BorderLayout.CENTER);
		Font f = new Font("Serif", Font.PLAIN, 20);
		Dimension d = new Dimension(100, 30);

		JLabel lab1 = new JLabel("Home");
		lab1.setFont(f);
		lab1.setPreferredSize(d);
		tabbedPane.setTabComponentAt(0, lab1);

		JLabel lab2 = new JLabel("Recipes");
		lab2.setFont(f);
		lab2.setPreferredSize(d);
		tabbedPane.setTabComponentAt(1, lab2);

		JLabel lab3 = new JLabel("Cookbooks");
		lab3.setFont(f);
		lab3.setPreferredSize(d);
		tabbedPane.setTabComponentAt(2, lab3);
		
		JLabel title = new JLabel("         ToiToi");
		title.setFont(new Font("Serif", Font.ITALIC, 50));
		title.setPreferredSize(new Dimension(100, 40));

		signUpBttn = new JButton("Sign up");
		
		signUpBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(signUp == null))
					signUp.dispose();
				signUp = new SignUpForm(toiToiController);
				signUp.setVisible(true);

			}
		});
		signUpBttn.setSize(50, 30);
		
		logInBttn = new JButton("Log in");
		
		logInBttn.setSize(50, 30);
		logInBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(signIn == null))
					signIn.dispose();


				signIn = new SignInForm(toiToiController);
				signIn.setVisible(true);
				signIn.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
					}

					@Override
					public void windowIconified(WindowEvent e) {
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
					}

					@Override
					public void windowClosing(WindowEvent e) {
					}

					@Override
					public void windowClosed(WindowEvent e) {
						akter = signIn.getAkter();

						if (akter != null) {
							if(akter.getClass() != Admin.class) {
								pw = new ProfileWindow(akter, toiToiController);
								try {
									tabbedPane.addTab("", pw.createMyProfilePage());
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								JLabel lab4 = new JLabel("My profile");
								lab4.setFont(f);
								lab4.setPreferredSize(d);
								tabbedPane.setTabComponentAt(3, lab4);
								loggedInUser();
							}
							
						}
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}
				});

			}
		});
		
		pan1.add(title, "gapleft 150");
		pan1.add(signUpBttn, "gapleft 100");
		pan1.add(logInBttn);

		JPanel masterPan = new JPanel();
		masterPan.setLayout(new BorderLayout());
		masterPan.add(pan, BorderLayout.CENTER);
		masterPan.add(pan1, BorderLayout.NORTH);
		getContentPane().add(masterPan);

		setVisible(true);
	}

	public JPanel createPage1() {
		JPanel panel = new HomePanel(toiToiController);

		panel.setBackground(new Color(200, 221, 242));
		setHomePanel(panel);

		return panel;
	}
	
	private void loggedInUser() {
		pan1.remove(logInBttn);
		pan1.remove(signUpBttn);
		pan1.repaint();
		logOutBttn =  new JButton("Log out");
		pan1.add(logOutBttn, "gapleft 100");
				
		logOutBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirm Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, new ImageIcon("./img/signOut.png"));
				if (reply == JOptionPane.YES_OPTION) {
					akter = null;
					tabbedPane.remove(3);
					loggedOutUser();
				}

			}

		});
	}
	
	private void loggedOutUser() {
		pan1.remove(logOutBttn);
		pan1.repaint();
		pan1.add(signUpBttn, "gapleft 100");
		pan1.add(logInBttn);

	}


	public static MainFrame getInstance() {
		return instance;
	}



	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	public RecipesTab getRecipesTab() {
		return recipesTab;
	}


	public void setRecipesTab(RecipesTab recipesTab) {
		this.recipesTab = recipesTab;
	}


	public ToiToiController getToiToiController() {
		return toiToiController;
	}


	public void setToiToiController(ToiToiController toiToiController) {
		MainFrame.toiToiController = toiToiController;
	}


	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}


	public void setTabbedPane(JTabbedPane tabbedPane) {
		MainFrame.tabbedPane = tabbedPane;
	}


	public RecipeWindow getRecipeWindow() {
		return recipeWindow;
	}


	public void setRecipeWindow(RecipeWindow recipeWindow) {
		this.recipeWindow = recipeWindow;
	}


	public Akter getAkter() {
		return akter;
	}


	public void setAkter(Akter akter) {
		this.akter = akter;
	}


	public JPanel getHomePanel() {
		return homePanel;
	}


	public void setHomePanel(JPanel homePanel) {
		this.homePanel = homePanel;
	}


	public CommentWindow getCommentWindow() {
		return commentWindow;
	}


	public void setCommentWindow(CommentWindow commentWindow) {
		this.commentWindow = commentWindow;
	}


	public EditRecipeWindow getEditRecipe() {
		return editRecipe;
	}


	public void setEditRecipe(EditRecipeWindow editRecipe) {
		this.editRecipe = editRecipe;
	}

	
	
	
}
