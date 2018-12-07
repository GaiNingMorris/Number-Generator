package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crowdstreet.homework.model.RandomNumber;

/**
 * Helper
 * @author ningm
 *
 */
public class Helper {

	private static final Logger logger = 
			LoggerFactory.getLogger(Helper.class);
	
	private static final String filePath = "test.output.txt";

	/**
	 * get a random number
	 * 
	 * @param list list
	 * @param size 
	 * 			the size of list
	 * @return
	 */
	public static int getRandNumber(List<Integer> list, int size) {
		int index = (int) (Math.random() * size);
		int randNum = list.get(index);
		// exchange current number with the last number
		moreFrequentExchange(list, index, size - 1);
		return randNum;
	}
	
	/**
	 * exchange two numbers
	 * 
	 * @param list list
	 * @param start 
	 * 			the start index of list
	 * @param end 
	 * 			the end index of list
	 */
	public static void moreFrequentExchange(List<Integer> list, 
			int start, int end) {
		if (start == end)
			return;
		
		int temp = list.get(start);
		list.set(start, list.get(end));
		list.set(end, temp);
	}

	/**
	 * exchange two items
	 * 
	 * @param list list
	 * @param start 
	 * 			the start index of list
	 * @param end 
	 * 			the end index of list
	 */
	public static void lessFrequentExchange(List<RandomNumber> list, 
			int start, int end) {
		if (start == end)
			return;
		
		RandomNumber temp = list.get(start);
		list.set(start, list.get(end));
		list.set(end, temp);
	}

	/**
	 * write generated random numbers to file
	 * @param arr array
	 */
	public static void writeFile(int[] arr) {
		Path fpath=Paths.get(filePath);
		// create file
		if (!Files.exists(fpath)) { 
			try {
				Files.createFile(fpath); 
			} catch (IOException e) {
				logger.error("IOException when creating file: {}", e.getMessage());
			}
		}
		
		try {
			BufferedWriter bfw = Files.newBufferedWriter(fpath);
			bfw.write("total numbers: " 
					+ Integer.valueOf(arr.length).toString());
			bfw.newLine();

			for (int num : arr) {
				bfw.write(Integer.valueOf(num).toString());
				bfw.newLine();
			}
			
			bfw.flush();
            bfw.close();
		} catch (Exception e) {
			logger.error("IOException when writing file: {}", e.getMessage());
		}
	}
}