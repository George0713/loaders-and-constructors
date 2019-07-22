package questions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import questions.Q5SpeedRacing;;


public class A2Q1Vehicles {
	
public static void main(String[] args) {
		
		HashMap<String, Q5Car> map = new HashMap<String, Q5Car>();
		LinkedHashSet<String> printSet = new LinkedHashSet<String>();
		
		Scanner sc = new Scanner(System.in);
		int num=0;
		
		while(sc.hasNext()) {
			String model = sc.next();
			if(Pattern.matches("[0-9]+", model))
				num = Integer.valueOf(model);
			System.out.println(model);
			double fuelAmount = sc.nextDouble();
			System.out.println(fuelAmount);
			double cost = sc.nextDouble();
			System.out.println(cost);
			Q5Car car = new Q5Car(model, fuelAmount, cost);
			map.put(model, car);
			printSet.add(model);
		}
		
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			
			String line = sc.nextLine();
			
			String[] input = line.split(" ");
			System.out.println(line+" "+Arrays.toString(input));
			String oper = input[0];
			String model = input[1];
			Double third = Double.valueOf(input[2]);
			Q5Car runningCar = map.get(model);
			switch (oper) {
			case "Drive":
				if(runningCar.fuelAmount < third*runningCar.cost) {
					System.out.println("Insufficient fuel for the drive of " + model);
				}
				else {
					runningCar.fuelAmount -= third*runningCar.cost;
					runningCar.traveled += third;
					System.out.println(model+" travelled "+third+" km ");
				}
			
				break;
				
			case "Refuel":
				runningCar.fuelAmount += third;

			default:
				break;
			}

			printSet.add(model);
			
		}
		
		for (String model:printSet) {
			System.out.println(map.get(model).model+": "+map.get(model).fuelAmount);
		}
		
		
	}
}
