package adventofcode2023.day3;

import adventofcode2023.day2.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/*
	https://adventofcode.com/2023/day/3
	//part 1
	given the input sum all the numbers that have a symbol near them. Consider valid all the symbols (excluded the '.') that are near also in diagonal
	example
	467..114..
	...*......
	..35..633.
	......#...
	617*......
	.....+.58.
	..592.....
	......755.
	...$.*....
	.664.598..

	114 and 58 have not any symbols near them. The sum of the other numbers is 4361

	//part 2
	given the same input consider all the '*' that have 2 value near them (considering also diagonal)
	for all these * multiply the numbers near them and sum up the result.
	example
	467..114..
	...*......
	..35..633.
	......#...
	617*......
	.....+.58.
	..592.....
	......755.
	...$.*....
	.664.598..

	there are two valid '*'. the sum of the multiplication of their near number is 467835
 */
public class Day3 {

	public static void main(String[] args) {


		long result = 0;
		List<LineValues> lineDataList = new ArrayList<>();


		try (BufferedReader reader = new BufferedReader(new FileReader("./input")) {}){
			for(String line; (line = reader.readLine()) != null; ) {

				//part 1
//				LineValues newLineData = parseLinePart1(line, previousLineData);
//				result = result + newLineData.getRowValue();
//				previousLineData = newLineData;

				//part 2
				lineDataList.add(parseLinePart2(line));
			}

			LineValues previousLineValues = null;
			LineValues nextLineValues = null;

			for(int i = 0 ; i < lineDataList.size() ; i++) {

				if(i+1 < lineDataList.size()) {
					nextLineValues = lineDataList.get(i+1);
				}

				LineValues currentLineValues = lineDataList.get(i);

				result = result + calculateLineDataResult(previousLineValues, currentLineValues, nextLineValues);

				previousLineValues = currentLineValues;
			}

		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		System.out.println(result);
	}

	private static LineValues parseLinePart1(String line, LineValues previousLineData) {

		LineValues lineData = new LineValues();

		char[] characters = line.toCharArray();

		for(int i = 0; i < characters.length; i++) {

			char character = characters[i];

			if(Character.isDigit(character)) {

				LineValues.NumberData data = new LineValues.NumberData();
				data.setFirstIndex(i);
				data.setValue(Character.getNumericValue(character));

				while((i+1) < characters.length && Character.isDigit(characters[i+1])) {
					character = characters[i+1];
					data.setValue(data.getValue() * 10 + Character.getNumericValue(character));
					i++;
				}
				data.setLastIndex(i);

				if(isPartNumber(data, lineData, previousLineData)) {
					lineData.addToRowValue(data.getValue());
				} else {
					lineData.addNumberToCheck(data);
				}

			} else if(character != '.') {
				lineData.addSymbolPositions(i);

				lineData.popAdiacentNumberData(i)
						.forEach(numberData -> lineData.addToRowValue(numberData.getValue()));

				if(previousLineData != null) {
					previousLineData.popAdiacentNumberData(i)
							.forEach(numberData -> lineData.addToRowValue(numberData.getValue()));
				}
			}

		}

		return lineData;
	}

	private static boolean isPartNumber(LineValues.NumberData value, LineValues currentLineData, LineValues previousLineData) {
		return currentLineData.isAdiacentToSymbol(value.getFirstIndex(), value.getLastIndex()) ||
				(previousLineData != null && previousLineData.isAdiacentToSymbol(value.getFirstIndex(), value.getLastIndex()));
	}

	private static LineValues parseLinePart2(String line) {
		LineValues lineData = new LineValues();

		char[] characters = line.toCharArray();

		for(int i = 0; i < characters.length; i++) {

			char character = characters[i];

			if(Character.isDigit(character)) {

				LineValues.NumberData data = new LineValues.NumberData();
				data.setFirstIndex(i);
				data.setValue(Character.getNumericValue(character));

				while((i+1) < characters.length && Character.isDigit(characters[i+1])) {
					character = characters[i+1];
					data.setValue(data.getValue() * 10 + Character.getNumericValue(character));
					i++;
				}
				data.setLastIndex(i);
				lineData.addNumberToCheck(data);

			} else if(character == '*') {
				lineData.addSymbolPositions(i);
			}
		}

		return lineData;
	}

	private static long calculateLineDataResult(LineValues previousLineData, LineValues currentLineData, LineValues nextLineData) {

		long result = 0;

		for(int position : currentLineData.symbolPositions) {
			List<Integer> adiacentValues = new ArrayList<>();

			adiacentValues.addAll(currentLineData.getAdiacentNumberData(position).stream().map(LineValues.NumberData::getValue).collect(Collectors.toList()));

			if(previousLineData != null) {
				adiacentValues.addAll(previousLineData.getAdiacentNumberData(position).stream().map(LineValues.NumberData::getValue).collect(Collectors.toList()));
			}

			if(nextLineData != null) {
				adiacentValues.addAll(nextLineData.getAdiacentNumberData(position).stream().map(LineValues.NumberData::getValue).collect(Collectors.toList()));
			}

			if(adiacentValues.size() == 2) {
				result = result + adiacentValues.get(0) * adiacentValues.get(1);
			}
		}
		return result;
	}

	static class LineValues {

		private List<Integer> symbolPositions = new ArrayList<>();
		private List<NumberData> numbersToCheck = new ArrayList<>();

		private long rowValue = 0;

		public void addSymbolPositions(int value) {
			this.symbolPositions.add(value);
		}

		public boolean isAdiacentToSymbol(int startIndex, int lastIndex) {
			return symbolPositions.stream().anyMatch(x -> x >= startIndex-1 && x <= lastIndex +1);
		}

		public void addNumberToCheck(NumberData numberToCheck) {
			this.numbersToCheck.add(numberToCheck);
		}

		public Set<NumberData> getAdiacentNumberData(int index) {
			return numbersToCheck.stream().filter(x -> x.getFirstIndex() <= index+1 && x.getLastIndex() >= index-1).collect(Collectors.toSet());
		}

		public Set<NumberData> popAdiacentNumberData(int index) {

			Set<NumberData> result = getAdiacentNumberData(index);

			result.forEach(numberData -> numbersToCheck.remove(numberData));

			return result;
		}

		public void addToRowValue(int value) {
//			System.out.println(value);
			this.rowValue = this.rowValue + value;
		}

		public long getRowValue() {
			return rowValue;
		}

		static class NumberData {
			private int value;
			private int firstIndex;
			private int lastIndex;

			public int getValue() {
				return value;
			}

			public void setValue(int value) {
				this.value = value;
			}

			public int getFirstIndex() {
				return firstIndex;
			}

			public void setFirstIndex(int firstIndex) {
				this.firstIndex = firstIndex;
			}

			public int getLastIndex() {
				return lastIndex;
			}

			public void setLastIndex(int lastIndex) {
				this.lastIndex = lastIndex;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				NumberData that = (NumberData) o;
				return value == that.value && firstIndex == that.firstIndex && lastIndex == that.lastIndex;
			}

			@Override
			public int hashCode() {
				return Objects.hash(value, firstIndex, lastIndex);
			}
		}
	}
}
