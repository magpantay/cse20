package project2Package;

import java.util.Scanner;

public class Project2Trials {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the sample size: ");
		int sampleSize = in.nextInt();
		checkIntInput(sampleSize);

		int trialAmount = 4;
		int[][] data = new int[trialAmount][sampleSize]; //creates an array (length 4) of arrays (of length sampleSize)

		for(int i = 0; i < trialAmount; i++){
			System.out.println("Enter numbers for Trial " + i);
			for (int j = 0; j < sampleSize; j++){
				System.out.print("Enter sample #" + j + ": ");
				data[i][j] = in.nextInt();
			}
		}

		printList(sampleSize, data);

		int sum[] = findSum(trialAmount, sampleSize, data);
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

	public static void printList(int sampleSize, int[][]data){
		System.out.println("Sample # \t Trial 1 \t Trial 2 \t Trial 3 \t Trial 4");
		for (int i = 0; i < sampleSize; i++){
			System.out.print(i + "\t");
			System.out.print("\t" + data[0][i] + "\t");
			System.out.print("\t" + data[1][i] + "\t");
			System.out.print("\t" + data[2][i] + "\t");
			System.out.print("\t" + data[3][i] + "\t");
			System.out.println("");
		}

		System.out.println("--------------------------------------------------------------------------------------------");
	}

	public static int[] findSum(int trialAmount, int sampleSize, int[][] data){
		int[] sum = new int [trialAmount];
		for (int i = 0; i < sampleSize; i++){
			sum[0] += data[0][i];
			sum[1] += data[1][i];
			sum[2] += data[2][i];
			sum[3] += data[3][i];
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
