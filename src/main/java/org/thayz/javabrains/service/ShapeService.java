package org.thayz.javabrains.service;

import org.thayz.javabrains.model.Circle;
import org.thayz.javabrains.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;
	
	public Circle getCircle() {
//		System.out.println("In getCircle()...");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
//		System.out.println("In getTriangle()...");
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
}
