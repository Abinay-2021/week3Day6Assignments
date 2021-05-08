package week3.Day6.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get(" https://www.myntra.com/");

		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
		action.moveToElement(element).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Jackets & Coats']")).click();
		String Total = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		Total = Total.replaceAll("[\\D]", "");
		
		int Totalcount = Integer.parseInt(Total);
		System.out.println("Total count of jackets and coats " + Totalcount);
		Thread.sleep(1000);
		String jacketCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		jacketCount = jacketCount.replaceAll("[\\D]", "");
		int jacketTotal = Integer.parseInt(jacketCount);
		System.out.println("Total count of jackets " + jacketTotal);
		Thread.sleep(1000);
		String coatsCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		coatsCount = coatsCount.replaceAll("[\\D]", "");
		int coatsTotal = Integer.parseInt(coatsCount);
		System.out.println("Total count of Coats " + coatsTotal);

		int TotalCount = jacketTotal + coatsTotal;
		System.out.println("total count of jackets and coats " + TotalCount);
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("MANGO");
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div")).click();
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//child::span")).click();
		Thread.sleep(3000);
		List<WebElement> brand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
	
		for (WebElement productName : brand) {
			
			String product = productName.getText();
			//System.out.println(product);
			if (product.equals("MANGO")) {

				System.out.println("the coats are mango brand");
				break;
			} else
			{
				System.out.println("Coat doesn't matches");
			}

		}

		WebElement SortBy = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		action.moveToElement(SortBy).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		Thread.sleep(1000);
		String FirstDiscount = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The first Discount price " + FirstDiscount);
		Thread.sleep(1000);
		WebElement EleSize = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]"));
		action.moveToElement(EleSize).build().perform();
		driver.findElement(By.xpath("(//span[text()='wishlist'])[1]")).click();
		driver.close();

	}

}
