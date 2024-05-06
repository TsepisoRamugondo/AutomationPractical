package com.SearchTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.pl/";

    WebElement txtsearchBox = driver.findElement(By.xpath("//input[contains(@id,'search_query_top')]"));
    WebElement btnsearchBox = driver.findElement(By.xpath("//input[contains(@id,'search_query_top')]"));

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void VerifyThatAClientCanSearchProducts() {
        //Open a browser.
        driver.get(baseUrl);

        //Clearingthe search box field and capturing it
        enterSearchBox("breherh");

        //Click on the search button.
        click_submitButton();

        WebElement firstSearchResult = driver.findElement(By.xpath("(//a[contains(@class,'product-name')])[8]"));

        String actualText = firstSearchResult.getText();

        Assert.assertEquals(actualText, "Blouse");

    }



    //Tests two :TC2
    //@Test
//    public void Test() {
//        //Open a browser.
//        driver.get(baseUrl);
//
//        for (int i=1; i<2;i++){
//
//            //Clearing the search box field and capturing it
//            enterSearchBox("Blouse");
//
//            //Click on the search button.
//            click_submitButton();
//
//            WebElement firstSearchResult = driver.findElement(By.xpath("(//a[contains(@class,'product-name')])[8]"));
//
//            String actualText = firstSearchResult.getText();
//
//            Assert.assertEquals(actualText, "Blouse");
//            System.out.println("Outer: " + i ); //this will execute 2 times
//        }
//
//
//
//    }
//
//    public void enterSearchBox(String value){
//        WebDriverWait waitForElementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(10));
//        waitForElementToBeVisible.until(ExpectedConditions.visibilityOf(txtsearchBox));
//        txtsearchBox.clear();
//        txtsearchBox.sendKeys(value);
//
//    }
//
//    public void click_submitButton(){
//        WebDriverWait waitForElementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(10));
//        waitForElementToBeVisible.until(ExpectedConditions.visibilityOf(btnsearchBox));
//        btnsearchBox.click();
//
//    }
//
//
//    @AfterMethod
//
//    public void tearDown() {
//
//        if (driver != null) {
//
//            driver.quit();
//
//        }
//
//    }
//
//}

    //Test Case 2a.
    public class SearchTest1 {
        private WebDriver driver;
        private String baseUrl = "http://automationpractice.pl/";
        private String[] searchCriteria = {"women", "Dresses", "T-shirts"};

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void testSearch() {
            for (String criteria : searchCriteria) {
                driver.get(baseUrl);
                WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id,'search_query_top')]"));
                searchBox.sendKeys(criteria);
                searchBox.submit();
                WebElement firstSearchResult = driver.findElement(By.cssSelector("ul.product_list li:nth-child(1) a.product-name"));
                String actualText = firstSearchResult.getText();
                Assert.assertTrue(actualText.contains(criteria), "Search result does not match search criteria: " + criteria);
            }
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }}

    //Test Case 2b
    public class SearchTestArray {
        private WebDriver driver;
        private String baseUrl = "http://automationpractice.pl/";
        private String searchCriteriaString = "Women,Dresses,T-shirts"; // we'll have to Store search criteria in a string

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void testSearch() {
            String[] searchCriteria = searchCriteriaString.split(",");
            for (String criteria : searchCriteria) {
                driver.get(baseUrl);
                WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id,'search_query_top')]"));
                searchBox.sendKeys(criteria);
                searchBox.submit();
                WebElement firstSearchResult = driver.findElement(By.cssSelector("ul.product_list li:nth-child(1) a.product-name"));
                String actualText = firstSearchResult.getText();
                Assert.assertTrue(actualText.contains(criteria), "Search result does not match search criteria: " + criteria);
            }
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    //Test Case 3
