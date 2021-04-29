package src.se.kth.iv1350.POS.controller;

import src.se.kth.iv1350.POS.integration.DCHandler;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
  private EISHandler eis;
  private EASHandler eas;
  private DCHandler dc;
  private Printer printer;
  private Sale sale;

  /**
   * The applications only controller which takes several parameters.
   * @param eas This is the external accounting system parameter.
   * @param eis This is the external inventory system parameter.
   * @param dc This is the discount handler parameter.
   * @param printer This is the printer parameter.
   */
  public Controller(EISHandler eis, EASHandler eas, DCHandler dc, Printer printer){
    this.eis = eis;
	this.eas = eas;
    this.dc = dc;
    this.printer = printer;

    //For testing purposes
    System.out.println("Controller started successfully");
  }


  /**
   * Starts a new sale. This method must be called before doing anything else during a sale.
   */
  public void startSale() {
	sale = new Sale();
  }

}