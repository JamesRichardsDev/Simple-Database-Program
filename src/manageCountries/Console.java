package manageCountries;

import java.util.Scanner;

public class Console {
	static Scanner sc = new Scanner(System.in);

	public static void displayMenu() {
		String menu = "1 - List countries\n" + "2 - Add a country\n" + "3 - Delete\n" + "4 - Exit\n";
		System.out.print(menu);
	}

	public static int displayMessage(String message) {
		int choice;
		while (true) {
			System.out.print(message);
			try {
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
				break;
			} catch (NumberFormatException e) {

			}

		}
		return choice;
	}

	public static String getCountry(String message) {
		System.out.print(message);
		String s = sc.nextLine();
		return s;
	}

}
