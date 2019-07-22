package demos.day6;



public class DemoForClone {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		D6testclass.tryClone();
	}


}


class Employee implements Cloneable{
	
	String name;
	
	Employee(String name){
		this.name = name;
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException {
		
		return (Employee)super.clone();
		
	}
	
}

class D6testclass{
	
	public static void tryClone() throws CloneNotSupportedException{
		
		Employee e = new Employee("Qiaozhi");
		Employee e_ = e.clone();
		
		System.out.println(e.name);
		System.out.println(e_.name);
	}
	
}