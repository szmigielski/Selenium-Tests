import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BankMillenniumTest {

    @Test
    public void millenniumTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bankmillennium.pl/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //accept cookie
        driver.findElement(By.xpath("//*[@id='cookie-m-button-allow']")).click();
        //maximize window
        driver.manage().window().maximize();
        //career click
        driver.findElement(By.cssSelector("#portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_SC_FOOTER_MIDDLE_COL2 > div > div.portlet-content-container > div > div.clearfix.journal-content-article > div > ul > li:nth-child(2) > a > span")).click();
        //check offer click
        driver.findElement(By.cssSelector("#portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_BNyVqt6dwJW1 > div > div.portlet-content-container > div > div.clearfix.journal-content-article > wc-anchornav > div > div > div > nav > ul > li.bmp-anchorNav__last > div > a > span:nth-child(2)")).click();
        //checking which window is opened
        System.out.println(driver.getCurrentUrl());
        //checking all windows
        System.out.println(driver.getWindowHandles());

        Set<String> openedWindows = driver.getWindowHandles();

        Iterator<String> it = openedWindows.iterator();
        String tab1 = it.next();
        String tab2 = it.next();

        System.out.println("Spis otwartych okien w przegladarce: ");
        for (String showWindows : openedWindows) {
            System.out.println(showWindows);
        }

        //closing first tab in browser
        driver.switchTo().window(tab1);
        driver.close();
        driver.switchTo().window(tab2);

        //checking the current url
        System.out.println(driver.getCurrentUrl());


        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"keywordSearchDsk\"]")).sendKeys("Tester");
        driver.findElement(By.xpath("//*[@id=\"locationSearchDsk\"]")).sendKeys("Wrocław");
        driver.findElement(By.xpath("//*[@id=\"locationSearchDsk\"]")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cs-root\"]/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-tag='applyNowButton']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='actionItem.firstName.idTag']")).sendKeys("Imie");
        driver.findElement(By.xpath("//*[@id=\"actionItem.lastName.idTag\"]")).sendKeys("Nazwisko");
        driver.findElement(By.xpath("//*[@id=\"actionItem.email.idTag\"]")).sendKeys("mail@gmail.com");
        By dateOfBirth = By.xpath("//input[@type='text']");
        driver.findElement(dateOfBirth).sendKeys("11.11.1999");
        By applyCv = By.xpath("//*[@id='resumeFileUpload']");
        driver.findElement(applyCv).sendKeys("D:\\MojeCV\\damian_szmigielski_cv.pdf");
        Thread.sleep(5000);
        By adress = By.xpath("//*[@id='contactDetails_addressLine1']");
        driver.findElement(adress).sendKeys("ul. ");
        By country = By.xpath("//*[@id='contactDetails_city']");
        driver.findElement(country).sendKeys("Miasto");
        By zipCode = By.xpath("//*[@id='contactDetails_zipCode']");
        driver.findElement(zipCode).sendKeys("55-555");
        By phoneContact = By.xpath("//*[@id='contactDetails_phone']");
        driver.findElement(phoneContact).sendKeys("555333222");
        driver.findElement(By.xpath("//button[@class='p-button basic primary width-auto']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-tag='DisclaimerCheckbox']")).click();//accept RODO
        //driver.findElement(By.xpath("//button[@data-tag='btnSubmit']")).click(); //submit
    }
}
