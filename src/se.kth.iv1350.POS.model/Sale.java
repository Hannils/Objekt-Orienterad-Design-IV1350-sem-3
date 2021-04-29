package src.se.kth.iv1350.POS.model;

import java.time.LocalTime;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
  private LocalTime saleTime;

  /**
   * Creates a new instance and saves the time for the sale.
   */
  public Sale() {
	saleTime = LocalTime.now();
  }
}
