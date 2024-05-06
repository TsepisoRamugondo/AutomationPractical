package com.NavigationMenuTest;
{

    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class NavigationMenuTest {
        private WebDriver driver;
        private String baseUrl = "http://automationpractice.pl/";
        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        public void navigateToPage(String category) {
            WebElement categoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(categoryElement).perform();
            lick()
        }
        @Test
        public void testNavigateToWomenPage() {
            navigateToPage("Women"); // Navigate to Women page
        }
        @Test
        public void testNavigateToDressesPage() {
            // Navigate to Dresses page
            navigateToPage("Dresses");
        }
        @Test
        public void testNavigateToTShirtsPage() {
            // Navigate to T-Shirts page
            navigateToPage("T-Shirts");
            // Optionally, add verification/assertion here to confirm navigation
        }
        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    // Method to navigate to a subcategory under a main category
    public void navigateToSubcategory(String mainCategory, String subCategory) {
        WebElement mainCategoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + mainCategory + "')]")); // Example xpath, replace with actual locator
        Actions actions = new Actions(driver);
        actions.moveToElement(mainCategoryElement).perform();

        WebElement subCategoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + subCategory + "')]"));
        subCategoryElement.click();

    public void testNavigateToWomenTopsBlousesPage() {
        // Navigate to Tops & Blouses subcategory under Women main category
        navigateToSubcategory("Women", "Tops & Blouses");

        // Optionally, add verification/assertion here to confirm navigation
            public class HomePage {

                private WebDriver driver;



                public HomePage(WebDriver driver) {

                    this.driver = driver;

                }



                public void navigateToCategory(String category) {

                    WebElement categoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]"));

                    Actions actions = new Actions(driver);

                    actions.moveToElement(categoryElement).perform();

                }

            }



            public class CategoryPage {

                private WebDriver driver;



                public CategoryPage(WebDriver driver) {

                    this.driver = driver;

                }



                public void selectSubcategory(String subcategory) {

                    WebElement subcategoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + subcategory + "')]"));

                    subcategoryElement.click();

                }
            }
            public class NavigationMenuTest {
                private WebDriver driver;
                private HomePage homePage;
                private CategoryPage categoryPage;
                private String baseUrl = "http://automationpractice.pl/";
                @BeforeMethod
                public void setUp() {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    homePage = new HomePage(driver);
                    categoryPage = new CategoryPage(driver);
                }
                @Test
                public void testNavigateToSubcategory() {
                    // Navigate to the main category page
                    driver.get(baseUrl);
                    homePage.navigateToCategory("Dresses");
                    // Select the subcategory
                    categoryPage.selectSubcategory("Casual Dresses");
                    // Optionally, add verification/assertion here to confirm navigation
                }
                @AfterMethod
                public void tearDown() {
                    if (driver != null) {
                        driver.quit();
                    }
                }
            }
            public class CategoryPage {
                private WebDriver driver;
                public CategoryPage(WebDriver driver) {
                    this.driver = driver;
                }
                public void selectSubcategory(String subcategory) {
                    WebElement subcategoryElement = driver.findElement(By.xpath("//a[contains(text(),'" + subcategory + "')]"));
                    subcategoryElement.click();
                }
                public boolean isPageLoaded() {
                    WebDriverWait wait = new WebDriverWait(driver, 10);
                    return wait.until(ExpectedConditions.titleContains("Expected Page Title"));
                }
            }
            public void testNavigateToSubcategory() {
                // Navigate to the main category page
                driver.get(baseUrl);
                homePage.navigateToCategory("Dresses");
                // Select the subcategory
                categoryPage.selectSubcategory("Casual Dresses");
                // Verify that the correct page has loaded
                Assert.assertTrue(categoryPage.isPageLoaded(), "Expected page is not loaded");
            }     } }
