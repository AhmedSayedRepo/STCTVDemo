package com.testng;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;




public class Subscription {
	
	public static ExtentReports extent;
	public static com.relevantcodes.extentreports.ExtentTest logger;
	static WebDriver driver;
	SoftAssert softAssert;
	JavascriptExecutor js;


	@BeforeSuite
	public void start() {
		extent = new ExtentReports("C:\\Users\\ahmed.ibrahim\\eclipse-workspace\\STCSTV\\TestReport\\TestReport.html", true);
		extent.addSystemInfo("Owner","Ahmed Sayed");
		extent.addSystemInfo("OS","Windows");
		extent.addSystemInfo("Browser","Chrome");

	}
	
	@AfterSuite 
	public void end() {
		
		extent.flush();
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		
		logger = extent.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.ibrahim\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://subscribe.jawwy.tv");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		softAssert = new SoftAssert();
	}
	
	@AfterMethod
	public void after(Method method, ITestResult result) throws IOException {
	
		
		softAssert.assertAll();
		TestUtils.takePicture(method.getName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Pass");
			logger.log(LogStatus.PASS, "<a href='"+result.getName() +".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable());
			logger.log(LogStatus.FAIL, "<a href='"+result.getName() +".png" + "'><span class='lable info'>Download Snapshot</span></a>");

		}
		else {
			logger.log(LogStatus.SKIP, "Test Skipped");
		}
		
		driver.quit();
		
	}
	
	
	@Test (priority = 1)
	public void ClassicPackForUAEinArabic(Method method) throws IOException {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("ae-contry-lable")).click();
		WebElement ClassicPackTypeInArabic= driver.findElement(By.xpath("//*[@id=\"name-الأساسية\"]"));
		String packActualResult = ClassicPackTypeInArabic.getText();
		String packExpectedResult = "الأساسية";
		System.out.println("Classic Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Classic Package Is Not Available");

		WebElement ClassicPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/b"));
		String priceActualResult = ClassicPackPrice.getText();
		String priceAxpectedResult = "10.9";
		System.out.println("Classic Package Price Actual Result for (UAE): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Classic Package Is Not Available");

		WebElement ClassicPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/i"));
		String currActualResult = ClassicPackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Classic Package Currency In Arabic Actual Result for (UAE): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Classic Package Currency In Arabic Is Incorrect");

		}
	
	@Test (priority = 2)
	public void LitePackForUAEinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("ae-contry-lable")).click();
		WebElement LitePackType= driver.findElement(By.xpath("//*[@id=\"name-لايت\"]"));
		String packActualResult = LitePackType.getText();
		String packExpectedResult = "لايت";
		System.out.println("Lite Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackPrice= driver.findElement(By.xpath("//*[@id=\"currency-لايت\"]/b"));
		String priceActualResult = LitePackPrice.getText();
		String priceAxpectedResult = "5.4";
		System.out.println("Lite Package Price Actual Result for (UAE): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-لايت\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Lite Package Currency In Arabic Actual Result for (UAE): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Lite Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 3)
	public void PremPackForUAEinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("ae-contry-lable")).click();
		WebElement PremPackType= driver.findElement(By.xpath("//*[@id=\"name-بريميوم\"]"));
		String packActualResult = PremPackType.getText();
		String packExpectedResult = "بريميوم";
		System.out.println("Premium Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/b"));
		String priceActualResult = PremPackPrice.getText();
		String priceAxpectedResult = "16.3";
		System.out.println("Premium Package Price Actual Result for (UAE): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/i"));
		String currActualResult = PremPackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Premium Package Currency In Arabic Actual Result for (UAE): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Premium Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 4)
	public void ClassicPackForUAEinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("ae-contry-lable")).click();
		WebElement ClassicPackTypeInArabic= driver.findElement(By.xpath("//*[@id=\"name-classic\"]"));
		String packActualResult = ClassicPackTypeInArabic.getText();
		String packExpectedResult = "CLASSIC";
		System.out.println("Classic Package Type In English Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/b"));
		String priceActualResult = ClassicPackPrice.getText();
		String priceAxpectedResult = "10.9";
		System.out.println("Classic Package Price Actual Result for (UAE): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Classic Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Classic Package Currency In English Actual Result for (UAE): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Classic Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 5)
	public void LitePackForUAEinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("ae-contry-lable")).click();
		WebElement LitePackType= driver.findElement(By.xpath("//*[@id=\"name-lite\"]"));
		String packActualResult = LitePackType.getText();
		String packExpectedResult = "LITE";
		System.out.println("Lite Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackPrice= driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/b"));
		String priceActualResult = LitePackPrice.getText();
		String priceAxpectedResult = "5.4";
		System.out.println("Lite Package Price Actual Result for (UAE): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Lite Package Currency In Arabic Actual Result for (UAE): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Lite Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 6)
	public void PremPackForUAEinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("ae-contry-lable")).click();
		WebElement PremPackType= driver.findElement(By.xpath("//*[@id=\"name-premium\"]"));
		String packActualResult = PremPackType.getText();
		String packExpectedResult = "PREMIUM";
		System.out.println("Premium Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/b"));
		String priceActualResult = PremPackPrice.getText();
		String priceAxpectedResult = "16.3";
		System.out.println("Premium Package Price Actual Result for (UAE): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/i"));
		String currActualResult = PremPackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Premium Package Currency In Arabic Actual Result for (UAE): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Premium Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	
	
	@Test (priority = 7)
	public void ClassicPackForJOinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("jo-contry-lable")).click();
		WebElement ClassicPackTypeInArabic= driver.findElement(By.xpath("//*[@id=\"name-الأساسية\"]"));
		String packActualResult = ClassicPackTypeInArabic.getText();
		String packExpectedResult = "الأساسية";
		System.out.println("Classic Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/b"));
		String priceActualResult = ClassicPackPrice.getText();
		String priceAxpectedResult = "5.2";
		System.out.println("Classic Package Price Actual Result for (Jordan): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/i"));
		String currActualResult = ClassicPackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Classic Package Currency In Arabic Actual Result for (Jordan): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Classic Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 8)
	public void LitePackForJOinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("jo-contry-lable")).click();
		WebElement LitePackType= driver.findElement(By.xpath("//*[@id=\"name-لايت\"]"));
		String packActualResult = LitePackType.getText();
		String packExpectedResult = "لايت";
		System.out.println("Lite Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackPrice= driver.findElement(By.xpath("//*[@id=\"currency-لايت\"]/b"));
		String priceActualResult = LitePackPrice.getText();
		String priceAxpectedResult = "2.7";
		System.out.println("Lite Package Price Actual Result for (Jordan): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-لايت\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Lite Package Currency In Arabic Actual Result for (Jordan): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Lite Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 9)
	public void PremPackForJOinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("jo-contry-lable")).click();
		WebElement PremPackType= driver.findElement(By.xpath("//*[@id=\"name-بريميوم\"]"));
		String packActualResult = PremPackType.getText();
		String packExpectedResult = "بريميوم";
		System.out.println("Premium Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/b"));
		String priceActualResult = PremPackPrice.getText();
		String priceAxpectedResult = "8";
		System.out.println("Premium Package Price Actual Result for (Jordan): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/i"));
		String currActualResult = PremPackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Premium Package Currency In Arabic Actual Result for (Jordan): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Premium Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 10)
	public void ClassicPackForJOinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("jo-contry-lable")).click();
		WebElement ClassicPackTypeInArabic= driver.findElement(By.xpath("//*[@id=\"name-classic\"]"));
		String packActualResult = ClassicPackTypeInArabic.getText();
		String packExpectedResult = "CLASSIC";
		System.out.println("Classic Package Type In English Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/b"));
		String priceActualResult = ClassicPackPrice.getText();
		String priceAxpectedResult = "5.2";
		System.out.println("Classic Package Price Actual Result for (Jordan): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Classic Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Classic Package Currency In English Actual Result for (Jordan): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Classic Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 11)
	public void LitePackForJOinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("jo-contry-lable")).click();
		WebElement LitePackType= driver.findElement(By.xpath("//*[@id=\"name-lite\"]"));
		String packActualResult = LitePackType.getText();
		String packExpectedResult = "LITE";
		System.out.println("Lite Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackPrice= driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/b"));
		String priceActualResult = LitePackPrice.getText();
		String priceAxpectedResult = "2.7";
		System.out.println("Lite Package Price Actual Result for (Jordan): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Lite Package Currency In Arabic Actual Result for (Jordan): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Lite Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 12)
	public void PremPackForJOinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("jo-contry-lable")).click();
		WebElement PremPackType= driver.findElement(By.xpath("//*[@id=\"name-premium\"]"));
		String packActualResult = PremPackType.getText();
		String packExpectedResult = "PREMIUM";
		System.out.println("Premium Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/b"));
		String priceActualResult = PremPackPrice.getText();
		String priceAxpectedResult = "8";
		System.out.println("Premium Package Price Actual Result for (Jordan): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/i"));
		String currActualResult = PremPackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Premium Package Currency In Arabic Actual Result for (Jordan): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Premium Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 13)
	public void ClassicPackForOMinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("om-contry-lable")).click();
		WebElement ClassicPackTypeInArabic= driver.findElement(By.xpath("//*[@id=\"name-الأساسية\"]"));
		String packActualResult = ClassicPackTypeInArabic.getText();
		String packExpectedResult = "الأساسية";
		System.out.println("Classic Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/b"));
		String priceActualResult = ClassicPackPrice.getText();
		String priceAxpectedResult = "10";
		System.out.println("Classic Package Price Actual Result for (Oman): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/i"));
		String currActualResult = ClassicPackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Classic Package Currency In Arabic Actual Result for (Oman): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Classic Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 14)
	public void LitePackForOMinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("om-contry-lable")).click();
		WebElement LitePackType= driver.findElement(By.xpath("//*[@id=\"name-لايت\"]"));
		String packActualResult = LitePackType.getText();
		String packExpectedResult = "لايت";
		System.out.println("Lite Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackPrice= driver.findElement(By.xpath("//*[@id=\"currency-لايت\"]/b"));
		String priceActualResult = LitePackPrice.getText();
		String priceAxpectedResult = "5";
		System.out.println("Lite Package Price Actual Result for (Oman): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-لايت\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Lite Package Currency In Arabic Actual Result for (Oman): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Lite Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 15)
	public void PremPackForOMinArabic(Method method) {
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("om-contry-lable")).click();
		WebElement PremPackType= driver.findElement(By.xpath("//*[@id=\"name-بريميوم\"]"));
		String packActualResult = PremPackType.getText();
		String packExpectedResult = "بريميوم";
		System.out.println("Premium Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/b"));
		String priceActualResult = PremPackPrice.getText();
		String priceAxpectedResult = "15";
		System.out.println("Premium Package Price Actual Result for (Oman): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/i"));
		String currActualResult = PremPackCurrency.getText();
		String currExpectedResult = "دولار أمريكي/شهر";
		System.out.println("Premium Package Currency In Arabic Actual Result for (Oman): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Premium Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 16)
	public void ClassicPackForOMinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("om-contry-lable")).click();
		WebElement ClassicPackTypeInArabic= driver.findElement(By.xpath("//*[@id=\"name-classic\"]"));
		String packActualResult = ClassicPackTypeInArabic.getText();
		String packExpectedResult = "CLASSIC";
		System.out.println("Classic Package Type In English Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Classic Package Is Not Available");
		
		WebElement ClassicPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/b"));
		String priceActualResult = ClassicPackPrice.getText();
		String priceAxpectedResult = "10";
		System.out.println("Classic Package Price Actual Result for (Oman): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Classic Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Classic Package Currency In English Actual Result for (Oman): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Classic Package Currency In Arabic Is Incorrect");
		
			
		}
	
	@Test (priority = 17)
	public void LitePackForOMinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("om-contry-lable")).click();
		WebElement LitePackType= driver.findElement(By.xpath("//*[@id=\"name-lite\"]"));
		String packActualResult = LitePackType.getText();
		String packExpectedResult = "LITE";
		System.out.println("Lite Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackPrice= driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/b"));
		String priceActualResult = LitePackPrice.getText();
		String priceAxpectedResult = "5";
		System.out.println("Lite Package Price Actual Result for (Oman): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Lite Package Is Not Available");
		
		WebElement LitePackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/i"));
		String currActualResult = LitePackCurrency.getText();
		String currExpectedResult = "/month";
		System.out.println("Lite Package Currency In Arabic Actual Result for (Oman): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Lite Package Currency In Arabic Is Incorrect");
		
			
		}
	
	
	@Test (priority = 18)
	public void PremPackForOMinEnglish(Method method) {
		driver.findElement(By.id("translation-btn")).click();
		driver.findElement(By.id("country-btn")).click();
		driver.findElement(By.id("om-contry-lable")).click();
		WebElement PremPackType= driver.findElement(By.xpath("//*[@id=\"name-premium\"]"));
		String packActualResult = PremPackType.getText();
		String packExpectedResult = "PREMIUM";
		System.out.println("Premium Package Type In Arabic Actual Result: "+packActualResult);
		softAssert.assertEquals(packActualResult, packExpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackPrice= driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/b"));
		String priceActualResult = PremPackPrice.getText();
		String priceAxpectedResult = "15";
		System.out.println("Premium Package Price Actual Result for (Oman): "+priceActualResult);
		softAssert.assertEquals(priceActualResult, priceAxpectedResult, "Premium Package Is Not Available");
		
		WebElement PremPackCurrency= driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/i"));
		String currActualResult = PremPackCurrency.getText();
		String currExpectedResult = "USD/month";
		System.out.println("Premium Package Currency In Arabic Actual Result for (Oman): "+currActualResult);
		Assert.assertEquals(currActualResult,currExpectedResult, "Premium Package Currency In Arabic Is Incorrect");
		
			
		}
}



