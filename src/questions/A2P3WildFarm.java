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
	
	abstract void makeSound();
	abstract void eatFood();
}
abstract class Mammal extends Animal{
	String livingRegion;
}
abstract class Feliformia extends Mammal{
	
}


class Vegetable extends Food{
	
}
class Meat extends Food{
	
}
class Mouse extends Mammal{

	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void eatFood() {
		// TODO Auto-generated method stub
		
	}
	
}
class Zebra extends Mammal{

	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void eatFood() {
		// TODO Auto-generated method stub
		
	}
	
}
class P3Cat extends Feliformia{
	@Override
	void makeSound()
	{
		
	}

	@Override
	void eatFood() {
		// TODO Auto-generated method stub
		
	}
}
class Tiger extends Feliformia{

	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void eatFood() {
		// TODO Auto-generated method stub
		
	}
	
}
