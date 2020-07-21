package object.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialize {

	public static void main(String[] args) {
		
		try(ObjectInputStream input=new ObjectInputStream(new FileInputStream("emp.obj"))){
			Employee obj=(Employee)input.readObject();
			System.out.println("Salary: "+obj.getSalary());
			System.out.println("Name: "+obj.getName());
			System.out.println("Experience: "+obj.getExperience());
		}catch(Exception e) {
			e.printStackTrace();
			}
		}

}
