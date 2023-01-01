package cl.vicoga.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("cl.vicoga.annotations")
@PropertySource("classpath:dataCompany.properties")
public class EmployeeConfig {
	
	//bean definition for FinanceReportSell
	
	@Bean
	public CreateFinanceReport financeReportSellDpt() {
		return new FinanceReportSellDpt();
	}
	
	//bean definition for the Finance Director e Injection
	
	@Bean
	public Employee financeDirector() {
		return new FinanceDirector(financeReportSellDpt());
	}
	
	
	
	
	
	
	

}
