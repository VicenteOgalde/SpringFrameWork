package cl.vicoga.IoC;

public class EmployeeBoss implements Employee{

	private ReportCreation reportCreation;
	
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
}
