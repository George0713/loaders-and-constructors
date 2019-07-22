package questions;

public class A2P3WildFarm {
	
	public static void main(String[] args) {
		
	}

}

abstract class Food{
	Integer quantity;
}
abstract class Animal{
	String animalName;
	String animalType;
	double animalWeight;
	Integer foodEaten;
	
	void makeSound() {};
	void eatFood() {};
}
abstract class Mammal{
	String livingRegion;
}

class Vegetable extends Food{
	
}
class Meat extends Food{
	
}