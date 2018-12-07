package com.crowdstreet.homework.model;

/**
 * Random Number
 * @author ningm
 *
 */
public class RandomNumber {

	// the value of the number
	private int value;
	
	// the count of the number
	private int count;
	
	public RandomNumber(int value, int count) {
		this.value = value;
		this.count = count;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RandomNumber [value=" + value + ", count=" + count + "]";
	}
}