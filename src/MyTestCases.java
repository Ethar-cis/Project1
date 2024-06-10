import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestCases {
	
	WebDriver driver =  new ChromeDriver();
	String theURL = "https://www.saucedemo.com/";
	
	
	@Test (priority = 1)
	public void login () {
		
		driver.get(theURL);
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		WebElement logIn = driver.findElement(By.id("login-button"));
		logIn.click();
	} 
	
	
	
	
	@Test( priority = 2 ,description = "Verify the Title ")
	public void VerifyTheTitle() {
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle,ExpectedTitle);				
	}
	
	
	
	
	@Test ( priority = 3 ,description = "Verify the Products")
	public void TestProducts() {
		boolean Expectedresult = true;
		WebElement MainNameTheWebsite = driver.findElement(By.xpath("//span[@data-test='title']"));
		boolean Actualresult = MainNameTheWebsite.isDisplayed();
		Assert.assertEquals(Actualresult, Expectedresult);
	}
	
	
	
	@Test (priority = 4)
	public void  SortItem () {
		WebElement selectsort = driver.findElement(By.className("product_sort_container"));
		Select myselect = new Select(selectsort);
		myselect.selectByValue("lohi");
		
		 List <WebElement> ThePrices = driver.findElements(By.className("inventory_item_price"));
		 String TheLowestPrice = (ThePrices.get(0).getText().replace("$", ""));
		 String TheHighestPrice = (ThePrices.get(5).getText().replace("$", ""));

		Double hightprice = Double.parseDouble(TheHighestPrice);
 	    Double lowestprice =Double.parseDouble(TheLowestPrice);
 	    boolean expectedresult = true ;
 	    Assert.assertEquals(hightprice>lowestprice, expectedresult);
	}
	




	@Test ( priority = 5 , description = "Test first and last product name when sorting Name (A to Z)")
	public void TestProductsName () throws InterruptedException {
		Thread.sleep(2000);
		WebElement SelectTheSort  = driver.findElement(By.className("product_sort_container"));
		Select NewSelect = new Select(SelectTheSort);
		NewSelect.selectByVisibleText("Name (A to Z)");
		
		List <WebElement> ProductList = driver.findElements(By.className("inventory_item_name"));
		String ExpectedFirstName = "Sauce Labs Backpack";
		for (int i = 0 ; i <ProductList.size() ; i++) {
			String ActualFirstName = ProductList.get(0).getText();
			Assert.assertEquals(ActualFirstName, ExpectedFirstName);
		}
		String ExpectedLastName = "Test.allTheThings() T-Shirt (Red)";
		for (int i = 0 ; i < ProductList.size() ; i++) {
			String ActualLastName = (ProductList.get(ProductList.size()-1)).getText();
			Assert.assertEquals(ActualLastName, ExpectedLastName);
	}}
	
	
	@Test (priority = 6 ,description = "Test first and last product name when sorting Price (high to low)")
	public void TestProductsName2  () throws InterruptedException {
		Thread.sleep(2000);
		WebElement SelectSortPrice = driver.findElement(By.className("product_sort_container"));
		Select NewSelected = new Select(SelectSortPrice);
		NewSelected.selectByValue("hilo");
		List <WebElement> NewListProduct = driver.findElements(By.className("inventory_item_name"));
	   String ExpectedFname = "Sauce Labs Fleece Jacket";
	   for(int i = 0 ; i < NewListProduct.size() ; i++) {
		   String ActualFname =  NewListProduct.get(0).getText();
	      Assert.assertEquals(ActualFname, ExpectedFname); }
	   
	   
	   String ExpectedLname = "Sauce Labs Onesie";
	   for (int i = 0 ; i <NewListProduct.size(); i++) {
		   String ActualLname = (NewListProduct.get(NewListProduct.size()-1).getText());
		   Assert.assertEquals(ActualLname, ExpectedLname);
	   }
		
	}
	
	
	
}




