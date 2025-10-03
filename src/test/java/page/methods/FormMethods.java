package page.methods;

import org.openqa.selenium.WebDriver;
import page.objects.FormObjects;

import java.util.Map;

public class FormMethods {


    public static void enterUrl(String url, WebDriver driver) {
        try {
            driver.get(url);

        } catch (Exception e) {

        }
    }

    public static void clickSubmit(WebDriver driver) {
        try {

            driver.findElement(FormObjects.SUBMIT_BUTTON).click();


        } catch (Exception e) {

        }
    }

    public static void fillForm(WebDriver driver, Map<String, String> formdata) throws InterruptedException {
        try {

            driver.findElement(FormObjects.FIRST_NAME).sendKeys(formdata.get("firstName"));
            driver.findElement(FormObjects.MIDDLE_NAME).sendKeys(formdata.get("middleName"));
            driver.findElement(FormObjects.LAST_NAME).sendKeys(formdata.get("lastName"));
            driver.findElement(FormObjects.EMAIL).sendKeys(formdata.get("email"));
            driver.findElement(FormObjects.PASSWORD).sendKeys(formdata.get("password"));
            driver.findElement(FormObjects.ADDRESS).sendKeys(formdata.get("address"));
            driver.findElement(FormObjects.CITY).sendKeys(formdata.get("city"));
            driver.findElement(FormObjects.STATE).sendKeys(formdata.get("state"));
            driver.findElement(FormObjects.PIN_CODE).sendKeys(formdata.get("pinCode"));
            Thread.sleep(2000);

        } catch (Exception e) {

        }
    }
}
