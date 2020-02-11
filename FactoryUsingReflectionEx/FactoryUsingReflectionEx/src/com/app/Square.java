package com.app;

public class Square implements IShape {

	public Square() {
		System.out.println("Square object is created..");
	}

	public void showInfo() {
		System.out.println("This is Square Shape ");
	}

	@Override
	public void shapeMsg() {
		IShape.super.shapeMsg();
		System.out.println("Also Square message Printed..");
	}
	
}
