package slotsForHRAndTech;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SlotHR {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jobadmin.erai.cloud/admin/agri-cand");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LocalDate now = LocalDate.now();
         
         // Define the desired date format
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         
         // Format the date using the formatter
         String formattedDate = now.format(formatter);
         
         // Print the formatted date
        // System.out.println(formattedDate);

		Thread.sleep(2000);
		//dashboard
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/router-outlet/div/app-sidebar/div/div/div/div/ul/li[16]")).click();
		driver.findElement(By.xpath(" //button['text()=Add Slot ']")).click();
		
        int a= 10;
        int b= 00;
        //        System.out.println(a+":"+b);
        for (int i = a;i<=18;i++)
        {
        	for(int j = b;j<=30;j+=30)
        	{
        		Thread.sleep(2000);
        		driver.findElement(By.xpath("//input[@id='HR']")).click();
        		
                driver.findElement(By.xpath("//input[@formcontrolname='date']")).sendKeys(formattedDate);
        	    String c = i+ ":" +j;
        		System.out.println(c);
        		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-slot-creation/div[2]/div[2]/div[2]/div/div[3]/div[2]/input")).sendKeys(c);
        		Thread.sleep(2000);
//        	submit
        		driver.findElement(By.xpath("//button[text()='Submit']")).click();
        		
        		Thread.sleep(2000);
                driver.findElement(By.xpath(" //button['text()=Add Slot ']")).click();
        		
        		
//        		WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-slot-creation/div[2]/div[2]/div[2]/div/div[5]/button"));
//        		driver.executeScript("arguments[0].click()",element);
        }		
        	
        }
        driver.close();	
        }
	}


