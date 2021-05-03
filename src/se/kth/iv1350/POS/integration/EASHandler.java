package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the external accounting system handler form the integration package.
 */
public class EASHandler {
	public void registerPayment(PaymentDTO payment, Sale sale) {
		System.out.println("Payment of " + payment.toString() + " has been registered");
	}
}
