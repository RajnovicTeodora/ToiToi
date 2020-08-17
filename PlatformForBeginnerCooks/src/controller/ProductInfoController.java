package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.ProductInfo;

public class ProductInfoController {

	private ProductInfo productInfo;
	
	private String productInfoFile;

	public ProductInfoController(ProductInfo productInfo, String productInfoFile) {
		super();
		this.productInfo = productInfo;
		this.productInfoFile = productInfoFile;
	}

	public ProductInfoController(String productInfoFile) {
		super();
		this.productInfoFile = productInfoFile;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductInfoFile() {
		return productInfoFile;
	}

	public void setProductInfoFile(String productInfoFile) {
		this.productInfoFile = productInfoFile;
	}
	
	public void writeProductInfo(ArrayList<ProductInfo> ProductInfoList)  {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(productInfoFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(ProductInfoList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				try {
					objectOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ProductInfo> readUsers(){
		ObjectInputStream objectIn = null;
		ArrayList<ProductInfo> ProductInfoList = null;
		try {
			FileInputStream fileIn = new FileInputStream(productInfoFile);
			objectIn = new ObjectInputStream(fileIn);
			ProductInfoList = (ArrayList<ProductInfo>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				try {
					objectIn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return ProductInfoList;
	}
}
