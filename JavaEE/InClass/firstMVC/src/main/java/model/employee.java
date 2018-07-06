package model;

public class employee {

	private String name;
	
	private address address;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public address getAddress() {
		return address;
	}



	public void setAddress(address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return this.name;
	}
}
