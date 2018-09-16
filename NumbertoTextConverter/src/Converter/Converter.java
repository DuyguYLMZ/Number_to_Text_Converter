package Converter;
/**
 * @author Duygu YILMAZ
 */

import java.util.Scanner;

public class Converter {

	String result;

	public static void main(String[] args) {
		System.out.print("----CONVERTER------");
		String choice = "";
		Scanner scanner = new Scanner(System.in);

		// Menu
		while (choice != null && !choice.equals("3")) {
			System.out.print("\n1. Number to Text\n2. Text to Number\n3. Exit\nchoice:  ");
			choice = scanner.nextLine();
			scanner = new Scanner(System.in);
			
			switch (choice) {
			case "1":
				System.out.print("Amount in numbers (eg: 745 \\$) : ");
				String number = scanner.nextLine();
				convertNumtoText(number);
				break;
			case "2":
				System.out.print("Amount in words (eg: twenty dollars) :  ");
				String text = scanner.nextLine();
				convertTexttoNumber(text);
				break;
			}
		}

		// Exit
		if (choice != null && choice.equals("3")) {
			System.out.print("\nBye bye! :) ");
		}
	}

	public static String convertNumtoText(String input) {
		TextConverter numCon = new TextConverter();
		String amount = numCon.converttoText(input);
		if (amount == null || amount.equals("")) {
			System.out.println(" Please type amount correctly (eg: 20 \\$)");
		} else {
			System.out.println(" (amount in words)");
		}
		return amount;
	}

	public static String convertTexttoNumber(String text) {
		NumberConverter numCon = new NumberConverter();
		String amount = numCon.converttoNumber(text);
		if (amount == null || amount.equals("")) {
			System.out.println(" Please type amount correct correctly (eg: twenty dollars)");
		} else {
			System.out.println(" " + amount + "(amount in numbers)");
		}

		return amount;
	}

}