package bobcarPackage1;

import java.util.Scanner;

public class Bobcar_Project1 {

	public static void main(String[] args) {

		int carClass = 0; //The integer data for choice of car
		double dailyRate = 0; //The daily rate of the rental car
		String carLabel = null; //The label on whether the car is economy, compact, or standard
		int rentalDays = 0; //The amount of days that the person will rent the car for
		int isClubMember = 0; //The integer data for whether the person is a club member or not
		double basePrice = 0; //The price before any discounts and/or additional charges

		Scanner scan = new Scanner (System.in);

		System.out.print("Please press 1 for Economy, 2 for Compact, or 3 for Standard: ");
		carClass = scan.nextInt();

		if (carClass > 3 || carClass < 0){
			System.out.println("That is not a valid choice. This program will now terminate.");
			System.exit(1); //Terminates the program in an error state.
		}

		else if (carClass == 1){
			dailyRate = 25;
			carLabel = "economy";
		}
		
		else if (carClass == 2){
			dailyRate = 55;
			carLabel = "compact";
		}
		
		else {
			dailyRate = 100;
			carLabel = "standard";
		}

		System.out.print("Please enter the number of days you will rent the car: ");
		rentalDays = scan.nextInt();

		System.out.print("Are you a club member? Please press 1 for yes or 0 for no: ");
		isClubMember = scan.nextInt(); //Terminates the program in an error state.

		if (isClubMember > 1 || isClubMember < 0){
			System.out.println("That is not a valid choice. This program will now terminate.");
			System.exit(1); //Terminates the program in an error state.
		}

		else if (isClubMember == 1){
			int wantsExecutive = 0; //The integer data for whether the person wants the executive package or not
			int rentalDiscount = (rentalDays / 5); //For the Club Member Discount
			double dailyRateMultiplier = 0; //For the Executive Package Charge

			System.out.print("Would you like our Platinum Executive Package? Please press 1 for yes or 0 for no: ");
			wantsExecutive = scan.nextInt(); 

			if (wantsExecutive > 1 || wantsExecutive < 0){
				System.out.println("That is not a valid choice. This program will now terminate.");
				System.exit(1); //Terminates the program in an error state.
			}

			if (wantsExecutive != 0)
				dailyRateMultiplier = (dailyRate * 0.2);
			
			basePrice = (dailyRate * rentalDays);
			double memberDiscount = (rentalDiscount * dailyRate); //The amount discounted for being a club member
			double executiveCharge = dailyRateMultiplier * rentalDays;  //The amount charged for wanting the executive package
			double totalPrice = (basePrice - memberDiscount) + executiveCharge; //The price after everything

			System.out.println(""); //Creates a gap in between the prompts and answers
			System.out.println(rentalDays + " day(s) for a(n) " + carLabel + " car at $" + (int)(dailyRate) + " per day: $" + (int)(basePrice));
			System.out.println("Your club member discount: -$" + (int)(memberDiscount));
			
			if (executiveCharge > 0)
				System.out.println("The executive package charge: +$" + (int)(executiveCharge));
			
			System.out.println(""); //Creates a gap in between
			System.out.println("Your total estimate is: $" + (int)(totalPrice));
		}

		else {
			basePrice = (dailyRate * rentalDays);
			
			System.out.println(""); //Creates a gap in between
			System.out.println(rentalDays + " day(s) for a(n) " + carLabel + " car at $" + (int)(dailyRate) + " per day: $" + (int)(basePrice));
			System.out.println(""); //Creates a gap in between
			System.out.println("Your total estimate is: $" + (int)(basePrice));
		}
		scan.close();
	}
}
