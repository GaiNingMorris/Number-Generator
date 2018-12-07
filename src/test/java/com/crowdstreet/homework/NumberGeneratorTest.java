package com.crowdstreet.homework;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crowdstreet.homework.model.RandomNumber;
import com.crowdstreet.homework.service.NumberGenerator;


public class NumberGeneratorTest {

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

	// the array to store the generated random numbers
	private static int[] arr = new int[TOTAL_COUNT];
	
	@BeforeClass
	public static void init() {
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
		mg.generateRandNum(arr, 
				moreFrequencyList, 
				lessFrequencyList, 
				LOOP_COUNT, 
				LESS_FREQUENT_COUNT,
				TOTAL_COUNT, 
				PRINT_OUT_NUM);	
	}
	
	/**
	 * test if consecutive numbers repeat
	 */
	@Test
	public void testIsRepeat() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				fail("consecutive numbers repeat");
			}
		}
	}

	/**
	 * test if numbers are valid
	 */
	@Test
	public void testIsValidNumbers() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < 1 || arr[i] > 20) {
				fail("numbers are invalid");
			}
		}
	}

	/**
	 * test if the more frequent numbers` count are correct
	 */
	@Test
	public void testMoreFrequentNumCount() {
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, 
			count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0,
			count11 = 0, count12 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
				case 1:
					count1++;
					break; 
				case 2:
					count2++;
					break; 
				case 3:
					count3++;
					break; 
				case 4:
					count4++;
					break; 
				case 5:
					count5++;
					break; 
				case 6:
					count6++;
					break;
				case 7:
					count7++;
					break; 
				case 8:
					count8++;
					break; 
				case 9:
					count9++;
					break; 
				case 10:
					count10++;
					break; 
				case 11:
					count11++;
					break; 
				case 12:
					count12++;
					break; 
				default:
					break;
			}
		}
		
		if(count1 != MORE_FREQUENT_COUNT || count2 != MORE_FREQUENT_COUNT
			|| count3 != MORE_FREQUENT_COUNT || count4 != MORE_FREQUENT_COUNT
			|| count5 != MORE_FREQUENT_COUNT || count6 != MORE_FREQUENT_COUNT
			|| count7 != MORE_FREQUENT_COUNT || count8 != MORE_FREQUENT_COUNT
			|| count9 != MORE_FREQUENT_COUNT || count10 != MORE_FREQUENT_COUNT
			|| count11 != MORE_FREQUENT_COUNT || count12 != MORE_FREQUENT_COUNT)
			fail("the more frequent numbers` count are wrong");
	}

	/**
	 * test if the less frequent numbers` count are correct
	 */
	@Test
	public void testLessFrequentNumCount() {
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0,  
			count5 = 0,	count6 = 0, count7 = 0, count8 = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {
			switch (arr[i]) {
				case 13:
					count1++;
					break; 
				case 14:
					count2++;
					break; 
				case 15:
					count3++;
					break; 
				case 16:
					count4++;
					break; 
				case 17:
					count5++;
					break; 
				case 18:
					count6++;
					break;
				case 19:
					count7++;
					break; 
				case 20:
					count8++;
					break; 
				default:
					break;
			}
		}
		
		if(count1 != 1000 || count2 != 500
				|| count3 != 250 || count4 != 100
				|| count5 != 50 || count6 != 25
				|| count7 != 10 || count8 != 5)
				fail("the less frequent numbers` count are wrong");
	}
}