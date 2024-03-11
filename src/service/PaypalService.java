package service;

import model.entities.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService{
	
	private static final double FEE = 0.02;
	private static final double MONTH_FEE = 0.01;

	@Override
	public double paymentFee(double amount) {
		
		return amount += amount * FEE;
	}

	@Override
	public double interest(double amount, int months) {
		
		return amount += amount * MONTH_FEE * months;
	}

}
