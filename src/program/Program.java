package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {
	
	public static void main(String args[]) throws ParseException {

	Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		String dateContract = sc.next();
		System.out.println("Contract Value: ");
		double valueContract = sc.nextDouble();
		
		System.out.print("Enter number of installments: ");
		int numberMonths = sc.nextInt();
	
		Contract contract = new Contract(number, formatter.parse(dateContract), valueContract);
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, numberMonths);
		
		System.out.println("Installments:");
		
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();
	}
}
