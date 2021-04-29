package src.se.kth.iv1350.POS.model;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
  private LocalTime saleTime;
  private ArrayList<Item> items = new ArrayList<Item>();
  private double totalPrice;
  private double totalVAT;
  private double runningTotal = totalPrice + totalVAT;

  /**
   * Creates a new instance and saves the time for the sale.
   */
  public Sale() {
	saleTime = LocalTime.now();
  }

  /**
   * This function creates a new item and adds its price to the running total then proceeds to create a
   * Sale Information Data Transfer Object and returns it.
   * @param itemDTO
   * @return
   */
  public SaleInfoDTO addItem(ItemDTO itemDTO) {
    Item createdItem = new Item(itemDTO, 1);
    items.add(createdItem);
    calculateRunningTotal(createdItem);
	SaleInfoDTO saleInformation = new SaleInfoDTO(itemDTO, runningTotal);
	System.out.println("Item has been added to sale");
	return saleInformation;
  }

  /**
   * This function calculates the running total price based on the price of the item scanned and the VAT of that item.
   * @param createdItem
   */
  public void calculateRunningTotal(Item createdItem) {
	totalPrice += createdItem.getPrice();
	totalVAT += (createdItem.getVAT() * createdItem.getPrice());
  }

  /**
   * This is the function which completes the sale and accepts payment. It takes in several parameters.
   * @param payment This is the parameter which takes in the payment recieved.
   * @param sale This is the parameter which takes in the current sale.
   * @return
   */
  public Receipt complete(PaymentDTO payment, Sale sale) {
    Receipt receipt = new Receipt(sale, payment);
    return receipt;
  }

  /**
   * This is the function which return the time of the sale.
   * @return
   */
  public LocalTime getSaleTime() {
    return this.saleTime;
  }

  /**
   * This is the function which returns the items of the sale.
   * @return
   */
  public ArrayList<Item> getItems() {
    return this.items;
  }

  /**
   * This is the function which returns the total price of the sale.
   * @return
   */
  public double getTotalPrice() {
    return this.totalPrice;
  }

  /**
   * This is the function which returns the total VAT of the sale.
   * @return
   */
  public double getTotalVAT() {
    return this.totalVAT;
  }
  /**
   * This is the function which return the running total of the sale.
   * @return
   */
  public double getRunningTotal() {
    return this.runningTotal;
  }
}
