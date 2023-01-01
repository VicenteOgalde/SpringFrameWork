package cl.vicoga.annotations;

import org.springframework.beans.factory.annotation.Value;

public class FinanceDirector implements Employee {
	
	private CreateFinanceReport financeReport;
	
	@Value("${email}")
	private String email;
	@Value("${companyName}")
	private String companyName;
	
	

	public FinanceDirector(CreateFinanceReport financeReport) {
		super();
		this.financeReport = financeReport;
	}

	@Override
	public String getTask() {
		// TODO Auto-generated method stub
		return "task from the finance director \nemail:"+email
				+" \ncompany name:"+companyName;
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return financeReport.getFinanceReport();
	}

}
