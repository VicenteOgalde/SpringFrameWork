package cl.vicoga.annotations;
import org.springframework.stereotype.Component;

@Component
public class FinanceReportTrim2 implements CreateFinanceReport{

	@Override
	public String getFinanceReport() {
		// TODO Auto-generated method stub
		return "trimester 3 report";
	}

}
