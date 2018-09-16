package test;

/**
 * @author Duygu YILMAZ
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Converter.Converter;

public class ConverttoNumberTest {
	String result;

	@Test
	public void currTest() {
		result = Converter.convertTexttoNumber("seventy four dollars");
		assertEquals("74.00 $", result);
	}

	@Test
	public void wordText() {
		result = Converter.convertTexttoNumber("seven hundred thousand ninety five");
		assertEquals("700095.00 ", result);
	}

	@Test
	public void symbolTest() {
		result = Converter.convertTexttoNumber("nine hundred two $");
		assertEquals("902.00 $", result);
	}
}
