package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Receipt;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the printer from the integration package.
 */
public class Printer {

  /**
   * This is the function which prints the receipt.
   * @param receipt This is the parameter receipt which contains information.
   */
  public void printReceipt(Receipt receipt, Sale sale) {
    System.out.println("Printing receipt...");
  }
}
