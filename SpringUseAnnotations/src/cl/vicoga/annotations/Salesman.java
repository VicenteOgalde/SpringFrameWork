package cl.vicoga.annotations;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Salesman implements Employee ,InitializingBean, DisposableBean{
	
	@Autowired
	@Qualifier("financeReportTrim1")//remember lowercase for the parameter
	private CreateFinanceReport financeReport;
	

	
	
	public Salesman() {
		
		
	}
	
	//execute task after the bean is shutdown
	
	@Override
	public void destroy() throws Exception {
		System.out.println("execute after shutdown");
		
	}
	

	//execute task before the bean is create
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("execute before creation");
		
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
