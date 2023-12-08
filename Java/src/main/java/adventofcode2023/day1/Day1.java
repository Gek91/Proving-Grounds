package adventofcode2023.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

	/*
		On each line, the calibration value can be found by combining
		the first digit and the last digit container in the line (in that order) to form a single two-digit number.
		example:
		1abc2 -> 12
		pqr3stu8vwx -> 38
		a1b2c3d4e5f -> 15
		treb7uchet -> 77

		Adding the values obtained together produces 142.

		-----------

		part 2
		use also the number written by words (one, two, three, four, five, six, seven, eight, nine) to calculate the first
		and last digits in every line.
		example:
		two1nine -> 29
		eightwothree -> 83
		abcone2threexyz -> 13
		xtwone3four -> 24
		4nineeightseven2 -> 42
		zoneight234 -> 14
		7pqrstsixteen -> 76

		also in this case sum the values -> 281
	 */

	public static void main(String[] args) {

		int result = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader("./calibrationInput")) {}){
			for(String line; (line = reader.readLine()) != null; ) {

				//part 1
//				int value = getLineValue(line);
				//part 2
				int value = getLineValuePartTwo(line);
				System.out.println(line +  " " + value);

				result = result + value;
			}
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		System.out.println(result);
	}

	private static int getLineValue(String line) {

		int result = 0;

		char[] charArray = line.toCharArray();

		for (char c : charArray) {
			if (Character.isDigit(c)) {
				result = 10 * Character.getNumericValue(c);
				break;
			}
		}

		for(int i = charArray.length - 1; i >= 0; i--) {
			if (Character.isDigit(charArray[i])) {
				result = result + Character.getNumericValue(charArray[i]);
				break;
			}
		}

		return result;
	}

	private static Map<Integer, String> intValueMap = new HashMap<Integer, String>();
	static {
		intValueMap.put(1, "one");
		intValueMap.put(2, "two");
		intValueMap.put(3, "three");
		intValueMap.put(4, "four");
		intValueMap.put(5, "five");
		intValueMap.put(6, "six");
		intValueMap.put(7, "seven");
		intValueMap.put(8, "eight");
		intValueMap.put(9, "nine");
	}

	private static int getLineValuePartTwo(String line) {

		int minValue = -1;
		int maxValue = -1;
		int min = Integer.MAX_VALUE;
		int max = -1;

		for(int i = 1; i < 10 ; i++) {

			OccurrencePositions value = calculateMinMaxOccurrencesPosition(line, i);
			if(value.getMax() > max) {
				max = value.getMax();
				maxValue = i;
			}
			if(value.getMin() < min) {
				min = value.getMin();
				minValue = i;
			}
		}

		return minValue * 10 + maxValue;
	}

	private static OccurrencePositions calculateMinMaxOccurrencesPosition(String line, Integer value) {

		OccurrencePositions result = new OccurrencePositions();

		calculateMinMaxInner(result, line, "" + value);
		calculateMinMaxInner(result, line, intValueMap.get(value));

		return result;
	}

	private static void calculateMinMaxInner(OccurrencePositions result, String line, String pattern) {
		int index = line.indexOf(pattern);
		if(index != -1) {
			result.updateMin(index);
			result.updateMax(index);
		}

		while(index >= 0) {
			index = line.indexOf(pattern, index+1);
			result.updateMax(index);
		}
	}

	static class OccurrencePositions {
		private Integer min = Integer.MAX_VALUE;
		private Integer max = -1;

		public Integer getMin() {
			return min;
		}

		public void updateMin(Integer min) {
			if(min < this.min) {
				this.min = min;
			}
		}

		public Integer getMax() {
			return max;
		}

		public void updateMax(Integer max) {
			if(max > this.max) {
				this.max = max;
			}
		}
	}
}
