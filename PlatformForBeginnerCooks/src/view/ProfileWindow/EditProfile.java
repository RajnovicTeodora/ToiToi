package view.ProfileWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.Gender;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.DataLabelFormatter;
import view.MainFrame;

public class EditProfile {
	
	private User user;
	
	
	public EditProfile(User user) {
		this.user = user;
		try {
			pocetak();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void pocetak() throws IOException{
		
		JFrame prozor = new JFrame();
		prozor.setIconImage(new ImageIcon("./img/logo.png").getImage());
		prozor.setSize(640, 700);
		prozor.setResizable(false);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setTitle("Edit profile");
		prozor.setLocationRelativeTo(null);
		
		JPanel  panel = new  JPanel(new MigLayout());
		
		JPanel panel1 = new JPanel(new MigLayout());
		JPanel imgPanel = new JPanel(new MigLayout());
		JPanel imagePanel = new JPanel();
		
		//panel za profilnu
		
		Border border = BorderFactory.createTitledBorder("Profile photo");
		imagePanel.setBorder(border);
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setPreferredSize(new Dimension(220, 220));
		
		//odabir slike za profilnu
		
		BufferedImage img = null;
		if (!user.getImage().equals("")) {
			img = ImageIO.read(new File(user.getImage()));
		} else {
			if (user.getGender() == Gender.FEMALE)
				img = ImageIO.read(new File("./img/user-female.png"));
			else if (user.getGender() == Gender.MALE)
				img = ImageIO.read(new File("./img/user.png"));
			else
				img = ImageIO.read(new File("./img/accessibility2.png"));
		}

		//Profilna
		
		ImageIcon profileIcon = new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel label = new JLabel();
		label.setIcon(profileIcon);
		imagePanel.add(label);
		
//		ImageIcon addIcon = new ImageIcon(new ImageIcon("img/addimg.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
//		JButton buttonAdd = new JButton(addIcon);
//		buttonAdd.setContentAreaFilled(false);
//		buttonAdd.setBorderPainted(false);
//		buttonAdd.setToolTipText("Add profile photo");
//		
//		buttonAdd.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fileChooser = new JFileChooser();
//				fileChooser.addChoosableFileFilter(new ImageFilter());
//				fileChooser.setAcceptAllFileFilterUsed(false);
//
//				int option = fileChooser.showOpenDialog(imgPanel);
//
//				if (option == JFileChooser.APPROVE_OPTION) {
//					File file = fileChooser.getSelectedFile();
//
//					try {
//						if (file.exists()) {
//							BufferedImage  image = ImageIO.read(file);
//							Image dimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//							ImageIcon icon = new ImageIcon(dimg);
//							label.setIcon(icon);
//						} else {
//							JOptionPane.showMessageDialog(null, "No image was found!", "Error!",
//									JOptionPane.ERROR_MESSAGE);
//
//						}
//					} catch (IOException ex) {
//
//						ex.printStackTrace();
//					}
//				} else {
//					label.setIcon(profileIcon);
//				}
//			}
//		});
		
		imgPanel.add(imagePanel, "span, wrap");
//		imgPanel.add(buttonAdd, "gapleft 5");
		
		panel1.add(imgPanel);
		
		//ime i prezime
		
		Font f  = new Font("Serif", Font.PLAIN, 20);
		
		JPanel panel2 = new JPanel(new MigLayout());
		
		JLabel ime = new JLabel("Name:");
		JLabel prezime = new JLabel("Surname:");
		
		ime.setFont(f);
		prezime.setFont(f);
		
		Color pozadina = new Color(255, 230, 255);
		Color ivicaColor = new Color(247,100,247);
		Border border2 = BorderFactory.createMatteBorder(2, 2, 2, 2, ivicaColor);
		
		JTextField imePolje = new JTextField(15);
		imePolje.setText(user.getName());
		imePolje.setBackground(pozadina);
		imePolje.setHorizontalAlignment(JTextField.CENTER);
		imePolje.setFont(f);
		
		JTextField prezimePolje = new JTextField(15);
		prezimePolje.setText(user.getSurname());
		prezimePolje.setBackground(pozadina);
		prezimePolje.setHorizontalAlignment(JTextField.CENTER);
		prezimePolje.setFont(f);
		
		panel2.add(ime);
		panel2.add(imePolje,"gaptop 50, wrap");
		panel2.add(prezime);
		panel2.add(prezimePolje, "gapbottom 50, wrap");
		panel2.setBorder(border2);
		
		//ostali podaci
		
		JPanel panel3 = new JPanel(new MigLayout());
		
		JLabel pol = new JLabel("Gender:");
		JLabel adresa = new JLabel("Adress:");
		JLabel mail = new JLabel("Mail:");
		JLabel brTel = new JLabel("Phone number:");
		JLabel korIme = new JLabel("Username:");
		JLabel loz = new JLabel("Password:");
		JLabel rodj = new JLabel("Birthday:");
				
		pol.setFont(f);
		adresa.setFont(f);
		mail.setFont(f);
		brTel.setFont(f);
		korIme.setFont(f);
		loz.setFont(f);
		rodj.setFont(f);
		
		String[] polovi = {Gender.MALE.toString(),  Gender.FEMALE.toString(), Gender.OTHER.toString()};
		
		if(user.getGender()==Gender.FEMALE) {
			polovi[0] = Gender.FEMALE.toString();
			polovi[1] = Gender.MALE.toString();
		}
		
		if(user.getGender()==Gender.OTHER) {
			polovi[0] = Gender.OTHER.toString();
			polovi[2] = Gender.MALE.toString();
		}

		
		JComboBox<String> jcb = new JComboBox<String>(polovi);
		jcb.setFont(f);
		jcb.setBackground(pozadina);
		
		
		JTextField adresaPolje = new JTextField(15);
		adresaPolje.setText(user.getAddress());
		adresaPolje.setBackground(pozadina);
		adresaPolje.setHorizontalAlignment(JTextField.CENTER);
		adresaPolje.setFont(f);
		
		JTextField brTelPolje = new JTextField(15);
		brTelPolje.setText(user.getTelephone());
		brTelPolje.setBackground(pozadina);
		brTelPolje.setHorizontalAlignment(JTextField.CENTER);
		brTelPolje.setFont(f);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		UtilDateModel model = new UtilDateModel(Date.from(user.getBirthday().atStartOfDay(defaultZoneId).toInstant()));
		JDatePanelImpl rodjPolje = new JDatePanelImpl(model, new Properties());
		rodjPolje.setBackground(pozadina);

		JDatePickerImpl date = new JDatePickerImpl(rodjPolje, new DataLabelFormatter());
		date.setBackground(pozadina);		
		
		brTelPolje.setText(user.getTelephone());
		brTelPolje.setBackground(pozadina);
		brTelPolje.setHorizontalAlignment(JTextField.CENTER);
		brTelPolje.setFont(f);
		
		JTextField mailPolje = new JTextField(15);
		mailPolje.setText(user.getMail());
		mailPolje.setBackground(pozadina);
		mailPolje.setHorizontalAlignment(JTextField.CENTER);
		mailPolje.setFont(f);
		
		JTextField korImePolje = new JTextField(user.getUsername());
		korImePolje.setColumns(15);
		korImePolje.setBackground(pozadina);
		korImePolje.setHorizontalAlignment(JTextField.CENTER);
		korImePolje.setFont(f);
		korImePolje.setEditable(false);
		korImePolje.setToolTipText("You can't change username :(");
		
		JTextField lozPolje = new JTextField(15);
		lozPolje.setText(user.getPassword());
		lozPolje.setBackground(pozadina);
		lozPolje.setHorizontalAlignment(JTextField.CENTER);
		lozPolje.setFont(f);
		
		panel3.add(pol);
		panel3.add(jcb, "wrap");
		panel3.add(adresa);
		panel3.add(adresaPolje, "wrap");
		panel3.add(mail);
		panel3.add(mailPolje, "wrap");
		panel3.add(brTel);
		panel3.add(brTelPolje, "wrap");
		panel3.add(rodj);
		panel3.add(date, "wrap");
		panel3.add(korIme);
		panel3.add(korImePolje, "wrap");
		panel3.add(loz);
		panel3.add(lozPolje, "gapright 300, gapbottom 30, wrap");
		
		JScrollPane jcp = new JScrollPane(panel3);
		jcp.setBorder(border2);
		
		//dugmici
		JButton potvrdi = new JButton("Confirm");
		JButton odustani = new JButton("Cancel");
		
		potvrdi.setIcon(new ImageIcon("img/confirm.png"));
		odustani.setIcon(new ImageIcon("img/cancel.png"));
		
		potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!prazno(imePolje)) {
					user.setName(imePolje.getText());
				}
				if(!prazno(prezimePolje)) {
					user.setSurname(prezimePolje.getText());
				}
				if(!prazno(adresaPolje)) {
					user.setAddress(adresaPolje.getText());
				}
				if(!prazno(mailPolje)) {
					user.setMail(mailPolje.getText());
				}
				if(!prazno(brTelPolje)) {
					user.setTelephone(brTelPolje.getText());
				}
				user.setGender(Gender.valueOf(polovi[jcb.getSelectedIndex()]));
				
				if(!prazno(lozPolje)) {
					user.setPassword(lozPolje.getText());
				}
				
				int day = model.getDay();
				int month = model.getMonth() + 1;
				int year = model.getYear();
				
				if(model.isSelected()) {
					String date;
					if (day < 10 && month < 10)
						date = "0" + day + "-" + "0" + month + "-" + year;
					else if (day < 10) {
						date = "0" + day + "-" + month + "-" + year;
					} else if (month < 10)
						date = day + "-" + "0" + month + "-" + year;

					else
						date = day + "-" + month + "-" + year;

					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate noviRodj = LocalDate.parse(date, format);
					user.setBirthday(noviRodj);
				}
				
				
				prozor.dispose();
			}
		});
		
		odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prozor.dispose();
			}
		});
		
		JPanel panel4 = new JPanel(new MigLayout());
		panel4.add(potvrdi, "gapleft 50, gapright 100");
		panel4.add(odustani, "gapleft 100");
		
		
		panel.add(imgPanel);
		panel.add(panel2, "wrap");
		panel.add(jcp, "span, gaptop 20, gapleft 10, wrap");
		panel.add(panel4, "span, wrap");
		
		prozor.add(panel);
		prozor.setVisible(true);
		
	}
	
	private boolean prazno(JTextField polje) {
		if(polje.getText()==null) {
			return false;
		}
		return true;
	}
	
//	private boolean proveraBrTel(String brTel) {
//		
//	}

	

}
