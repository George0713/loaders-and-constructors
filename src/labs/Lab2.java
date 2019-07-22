package labs;

import labs.Student.Gender;

public class Lab2 {
	
	public static void main(String[] args) {
		
		Student firstStudent = new Student("Li", "Qiaozhi", Gender.MALE, 27, 63.5);
		System.out.println(firstStudent);
		
	}

}

class Student {

	String lastname;
	String firstname;
	Gender gender;
	int age;
	double weight;

	enum Gender {
		MALE('M'), FEMALE('F');
		char c;

		Gender(char c) {
			this.c = c;
		}

		char getValue() {
			return c;
		}
	}

	Student(String lastname, String firstname, Gender gender, int age, double d) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.age = age;
		this.weight = d;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String r = "Person Details:\n" + "_______________\n" + 
		"First Name: "+ firstname +"\n"+
		"Last Name: " + lastname+"\n" +
		"Gender: "+ gender.getValue()+"\n" +
		"Weight: "+weight;
		
		return r;
	}

}
