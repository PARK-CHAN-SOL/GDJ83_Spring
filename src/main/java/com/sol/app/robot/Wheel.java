package com.sol.app.robot;

public class Wheel {
	
	private int size;
	private String brand;
	private int count;
	
	public Wheel(int size, String brand, int count) {
		this.size = size;
		this.brand = brand;
		this.count = count;
	}
	
	public int getSize() {
		return size;
	}
	public String getBrand() {
		return brand;
	}
	public int getCount() {
		return count;
	}
	
}
