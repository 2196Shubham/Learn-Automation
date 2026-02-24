package page.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import page.methods.FormMethods;
import page.objects.FormObjects;

import java.util.List;
import java.util.Map;

public class FormSteps {

    public WebDriver driver;

    public FormSteps() {
        driver = Hooks.driver;
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        // Open the URL
        FormMethods.enterUrl(url, driver);
    }

    @When("I fill the form with the following data:")
    public void i_fill_the_form_with(DataTable dataTable) throws InterruptedException {
        // Convert the DataTable to a List of Maps
        List<Map<String, String>> formDataList = dataTable.asMaps(String.class, String.class);

        // Iterate through each map and fill the form
        for (Map<String, String> formData : formDataList) {
            // Call your FormMethods class (or the method to handle the form filling)
            FormMethods.fillForm(driver, formData);
        }
    }

    @And("I click the submit button")
    public void i_click_the_submit_button() {
        // Call the method to click the submit button
        FormMethods.clickSubmit(driver);
    }

    @Then("I should see a successful submission message")
    public void i_should_see_a_successful_submission_message() {

        // Get the success message text
        String actualMessage = driver.findElement(FormObjects.SUCCESS_MESSAGE).getText();
//        String expectedMessage = "Form submitted successfully"; // You should have an expected value here
//
//        // Assert the expected vs actual message
//        if (!actualMessage.contains(expectedMessage)) {
//            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
//        }
        System.out.println("Success message: " + actualMessage);
    }

    @When("I fill the form with the following data {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iFillTheFormWithTheFollowingData(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("Navigate to {string}")
    public void navigateTo(String url) throws InterruptedException {
        FormMethods.enterUrl(url, driver);
        Thread.sleep(2000);
    }

    @When("Login with valid {string} {string}")
    public void loginWithValid(String email, String pass) {
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("Login successful message")
    public void loginSuccessfulMessage() {
        String expectedMessage = driver.findElement(By.xpath("//div[@class='post-content']/p/strong[contains(text(),'Congratulations')]")).getText();
        String actualMessage = "Congratulations student. You successfully logged in!";
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
