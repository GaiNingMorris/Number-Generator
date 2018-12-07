package com.crowdstreet.homework.service;

import java.util.List;

import utils.Helper;

/**
 * generate more frequent numbers
 * @author ningm
 *
 */
public class MoreFrequentNumber {

	/**
	 * generate random numbers
	 * 
	 * @param newArr
	 * 			the array to store the generated random numbers
	 * @param list
	 * 			the list to store the less frequent numbers
	 * @param count
	 * 			the count to loop more frequent numbers dataset
	 * @param start
	 * 			the start index of newArr
	 * @return the start index of newArr
	 */
	public int generateNumber(int[] newArr, 
			List<Integer> list, int count, int start) {
		int size = list.size();

		while (count > 0) {
			generateMoreFrequentNumber(list, newArr, start);
			start += size;
			count--;
		}

		return start;
	}

	/**
	 * generate random number
	 * @param list
	 * 			the list to store the less frequent numbers
	 * @param newArr
	 * 			the array to store the generated random numbers
	 * @param start
	 * 			the start index of newArr
	 */
	private void generateMoreFrequentNumber(List<Integer> list,
			int[] newArr, int start) {
		int size = list.size();
		int randNum;
		
		// generate the first number
		do {
			// the first value can not be same as the last value of last loop
			randNum = Helper.getRandNumber(list, size);
		} while (start != 0 && randNum == newArr[start - 1]);
		newArr[start++] = randNum;
		size--;

		// generate the rest 11 numbers
		while (size > 0) {
			randNum = Helper.getRandNumber(list, size);
			newArr[start++] = randNum;
			size--;
		}
	}
}