package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import controller.ToiToiController;
import model.User;

public class Tests {
	ToiToiController toiToiController = new ToiToiController();
	User user;
	
	@Before 
	public void ucitajPodatke() throws IOException {
		toiToiController.readData();
		user = (User) toiToiController.getToiToi().users.get(2);
	}
	
	
	@Test
	public void calculatePointsTest() throws IOException {
		assertEquals(0, user.calculatePoints());
	}
	
	@Test
	public void freeIdEquipmentTest() throws IOException {
		assertEquals(3, toiToiController.getEquipmentController().freeId(user.getEquipment()));
	}
	
	@Test 
	public void freeIdRecipeTest() throws IOException {
		assertEquals(1, toiToiController.getRecipeController().freeId(user.getRecipes()));
	}
	
	@Test 
	public void logInTest() throws IOException {
		assertNull(toiToiController.checkUser("a", "a"));
		assertNotNull(toiToiController.checkUser("p", "p"));
	}
	
	

}
