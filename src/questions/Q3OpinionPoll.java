package questions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q3OpinionPoll {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		ArrayList<Q3Person> r = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			
			String name = sc.next();
			int age = sc.nextInt();
			if(age>30) {
				r.add(new Q3Person(name,age));
			}

		}
		
		r.sort(new Q3Comparator());
		for(Q3Person p:r)
		{
			System.out.println(p.name +" - "+p.age);
		}

	}
}

class Q3Person {
	String name;
	int age;
	public Q3Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
}

class Q3Comparator implements Comparator<Q3Person>{

	@Override
	public int compare(Q3Person o1, Q3Person o2) {
		return o1.name.compareTo(o2.name);
		
	}
	
}