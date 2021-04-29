package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.model.Receipt;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the printer from the integration package.
 */
public class Printer {
  public void printReceipt(Receipt receipt) {
    Sale sale = new Sale();
    String storeinformation = receipt.getStoreInformation();
    System.out.println("*****************************************");
    System.out.println(storeinformation);
    System.out.println(sale.getItems().toString());
    System.out.println(sale.getTotalPrice());
    System.out.println(sale.getTotalVAT());
    System.out.println(sale.getSaleTime());
    System.out.println("*****************************************");
  }
}
