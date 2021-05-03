package src.se.kth.iv1350.POS.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;
import src.se.kth.iv1350.POS.model.Sale;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
  private Controller instanceToTest;
  private EASHandler eas;
  private EISHandler eis;
  private Printer printer;
  private String identifier;
  private int amount;
  private String currency;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
	eas = new EASHandler();
	eis = new EISHandler();
	printer = new Printer();
	instanceToTest = new Controller(eis, eas, printer);
	instanceToTest.startSale();
  }

  @AfterEach
  public void tearDown() {
	instanceToTest = null;
	printoutBuffer = null;
	System.setOut(originalSysOut);
	eas = null;
	eis = null;
	printer = null;
  }
  @Test
  public void testControllerHasStarted() {
    String printOut = this.printoutBuffer.toString();
    String expectedOutput = "successfully";
	assertTrue(printOut.contains(expectedOutput), "Controller did not start correctly.");
  }

  @Test
  public void testStartSaleHasStarted() {
	String printOut = this.printoutBuffer.toString();
	String expectedOutput = "started";
	assertTrue(printOut.contains(expectedOutput), "Sale did not start correctly.");
  }

  @Test
  public void testEnterItemHasEnteredItem(){
      SaleInfoDTO saleInformation = instanceToTest.enterItem("first");
      String printOut = eis.findItem("first").getName();
      String expectedOutput = "Uncle Ben's 1 minute rice";
      assertTrue(printOut.contains(expectedOutput), "Item did not enter correctly.");
  }

  @Test
  public void testIfPaymentHasGoneThrough() {
      PaymentDTO paymentDTO = instanceToTest.pay(amount, currency);
      String printOut = paymentDTO.toString();
      String expectedOutput = amount + " " + currency;
      assertTrue(printOut.contains(expectedOutput), "Payment did not go through.");
  }

  @Test
  public void testIfChangeIsCalculatedCorrectly() {
     SaleInfoDTO saleInformation = instanceToTest.enterItem("first");
     double change = 100 - saleInformation.getRunningTotal();
     double expectedOutput = 81.25;
     assertEquals(expectedOutput, change, "Change was not calculated correctly.");
  }
}