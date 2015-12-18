package Compiler;

public class Identifier {
	 //public int DA = 1000;
	//the beginning of the address space
	 /*
	  * every identifier has an id number and address
	  */
	public String name ,address;
	//int address;
	public Identifier(String name , String address)
	{
		name = name;
		address  = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
