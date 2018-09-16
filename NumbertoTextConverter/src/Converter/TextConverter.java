package Converter;
/**
 * @author Duygu YILMAZ
 */

import java.util.HashMap;
import java.util.Map;

public class TextConverter {

	private String currencyType = "";
	private String currencyTypeName = "";

	private String[] tens = Numbers.tens;
	private String[] ones = Numbers.ones;

	static Map<String, String> hmap = new HashMap<String, String>();

	public TextConverter() {

	}

	public String converttoText(String input) {
		StringBuilder text = new StringBuilder();
		String amount = split(input);

		int number = 0;
		if (amount != null && !amount.equals("")) {
			number = (int) Long.parseLong(amount);
		}
		if (number < 1000000) {
			if (number > 0) {
				System.out.print(" " + number + ".00 " + currencyType + " (amount in numbers)\n");

				// for bigger than 4 digit numbers
				if (number > 999) {
					int digit = number / 1000;
					if (digit < 100) {
						text.append(thousandsSeperator(digit));
					} else {
						text.append(numberToWord(((digit / 100) % 10), " hundred "));
						text.append(numberToWord((digit % 100), " "));
						text.append("thousand");
						System.out.print("thousand ");
					}
					// last 3 digits
					number = number % 1000;
				}
				text.append(numberToWord(((number / 100) % 10), " hundred "));
				text.append(numberToWord((number % 100), " "));

			}
			if ((amount != null && !amount.equals(""))) {
				System.out.print(currencyTypeName);
				return text.toString();
			}
		}
		return null;
	}

	private String thousandsSeperator(int digit) {
		StringBuilder thousandsDigit = new StringBuilder();

		StringBuilder tenDigit = new StringBuilder();
		if (digit < 20) {
			tenDigit.append(ones[digit]);
			thousandsDigit.append(tenDigit.toString() + " thousand ");
		} else {
			int tensDigit = (digit / 10);
			int unitsDigit = digit % 10;
			if (unitsDigit > 0) {
				thousandsDigit.append(" " + tens[tensDigit] + " " + ones[unitsDigit] + " thousand ");
			} else {
				thousandsDigit.append(" " + tens[tensDigit] + " thousand ");
			}
		}

		System.out.print(thousandsDigit.toString());
		return thousandsDigit.toString();
	}

	private String split(String input) {
		// name and symbol of currency
		FindCurrencyType findCurrencyType = new FindCurrencyType();
		for (Map.Entry<String, String> entry : findCurrencyType.findCurrency(input).entrySet()) {
			currencyType = entry.getKey();
			currencyTypeName = entry.getValue();
		}

		StringBuilder result = new StringBuilder();
		// free from punctuation(/, $)
		String[] tokens = input.split("/|$|\\s+");
		if (tokens != null && tokens.length > 0) {
			for (String t : tokens) {
				if (t.matches("-?\\d+(\\.\\d+)?")) {
					result.append(t);
				}
			}
		}

		return result.toString();
	}

	public String numberToWord(int num, String val) {
		String word = "";
		// Multiples of 10
		if (num > 19) {
			word = tens[num / 10] + " " + ones[num % 10];
		} else {
			word = ones[num];
		}
		System.out.print(word);
		if (num > 0) {
			System.out.print(val);
			return word + val;
		}
		return word;

	}

}
