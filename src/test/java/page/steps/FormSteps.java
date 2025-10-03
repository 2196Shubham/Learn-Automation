package page.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
