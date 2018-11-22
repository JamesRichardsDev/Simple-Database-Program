package manageCountries;

import java.util.ArrayList;

public class CountryApp {

	public static void main(String[] args) throws Exception {
		CountryDB DB = new CountryDB();

		boolean shouldContinue = true;
		ArrayList<String> array = new ArrayList<>();
		int decision = 0;
		while (shouldContinue) {
			Console.displayMenu();
			decision = Console.displayMessage("\nEnter menu number: ");
			if (decision == 1) {
				array = DB.getCountries();

				for (String s : array) {
					System.out.println(s);
				}
				System.out.println();
			} else if (decision == 2) {
				String countryToAdd = Console.getCountry("\nEnter country: ");
				

				DB.addCountry(countryToAdd);

			} else if (decision == 3) {
				String countryToAdd = Console.getCountry("\nEnter country to delete: ");
				DB.deleteCountry(countryToAdd);
				System.out.println();

			} else if (decision == 4) {
				shouldContinue = false;

			} else
				System.out.println("That is not a valid input");

		}
		System.out.println("\nGoodbye!");
	}

}
