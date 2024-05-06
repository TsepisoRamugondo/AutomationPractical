import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//import java.time.Duration;


public class SeleniumTest {

    private WebDriver driver;

    //Setting up a location/directory a pre_fix
    private static final String dir = System.getProperty("user.dir");

    //initializing chromedriver library
    private static final String Chromedriver = dir + "/src/test/resources/chromedriver.exe";

    @Test
    void Setup(){
        System.setProperty("webdriver.chrome.driver", Chromedriver);
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("useAutomationExtention", false);
        //driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

        //driver.manage().window().maximize();


        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);


        driver.get("http://automationpractice.pl/");

    }

}
