package cl.vicoga.annotations;

import org.springframework.stereotype.Component;

@Component("salesman")
public class Salesman implements Employee {

	@Override
	public String getTask() {
		// TODO Auto-generated method stub
		return "Sell, sell ...";
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return "report of salesman";
	}

}
