package questions;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Q4CompanyRoster {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<String, List<Q4Person>> map = new HashMap<>();
		
		int num = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < num; i++) {
			String[] input = sc.nextLine().split(" ");

			String name = input[0];
			double salary = Double.valueOf(input[1]);
			String position = input[2];
			String department = input[3];
			String email = "n/a";
			int age = -1;
			switch (input.length) {
			case 6:
				email = input[4];
				age = Integer.valueOf(input[5]);
				break;
			case 5:
				if (Pattern.matches("[0-9]*", input[4])) {
					
					age = Integer.valueOf(input[4]);

				}
				else {
					email = input[4];
				}
				break;
			}
			
			Q4Person p = new Q4Person(name,salary,position,department,email,age);
			if (map.containsKey(department)) {
				map.get(department).add(p);
			}else {
				List<Q4Person> t = new ArrayList<Q4Person>();
				t.add(p);
				map.put(department, t);
			}

		}
		
		double maxaver = 0;
		String target = "";
		
		for(String dep:map.keySet())
		{
			double sum = 0;
			for (Q4Person p:map.get(dep)) {
				sum += p.salary;
			}
			target = maxaver>(sum/map.get(dep).size())?target:dep;
			maxaver = Math.max(maxaver, (sum/map.get(dep).size()));		
			
		}
		
		System.out.println("Highest Average Salary");
		System.out.println(target);
		
		map.get(target).sort((p1,p2) -> {if(p1.salary>p2.salary)return -1;
		if (p1.salary<p2.salary) return 1;return 0;});
		
		for (Q4Person p:map.get(target))
		{
			System.out.println(p);
		}
		
		

	}
}

class Q4Person {
	public Q4Person(String name, double salary, String position, 
			String department, String email, int age) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.email = email;
		this.age = age;
	}
	String name;
	double salary;
	String position;
	String department;
	String email;
	int age;
	
	@Override
	public String toString()
	{
		return (name+" "+salary+" "+email+" "+age);
	}
	

}