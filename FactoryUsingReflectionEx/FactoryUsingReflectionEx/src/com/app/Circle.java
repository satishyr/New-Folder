package com.app;

public class Circle implements IShape {

	public Circle() {
		System.out.println("circle is created..");
	}
	
	public void showInfo() {
		System.out.println("This is a circle Object");
	}

	
	@Override
	public void shapeMsg() {
		System.out.println("Message from circle");
	}
}



