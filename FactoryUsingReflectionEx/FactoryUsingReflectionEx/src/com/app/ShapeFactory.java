package com.app;

public class ShapeFactory {
	
	public static IShape getShape(int ch){
		String cls=choose(ch);
		IShape shpae=null;
		try {
			Object ob=Class.forName(cls).newInstance();
			if(ob instanceof IShape) {
				shpae=(IShape)ob;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return shpae;
	}

	private static String choose(int ch) {
		String cls=null;
		switch (ch) {
		case 1: 
			cls="com.app.Circle";	
			break;
		case 2: 
			cls="com.app.Square";	
			break;
		case 3: 
			cls="com.app.Triangle";	
			break;
		default:
			break;
		}
		
		return cls;
	}
}
