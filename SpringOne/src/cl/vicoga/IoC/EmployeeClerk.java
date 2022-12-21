package cl.vicoga.IoC;

public class EmployeeClerk implements Employee {
	
	private ReportCreation reportCreation;

	public void setReportCreation(ReportCreation reportCreation) {
		this.reportCreation = reportCreation;
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
