package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdactinLoginTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
     
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the Adactin Hotel App login page
            driver.get("https://adactinhotelapp.com/");
            driver.manage().window().maximize();

            // Find username and password fields and enter values
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));

            username.sendKeys("reyaz0806");
            password.sendKeys("reyaz123");

            // Click on Login button
            WebElement loginBtn = driver.findElement(By.id("login"));
            loginBtn.click();

            // Optionally, verify successful login (e.g., by checking title or element presence)
            String expectedTitle = "Adactin.com - Search Hotel";
            if (driver.getTitle().equals(expectedTitle)) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Login Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
