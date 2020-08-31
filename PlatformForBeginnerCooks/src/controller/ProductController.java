package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Product;

public class ProductController {

	private Product product;

	private String productFile;

	public ProductController(String productfile) {

		super();
		this.productFile = productfile;

	}

	public void writeProducts(ArrayList<Product> productList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(productFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(productList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Product> readProducts() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<Product> productList = null;
		try {
			FileInputStream fileIn = new FileInputStream(productFile);
			objectIn = new ObjectInputStream(fileIn);
			productList = (ArrayList<Product>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return productList;

	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
