package Converter;
/**
 * @author Duygu YILMAZ
 */

import java.util.HashMap;

import Enum.Currency_Name;
import Enum.Currency_Symbol;

public class FindCurrencyType {
	HashMap<String, String> hmap;
	private String currencyType = "";
	private String currencyTypeName = "";

	public FindCurrencyType() {

	}

	public HashMap<String, String> findCurrency(String input) {
		hmap = new HashMap<String, String>();
		if (input.contains(Currency_Name.DOLLARS.toString()) || input.contains(Currency_Symbol.DOLLARS.toString())) {
			currencyType = Currency_Symbol.DOLLARS.toString();
			currencyTypeName = Currency_Name.DOLLARS.toString();
		} else if (input.contains(Currency_Name.EUROS.toString()) || input.contains(Currency_Symbol.EUROS.toString())) {
			currencyType = Currency_Symbol.EUROS.toString();
			currencyTypeName = Currency_Name.EUROS.toString();
		} else if (input.contains(Currency_Name.TURKISHLIRA.toString())|| input.contains(Currency_Symbol.TURKISHLIRA.toString())) {
			currencyType = Currency_Symbol.TURKISHLIRA.toString();
			currencyTypeName = Currency_Name.TURKISHLIRA.toString();
		}

		hmap.put(currencyType, currencyTypeName);

		return hmap;
	}
}
