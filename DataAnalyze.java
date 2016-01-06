package project2Package;

import java.util.Scanner;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the sample size: ");
		int sampleSize = in.nextInt();

		int[] numInputData = new int[(sampleSize * 4)];
		int[] dataT0 = new int[sampleSize];
		int[] dataT1 = new int[sampleSize];
		int[] dataT2 = new int[sampleSize];
		int[] dataT3 = new int[sampleSize];
		int trialAmount = 4;
		int[] averagesSum = new int[trialAmount];
		int[] averages = new int[trialAmount];
		int minimum = 0;
		int maximum = 0;

		for(int i = 0; i < trialAmount; i++){
			System.out.println("Enter numbers for Trial " + i);
			for (int j = 0; j < sampleSize; j++){
				System.out.print("Enter sample #" + j + ": ");
				if(i == 0){
					dataT0[j] = in.nextInt();
				}
				else if(i == 1){
					dataT1[j] = in.nextInt();
				}
				else if(i == 2){
					dataT2[j] = in.nextInt();
				}
				else{
					dataT3[j] = in.nextInt();
				}
			}
		}

		System.out.println("Sample # \t Trial 1 \t Trial 2 \t Trial3 \t Trial 4");
		for(int i = 0; i < sampleSize; i++){
			System.out.print(i + "\t");
			for(int j = 0; j < 4; j++){
				System.out.print("\t" + numInputData[j] + "\t");
				if(j % 3 == 0 && j != 0){
					System.out.println("");
				}
			}
		}

		System.out.println("--------------------------------------------------------------------------------------------");

		int count = 0;

		for(int i = 0, index = 0; count < sampleSize; i++){
			if (index == 0){
				averagesSum[index] += numInputData[i];
				index++;
			}
			else if(index == 1){
				averagesSum[index] += numInputData[i];
				index++;
			}
			else if(index == 2){
				averagesSum[index] += numInputData[i];
				index++;
			}
			else{
				averagesSum[index] += numInputData[i];
				index = 0;
				count++;
			}
		}

		for (int index = 0; index < averages.length; index++){
			averages[index] = (averagesSum[index] / sampleSize);
		}

		maximum = averages[0];
		minimum = averages[0];

		System.out.print("\t");

		for(int i = 0; i < averages.length; i++){
			System.out.print("\t" + averages[i] + "\t");
			if (averages[i] < minimum){
				minimum = averages[i];
			}
			if (averages[i] > maximum){
				maximum = averages[i];
			}
			if(i % 3 == 0 && i != 0){
				System.out.println("");
			}
		}

		System.out.println("Maximum average: " + maximum);
		System.out.println("Minimum average: " + minimum);
		if(minimum == maximum){
			System.out.println("The trials match EXACTLY!");
		}
		else if(maximum < (minimum * 2)){
			System.out.println("The trials concur with each other!");	
		}
		else{
			System.out.println("The trials DO NOT concur with each other!");
		}
		in.close();
	}

}
