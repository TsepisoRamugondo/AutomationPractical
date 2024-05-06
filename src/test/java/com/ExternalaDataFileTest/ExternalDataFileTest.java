package com.ExternalaDataFileTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

//Test Case 3
public class ExternalDataFileTest {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.pl/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "searchCriteriaProvider")
    public Object[][] getSearchCriteria() throws IOException {
        String filePath = "src/test/resources/testdata.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][1];
        for (int i = 0; i < rowCount; i++) {
            data[i][0] = sheet.getRow(i + 1).getCell(0).getStringCellValue();
        }
        workbook.close();
        return data;
    }



    @Test(dataProvider = "searchCriteriaProvider")

    public void testSearch(String searchCriteria) {
        driver.get(baseUrl);
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys(searchCriteria);
        searchBox.submit();
        WebElement firstSearchResult = driver.findElement(By.cssSelector("ul.product_list li:nth-child(1) a.product-name"));
        String actualText = firstSearchResult.getText();
        Assert.assertTrue(actualText.contains(searchCriteria), "Search result does not match search criteria: " + searchCriteria);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

//Test Case 4

public class LoginTest {
    private WebDriver driver;
    private String baseUrl = "https://automationpractice.pl/login";
    private String globalUsername;
    private String globalPassword;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @DataProvider(name = "loginDataProvider")
    public Object[][] getLoginData() throws IOException {
        String filePath = "src/test/resources/testdata.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][2];
        for (int i = 0; i < rowCount; i++) {
            data[i][0] = sheet.getRow(i + 1).getCell(0).getStringCellValue(); // Username
            data[i][1] = sheet.getRow(i + 1).getCell(1).getStringCellValue(); // Password
        }
        workbook.close();
        return data;
    }

    @Test(dataProvider = "loginDataProvider")

    public void testLogin(String username, String password) {
        // Store username and password as global variable
        globalUsername = username;
        globalPassword = password;
        driver.get(baseUrl);
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



