package cl.vicoga.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Salesman implements Employee {
	@Autowired
	@Qualifier("financeReportTrim1")//remember lowercase for the parameter
	private CreateFinanceReport financeReport;
	

	
	
	public Salesman() {
		
	}
	/*
	@Autowired
	public Salesman(CreateFinanceReport financeReport) {
		
		this.financeReport = financeReport;
	}
*/
	/*
	public void setFinanceReport(CreateFinanceReport financeReport) {
		this.financeReport = financeReport;
	}
*/
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
