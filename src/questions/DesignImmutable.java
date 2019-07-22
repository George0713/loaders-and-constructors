package questions;

public class DesignImmutable {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int r = arr[3];
		r = 5;
		System.out.println(r + " " + arr[3]);
	}
}

final class Student implements Cloneable{
	final private int id;// id=5; id=6;
	final private String name;
	final private int[] arr = { 1, 2, 3 };// arr= new int[3]; cannot make it point to another object
	// arr[1]=35; It is allowed

	protected Student clone()
	{
		return this;
	}
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public final int getId() {
		return id;
	}

	public final String getName() {
		return name;
	}

	public final int getArrElement(int i) {
		return arr[i];
	}
}