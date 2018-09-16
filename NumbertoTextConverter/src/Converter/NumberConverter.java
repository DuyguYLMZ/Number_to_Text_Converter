package Converter;
/**
 * @author Duygu YILMAZ
 */

import java.util.List;
import java.util.Map;

public class NumberConverter {

	private String currencyType = "";
	private String amount = "1";
	private FindCurrencyType findCurrencyType = new FindCurrencyType();
	private List<String> tensList = Numbers.tensList;
	private List<String> onesList = Numbers.onesList;

	private String[] tokens;

	public NumberConverter() {
	}

	public String converttoNumber(String text) {
		for (Map.Entry<String, String> entry : findCurrencyType.findCurrency(text).entrySet()) {
			currencyType = entry.getKey();
		}
		tokens = text.split("/|$|\\s+");
		int number = 0;

		// check spelling
		for (String t : tokens) {
			if (tensList.contains(t)) {
				number = number + Integer.parseInt(Numbers.dec[tensList.indexOf(t)]);
			} else if (onesList.contains(t)) {
				number = number + Integer.parseInt(Numbers.num[onesList.indexOf(t)]);
			} else if (t.equalsIgnoreCase("hundred")) {
				if (number > 0) {
					number = number * 100;
				}else {
					number = Integer.parseInt(amount) * 100;
				}
			} else if (t.equalsIgnoreCase("thousand")) {
				if (number > 0) {
					number = number * 1000;
				}else {
					number = Integer.parseInt(amount) * 1000;
				}
			}

			if (number > 0) {
				amount = String.valueOf(number);
				amount += ".00 " + currencyType;
			} else {
				amount = "";
			}
		}
		return amount;
	}

}
