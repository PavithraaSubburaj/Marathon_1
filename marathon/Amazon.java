package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch Firefox / Chrome / Safari / Edge 
				ChromeDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("https://www.amazon.in/");
				//To maximize the window
				driver.manage().window().maximize();
				Thread.sleep(2000);
				//Type "Bags for b" in the Search box
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for b");
				//Choose the 	 item in the result (bags for boys)
				driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
				//Print the total number of results (like 50000)  1-48 of over 30,000 results for "bags for boys"
				String totalResults = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
				System.out.println("total number of results :"+totalResults);
				//Select the first brand in the left menu  (like American Tourister)
				driver.findElement(By.xpath("//span[text()='Brand']//following::i")).click();
				//Choose New Arrivals (Sort)
				driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
				driver.findElement(By.linkText("Newest Arrivals")).click();
				//Print the first resulting bag info (name, discounted price)
				String brandName = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base a-text-center']//following::h2)")).getText();
				String discountedPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
				//Get the page title and close the browser(driver.close())
				String title = driver.getTitle();
				System.out.println("Current Page Title :"+title);
				driver.close();

	}

}
