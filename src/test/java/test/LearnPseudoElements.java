package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnPseudoElements {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://play1.automationcamp.ir/advanced.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String elementValue = js.executeScript("return window.getComputedStyle(document.querySelector('.star-rating'),'::after').getPropertyValue('content')").toString();
        String modifiedValue = elementValue.replace("\"","");

        System.out.println(modifiedValue);

        driver.findElement(By.id("txt_rating")).sendKeys(modifiedValue);
        driver.findElement(By.id("check_rating")).click();
        boolean wellDone = driver.findElement(By.id("validate_rating")).isDisplayed();
        System.out.println("Is well done displayed: "+wellDone);

    }
}
