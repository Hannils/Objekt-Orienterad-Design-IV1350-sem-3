package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the external inventory system handler from the integration package.
 */
public class EISHandler {

  public ItemDTO findItem(String identifier){
    ItemDTO itemDTO = new ItemDTO("Ris", 0.25, 15, "Uncle Ben's 1 minute rice");
	return itemDTO;
  }
  public void updateInventory(Sale sale) {
    System.out.println("Inventory has been updated!");
  }

}
