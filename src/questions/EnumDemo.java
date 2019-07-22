package questions;

import questions.APerson.Gender;

public class EnumDemo {
public static void main(String[] args) {
		APerson p= new APerson("Payal", 34, Gender.FEMALE);
		System.out.println(p.gender.getValue());
		System.out.println(p.gender);
}
}

class APerson{
	
	APerson(String name, int age, Gender gender){
		this.name= name;
		this.age= age;
		this.gender= gender;
	}
	String name;
	int age;
	String address;
	Gender gender; //Male: M | Female: F
	
	enum Gender{
		MALE('M'), FEMALE('F');
		char c;
		Gender(char c){
			this.c= c;
		}
		
		char getValue() {
			return c;
		}
	}
}