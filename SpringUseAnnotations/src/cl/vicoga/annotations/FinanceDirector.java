package cl.vicoga.annotations;

public class FinanceDirector implements Employee {
	
	private CreateFinanceReport financeReport;
	
	

	public FinanceDirector(CreateFinanceReport financeReport) {
		super();
		this.financeReport = financeReport;
	}

	@Override
	public String getTask() {
		// TODO Auto-generated method stub
		return "task from the finance director";
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return financeReport.getFinanceReport();
	}

}
