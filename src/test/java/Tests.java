import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {

    Private WebDriver driver;

    @BeforeAll
    public void setupAll() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void abrirPaginaTest() {
        driver.get("https://www.cursoemvideo.com");
        assertEquals("https://www.cursoemvideo.com", driver.getCurrentUrl());

        Thread.sleep(3000);
    }

    @Test
    public void verificaLoginTest() {
        driver.get("https://www.cursoemvideo.com/login/");
        WebElement email = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/article/div/div[1]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/form/div[3]/input"));
        email.sendKeys("pedro@gmail.com");
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/article/div/div[1]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/form/div[5]/input"));
        password.sendKeys("1234");

        WebElement botaoSubmit = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/article/div/div[1]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/form/div[7]/div/button"));
        botaoSubmit.submit();

        assertNotEquals("https://www.cursoemvideo.com/minha-conta/", driver.getCurrentUrl()));

    }
}


