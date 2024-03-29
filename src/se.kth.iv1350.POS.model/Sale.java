package src.se.kth.iv1350.POS.model;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
  private LocalTime saleTime;
  private LocalDate date;
  private ArrayList<Item> items = new ArrayList<Item>();
  private Item createdItem;
  private double totalPrice;
  private double totalVAT;
  private double runningTotal = totalPrice + totalVAT;

  /**
   * Creates a new instance and saves the time for the sale.
   */
  public Sale() {
	this.saleTime = LocalTime.now();
	this.date = LocalDate.now();
	this.totalPrice = totalPrice;
	this.totalVAT = totalVAT;
  }

  /**
   * This function creates a new item and adds its price to the running total then proceeds to create a
   * Sale Information Data Transfer Object and returns it.
   * @param itemDTO
   * @return The saleinformation from the newly added item.
   */
  public SaleInfoDTO addItem(ItemDTO itemDTO) {
    Item createdItem = new Item(itemDTO, 1);
    for(int i = 0; i < items.size(); i++){
      if(createdItem.getName().equals(items.get(i).getName())){
        createdItem = new Item(itemDTO, items.get(i).getQuantity() + 1);
        items.remove(i);
      }
    }
    items.add(createdItem);
    updatePrices();
	SaleInfoDTO saleInformation = new SaleInfoDTO(itemDTO, runningTotal);
	return saleInformation;
  }

  /**
   * This function calculates the running total price based on the price of the item scanned and the VAT of that item.
   */
  public void updatePrices() {
    this.totalPrice = 0;
    this.totalVAT = 0;
    for(Item item : items) {
      this.totalPrice += item.getPrice();
      this.totalVAT += (item.getVAT() * item.getPrice());
    }
    this.runningTotal = this.totalPrice + this.totalVAT;
  }


  /**
   * This is the function which completes the sale and accepts payment. It takes in several parameters.
   * @param payment This is the parameter which takes in the payment recieved.
   * @param sale This is the parameter which takes in the current sale.
   * @return The receipt.
   */
  public Receipt complete(PaymentDTO payment, Sale sale) {
    Receipt receipt = new Receipt(sale, payment);
    return receipt;
  }

  /**
   * This is the function which return the time of the sale.
   * @return The time in hours, minutes and seconds.
   */
  public String getSaleTime() {
    return this.saleTime.getHour()+":"+this.saleTime.getMinute()+":"+this.saleTime.getSecond();
  }

  /**
   * This function returns the date of the sale.
   * @return The date.
   */
  public LocalDate getDate() {
    return this.date;
  }

  /**
   * This is the function which returns the items of the sale.
   * @return The items.
   */
  public ArrayList<Item> getItems() {
    return this.items;
  }

  /**
   * This is the function which returns the total price of the sale.
   * @return The total price.
   */
  public double getTotalPrice() {
    return this.totalPrice;
  }

  /**
   * This is the function which returns the total VAT of the sale.
   * @return The total VAT.
   */
  public double getTotalVAT() {
    return this.totalVAT;
  }

  /**
   * This is the function which return the running total of the sale.
   * @return The running total
   */
  public double getRunningTotal() {
    return this.runningTotal;
  }
}
