package questions;

public class InmutableClass {

		final int id;
		final String name;
		
		InmutableClass(int id,String name){
			this.id = id;
			this.name = name;
			
		}
		
		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
		
		public static void main(String[] args) {
			InmutableClass st= new InmutableClass(5,"Payal");
			String p1 = st.getName();
			p1 = "ritu";
			System.out.println(st.getName());

		}

	}

