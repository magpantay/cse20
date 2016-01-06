package project2Package;

import java.util.Scanner;

public class Project2Trials {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the sample size: ");
		int sampleSize = in.nextInt();
		checkIntInput(sampleSize);

		int trialAmount = 4;
		int[] dataT0 = new int[sampleSize];
		int[] dataT1 = new int[sampleSize];
		int[] dataT2 = new int[sampleSize];
		int[] dataT3 = new int[sampleSize];

		for(int i = 0; i < trialAmount; i++){
			System.out.println("Enter numbers for Trial " + i);
			for (int j = 0; j < sampleSize; j++){
				System.out.print("Enter sample #" + j + ": ");
				if (i == 0){
					dataT0[j] = in.nextInt();
				}
				else if (i == 1){
					dataT1[j] = in.nextInt();
				}
				else if (i == 2){
					dataT2[j] = in.nextInt();
				}
				else{
					dataT3[j] = in.nextInt();
				}
			}
		}

		printList(sampleSize, dataT0, dataT1, dataT2, dataT3);

		int sum[] = findSum(trialAmount, sampleSize, dataT0, dataT1, dataT2, dataT3);
		int averages[] = findAverages(trialAmount, sum, sampleSize);

		extremes(averages);

		in.close();
	}

	public static void checkIntInput(int nextInt){
		if (nextInt <= 0){
			System.out.println("There's no need for this then!");
			System.exit(1);
		}
	}

	public static void printList(int sampleSize, int[] dataT0, int[] dataT1, int[] dataT2, int[] dataT3){
		System.out.println("Sample # \t Trial 1 \t Trial 2 \t Trial 3 \t Trial 4");
		for (int i = 0; i < sampleSize; i++){
			System.out.print(i + "\t");
			System.out.print("\t" + dataT0[i] + "\t");
			System.out.print("\t" + dataT1[i] + "\t");
			System.out.print("\t" + dataT2[i] + "\t");
			System.out.print("\t" + dataT3[i] + "\t");
			System.out.println("");
		}

		System.out.println("--------------------------------------------------------------------------------------------");
	}

	public static int[] findSum(int trialAmount, int sampleSize, int[] dataT0, int[] dataT1, int[] dataT2, int[] dataT3){
		int[] sum = new int [trialAmount];
		for (int i = 0; i < sampleSize; i++){
			sum[0] += dataT0[i];
			sum[1] += dataT1[i];
			sum[2] += dataT2[i];
			sum[3] += dataT3[i];
		}
		return sum;
	}

	public static int[] findAverages(int trialAmount, int[] sum, int sampleSize){
		int[] averages = new int[trialAmount];
		averages[0] = (sum[0] / sampleSize);
		averages[1] = (sum[1] / sampleSize);
		averages[2] = (sum[2] / sampleSize);
		averages[3] = (sum[3] / sampleSize);
		return averages;
	}

	public static void extremes(int[] averages){
		int minimum = averages[0];
		int maximum = averages[0];
		System.out.print("Averages:");
		for (int i = 0; i < averages.length; i++){
			System.out.print("\t" + averages[i] + "\t");
			if (averages[i] < minimum){
				minimum = averages[i];
			}
			if (averages[i] > maximum){
				maximum = averages[i];
			}
		}
		concur(minimum, maximum);
	}

	public static void concur(int minimum, int maximum){
		System.out.println("\n\nMinimum average: " + minimum);
		System.out.println("Maximum average: " + maximum);

		if (minimum == maximum){
			System.out.println("\nThe trials match EXACTLY!");
		}
		else if (maximum < (minimum * 2)){
			System.out.println("\nThe trials concur with each other!");	
		}
		else{
			System.out.println("\nThe trials DO NOT concur with each other!");
		}
	}
}
