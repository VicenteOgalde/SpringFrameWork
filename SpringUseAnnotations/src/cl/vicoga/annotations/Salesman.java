package cl.vicoga.annotations;

import org.springframework.stereotype.Component;

@Component
public class Salesman implements Employee {
	
	private CreateFinanceReport financeReport;
	

	
	
	public Salesman(CreateFinanceReport financeReport) {
		
		this.financeReport = financeReport;
	}

	@Override
	public String getTask() {
		// TODO Auto-generated method stub
		return "Sell, sell ...";
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return financeReport.getFinanceReport();
	}

}
