package Model;

public class Sportsobjects {
	
	private boolean skiptest;
	private String testrownumber;
	private String username;
	private String password;
	private boolean expectedmess;
	private String usernameerrormess;
	private String Passworderrormess;
	private String signinerrormess;
	private boolean expectedpage;
	private String expectedafterlogin;
	private String crickpageverification;
	private String impverification;
	
	
	
	

	
	public boolean isExpectedpage() {
		return expectedpage;
	}
	public void setExpectedpage(boolean expectedpage) {
		this.expectedpage = expectedpage;
	}
	public String getImpverification() {
		return impverification;
	}
	public void setImpverification(String impverification) {
		this.impverification = impverification;
	}
	public String getCrickpageverification() {
		return crickpageverification;
	}
	public void setCrickpageverification(String crickpageverification) {
		this.crickpageverification = crickpageverification;
	}
	public boolean isExpectedmess() {
		return expectedmess;
	}
	public void setExpectedmess(boolean expectedmess) {
		this.expectedmess = expectedmess;
	}
	public String getExpectedafterlogin() {
		return expectedafterlogin;
	}
	public void setExpectedafterlogin(String expectedafterlogin) {
		this.expectedafterlogin = expectedafterlogin;
	}
	
	public String getUsernameerrormess() {
		return usernameerrormess;
	}
	public void setUsernameerrormess(String usernameerrormess) {
		this.usernameerrormess = usernameerrormess;
	}
	public String getPassworderrormess() {
		return Passworderrormess;
	}
	public void setPassworderrormess(String passworderrormess) {
		Passworderrormess = passworderrormess;
	}
	public String getSigninerrormess() {
		return signinerrormess;
	}
	public void setSigninerrormess(String signinerrormess) {
		this.signinerrormess = signinerrormess;
	}
	public boolean isSkiptest() {
		return skiptest;
	}
	public void setSkiptest(boolean skiptest) {
		this.skiptest = skiptest;
	}
	public String getTestrownumber() {
		return testrownumber;
	}
	public void setTestrownumber(String testrownumber) {
		this.testrownumber = testrownumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
