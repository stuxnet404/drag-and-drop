package TDY;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class dd2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		
  
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
    	Actions DD=new Actions(driver);
  	WebElement from=driver.findElement(By.cssSelector("body > div:nth-child(1) > div.row.topper > div.col-md-6.header-section > div.logo > a > img"));
	WebElement To=driver.findElement(By.id("mydropzone"));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
			                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
			                    + "setData: function (key, value='draggable1') {\n" + "this.data[key] = value;\n" + "},\n"
			                    + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
			                    + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
			                    + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
			                    + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
			                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
			                    + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
			                    + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
			                    + "var dropEvent = createEvent('drop');\n"
			                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
			                    + "var dragEndEvent = createEvent('dragend');\n"
			                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
			                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
			                    + "simulateHTML5DragAndDrop(source,destination);", from, To);  
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src, new File("C:\\Users\\Mr Avi\\eclipse-workspace\\Assign\\src\\TDY\\home.png"));


			  
			  /*
	  String filePath = "C:\\Users\\Mr Avi\\eclipse-workspace\\Assign\\drop.js";
	  StringBuffer buffer = new StringBuffer();

	  String line;
	  BufferedReader br = new BufferedReader(new FileReader(filePath));
	  while((line = br.readLine())!=null)
	      buffer.append(line);

	  String javaScript = buffer.toString();
	  javaScript = javaScript + "$('#todrag > span:nth-child(2)').simulateDragDrop({ dropTarget: '#mydropzone'});";
	  ((JavascriptExecutor)driver).executeScript(javaScript);*/
}
}
