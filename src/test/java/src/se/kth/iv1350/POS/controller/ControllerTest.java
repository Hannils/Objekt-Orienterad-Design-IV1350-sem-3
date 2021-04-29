package src.se.kth.iv1350.POS.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.integration.DCHandler;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;
import src.se.kth.iv1350.POS.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
  private Controller instanceToTest;
  private EASHandler eas;
  private EISHandler eis;
  private DCHandler dc;
  private Printer printer;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
	this.eas = eas;
	this.eis = eis;
	this.dc = dc;
	instanceToTest = new Controller(eis, eas, dc, printer);
  }

  @AfterEach
  public void tearDown() {
	instanceToTest = null;
	printoutBuffer = null;
	System.setOut(originalSysOut);
  }
  @Test
  public void testControllerHasStarted() {
    String printOut = this.printoutBuffer.toString();
    String expectedOutput = "successfully";
	assertTrue(printOut.contains(expectedOutput), "Controller did not start correctly.");
  }

  @Test
  public void testStartSaleHasStarted() {
    instanceToTest.startSale();
	String printOut = this.printoutBuffer.toString();
	String expectedOutput = "started";
	assertTrue(printOut.contains(expectedOutput), "Sale did not start correctly.");
  }
}