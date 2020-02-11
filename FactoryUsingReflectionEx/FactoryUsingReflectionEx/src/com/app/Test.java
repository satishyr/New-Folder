package com.app;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Choose One option");
		System.out.println("1.Circle");
		System.out.println("2.Square");
		System.out.println("3.Triangle");
		int ch=sc.nextInt();
		if(ch>0 && ch<4) {
			IShape shape=ShapeFactory.getShape(ch);
			shape.showInfo();
			shape.shapeMsg();
			IShape.commonMsg();
		}else {
			System.out.println("invalid selection");
		}
		
		
		
	}
}
