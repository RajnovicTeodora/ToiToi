package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.User;
import model.Admin;
import model.Akter;
import model.Comment;
import model.CookBook;
import model.Equipment;
import model.Gender;
import model.NeededQuantity;
import model.Product;
import model.ProductInfo;
import model.Recipe;
import model.Tag;
import model.Taste;
import model.ToiToi;

public class ToiToiController {

	private ToiToi toiToi = new ToiToi("ToiToi", "065 123 456");

	private static final String equipmentFile = "./data/equipment";
	private EquipmentController equipmentController = new EquipmentController(equipmentFile);

	private static final String productFile = "./data/products";
	private ProductController productController = new ProductController(productFile);

	private static final String tagFile = "./data/tags";
	private TagController tagController = new TagController(tagFile);

	private static final String userFile = "./data/users";
	private UserController userController = new UserController(userFile);

	private static final String akterFile = "./data/akters";
	private AkterController akterController = new AkterController(akterFile);

	private static final String commentFile = "./data/comments";
	private CommentController commentController = new CommentController(commentFile);

	private static final String recipeFile = "./data/recipes";
	private RecipeController recipeController = new RecipeController(recipeFile);

	private static final String cbFile = "./data/cookbook";
	private CookBookController cbController = new CookBookController(cbFile);

	private static final String nqFile = "./data/neededQuantity";
	private NeededQuantityController nqController = new NeededQuantityController(nqFile);

	public ToiToiController() {
		super();

	}

	public void writteData() {

		// PRAVLJENJE OBJEKATA PA IH UPISEM PA TEK ONDA UCITAM, OVAKO ZA POCETAK PA CE
		// KASNIJE ICI DRUGACIJE

		/*
		 * Equipment e1 = new Equipment(1, "Serpa", "Metalac",
		 * "Duboka serpa, precnik 5cm"); Equipment e2 = new Equipment(2, "Tanjir",
		 * "Home", "Beli tanjir, precnik 10, keramika"); Equipment e3 = new Equipment(3,
		 * "Tepsija", "Metalac", "precnik 10");
		 * 
		 * ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		 * equipmentList.add(e1); equipmentList.add(e2); equipmentList.add(e3);
		 * 
		 * Product p1 = new Product("Banana", "AfrikaProduces", 1); Product p2 = new
		 * Product("Sladoled vanila", "Frikom", 2); Product p3 = new
		 * Product("Sladoled cokolada", "Frikom", 3); Product p4 = new
		 * Product("Sladoled jagoda", "Frikom", 4); Product p5 = new
		 * Product("Preliv od cokolade", "Nestle", 5); Product p16 = new
		 * Product("Cheese", "President", 16); Product p7 = new Product("Pizza crust",
		 * "Betty Crocker", 7); Product p8 = new Product("Lemon", "Baileys", 8); Product
		 * p9 = new Product("Pepperoni", "Hormel", 9); Product p10 = new Product("Rice",
		 * "Uncle Bens", 10); Product p11 = new Product("Roasted seaweed", "Kirkland",
		 * 11); Product p12 = new Product("Veggies", "Frikom", 12); Product p13 = new
		 * Product("Smoked salmon", "HappyFish", 13); Product p14 = new
		 * Product("Chocolate", "Cadbury", 14); Product p15 = new Product("Cake batter",
		 * "Betty Crocker", 15); Product p17 = new Product("Mint", "Frikom", 17);
		 * ArrayList<Product> ingredients = new ArrayList<Product>();
		 * ingredients.add(p1); ingredients.add(p2); ingredients.add(p3);
		 * ingredients.add(p4); ingredients.add(p5);
		 * 
		 * Product p6 = new Product("Banana split", "", 6, ingredients);
		 * ArrayList<Product> ingredients1 = new ArrayList<Product>();
		 * 
		 * ingredients1.add(p1); ingredients1.add(p2); ingredients1.add(p3);
		 * ingredients1.add(p4); ingredients1.add(p5); ingredients1.add(p6);
		 * 
		 * ingredients1.add(p16); ingredients1.add(p7); ingredients1.add(p8);
		 * ingredients1.add(p9); ingredients1.add(p10); ingredients1.add(p11);
		 * ingredients1.add(p12); ingredients1.add(p13); ingredients1.add(p14);
		 * ingredients1.add(p15); ingredients1.add(p17);
		 * 
		 * Tag t1 = new Tag("Chinese"); Tag t2 = new Tag("Vegan"); Tag t3 = new
		 * Tag("Italian"); ArrayList<Tag> tagList = new ArrayList<Tag>();
		 * tagList.add(t1); tagList.add(t2); tagList.add(t3);
		 * 
		 * DateTimeFormatter x = DateTimeFormatter.ofPattern("yyyy-MM-dd"); LocalDate d1
		 * = LocalDate.parse("1999-12-12", x);
		 * 
		 * ArrayList<ProductInfo> peraProducts = new ArrayList<ProductInfo>();
		 * ProductInfo pi3 = new ProductInfo(11.1, LocalDate.parse("2020-12-12"), p3);
		 * ProductInfo pi2 = new ProductInfo(10.1, LocalDate.parse("2020-12-10"), p2);
		 * ProductInfo pi5 = new ProductInfo(5.1, LocalDate.parse("2020-12-25"), p5);
		 * peraProducts.add(pi3); peraProducts.add(pi2); peraProducts.add(pi5);
		 * ArrayList<String>peraAlergies = new ArrayList<String>();
		 * peraAlergies.add(p1.getName()); ArrayList<Equipment> peraEq = new
		 * ArrayList<Equipment>(); peraEq.add(e1); User u1 = new User("Pera", "Peric",
		 * "p", "p", "pera@gmail.com", Gender.MALE, d1, "Glavna 73 NS", "123456", 0,
		 * peraProducts, peraAlergies, peraEq); u1.setImage(""); u1.setLikedRecipes(new
		 * ArrayList<Recipe>()); Admin a1 = new Admin("MILIVOJE", "MILIVOJEVIC", "m",
		 * "m", "MAIL");
		 * 
		 * ArrayList<Akter> userList = new ArrayList<Akter>(); userList.add(u1);
		 * userList.add(a1);
		 * 
		 * Comment com = new Comment(); com.setDate(d1); com.setText("Prelepo!");
		 * com.commentator = u1; Comment dete = new Comment(); dete.setDate(d1);
		 * dete.setText("<3"); dete.commentator = u1; com.addChild(dete);
		 * ArrayList<Comment> commentList = new ArrayList<Comment>();
		 * commentList.add(com); LocalDate d2 = LocalDate.parse("2020-09-12", x);
		 * LocalDate d3 = LocalDate.parse("2019-09-11", x); LocalDate d4 =
		 * LocalDate.parse("2020-03-21", x);
		 * 
		 * 
		 * Recipe recipe = new Recipe(); recipe.setRecipeID(1);
		 * recipe.setDescription("Najlepsi milkshake koji cete ikada probati!");
		 * recipe.setLikes(12); recipe.setName("Milkshake"); recipe.addComment(com);
		 * recipe.addTags(t2); recipe.addTastes(Taste.sweet);
		 * recipe.addTastes(Taste.tangy); recipe.addEquipment(e1);
		 * recipe.setImage("./data/RecipeImage/milkshake.png");
		 * recipe.setDateCreated(d2); recipe.setCreator(u1);
		 * 
		 * Recipe recipe2 = new Recipe(); recipe2.setName("Pepperoni pizza");
		 * recipe2.setCreator(u1); recipe2.setRecipeID(2);
		 * recipe2.setDescription("Step1: preheat the oven to 180" +
		 * "Step2: place all your toppings on top of the piza crust" +
		 * "Step3: Bake in a preheated oven for 10 – 11 mins on 180 C and 2-3 mins on 220 C."
		 * +
		 * "Step4: Take it out rest it for 2 – 3 minutes and the serve the homemade pizza"
		 * ); recipe2.setLikes(15); recipe2.addComment(com); recipe2.addTags(t3);
		 * recipe2.addTastes(Taste.salty); recipe2.addTastes(Taste.spicy);
		 * recipe2.addEquipment(e3); recipe2.setImage("./data/RecipeImage/pizza.jpg");
		 * recipe2.setDateCreated(d2); NeededQuantity nqy9 = new NeededQuantity(1.0,
		 * true, p7); NeededQuantity nqy10 = new NeededQuantity(4.0, true, p16);
		 * NeededQuantity nqy11 = new NeededQuantity(10.0, true, p9); NeededQuantity
		 * nqy12 = new NeededQuantity(1.0, false, p17); recipe2.addNeededQuantity(nqy9);
		 * recipe2.addNeededQuantity(nqy10); recipe2.addNeededQuantity(nqy11);
		 * recipe2.addNeededQuantity(nqy12); recipe2.setServings(6);
		 * recipe2.setCookTime(20); recipe2.setPrepTime(10); recipe2.setDifficulty(2);
		 * 
		 * Recipe recipe3 = new Recipe(); recipe3.setName("Lemonade");
		 * recipe3.setCreator(u1); recipe3.setRecipeID(3); recipe3.
		 * setDescription("Step1: In a small saucepan, combine sugar and 1 cup water.Allow to boil then wait to chill"
		 * +
		 * "Step2: In pitcher, stir together chilled syrup, lemon juice and remaining 7 cups water"
		 * ); recipe3.setLikes(1); recipe3.addComment(com); recipe3.addTags(t2);
		 * recipe3.addTastes(Taste.sweet); recipe3.addTastes(Taste.sour);
		 * recipe3.addEquipment(e1);
		 * recipe3.setImage("./data/RecipeImage/lemonade.jpg");
		 * recipe3.setDateCreated(d3); NeededQuantity nqy7 = new NeededQuantity(5.0,
		 * true, p8); NeededQuantity nqy8 = new NeededQuantity(3.0, false, p17);
		 * recipe3.addNeededQuantity(nqy7); recipe3.addNeededQuantity(nqy8);
		 * recipe3.setServings(10); recipe3.setCookTime(0); recipe3.setPrepTime(5);
		 * recipe3.setDifficulty(1);
		 * 
		 * Recipe recipe4 = new Recipe(); recipe4.setName("Sushi rolls");
		 * recipe4.setCreator(u1); recipe4.setRecipeID(4);
		 * recipe4.setDescription("Step1: Cook your rice and wait to chill" +
		 * "Step2: Lay your seaweed flat on a cloth, put a layer of rice on top, and place your veggies and salmon in one line"
		 * + "Step3: Roll the seaweed in a tube, and seal the opening" +
		 * "Step4: Slice the tube in rolls and enyoj"); recipe4.setLikes(33);
		 * recipe4.addComment(com); recipe4.addTags(t1); recipe4.addTastes(Taste.salty);
		 * recipe4.addEquipment(e1);
		 * recipe4.setImage("./data/RecipeImage/sushi rolls.jpg");
		 * recipe4.setDateCreated(d4); NeededQuantity nqy3 = new NeededQuantity(1.0,
		 * true, p10); NeededQuantity nqy4 = new NeededQuantity(10.0, true, p11);
		 * NeededQuantity nqy5 = new NeededQuantity(5.0, true, p12); NeededQuantity nqy6
		 * = new NeededQuantity(2.0, false, p13); recipe4.addNeededQuantity(nqy3);
		 * recipe4.addNeededQuantity(nqy4); recipe4.addNeededQuantity(nqy5);
		 * recipe4.addNeededQuantity(nqy6); recipe4.setServings(10);
		 * recipe4.setCookTime(0); recipe4.setPrepTime(45); recipe4.setDifficulty(5);
		 * 
		 * Recipe recipe5 = new Recipe(); recipe5.setName("Vegan chocolate cake");
		 * recipe5.setCreator(u1); recipe5.setRecipeID(5); recipe5.
		 * setDescription("Step1: Preheat the oven to 180C and mix all your ingredients"
		 * + "Step2: bake it for 30 minutes and leave to chill"); recipe5.setLikes(21);
		 * recipe5.addComment(com); recipe5.addTags(t2); recipe5.addTastes(Taste.sweet);
		 * recipe5.addTastes(Taste.savoury); recipe5.addEquipment(e1);
		 * recipe5.setImage("./data/RecipeImage/veganChocolateCake.jpg");
		 * recipe5.setDateCreated(d3); NeededQuantity nqy1 = new NeededQuantity(2.0,
		 * true, p15); NeededQuantity nqy2 = new NeededQuantity(1.0, false, p14);
		 * recipe5.addNeededQuantity(nqy1); recipe5.addNeededQuantity(nqy2);
		 * recipe5.setServings(8); recipe5.setCookTime(30); recipe5.setPrepTime(20);
		 * recipe5.setDifficulty(3);
		 * 
		 * Recipe recipe6 = new Recipe(); recipe6.setName("Mini lemon cakes");
		 * recipe6.setCreator(u1); recipe6.setRecipeID(6); recipe6.
		 * setDescription("Step1: In a small saucepan, combine sugar and 1 cup water.Allow to boil then wait to chill"
		 * +
		 * "Step2: In pitcher, stir together chilled syrup, lemon juice and remaining 7 cups water"
		 * ); recipe6.setLikes(29); recipe6.addComment(com); recipe6.addTags(t2);
		 * recipe6.addTastes(Taste.sweet); recipe6.addEquipment(e1);
		 * recipe6.setImage("./data/RecipeImage/lemoncake.jpg");
		 * recipe6.setDateCreated(d3); recipe6.addNeededQuantity(new NeededQuantity(1.0,
		 * true, p15)); recipe6.addNeededQuantity(new NeededQuantity(2.0, true, p14));
		 * recipe6.addNeededQuantity(new NeededQuantity(1.0, false, p5));
		 * recipe6.addNeededQuantity(new NeededQuantity(5.0, true, p8));
		 * recipe6.setServings(8); recipe6.setCookTime(30); recipe6.setPrepTime(20);
		 * recipe6.setDifficulty(4);
		 * 
		 * recipe.setCreator(u1); recipe.setServings(2); recipe.setCookTime(0);
		 * recipe.setPrepTime(30); recipe.setDifficulty(1); recipe.setCookTime(5);
		 * recipe.setCreator(u1);
		 * 
		 * ArrayList<NeededQuantity> nqList = new ArrayList<NeededQuantity>();
		 * nqList.add(nqy1); nqList.add(nqy2); nqList.add(nqy3); nqList.add(nqy4);
		 * nqList.add(nqy5); nqList.add(nqy6); nqList.add(nqy7); nqList.add(nqy8);
		 * nqList.add(nqy9); nqList.add(nqy10); nqList.add(nqy11); nqList.add(nqy12);
		 * NeededQuantity nq1 = new NeededQuantity(); nq1.setIngredient(p1);
		 * nq1.setQuantity(2.0); nq1.setEssential(true); NeededQuantity nq2 = new
		 * NeededQuantity(); nq2.setIngredient(p4); nq2.setQuantity(1.0);
		 * nq2.setEssential(true); NeededQuantity nq3 = new NeededQuantity();
		 * nq3.setIngredient(p5); nq3.setQuantity(1.0); nq3.setEssential(false);
		 * nqList.add(nq1); nqList.add(nq2); nqList.add(nq3);
		 * 
		 * recipe.addNeededQuantity(nq1); recipe.addNeededQuantity(nq2);
		 * recipe.addNeededQuantity(nq3); ArrayList<Recipe> recipeList = new
		 * ArrayList<Recipe>(); recipeList.add(recipe); u1.setRecipes(recipeList);
		 * 
		 * recipeList.add(recipe2); recipeList.add(recipe3); recipeList.add(recipe4);
		 * recipeList.add(recipe5); recipeList.add(recipe6);
		 * 
		 * CookBook cb = new CookBook(); cb.setCreator(u1);
		 * cb.setName("Slatki recepti"); cb.setImage("./data/RecipeImage/sweetsCB.jpg");
		 * cb.setDate(d1); cb.setLikes(100); cb.setRecipes(recipeList);
		 * cb.setComments(commentList); ArrayList<CookBook> cbList = new
		 * ArrayList<CookBook>(); u1.setCookBooks(cbList); cbList.add(cb);
		 * u1.setCookBooks(cbList);
		 */

		// OVDJE IDU POZIVI KONTROLERA ZA UPIS
		try {

			/*
			 * this.equipmentController.writeEquipment(equipmentList);
			 * this.productController.writeProducts(ingredients1);
			 * this.tagController.writeTags(tagList);
			 * this.akterController.writeAkters(userList);
			 * this.commentController.writeComments(commentList);
			 * this.recipeController.writeRecipes(recipeList);
			 * this.cbController.writeCookBook(cbList); this.nqController.writeNQ(nqList);
			 */

			this.equipmentController.writeEquipment((ArrayList<Equipment>) toiToi.getEquipment());
			this.productController.writeProducts((ArrayList<Product>) toiToi.getProducts());
			this.tagController.writeTags((ArrayList<Tag>) toiToi.getTags());
			// System.out.println(toiToi.getUsers());
			this.akterController.writeAkters((ArrayList<Akter>) toiToi.getUsers()); //
			// this.commentController.writeComments(toiToi.get;
			this.recipeController.writeRecipes((ArrayList<Recipe>) toiToi.getRecipe());
			this.cbController.writeCookBook((ArrayList<CookBook>) toiToi.getCookBooks());
			// this.nqController.writeNQ(toi);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void readData() {

		try {
			toiToi.setEquipment(this.equipmentController.readEquipment());
			// System.out.println(toiToi.getEquipment());
			toiToi.setProducts(this.productController.readProducts());
			// System.out.println(toiToi.getProducts());
			toiToi.setTags(this.tagController.readTags());
			// System.out.println(toiToi.getTags());
			toiToi.setUsers(this.akterController.readAkters());
			System.out.println(toiToi.getUsers());
			toiToi.setRecipe(this.recipeController.readRecipes());
			// System.out.println(toiToi.getRecipe());
			toiToi.setCookBooks(this.cbController.readCookBook());
			// System.out.println(toiToi.getCookBooks());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public ToiToi getToiToi() {
		return toiToi;
	}

	public void setToiToi(ToiToi toiToi) {
		this.toiToi = toiToi;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public EquipmentController getEquipmentController() {
		return equipmentController;
	}

	public void setEquipmentController(EquipmentController equipmentController) {
		this.equipmentController = equipmentController;
	}

	public ProductController getProductController() {
		return productController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	public TagController getTagController() {
		return tagController;
	}

	public void setTagController(TagController tagController) {
		this.tagController = tagController;
	}

	public AkterController getAkterController() {
		return akterController;
	}

	public void setAkterController(AkterController akterController) {
		this.akterController = akterController;
	}

	public CommentController getCommentController() {
		return commentController;
	}

	public void setCommentController(CommentController commentController) {
		this.commentController = commentController;
	}

	public RecipeController getRecipeController() {
		return recipeController;
	}

	public void setRecipeController(RecipeController recipeController) {
		this.recipeController = recipeController;
	}

	public CookBookController getCbController() {
		return cbController;
	}

	public void setCbController(CookBookController cbController) {
		this.cbController = cbController;
	}

	public NeededQuantityController getNqController() {
		return nqController;
	}

	public void setNqController(NeededQuantityController nqController) {
		this.nqController = nqController;
	}

	// returns the user if pass and username match with an existing user
	public Akter checkUser(String password, String username) {
		for (Akter akter : toiToi.getUsers()) {
			if (akter.getUsername().equalsIgnoreCase(username) && akter.getPassword().equalsIgnoreCase(password)) {
				return akter;
			}
		}
		return null;

	}

}
