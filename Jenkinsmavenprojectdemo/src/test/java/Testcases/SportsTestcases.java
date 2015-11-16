package Testcases;

import helper.SportsMapping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Model.Sportsobjects;
import Uirepo.Sporteshomepage;

public class SportsTestcases {
	WebDriver d;
	 Sportsobjects testdata;
	
	
	@BeforeMethod(alwaysRun=true)
	public void launch()
	{ 
		  
	}
	
//@Test(dataProvider="sports",dataProviderClass=SportsMapping.class)
	public void SportTest(Sportsobjects testdata) throws InterruptedException
	{
				Sporteshomepage s=new Sporteshomepage(d);
		
		if(!testdata.isSkiptest())
		{
				s.openurl();
				Thread.sleep(2000);
				s.clicklogin();
			
				if(testdata.isExpectedmess())
				{
						if(!(testdata.getUsername().isEmpty()))
					{
					    System.out.println(testdata.getUsername());
						s.enterusername(testdata.getUsername());
					}
					if(!(testdata.getPassword().isEmpty()))
					{
					    System.out.println(testdata.getPassword());
						s.enterpassword(testdata.getPassword());
					}
					
			    s.signin();
			    Thread.sleep(2000);
			    
					if(!(testdata.getUsernameerrormess().isEmpty()))
					{
						System.out.println(testdata.getUsernameerrormess());
						s.usernameerrormess(testdata.getUsernameerrormess());
					}
					if(!(testdata.getPassworderrormess().isEmpty()))
					{
						System.out.println(testdata.getPassworderrormess());
						s.passworderroemess(testdata.getPassworderrormess());
					}
					if(!(testdata.getSigninerrormess().isEmpty()))
					{
						System.out.println(testdata.getSigninerrormess());
						s.signinerrormess(testdata.getSigninerrormess());
					}
		
					if(!(testdata.getExpectedafterlogin().isEmpty()))
				     {
						System.out.println(testdata.getExpectedafterlogin());
						s.afterlogin(testdata.getExpectedafterlogin());
					 }}
				
				if(testdata.isExpectedpage())
				{
				
				 s.clickcricket();
				 if(!(testdata.getCrickpageverification().isEmpty()))
				 {
					 System.out.println(testdata.getCrickpageverification());
				 s.cricketppageverifcation(testdata.getCrickpageverification());
				 }
				 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 s.clickimplink();
				 Thread.sleep(6000);
				 if(!(testdata.getImpverification().isEmpty()))
				 {
					 System.out.println(testdata.getImpverification());
				s.impverification(testdata.getImpverification());
				 }
				}//s.windowhandle();
			
		
	    }
	
		else
		{
			throw new SkipException("[skipTest]=[true];skiping iteration");
		}
	}
	
	@Test(groups={"firefox"})
    public void endToEndFlorida_firefox() throws Exception {
		
		
			
		 d = new FirefoxDriver();  
	 		 SportTest(testdata);
	 
	 }
	
	/*@Test(groups={"chrome"})
    public void endToEndFlorida_chrome() throws Exception {	
	 System.setProperty("webdriver.chrome.driver", "C://suresh project//chromedriver.exe");
	 if(!testdata.isSkiptest())
		{
			
	   d = new ChromeDriver();  
	   SportTest(testdata);
	 }}*/
	
	@AfterMethod(alwaysRun=true)	
      public void closeBrowser(ITestResult result) throws Exception {
			System.out.println(result.getStatus());	
	        Sporteshomepage s=new Sporteshomepage(d);	   
			s.screenshot(result);
			d.close();
		}
	
	
		@Factory(dataProviderClass=SportsMapping.class, dataProvider="sports")
		public SportsTestcases(Sportsobjects testdata) {
         this.testdata=testdata;
		}
}
