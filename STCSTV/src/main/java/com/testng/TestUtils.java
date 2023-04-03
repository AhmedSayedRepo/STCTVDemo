package com.testng;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtils extends Subscription {
	
	public static void takePicture(String name) throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\ahmed.ibrahim\\eclipse-workspace\\STCSTV\\TestReport\\"+name+".png"));
	}
	

}
