package test;
/**
 * @author Duygu YILMAZ
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Converter.Converter;

public class ConverttoTextTest {
	@Test
	public void euroTest() {
		String result = Converter.convertNumtoText("74 euros");
		result = result.replaceAll("\\s+","");
		assertEquals("seventyfour",result);
	}
	
	@Test
	public void dollarTest() {
		String result = Converter.convertNumtoText("74 dollars");
		result = result.replaceAll("\\s+","");
		assertEquals("seventyfour",result);
	}
	
	@Test
	public void numTest() {
		String result = Converter.convertNumtoText("20072");
		result = result.replaceAll("\\s+","");
		assertEquals("twentythousandseventytwo",result);
	}
	
	@Test
	public void currTest() {
		String result = Converter.convertNumtoText("61 \\$");
		result = result.replaceAll("\\s+","");
		assertEquals("sixtyone",result);
	}
	

}
