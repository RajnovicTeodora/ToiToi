package view.CookBookPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CookBook;
import net.miginfocom.swing.MigLayout;
import view.MainFrame;

public class CookBookPanel {
	static List<CookBook> lista;
	static boolean dodajSearchPanel = false;
	static JPanel Panel;
	static TopCookBooksPanel topLista;
	
	
	public static JPanel createCookBookPanel(List<CookBook> cookBooks) throws IOException {
		JPanel panel = new JPanel(new MigLayout());
		
		JPanel searchPanel = new JPanel(new MigLayout());
		searchPanel.setBackground((new Color(204, 204, 255)));
		
		JLabel naslov = new JLabel("Search cookbooks");
		naslov.setFont(new Font("Serif", Font.ITALIC, 20));
		
		searchPanel.add(naslov, "wrap");
		
		JTextField polje = new JTextField(100);
		
		JButton dugmic = new JButton("Search");
		
		topLista = new TopCookBooksPanel(cookBooks);
		Panel  = topLista.createTopCookBooksPanel();
		
		dugmic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(polje.getText()!=null) {
					lista = search(polje.getText());
					SelectedCookBooksPanel sp = new SelectedCookBooksPanel(lista);
					if(lista.size() != 0) {
						dodajSearchPanel = true;
						try {
							panel.remove(Panel);
							Panel = sp.createSelectedCookBooksPanel();
							panel.add(Panel);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
					else {
						panel.remove(Panel);
						try {
							Panel = topLista.createTopCookBooksPanel();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						panel.add(Panel);
					}
				}
			}
		});
		
		searchPanel.add(polje);
		searchPanel.add(dugmic);
		
		
		panel.add(searchPanel, "wrap");
		
		

		panel.add(Panel);
		
		return panel;
	}
	
	private static List<CookBook> search(String ime){
		List<CookBook> lista = new ArrayList<CookBook>();
		
		for(CookBook cb : MainFrame.toiToiController.getToiToi().getCookBooks()) {
			if(cb.getName().equalsIgnoreCase(ime)) {
				System.out.println("Isto");
				lista.add(cb);
			}
			
			else if(ime.toLowerCase().contains(cb.getName().toLowerCase())) {
				System.out.println("skoro isto");
				lista.add(cb);
			}
			
			else if(cb.getName().toLowerCase().contains(ime.toLowerCase())) {
				System.out.println("skoro isto");
				lista.add(cb);
			}
			
		}
		
		lista = MainFrame.toiToiController.getCbController().sortByName(lista, ime);
		
		return lista;
	}
	

	

}
