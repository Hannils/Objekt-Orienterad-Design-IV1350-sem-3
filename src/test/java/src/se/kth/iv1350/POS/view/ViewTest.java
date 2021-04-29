package src.se.kth.iv1350.POS.view;

import org.junit.jupiter.api.*;
import src.se.kth.iv1350.POS.controller.Controller;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
  private View instanceToTest;
  private EASHandler eas;
  private EISHandler eis;
  private Printer printer;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;


  @BeforeEach
  public void setUp() {
    eis = new EISHandler();
    eas = new EASHandler();
    printer = new Printer();
	Controller contr = new Controller(eis, eas, printer);
	instanceToTest = new View(contr);


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
  public void testRunFakeExecution() {
	instanceToTest.runFakeExecution();
	String printout = printoutBuffer.toString();
	String expectedOutput = "started";
	assertTrue(printout.contains(expectedOutput), "UI did not start correctly.");

  }

}