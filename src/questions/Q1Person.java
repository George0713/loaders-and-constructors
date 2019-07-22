package questions;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Q1Person {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, 
	IOException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		
		
		Class person = Person.class;
		Field[] fields = person.getDeclaredFields();
		System.out.println(fields.length);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader=new BufferedReader(isr);
		Class personClass = Person.class;
		
		Constructor emptyCtor = personClass.getDeclaredConstructor();
		Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
		Constructor nameAgeCtor=personClass.getDeclaredConstructor(String.class, int.class);
		
		String name = reader.readLine();
		int age = Integer.parseInt(reader.readLine());
		Person basePerson = (Person) emptyCtor.newInstance();
		Person personWithAge = (Person) ageCtor.newInstance(age);
		Person personFull = (Person) nameAgeCtor.newInstance(name,age);
		
		System.out.printf("%s %s%n", basePerson.getName(),basePerson.getAge());
		System.out.printf("%s %s%n", personWithAge.getName(),personWithAge.getAge());
		System.out.printf("%s %s%n", personFull.getName(), personFull.getAge());
		
		

	}

}

class Person{
	private String name;
	private int age;
	
	{
		name="No name";
	}

	Person(){
		
		age=1;
	}	
	Person(int age){
		this.age = age;		
	}
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}