package com.java.learning;

public class ParameterizedConstructor {

	Integer i;
	
	Integer getValue(){
		return i;
	}
	public ParameterizedConstructor() {
	
	}
	ParameterizedConstructor(Integer i){
		this.i = i;
	}
	
	public static void main(String [] args){
		Integer i = new Integer(10);
		ParameterizedConstructor pCond =  new ParameterizedConstructor(i);
		System.out.println(pCond.getValue());
		i = new Integer(1000);
		System.out.println(pCond.getValue());
	}
}

