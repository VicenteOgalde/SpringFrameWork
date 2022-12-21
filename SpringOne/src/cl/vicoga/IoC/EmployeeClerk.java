package cl.vicoga.IoC;

public class EmployeeClerk implements Employee {
	
	private ReportCreation reportCreation;
	private String email;
	private String nameCompany;

	public void setReportCreation(ReportCreation reportCreation) {
		this.reportCreation = reportCreation;
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

	@Override
	public String getTask() {
		// TODO Auto-generated method stub
		return "manage boss schedule";
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return "Clerk Report: "+reportCreation.getReport();
	}

}
