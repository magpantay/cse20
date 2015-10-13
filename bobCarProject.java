package bobcarPackage1;

import java.util.Scanner;

public class Bobcar_Project1 {

    public static void main(String[] args) {
        int carClass;
        double dailyRate;
        String carLabel;
        int rentalDiscount = 0;
        double dailyRateMultiplier = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please press 1 for Economy, 2 for Compact, or 3 for Standard: ");
        carClass = scan.nextInt();
        
        if (carClass > 3 || carClass < 0) {
            System.out.println("That is not a valid choice. This program will now terminate.");
            System.exit(1);
        }
        
        System.out.print("Please enter the number of days you will rent the car: ");
        int rentalDays = scan.nextInt();
        
        System.out.print("Are you a club member? Please press 1 for yes or 0 for no: ");
        int isClubMember = scan.nextInt();
        
        if (isClubMember > 1 || isClubMember < 0) {
            System.out.println("That is not a valid choice. This program will now terminate.");
            System.exit(1);
        }
        
        System.out.print("Would you like our Platinum Executive Package? Please press 1 for yes or 0 for no: ");
        int wantsExecutive = scan.nextInt();
        
        if (wantsExecutive > 1 || wantsExecutive < 0) {
            System.out.println("That is not a valid choice. This program will now terminate.");
            System.exit(1);
        }
        
        if (carClass == 1) {
            dailyRate = 25.0;
            carLabel = "economy";
        } 
        else if (carClass == 2) {
            dailyRate = 55.0;
            carLabel = "compact";
        } 
        else {
            dailyRate = 100.0;
            carLabel = "standard";
        }
        
        if (isClubMember != 0) 
            rentalDiscount = rentalDays / 5;
        
        if (wantsExecutive != 0) 
          dailyRateMultiplier = dailyRate * 0.2;
        
        double basePrice = dailyRate * rentalDays;
        double memberDiscount = rentalDiscount * dailyRate;
        double executiveCharge = dailyRateMultiplier * rentalDays;
        double totalPrice = (basePrice - memberDiscount) + executiveCharge;
       
        System.out.println("");
        System.out.println(String.valueOf(rentalDays) + " day(s) for a(n) " + carLabel + " car at $" + dailyRate + " per day: $" + basePrice);
        System.out.println("Your club member discount: -$" + memberDiscount);
        System.out.println("The executive package charge: +$" + executiveCharge);
        System.out.println("Your grand total is: $" + totalPrice);
    }
}
