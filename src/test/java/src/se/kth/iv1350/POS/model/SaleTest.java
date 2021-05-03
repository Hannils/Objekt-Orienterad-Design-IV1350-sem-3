package src.se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.controller.Controller;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;
import src.se.kth.iv1350.POS.model.Sale;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
  private Sale instanceToTest;
  private ItemDTO itemDTO;
  private EASHandler eas;
  private EISHandler eis;
  private Printer printer;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	Controller contr = new Controller(eis, eas, printer);
	instanceToTest = new Sale();
	itemDTO = new ItemDTO("Ris", 0.25, 15, "Basmati");
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
  }

  @AfterEach
  public void tearDown() {
	instanceToTest = null;
	printoutBuffer = null;
	System.setOut(originalSysOut);
  }
  @Test
  public void testIfItemAddedToSale() {
	SaleInfoDTO saleInformation = instanceToTest.addItem(itemDTO);
	String printout = saleInformation.getCurrentItemName();
	String expectedOutput = "Basmati";
	assertTrue(printout.contains(expectedOutput), "Sale did not add item correctly.");
  }



}