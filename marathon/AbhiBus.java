package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Launch Firefox / Chrome / Safari / Edge 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.abhibus.com/");
		//To maximize the window
		driver.manage().window().maximize();
		//Type "Chennai" in the FROM text box
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		// To click the first Option
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		//Type "Bangalore" in the TO text box
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore");
		// Click the first option from the popup box
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		//Click the'Tomorrow' button
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		//Print the name of the first resulting bus (use .getText())
		String bus = driver.findElement(By.xpath("(//div[contains(@id,'service-operator-info')]//h5)[1]")).getText();
		System.out.println("First Resulting Bus :" +bus);
		//Choose SLEEPER in the left menu from Bus Type
		driver.findElement(By.xpath("//span[text()='Sleeper']")).click();
		//Print the first resulting bus seat count(Example:35 Seats Available)(use .getText())
		String seatCount = driver.findElement(By.xpath("(//button[text()='Show Seats']//following::small)[1]")).getText();
		System.out.println("first resulting bus seat count :"+seatCount);
		//Click Show Seats
		driver.findElement(By.xpath("//button[text()='Show Seats']")).click();
		//Choose any one Available seat
		driver.findElement(By.xpath("(//button[@class='seat sleeper'])[1]")).click();
		//Select the first resulting checkbox from the Boarding Point and Dropping Point
		driver.findElement(By.xpath("(//div[@id='place-container']//input )[1]")).click();
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Dropping Point')]/following::input[@type='checkbox'])[1]")).click();
		//Print Seats Selected, Total Fare
		String selectedSeat = driver.findElement(By.xpath("(//span[@class='text-primary'])")).getText();
		String busFare = driver.findElement(By.xpath("(//span[@class='text-primary'])[2]")).getText();
		System.out.println("Seat Selected:"+selectedSeat+"\n"+"Total fare:"+busFare);
		//Get the Title of the page(use .getTitle())
		String resultingPage = driver.getTitle();
		System.out.println("Resulting page :"+resultingPage);
		//Close the browser
		driver.close();
		
	}

}
