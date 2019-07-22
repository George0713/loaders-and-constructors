package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Q5SpeedRacing {
	public static void main(String[] args) {
		
		HashMap<String, Q5Car> map = new HashMap<String, Q5Car>();
		LinkedHashSet<String> printSet = new LinkedHashSet<String>();
		
		Scanner sc = new Scanner(System.in);
		int numCar = sc.nextInt();
		
		for(int i=0;i<numCar;i++) {
			String model = sc.next();
			System.out.println(model);
			double fuelAmount = sc.nextDouble();
			System.out.println(fuelAmount);
			double cost = sc.nextDouble();
			System.out.println(cost);
			Q5Car car = new Q5Car(model, fuelAmount, cost);
			map.put(model, car);
			System.out.println(i);
			printSet.add(model);
		}
		
		
//		2
//		AudiA4 23 0.3	
//		BMW-M2 45 0.42
//		Drive BMW-M2 56
//		Drive AudiA4 5
//		Drive AudiA4 13
//		End
		
		sc.nextLine();
		while(sc.hasNextLine())
		{
			
			String line = sc.nextLine();
			
			if(line.equals("End")) break;
			
			String[] input = line.split(" ");
			System.out.println(line+" "+Arrays.toString(input));
			String model = input[1];
			Double dist = Double.valueOf(input[2]);
			Q5Car runningCar = map.get(model);
			
			if(runningCar.fuelAmount < dist*runningCar.cost) {
				System.out.println("Insufficient fuel for the drive");
			}
			else {
				runningCar.fuelAmount -= dist*runningCar.cost;
				runningCar.traveled += dist;
			}
			
			printSet.add(model);
			
		}
		
		for (String model:printSet) {
			System.out.println(map.get(model));
		}
		
		
	}
}

class Q5Car{
	String model;
	double fuelAmount;
	double cost;
	double traveled=0;
	
	Q5Car(String model,double fuelAmount,double cost)
	{
		this.model = model;
		this.fuelAmount = fuelAmount;
		this.cost = cost;
	}
	
	@Override
	public String toString()
	{
		return (model + " " +fuelAmount+" "+(int)traveled);
	}
}
