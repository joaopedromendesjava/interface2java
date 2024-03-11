package service;

import java.util.Calendar;

import model.entities.Contract;
import model.entities.Installment;
import model.entities.OnlinePaymentService;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {
	
	}
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		
		this.onlinePaymentService = onlinePaymentService;
	}


	public void processContract(Contract contract, Integer months) {
		
		double installmentValue = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(contract.getDate());
			calendar.add(Calendar.MONTH, i);
				
			double amountWithInterest = onlinePaymentService.interest(installmentValue, i);
			double amountFinal = onlinePaymentService.paymentFee(amountWithInterest);
			
			contract.getInstallments().add(new Installment(calendar.getTime(), amountFinal));
			
		}
	}
}



