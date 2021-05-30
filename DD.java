package TDY;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;




public class DD {

	
	   
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		File src;
		
  
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
    	Actions DD=new Actions(driver);
  //  	WebElement from=driver.findElement(By.cssSelector("#todrag > span:nth-child(2)"));
 //  	WebElement To=driver.findElement(By.id("mydropzone"));
    final String JQUERY_LOAD_SCRIPT = ("C:\\Users\\Mr Avi\\eclipse-workspace\\Assign\\help.js");
    String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);

    driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeAsyncScript(
            jQueryLoader );

    // ready to rock
    js.executeScript("jQuery(function($) { " + " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); "
            + " }); ");



  //http://stackoverflow.com/questions/29381233/how-to-simulate-html5-drag-and-drop-in-selenium-webdriver
  //"where jquery_load_helper.js contains:"  
  String filePath = "C:\\Users\\Mr Avi\\eclipse-workspace\\Assign\\drop.js";


  //JQuery can ONLY work with id and css , xpath does NOT work with it.
  //String source =  "//section[@id='wrapper']/article/ul/li[4]/a"; 
  String source = "#todrag > span:nth-child(2)";
  String target = "#mydropzone"; 

  StringBuffer buffer = new StringBuffer();
  String line;
  BufferedReader br = new BufferedReader(new FileReader(filePath));
  while((line = br.readLine())!=null)
      buffer.append(line);

  String javaScript = buffer.toString();

  javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
  ((JavascriptExecutor)driver).executeScript(javaScript);
  src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(src, new File("C:\\Users\\Mr Avi\\eclipse-workspace\\Assign\\src\\TDY\\Jquery.png"));


  Thread.sleep(1000);
}
/*	catch(Exception e){
e.printStackTrace();
}
*/


private static String readFile(String file) throws IOException {
Charset cs = Charset.forName("UTF-8");
FileInputStream stream = new FileInputStream(file);
try {
Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
StringBuilder builder = new StringBuilder();
char[] buffer = new char[8192];
int read;
while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
builder.append(buffer, 0, read);
}
return builder.toString();
} finally {
stream.close();
}
}
}

    	


	