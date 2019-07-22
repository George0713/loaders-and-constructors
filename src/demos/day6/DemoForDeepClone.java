package demos.day6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DemoForDeepClone {

	public static void main(String[] args) {
		
		Person pO = new Person();
		Person pC = (Person)deepCopy(pO);
		
		System.out.println(pO.address[0].city);
		System.out.println(pC.address[0].city);
		pC.address[0].city = "City3";
		System.out.println(pO.address[0].city);
		System.out.println(pC.address[0].city);

	}
    
	public static Object deepCopy(Object from) {
        Object obj = null;
        
        try {
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(from);
            out.flush();
            out.close();
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
            
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        
        return obj;
    }

}

class Person implements Serializable{

	static final long serialVersionUID = 1;
	
	String name = "Me";
	Address[] address= {new Address(1, 2, "Street1", "City1", "WA"),new Address(2, 3, "Street2", "City2", "IL")};
	double[] phoneNumbers = {253d,137d};
	
	

}

class Address implements Serializable{
	
	static final long serialVersionUID = 1;
	
	int hNo;
	String street, city, state;
	int pincode;
	
	public Address(int hNo,int pincode,String street,String city,String state) {
		this.hNo = hNo;
		this.pincode = pincode;
		this.street = street;
		this.city = city;
		this.state = state;
	}
}



