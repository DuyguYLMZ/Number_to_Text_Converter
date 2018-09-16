package Converter;
/**
 * @author Duygu YILMAZ
 */

import java.util.Arrays;
import java.util.List;

public class Numbers {
	static String num[] = { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "0" };
	static String dec[] = { " ", " ", "20", "30", "40", "50", "60", "70", "80", "90" };
	static String ones[] = { " ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"zero" };
	static String tens[] = { " ", " ", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	static List<String> onesList = Arrays.asList(ones);
	static List<String> tensList = Arrays.asList(tens);
}
