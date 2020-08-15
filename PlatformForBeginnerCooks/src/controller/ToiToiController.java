package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Equipment;
import model.Product;
import model.Tag;
import model.ToiToi;

public class ToiToiController {

	private ToiToi toiToi = new ToiToi();

	private static final String equipmentFile = "./src/data/equipment";
	private EquipmentController equipmentController = new EquipmentController(equipmentFile);

	private static final String productFile = "./src/data/products";
	private ProductController productController = new ProductController(productFile);

	private static final String tagFile = "./src/data/tags";
	private TagController tagController = new TagController(tagFile);

	public ToiToiController() {
		super();

	}

	public void writteData() {

		// PRAVLJENJE OBJEKATA PA IH UPISEM PA TEK ONDA UCITAM, OVAKO ZA POCETAK PA CE KASNIJE ICI DRUGACIJE
		Equipment e1 = new Equipment("Serpa", "Metalac", "Duboka serpa, precnik 5cm");
		Equipment e2 = new Equipment("Tanjir", "Home", "Beli tanjir, precnik 10, keramika");

		ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		equipmentList.add(e1);
		equipmentList.add(e2);

		Product p1 = new Product("Banana", "AfrikaProduces", 1);
		Product p2 = new Product("Sladoled vanila", "Frikom", 2);
		Product p3 = new Product("Sladoled cokolada", "Frikom", 3);
		Product p4 = new Product("Sladoled jagoda", "Frikom", 4);
		Product p5 = new Product("Preliv od cokolade", "Nestle", 5);
		ArrayList<Product> ingredients = new ArrayList<Product>();
		ingredients.add(p1);
		ingredients.add(p2);
		ingredients.add(p3);
		ingredients.add(p4);
		ingredients.add(p5);

		Product p6 = new Product("Banana split", "", 6, ingredients);
		ArrayList<Product> ingredients1 = new ArrayList<Product>();

		ingredients1.add(p1);
		ingredients1.add(p2);
		ingredients1.add(p3);
		ingredients1.add(p4);
		ingredients1.add(p5);
		ingredients1.add(p6);

		
		Tag t1 = new Tag("Kineska kuhinja");
		Tag t2 = new Tag("Vegan");
		ArrayList<Tag> tagList = new ArrayList<Tag>();
		tagList.add(t1);
		tagList.add(t2);
		// OVDJE IDU POZIVI KONTROLERA ZA UPIS
		try {
			this.equipmentController.writeEquipment(equipmentList);
			this.productController.writeProducts(ingredients1);
			this.tagController.writeTags(tagList);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void readData() {

		// OVDJE IDU POZIVI ZA CITANJE
		try {
			toiToi.setEquipment(this.equipmentController.readEquipment());
			// System.out.println(toiToi.getEquipment());
			toiToi.setProducts(this.productController.readProducts());
			//System.out.println(toiToi.getProducts());
			toiToi.setTags(this.tagController.readTags());
			System.out.println(toiToi.getTags());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
