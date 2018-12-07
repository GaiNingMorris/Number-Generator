package com.crowdstreet.homework.service;

import java.util.List;

import com.crowdstreet.homework.model.RandomNumber;

/**
 * Number Generator
 * @author ningm
 *
 */
public class NumberGenerator {
	/**
	 * generate random numbers
	 * 
	 * @param newArr 
	 * 			the array to store the generated random numbers
	 * @param moreFrequentList 
	 * 			list to store the more frequent numbers
	 * @param lessFrequentList 
	 * 			list to store the less frequent numbers
	 * @param loopCount 
	 * 			the count to loop more frequent numbers dataset
	 * @param lessFrequentCount
	 * 			the total count of less frequent numbers
	 * @param totalCount
	 * 			total count of the random numbers 
	 * @param printOutNum
	 * 			the number to be printed out on console
	 */
	public void generateRandNum(int[] newArr, 
			List<Integer> moreFrequentList,
			List<RandomNumber> lessFrequentList, 
			int loopCount,
			int lessFrequentCount,
			int totalCount,
			int printOutNum) {
		int start = 0;
		MoreFrequentNumber mfn = new MoreFrequentNumber();
		LessFrequentNumber lfn = 
				new LessFrequentNumber(lessFrequentList.size());

		/**
		 * generate a batch of more frequent numbers and a less frequent
		 * number continually until less frequent numbers are gone
		 */
		while (lessFrequentCount > 0) {
			start = mfn.generateNumber(newArr, 
					moreFrequentList, loopCount, start);
			start = lfn.generateNumber(newArr, 
					lessFrequentList, start, printOutNum);
			lessFrequentCount--;
		}

		// generate the rest of the more frequent numbers
		mfn.generateNumber(newArr, moreFrequentList, 
				(totalCount - start) / moreFrequentList.size(), start);
	}
}