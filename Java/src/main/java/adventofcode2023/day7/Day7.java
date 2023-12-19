package adventofcode2023.day7;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
	https://adventofcode.com/2023/day/7
 */
public class Day7 {

	public static void main(String[] args) {

		List<Hand> hands = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("./input")) {}){
			for(String line; (line = reader.readLine()) != null; ) {

				String[] handValues = line.split(" ");

				hands.add(Hand.buildHand(handValues[0], Integer.parseInt(handValues[1])));
			}
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		Collections.sort(hands);

		int result = 0;
		for(int i = hands.size() -1 ; i >= 0 ; i--) {
			Hand hand = hands.get(i);
			result = result + hand.bid * (i + 1);
		}

		System.out.println(result);
	}

	private static class Hand implements Comparable<Hand> {

		private String cards;
		private HandType type;
		private int bid;

		private Hand(String cards, HandType type, int bid) {
			this.cards = cards;
			this.type = type;
			this.bid = bid;
		}

		public static Hand buildHand(String cards, int bid) {

//			return new Hand(cards, computeHandType(cards), bid);
			return new Hand(cards, computeHandTypePartTwo(cards), bid);
		}

		private static HandType computeHandType(String cards) {

			Map<Character, Integer> countMap = new HashMap<>();

			for(char c : cards.toCharArray()) {
				countMap.put(c, countMap.getOrDefault(c, 0) + 1);
			}

			HandType result = HandType.NONE;

			for(int value : countMap.values()) {

				switch(value) {
					case 5:
						return HandType.FIVE;
					case 4:
						return HandType.FOUR;
					case 3:
						if(result == HandType.PAIR) {
							return HandType.FULL;
						} else {
							result = HandType.THREE;
						}
						break;
					case 2:
						if(result == HandType.PAIR) {
							return HandType.TWO_PAIR;
						} else if(result == HandType.THREE) {
							return HandType.FULL;
						} else {
							result = HandType.PAIR;
						}
						break;
				}
			}
			return result;
		}

		private static HandType computeHandTypePartTwo(String cards) {

			Map<Character, Integer> countMap = new HashMap<>();

			int jokerCount = 0;

			for(char c : cards.toCharArray()) {
				if(c != 'J') {
					countMap.put(c, countMap.getOrDefault(c, 0) + 1);
				} else {
					jokerCount++;
				}
			}

			if(jokerCount == cards.length()) {
				return HandType.FIVE;
			}

			if(jokerCount != 0) {
				int max = 0;
				char maxChar = cards.charAt(0);
				for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
					if(entry.getValue() > max) {
						max = entry.getValue();
						maxChar = entry.getKey();
					}
				}

				countMap.put(maxChar, countMap.get(maxChar) + jokerCount);
			}

			HandType result = HandType.NONE;

			for(int value : countMap.values()) {

				switch(value) {
					case 5:
						return HandType.FIVE;
					case 4:
						return HandType.FOUR;
					case 3:
						if(result == HandType.PAIR) {
							return HandType.FULL;
						} else {
							result = HandType.THREE;
						}
						break;
					case 2:
						if(result == HandType.PAIR) {
							return HandType.TWO_PAIR;
						} else if(result == HandType.THREE) {
							return HandType.FULL;
						} else {
							result = HandType.PAIR;
						}
						break;
				}
			}
			return result;
		}

		@Override
		public int compareTo(Hand input) {

			int result = Integer.compare(this.type.ordinal(), input.type.ordinal());

			if(result == 0) {
				for(int i = 0 ; i < this.cards.length() ; i++) {

					char thisChar = this.cards.charAt(i);
					char inputChar = input.cards.charAt(i);

					if(thisChar != inputChar) {

//						result = Integer.compare(charSortingMap.get(thisChar), charSortingMap.get(inputChar));
						result = Integer.compare(charSortingMapPartTwo.get(thisChar), charSortingMapPartTwo.get(inputChar));
						if(result != 0) {
							return result;
						}
					}
				}
			}

			return result;
		}
	}

	static Map<Character, Integer> charSortingMap = new HashMap<>() {
		{
			put('A', 14);
			put('K', 13);
			put('Q', 12);
			put('J', 11);
			put('T', 10);
			put('9', 9);
			put('8', 8);
			put('7', 7);
			put('6', 6);
			put('5', 5);
			put('4', 4);
			put('3', 3);
			put('2', 2);
		}};

	static Map<Character, Integer> charSortingMapPartTwo = new HashMap<>() {
		{
			put('A', 14);
			put('K', 13);
			put('Q', 12);
			put('T', 10);
			put('9', 9);
			put('8', 8);
			put('7', 7);
			put('6', 6);
			put('5', 5);
			put('4', 4);
			put('3', 3);
			put('2', 2);
			put('J', 1);
		}};

	private enum HandType {
		NONE,
		PAIR,
		TWO_PAIR,
		THREE,
		FULL,
		FOUR,
		FIVE;
	}
}
