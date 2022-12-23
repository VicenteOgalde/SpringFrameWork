package cl.vicoga.IoC;

public class EmployeeBoss implements Employee{

	private ReportCreation reportCreation;
	private String email;
	private String nameCompany;

	//init method execute task before the bean is available
	
	public void init() {
		System.out.println("inside method init before the bean is ready");
	}
		
	//destroy method execute task after the bean is use
	public void destroy() {
		System.out.println("inside method destroy after the bean is use");
	}
	
	
	
	public EmployeeBoss(ReportCreation reportCreation) {
		this.reportCreation=reportCreation;
	}
	
	public String getTask() {
		return "important tasks";
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return "boss report: "+ reportCreation.getReport();
		
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
}
