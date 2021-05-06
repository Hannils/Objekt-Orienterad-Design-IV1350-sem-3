package src.se.kth.iv1350.POS.DTO;

/**
 * This is the class which holds information about a payement
 */
public class PaymentDTO {
  private double amount;
  private String currency;

  /**
   * This is the constructor for the payment data transfer object which takes in two parameters.
   * @param amount This is the parameter which specifies how much of a certain currency is being paid.
   * @param currency This is the parameter which specifies what currency is used in the payment.
   */
  public PaymentDTO(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  /**
   * This is the function which returns the amount used in the payment.
   * @return The amount.
   */
  public double getAmount() {
    return this.amount;
  }

  /**
   * This is the function which returns the currency used in the payment.
   * @return The currency.
   */
  public String getCurrency() {
    return this.currency;
  }

  /**
   * This is the function which expressed how PaymentDTO will be printed.
   * @return The way a PaymentDTO will be printed.
   */
  @Override
  public String toString() {
    return this.amount + " " + this.currency;
  }
}
