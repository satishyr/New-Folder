package com.app;

public interface IShape {

	//must be overridden
	public void showInfo();
	//can be overridden
	public default void shapeMsg() {
		System.out.println("Welcome to ShapeFactory");
	}
	//can not be overridden
	public static void commonMsg() {
		System.out.println("Hello Shape..");
	}
	
}
