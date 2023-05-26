package n1exercici5;

import java.io.*;

public class Customer implements Serializable{

	//ATTRIBUTES
	private String name;
	private String DNI;
	private int age;
	private transient String password;
	
	//CONSTRUCTOR
	public Customer(String name, String dNI, int age) {
		super();
		this.name = name;
		DNI = dNI;
		this.age = age;
	}
	
	//GETTERS & SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", DNI=" + DNI + ", age=" + age + ", password=" + password + "]";
	}
}
