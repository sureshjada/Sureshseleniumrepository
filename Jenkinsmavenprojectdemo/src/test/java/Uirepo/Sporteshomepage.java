package Uirepo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;

public class Sporteshomepage {
	/*public int pass=1;
	public int fail=2;
	public int skip=3;
*/
	String url="http://117.240.88.103:8484/sportsomaniac/home";
	private WebDriver d;
	public String TestName2="screenshot";
	
	WebElement login;
	String loginloc="//a[contains(text(),'Login')]";
	By logBy=By.xpath(loginloc);
	
	
	WebElement username;
	String usernameloc="emailField";
	By userBy=By.id(usernameloc);
	
	
	WebElement password;
	String passwordloc="passwordField";
	By passBy=By.id(passwordloc);
	
	
	WebElement signin;
	String signloc="loginBtn";
	By signBy=By.id(signloc);
	
	
	WebElement usernameerrormess;
	String usernameerrorloc="//*[contains(text(),'This field is required.')]";
	By usernameBy=By.xpath(usernameerrorloc);
	
	
	WebElement passworderroemess;
	String passworderrorloc="//*[contains(text(),'This field is required.')]";
	By passworderrorBy=By.xpath(passworderrorloc);
	
	
	
	WebElement expectederroemessage;
	String expectederrorloc="//div[contains(text(),'Login Failed, Invalid login credentials.')]";
	By expectedBy=By.xpath(expectederrorloc);
	
	WebElement expectedafterloginmessage;
	String expectedloc=".//*[@id='cricket']/div[4]/div/div/div/div/div[1]";
	By expectedafterBy=By.xpath(expectedloc);
	
	
	WebElement cricket;
	String cricketloc="selcricket";
	By crickBy=By.id(cricketloc);
	
	WebElement cricketpageverification;
	String crickverificationloc="//*[contains(text(),'Important Articles')]";
	By crickverBy=By.xpath(crickverificationloc);
	
	
	WebElement importentarticla;
	String inploc="//*[contains(text(),'Sreesanth Permitted To Practice In Kochi Stadium, Says Greater Cochin Development Authority')]";
    By inpariBy=By.xpath(inploc);
    
    
    WebElement implinkverification;
    String implinkloc="//*[contains(text(),'Sreesanth Permitted To Practice In Kochi Stadium, Says Greater Cochin Development Authority')]";
    By impverBy=By.xpath(implinkloc);
    
    
    
    
    
public Sporteshomepage(WebDriver d)
{
	this.d=d;
}


public void openurl()
{
	d.get(url);
	d.manage().window().maximize();
}



public void clicklogin()
{
	login=d.findElement(logBy);
	login.click();
}


public void enterusername(String user)
{
	username=d.findElement(userBy);
	username.sendKeys(user);
}

public void enterpassword(String pass)
{
	password=d.findElement(passBy);
	password.sendKeys(pass);
}

public void signin()
{
	signin=d.findElement(signBy);
	signin.click();
}


public void usernameerrormess(String username)
{
	usernameerrormess=d.findElement(usernameBy);
	Assert.assertEquals(usernameerrormess.getText(), username);
}

public void passworderroemess(String password)
{
	passworderroemess=d.findElement(passworderrorBy);
    Assert.assertEquals(passworderroemess.getText(), password);
}

public void signinerrormess(String errormes)
{
	expectederroemessage=d.findElement(expectedBy);
	Assert.assertEquals(expectederroemessage.getText(), errormes);
	
}

public void afterlogin(String afteremess)
{
	expectedafterloginmessage=d.findElement(expectedafterBy);
	Assert.assertEquals(expectedafterloginmessage.getText(), afteremess);
}

public void clickcricket()
{
	cricket=d.findElement(crickBy);
	cricket.click();
}

public void cricketppageverifcation(String mess)
{
	cricketpageverification=d.findElement(crickverBy);
	Assert.assertEquals(cricketpageverification.getText(), mess);
}

public void clickimplink()
{
	importentarticla=d.findElement(inpariBy);
	importentarticla.click();
	
}

public void impverification(String veri)
{
	implinkverification=d.findElement(impverBy);
	Assert.assertEquals(implinkverification.getText(), veri);
}

public void windowhandle() throws InterruptedException
{
	String mainwindow=d.getWindowHandle();
	d.findElement(By.xpath("//*[contains(text(),'Sreesanth Permitted To Practice In Kochi Stadium, Says Greater Cochin Development Authority')]")).click();
	Thread.sleep(2000);
	for(String winhandle:d.getWindowHandles())
	{
		d.switchTo().window(winhandle);
		
		if(d.getTitle().equals("Sreesanth Permitted To Practice In Kochi Stadium, Says Greater Cochin Development Authority - Cricket News"))
		{
			d.close();
	    }
		else
		{ 
			 System.out.println("Title of the page after - switchingTo: " + d.getTitle());
		}
	}
	d.switchTo().window(mainwindow);
}

public void screenshot(ITestResult result) throws IOException  // Take a screen shot use this code
{
	 System.out.println(result.getStatus());
	 if((result.getStatus())==2){
		 File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C://suresh project//New folder//Failure_Screenshots\\"+ TestName2 + "_"+ new SimpleDateFormat("HHmmss").format(
                   Calendar.getInstance().getTime()).toString() + ".jpeg"));
	 }
	}
}
