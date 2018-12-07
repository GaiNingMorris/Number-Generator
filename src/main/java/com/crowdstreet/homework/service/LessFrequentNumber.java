package com.crowdstreet.homework.service;

import java.util.List;

import com.crowdstreet.homework.model.RandomNumber;

import utils.Helper;

/**
 * generate less frequent numbers
 * @author ningm
 *
 */
public class LessFrequentNumber {
	
	// the size of current list(choosable numbers)
	private int size;
	
	public LessFrequentNumber(int size) {
		this.size = size;
	}

	/**
	 * generate random number
	 * 
	 * @param newArr 
	 * 			the array to store the generated random numbers
	 * @param list
	 * 			the list to store the less frequent numbers
	 * @param start
	 * 			the start index of newArr
	 * @param printOutNum
	 * 			the number to be printed out on console
	 * @return the start index of newArr
	 */
	public int generateNumber(int[] newArr, 
			List<RandomNumber> list,
			int start, int printOutNum) {
		// get a random index of list
		int index = (int) (Math.random() * size);
		RandomNumber randNum = list.get(index);
		
		if (randNum.getCount() > 1)
			// decrease 1 from count each time
			randNum.setCount(randNum.getCount() - 1);
		else {
			// when number is no longer choosable, then
			// exchange this number with the last number of list
			size--;
			Helper.lessFrequentExchange(list, index, size);
		}

		newArr[start++] = randNum.getValue();
		
		// print out the particular number 
		if (randNum.getValue() == printOutNum)
			System.out.println(printOutNum);
		
		return start;
	}
}