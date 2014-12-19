import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyMainClassAltTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	


	@Test
	public void test0160() {
		MyMainClassAlt myClass = new MyMainClassAlt("1", "1", "-1");
		assertEquals("Third side must be greater than 0", myClass.processSides());
	}
	
	@Test
	public void test0161(){
		MyMainClassAlt myClass = new MyMainClassAlt("2", "2", "2");
		assertEquals("Equilateral triangle", myClass.processSides());
	}
	
	@Test
	public void test0162(){
		MyMainClassAlt myClass = new MyMainClassAlt("10", "1", "2");
		assertEquals("Invalid triangle", myClass.processSides());
	}
	
	@Test
	public void test0163(){
		MyMainClassAlt myClass = new MyMainClassAlt("4", "6", "0");
		assertEquals("Third side must be greater than 0", myClass.processSides());
	}
	
	@Test
	public void test0164(){
		MyMainClassAlt myClass = new MyMainClassAlt("22", "", "33");
		assertEquals("Second side is empty", myClass.processSides());
	}
	@Test
	public void test0165(){
		MyMainClassAlt myClass = new MyMainClassAlt("1.0", "1.0", "1.414");
		assertEquals("Isosceles right triangle", myClass.processSides());
	}
	@Test
	public void test0166(){
		MyMainClassAlt myClass = new MyMainClassAlt("1.0", "1.0", "1.0");
		assertEquals("Equilateral triangle", myClass.processSides());
	}
	@Test
	public void test0167(){
		MyMainClassAlt myClass = new MyMainClassAlt("3.0", "4.0", "5.0");
		assertEquals("Scalene right triangle", myClass.processSides());
	}
	@Test
	public void test0168(){
		MyMainClassAlt myClass = new MyMainClassAlt("1.732051", "2.236068", "1.414214");
		assertEquals("Scalene right triangle", myClass.processSides());
	}
	@Test
	public void test0169(){
		MyMainClassAlt myClass = new MyMainClassAlt("1.000005", "1.000020", "1.5");
		assertEquals("Isosceles triangle", myClass.processSides());
	}
	
	@Test
	public void test0170(){
		MyMainClassAlt myClass = new MyMainClassAlt("2.645751", "1.732051", "2.236068");
		assertEquals("Scalene triangle", myClass.processSides());
	}
	
	@Test
	public void test0171(){
		MyMainClassAlt myClass = new MyMainClassAlt("2.43", "3.24", "4.05");
		assertEquals("Scalene right triangle", myClass.processSides());
	}
	
	@Test
	public void test0172(){
		MyMainClassAlt myClass = new MyMainClassAlt("2", "2", "2.828427");
		assertEquals("Isosceles right triangle", myClass.processSides());
	}
	
	@Test
	public void test0173(){
		MyMainClassAlt myClass = new MyMainClassAlt("3", "4", "8");
		assertEquals("Invalid triangle", myClass.processSides());
	}
	
	@Test
	public void test0174(){
		MyMainClassAlt myClass = new MyMainClassAlt("1", "1", "2");
		assertEquals("Invalid triangle", myClass.processSides());
	}
	
	@Test
	public void test0175(){
		MyMainClassAlt myClass = new MyMainClassAlt("1234567890", "1234567890", "1745942654");
		assertEquals("Isosceles right triangle", myClass.processSides());
	}
	
	@Test
	public void test0176(){
		MyMainClassAlt myClass = new MyMainClassAlt("1", "1", "1.99");
		assertEquals("Isosceles triangle", myClass.processSides());
	}
	
	@Test
	public void test0177(){
		MyMainClassAlt myClass = new MyMainClassAlt("", "1", "12");
		assertEquals("First side is empty", myClass.processSides());
	}

	@Test
	public void test0178(){
		MyMainClassAlt myClass = new MyMainClassAlt("12", "4", "");
		assertEquals("Third side is empty", myClass.processSides());
	}
	
	@Test
	public void test0179(){
		MyMainClassAlt myClass = new MyMainClassAlt("12d", "4", "3");
		assertEquals("First side contains non-numeric characters", myClass.processSides());
	}
	@Test
	public void test0180(){
		MyMainClassAlt myClass = new MyMainClassAlt("12", "4%", "3");
		assertEquals("Second side contains non-numeric characters", myClass.processSides());
	}
	@Test
	public void test0181(){
		MyMainClassAlt myClass = new MyMainClassAlt("12", "4", "3 ");
		assertEquals("Third side contains non-numeric characters", myClass.processSides());
	}
	@Test
	public void test0182(){
		MyMainClassAlt myClass = new MyMainClassAlt("-134", "423", "342");
		assertEquals("First side must be greater than 0", myClass.processSides());
	}
	
	@Test
	public void test0183(){
		MyMainClassAlt myClass = new MyMainClassAlt("123", "0", "342");
		assertEquals("Second side must be greater than 0", myClass.processSides());
	}
	
	@Test
	public void test0184(){
		String[] args = {"123", "0"};
		MyMainClassAlt.main(args);
		assertEquals("Third side is empty\n", outContent.toString());
	}
	@Test
	public void test0185(){
		String[] args = {"123"};
		MyMainClassAlt.main(args);
		assertEquals("Second side is empty\n", outContent.toString());
	}
	@Test
	public void test0186(){
		String[] args = {};
		MyMainClassAlt.main(args);
		assertEquals("First side is empty\n", outContent.toString());
	}
	@Test
	public void test0187(){
		String[] args = {"6.0","8.00","10.00"};
		MyMainClassAlt.main(args);
		assertEquals("Scalene right triangle\n", outContent.toString());
	}
	
	

}
