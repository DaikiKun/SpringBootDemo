package object.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialize {

	public static void main(String[] args) {
		Employee emp=new Employee("oak"	,1,400000);
		try(ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("emp.obj"))){
			output.writeObject(emp);
			System.out.println("Successfully saved...");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
