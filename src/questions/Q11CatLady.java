package questions;

import java.util.HashMap;
import java.util.Scanner;

public class Q11CatLady {
	
	//Test Suite
	//StreetExtraordinaire Maca 85
	//Siamese Sim 4
	//Cymric Tom 28
	//End
	//Tom

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<String, Cat> catMap = new HashMap<String, Cat>();
		
		while (sc.hasNext()) {

			String inputString = sc.next();
			System.out.println(inputString);
		}

		while (sc.hasNext()) {

			String inputString = sc.next();

			
			if (inputString.equals("End")) {
				System.out.println("Record done!");
				break;
			}
			
			String catName = sc.next();
			double feature = Double.valueOf(sc.next());

			switch (inputString) {
			case "Siamese": {
				Cat newCat = new Siamese(catName, feature);
				catMap.put(catName, newCat);
				break;
			}
			case "Cymric": {
				Cat newCat = new Cymric(catName, feature);
				catMap.put(catName, newCat);
				break;
			}
			case "StreetExtraordinaire": {
				Cat newCat = new StreetExtraordinaire(catName, feature);
				catMap.put(catName, newCat);
				break;
			}

			default:
				System.out.println("Wrong Type!");
				break;
			}

		}
		
		System.out.println("Input your cat's name:");
		System.out.println(catMap.get(sc.next()));

	}

}

class Cat {
	String name;

	Cat(String name) {
		this.name = name;
	}
}

class Siamese extends Cat {

	double earsize;

	public Siamese(String name, double earsize) {
		super(name);
		this.earsize = earsize;
	}

	@Override
	public String toString() {
		return "Siamese " + name + " " + earsize;
	}

}

class Cymric extends Cat {

	double furLength;

	public Cymric(String name, double furLength) {
		super(name);
		this.furLength = furLength;
	}

	public String toString() {
		return "Cymric " + name + " " + furLength;
	}

}

class StreetExtraordinaire extends Cat {

	double decibelsOfMeows;

	public StreetExtraordinaire(String name, double decibelsOfMeows) {
		super(name);
		this.decibelsOfMeows = decibelsOfMeows;
	}

	public String toString() {
		return "StreetExtraordinaire " + name + " " + decibelsOfMeows;
	}

}