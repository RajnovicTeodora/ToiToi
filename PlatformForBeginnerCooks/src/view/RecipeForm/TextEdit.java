package view.RecipeForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import net.miginfocom.swing.MigLayout;

public class TextEdit extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea ta;
	private int count;
	private JMenuBar menuBar;
	private JMenu editM;
	private JScrollPane scpane;
	private JMenuItem cutI, copyI, pasteI, selectI;
	private String pad;

	//TODO CONTAINER

	public TextEdit() {

		setCount(0);
		setLayout(new MigLayout());
		setBackground(Color.white);
		setSize(450, 200);
		pad = " ";
		ta = new JTextArea(); // textarea
		ta.setPreferredSize(new Dimension(400, 150));
		
		menuBar = new JMenuBar(); // menubar
		editM = new JMenu("Edit"); // edit menu
		scpane = new JScrollPane(ta); // scrollpane and add textarea to scrollpane
		
		scpane.setPreferredSize(new Dimension(250,150));
		scpane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		cutI = new JMenuItem("Cut");
		copyI = new JMenuItem("Copy");
		pasteI = new JMenuItem("Paste");
		selectI = new JMenuItem("Select All"); // menuitems

		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		
		JPanel temp = new JPanel();
		temp.add(new JLabel("Description:                                    "));
		temp.add(menuBar, " wrap");
		temp.setBackground(Color.white);
		add(temp, "wrap");
		menuBar.add(editM);

		editM.add(cutI);
		editM.add(copyI);
		editM.add(pasteI);
		editM.add(selectI);

		cutI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		copyI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		pasteI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		selectI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		add(scpane, BorderLayout.CENTER);

		cutI.addActionListener(this);
		copyI.addActionListener(this);
		pasteI.addActionListener(this);
		selectI.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem choice = (JMenuItem) e.getSource();
		if (choice == cutI) {
			pad = ta.getSelectedText();
			ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
		} else if (choice == copyI)
			pad = ta.getSelectedText();
		else if (choice == pasteI)
			ta.insert(pad, ta.getCaretPosition());
		else if (choice == selectI)
			ta.selectAll();

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String confirm() {
		String returnVal = ta.getText();
		return returnVal;
	}
}
