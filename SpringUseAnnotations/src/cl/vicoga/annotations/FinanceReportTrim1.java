package cl.vicoga.annotations;
import org.springframework.stereotype.Component;

@Component
public class FinanceReportTrim1 implements CreateFinanceReport{

	@Override
	public String getFinanceReport() {
		// TODO Auto-generated method stub
		return "trimester 1 report";
	}

}
