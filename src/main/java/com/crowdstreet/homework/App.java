package com.crowdstreet.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.crowdstreet.homework.model.RandomNumber;
import com.crowdstreet.homework.service.NumberGenerator;
import com.crowdstreet.homework.util.Helper;

/**
 * Main class
 * @author ningm
 *
 */
public class App {
	
	// the total count of the random numbers
	private static final int TOTAL_COUNT = 997940;

	// the count of each more frequent number
	private static final int MORE_FREQUENT_COUNT = 83000;

	// the count of less frequent numbers
	private static final int LESS_FREQUENT_COUNT = 1940;

	// the count to loop more frequent numbers dataset
	private static final int LOOP_COUNT = 
			MORE_FREQUENT_COUNT / LESS_FREQUENT_COUNT;

	// the number to be printed out on console
	private static final int PRINT_OUT_NUM = 20;

	public static void main(String[] args) {
		// the array to store the generated random numbers
		int[] newArr = new int[TOTAL_COUNT];

		// more frequent numbers
		List<Integer> moreFrequencyList = 
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

		// less frequent numbers
		List<RandomNumber> lessFrequencyList = 
				new ArrayList<RandomNumber>();
		lessFrequencyList.add(new RandomNumber(13, 1000));
		lessFrequencyList.add(new RandomNumber(14, 500));
		lessFrequencyList.add(new RandomNumber(15, 250));
		lessFrequencyList.add(new RandomNumber(16, 100));
		lessFrequencyList.add(new RandomNumber(17, 50));
		lessFrequencyList.add(new RandomNumber(18, 25));
		lessFrequencyList.add(new RandomNumber(19, 10));
		lessFrequencyList.add(new RandomNumber(20, 5));

		// generate random numbers
		NumberGenerator mg = new NumberGenerator();
		mg.generateRandNum(newArr, 
				moreFrequencyList, 
				lessFrequencyList, 
				LOOP_COUNT, 
				LESS_FREQUENT_COUNT,
				TOTAL_COUNT, 
				PRINT_OUT_NUM);

		// write random numbers to test.output file
		Helper.writeFile(newArr);
	}
}