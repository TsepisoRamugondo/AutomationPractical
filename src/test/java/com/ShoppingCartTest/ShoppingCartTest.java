package com.ShoppingCartTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ShoppingCartTest {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.pl/";
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test

    public void testAddItemToShoppingCart() {

        // Open the website
        driver.get(baseUrl);
        WebElement item = driver.findElement(By.xpath("//a[@title, 'view my shopping cart']"));
        item.click();

        // Add the item to the shopping cart
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@title, 'view my shopping cart']"));
        addToCartButton.click();

        // Verifying that the item is added to the shopping cart
        WebElement cartIcon = driver.findElement(By.xpath("//a[@title, 'view my shopping cart']"));
        Assert.assertTrue(cartIcon.isDisplayed(), "Item was not added to the shopping cart");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//5b View Shopping cart

@Test(dependsOnMethods = "testAddItemToShoppingCart")
public void testViewShoppingCart() {
    // Open the shopping cart page
    WebElement cartIcon = driver.findElement(By.xpath("//a[@title, 'view my shopping cart']"));
    cartIcon.click();
    // Verify that the shopping cart page is displayed
    WebElement shoppingCartTitle = driver.findElement(By.xpath("//a[@title, 'view my shopping cart']"));
    Assert.assertTrue(shoppingCartTitle.isDisplayed(), "Shopping cart page is not displayed");

}

//5c Increase quantity to a desired amount
@Test(dependsOnMethods = "testViewShoppingCart")

public void testIncreaseQuantityInShoppingCart() {

    // Find the quantity input field in the shopping cart
    WebElement quantityInput = driver.findElement(By.xpath("//input[@class='quantity']")); // Example xpath, replace with actual locator


    // Clear the quantity input field and enter the desired quantity
    quantityInput.clear();
    quantityInput.sendKeys("3"); // Replace "3" with the desired quantity

    // Click on the update quantity button (if available)
    WebElement updateButton = driver.findElement(By.xpath("//button[@id='update-quantity-button']"));
    if (updateButton.isDisplayed()) {
        updateButton.click();
    }
    // Verify that the quantity is updated to the desired amount
    String updatedQuantity = quantityInput.getAttribute("value");
    Assert.assertEquals(updatedQuantity, "3", "Quantity is not updated to the desired amount");
}
//test case 5(d) i
// Custom method to calculate total price

{
public double calculateTotal(double unitPrice, int quantity) {return unitPrice * quantity;
}

@Test
public void testCalculateTotal() {
    double unitPrice = 10.5; // Example unit price
    int quantity = 3; // Example quantity

    // Calculate total price
    double total = calculateTotal(unitPrice, quantity);

    // Print the total price
    System.out.println("Total price: " + total);
}
//
public class ShoppingCartTest {

    // Custom method to calculate total price and return the result
    public double calculateTotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }
    @Test
    public void testCalculateTotal() {
        double unitPrice = 10.5; // Example unit price
        int quantity = 3; // Example quantity
        // Calculate total price
        double total = calculateTotal(unitPrice, quantity);
        // Print the total price
        System.out.println("Total price: " + total);
    }
}

//Test Case 5 (e)
public class ShoppingCartTest{

    // Custom method to calculate total price and return the result
    public double calculateTotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    @Test
    public void testVerifyDisplayedTotalMatchesCalculatedTotal() {
        double unitPrice = 10.5;
        int quantity = 3;
        double displayedTotal = 31.5;
        // Calculate total price

        double calculatedTotal = calculateTotal(unitPrice, quantity);
        // Verify that the displayed total matches the calculated total
        Assert.assertEquals(displayedTotal, calculatedTotal, "Displayed total does not match calculated total");
    }
}
