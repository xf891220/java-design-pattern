package com.teddy.factory;

public class CarFactory {
	public Car getCar(String name){
		if("Audi".equals(name)){
			return new Audi();
		}
		else if("Benz".equals(name)){
			return new Benz();
		}
		return null;
	}
	public Object getCar(Class<? extends Car> clazz){
		Object obj = null;
		try {
			obj = Class.forName(clazz.getName()).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		carFactory.getCar("Audi").getName();
		carFactory.getCar("Benz").getName();
		Audi audi = (Audi)carFactory.getCar(Audi.class);
		audi.getName();
	}
}
