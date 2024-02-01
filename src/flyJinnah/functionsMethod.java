package flyJinnah;

import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class functionsMethod {
//	public static String baseUrl = "https://www.flyjinnah.com/";
//	public static String driverPath = "geckodriver.exe";
//	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//        WebDriver driver = new FirefoxDriver();
//        System.out.println("launching Firefox browser");
//        System.setProperty("webdriver.gecko.driver", driverPath);
//        driver.get(baseUrl);
//        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle);
//        driver.manage().window().maximize();
//        closePopup();
//		switchWindow();
//        dropDown();
    	joinNow();
//    	checkBox();
	}

//@Test
	public static void closePopup() throws InterruptedException {
		String baseUrl = "https://www.flyjinnah.com/";
		String driverPath = "geckodriver.exe";
		WebDriver driver = new FirefoxDriver();
		System.out.println("launching Firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Plan']")).click();
		WebElement fromFlying = driver
				.findElement(By.xpath("//div[@class='search_field form_flying_from']//input[@name='flying-from']"));
		fromFlying.click();
		Thread.sleep(2000);
		WebElement selectFromPopup = driver.findElement(By.xpath("//span[normalize-space()='Lahore (LHE)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectFromPopup);
		selectFromPopup.click();
		Thread.sleep(2000);
		WebElement fromClosePopup = driver.findElement(By.xpath("//a[@class='closebtn']"));
		fromClosePopup.click();
		WebElement to = driver.findElement(By.xpath("//input[@name='flying-to']"));
		to.click();
		Thread.sleep(2000);
		WebElement selectToPopup = driver.findElement(By.xpath("//span[normalize-space()='Islamabad (ISB)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectToPopup);
		selectToPopup.click();
		Thread.sleep(2000);
		WebElement closeBtn = driver
				.findElement(By.xpath("//*[@id='tabs-flights']/div/div[1]/div/form/div[2]/div/div[4]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeBtn);
		Thread.sleep(2000);
		driver.quit();

	}

	public static void switchWindow() throws InterruptedException {
		String baseUrl = "https://www.flyjinnah.com/";
		String driverPath = "geckodriver.exe";
		WebDriver driver = new FirefoxDriver();
		System.out.println("launching Firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		Thread.sleep(2000);
		String originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;
		driver.findElement(By.xpath("//a[normalize-space()='Click here']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		wait.until(ExpectedConditions.titleIs("IBE Flight Booking"));
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
		email.sendKeys("sanakhan@gmail.com");
		WebElement password = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		password.sendKeys("Password123");
		Thread.sleep(2000);
		driver.quit();
	}

	public static void dropDown() throws InterruptedException {
		String baseUrl = "https://www.flyjinnah.com/";
		String driverPath = "geckodriver.exe";
		WebDriver driver = new FirefoxDriver();
		System.out.println("launching Firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement fromFlying = driver
				.findElement(By.xpath("//div[@class='search_field form_flying_from']//input[@name='flying-from']"));
		fromFlying.click();
		Thread.sleep(2000);
		WebElement selectFromPopup = driver.findElement(By.xpath("//span[normalize-space()='Lahore (LHE)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectFromPopup);
		selectFromPopup.click();
		Thread.sleep(2000);
		WebElement fromClosePopup = driver.findElement(By.xpath("//a[@class='closebtn']"));
		fromClosePopup.click();
		WebElement to = driver.findElement(By.xpath("//input[@name='flying-to']"));
		to.click();
		Thread.sleep(2000);
		WebElement selectToPopup = driver.findElement(By.xpath("//span[normalize-space()='Islamabad (ISB)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectToPopup);
		selectToPopup.click();
		Thread.sleep(2000);
		WebElement closeBtn = driver
				.findElement(By.xpath("//*[@id='tabs-flights']/div/div[1]/div/form/div[2]/div/div[4]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeBtn);
		Thread.sleep(2000);
		WebElement calControl = driver
				.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']"));
		calControl.click();
		Thread.sleep(2000);
//        WebElement clickNextBtn = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
//        clickNextBtn.click();
//        Thread.sleep(2000);
//        WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement selectDays= webdwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-state-default ui-state-hover']")));
////        selectDays.click();
//        Thread.sleep(2000);
		Select drpAdult = new Select(driver.findElement(By.xpath("//select[@name='pax_adult']")));
		drpAdult.selectByVisibleText("4");
		Thread.sleep(2000);
		Select drpChild = new Select(driver.findElement(By.xpath("//select[@name='pax_child']")));
		drpChild.selectByVisibleText("1");
		Thread.sleep(2000);
		Select drpInfant = new Select(driver.findElement(By.xpath("//select[@name='pax_infant']")));
		drpInfant.selectByVisibleText("1");
		Thread.sleep(2000);
		Select drpCurrency = new Select(driver.findElement(By.xpath("//select[@name='search_currency']")));
		drpCurrency.selectByVisibleText("RUB");
		Thread.sleep(2000);
		WebElement promoCode = driver.findElement(By.xpath("//input[@name='promocode']"));
		promoCode.sendKeys("12345");
		Thread.sleep(2000);
		WebElement bookNowBtn = driver.findElement(By.xpath("//input[@value='Book Now']"));
		bookNowBtn.click();
		Thread.sleep(2000);
//        WebElement rdBtn = driver.findElement(By.xpath("//label[@for='journey_type_rt']"));
//        rdBtn.click();
		driver.quit();
	}

	public static void joinNow() throws InterruptedException {
		String baseUrl = "https://www.flyjinnah.com/";
		String driverPath = "geckodriver.exe";
		WebDriver driver = new FirefoxDriver();
		System.out.println("launching Firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		WebElement joinBtn = driver.findElement(By.xpath("//a[@class='btn-filled-red']"));
		joinBtn.click();
		Thread.sleep(2000);
		String originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;
		driver.findElement(By.xpath("//a[normalize-space()='Click here']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		wait.until(ExpectedConditions.titleIs("IBE Flight Booking"));
		Thread.sleep(2000);
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		email.sendKeys("sanakhan@gmail.com");
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		password.sendKeys("Password123");
		Thread.sleep(2000);
		WebElement confirmPassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
		confirmPassword.sendKeys("Password123");
//		Select drpTitle = new Select(driver.findElement(By.xpath("//input[@id='salutation-button']")));
//		drpTitle.selectByVisibleText("MS.");
//		Thread.sleep(2000);
//		WebElement fn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstName']")));
//		fn.sendKeys("Sana");
//		WebElement ln = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastName']")));
//		ln.sendKeys("Khan");
//		Thread.sleep(2000);
//		Select drpNationality = new Select(driver.findElement(By.xpath("//input[@id='nationality']")));
//		drpNationality.selectByVisibleText("Pakistan");
//		Select drpCountry = new Select(driver.findElement(By.xpath("//input[@id='country']")));
//		drpCountry.selectByVisibleText("Pakistan");
//		Thread.sleep(2000);// input[@name='countryCode']
//		Select drpCode = new Select(driver.findElement(By.xpath("//input[@name='countryCode']")));
//		drpCode.selectByVisibleText("Pakistan");
//		WebElement phone = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='telNumber-phone']")));
//		phone.sendKeys("3002345678");
//		Thread.sleep(2000);
//		WebElement DOB = wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//i[@class='glyphicon glyphicon-calendar pax-dob-img pull-right']")));
//		DOB.click();
		Thread.sleep(2000);
		driver.quit();
	}

	public static void checkBox() throws InterruptedException {
		String baseUrl = "https://www.ironspider.ca/forms/checkradio.htm";
		String driverPath = "geckodriver.exe";
		WebDriver driver = new FirefoxDriver();
		System.out.println("launching Firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		WebElement chkBxRed = driver.findElement(By.xpath("//input[@value='red']"));
		chkBxRed.click();
		WebElement chkBxYellow = driver.findElement(By.xpath("//input[@value='yellow']"));
		chkBxYellow.click();
		WebElement chkBxOrange = driver.findElement(By.xpath("//input[@value='orange']"));
		chkBxOrange.click();
		WebElement chkBxBlue = driver.findElement(By.xpath("//input[@value='blue']"));
		chkBxBlue.click();
		WebElement checkBoxSelected = driver.findElement(By.cssSelector("input[value='red']"));
		boolean isSelected = checkBoxSelected.isSelected();
		if (isSelected == false) {
			checkBoxSelected.click();
		}
		WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("input[value='red']"));
		boolean isDisplayed = checkBoxDisplayed.isDisplayed();
		if (isDisplayed == true) {
			checkBoxDisplayed.click();
		}
		WebElement checkBoxEnabled = driver.findElement(By.cssSelector("input[value='red']"));
		boolean isEnabled = checkBoxEnabled.isEnabled();
		if (isEnabled == true) {
			checkBoxEnabled.click();

		}
		driver.quit();
	}
}
