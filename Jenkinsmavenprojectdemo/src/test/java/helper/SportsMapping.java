package helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import Model.Sportsobjects;
import au.com.bytecode.opencsv.CSVReader;

public class SportsMapping {

	@DataProvider(name="sports")
	public static Object[][] getSportsobjects() throws IOException 
	{
		CSVReader csvreader=new CSVReader(new FileReader("C:\\Jenkinsmavenprojectdemo\\src\\test\\resources\\sports.csv"));
		List<String[]> datalist=csvreader.readAll();
		datalist.remove(0);
		
		Object[][] data=new Object[datalist.size()][1];
		List <Sportsobjects> testlist= new ArrayList<Sportsobjects>();
		for(String[]StringArray:datalist)
		{
			Sportsobjects Testinfo=new Sportsobjects();
			Testinfo.setSkiptest(Boolean.parseBoolean(StringArray[0]));
			Testinfo.setTestrownumber(StringArray[1]);
			Testinfo.setUsername(StringArray[2]);
			Testinfo.setPassword(StringArray[3]);
			Testinfo.setExpectedmess(Boolean.parseBoolean(StringArray[4]));
			Testinfo.setUsernameerrormess(StringArray[5]);
			Testinfo.setPassworderrormess(StringArray[6]);
			Testinfo.setSigninerrormess(StringArray[7]);
			Testinfo.setExpectedpage(Boolean.parseBoolean(StringArray[8]));
			Testinfo.setExpectedafterlogin(StringArray[9]);
		    Testinfo.setCrickpageverification(StringArray[10]);
		    Testinfo.setImpverification(StringArray[11]);
		
			testlist.add(Testinfo);
		}
		for(int i=0;i<data.length;i++)
		{
			for(int j=0; j<data[i].length;j++)
				data[i][j]=testlist.get(i);
		}
		csvreader.close();
		return data;
		
	}}

