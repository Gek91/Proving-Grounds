package adventofcode2023.day4;

import adventofcode2023.day3.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
	https://adventofcode.com/2023/day/4
 */

public class Day4 {

	public static void main(String[] args) {


		long result = 0;

		Map<Integer, Card> cardMaps = new LinkedHashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("./input")) {}){
			for(String line; (line = reader.readLine()) != null; ) {

				//part 1
				Card card = Card.buildFromString(line);
//				result = result + card.calculateCardValue();

				cardMaps.put(card.getCardNumber(), card);
			}
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		for(int cardNumber : cardMaps.keySet()) {

			Card card = cardMaps.get(cardNumber);
			long numberOfMatchingCard =	card.calculateCardMatching();

			for(int i = 1 ; i <= numberOfMatchingCard ; i++) {
				cardMaps.get(cardNumber + i).increaseNumberOfCards(card.numberOfCards);
			}

			result = result + card.numberOfCards;
		}

		System.out.println(result);
	}

	private static class Card {
		private int cardNumber;
		private List<Integer> winningNumber = new ArrayList<>();
		private List<Integer> playedNumber = new ArrayList<>();

		private int numberOfCards = 0;

		private Card() { }

		public static Card buildFromString(String line) {

			//example
			//Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53

			Card result = new Card();
			result.increaseNumberOfCards(1);

			String[] elements = line.split(":");

			String[] nameElements = elements[0].split(" ");
			result.cardNumber = Integer.parseInt(nameElements[nameElements.length-1]);

			elements = elements[1].trim().split("\\|");

			Arrays.stream(elements[0].trim().split(" ")).filter(x -> !x.isEmpty()).forEach(elem -> result.winningNumber.add(Integer.parseInt(elem)));
			Arrays.stream(elements[1].trim().split(" ")).filter(x -> !x.isEmpty()).forEach(elem -> result.playedNumber.add(Integer.parseInt(elem)));

			return result;
		}

		public long calculateCardValue() {

			int i = calculateCardMatching() -1;

			return (long) (i >= 0 ? Math.pow(2, i) : 0);
		}

		public int calculateCardMatching() {
			int i = 0;

			for(int value : this.playedNumber) {

				if(this.winningNumber.contains(value)) {
					i++;
				}
			}

			return i;
		}

		public void increaseNumberOfCards(int number) {
			this.numberOfCards = numberOfCards + number;
		}

		public int getCardNumber() {
			return cardNumber;
		}

		public int getNumberOfCards() {
			return numberOfCards;
		}
	}
}
