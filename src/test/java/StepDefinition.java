import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class StepDefinition {
    ChromeDriver driver;

    @Given("User open browser")
    public void userOpenBrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenD\\Desktop\\chromedriver.exe");
        System.setProperty( ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        driver = new ChromeDriver();



    }

    @When("User Navigate login page as {string}")
    public void userNavigateLoginPageAs(String URL) {

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @And("User enters UserName as {string} and Password as {string}")
    public void userEntersUserNameAsAndPasswordAs(String Username, String Password) {


        WebElement element = driver.findElement(By.cssSelector( "#username" ));
        element.sendKeys( Username );
        WebElement pass = driver.findElement(By.cssSelector( "#password" ));
        pass.sendKeys( Password );
    }

    @Then("Message displayed is {string}")
    public void messageDisplayedLoginSuccessfully(String message) throws InterruptedException {
      if(Objects.equals( message, "success" ))  {
          System.out.println("Success");
      } else {
          //System.out.println("fail");
       driver.findElement( By.tagName( "button" ) ).click();
       sleep( 20000 );

       Assert.assertEquals( message,driver.findElement(By.xpath( "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]" )).getText() );

       }





    }


    @And("close the browser")
    public void closeTheBrowser() throws InterruptedException {
        sleep(1000);
        driver.quit();
    }



}
