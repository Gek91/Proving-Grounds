package adventofcode2023.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
	on each line of the input is described a game. Every game is composed by sets (delimited by ;).
	Every set has values with colors that can be red, blue and green (delimited by ,)
	Only the games in witch every set has the values corresponding at each color less than the check set is valid
	The check set is 12 red, 13 green, 14 blue. If a game contains a set with a colour with a corrisponding value more than these is not valid

	sum the game id (contained in each line) of valid game
	example
	Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green						VALID
	Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue			VALID
	Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red	NOT VALID
	Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red	NOT VALID
	Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green						VALID

	result 1+2+5 = 8

	--part 2

	find for each game a minimum check set (values of red, green and blue) that makes all the game set valid
	example
	Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green -> 					4 red, 2 green, 6 blue
	Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue -> 		1 red, 3 green, 4 blue
	Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red ->	20 red, 13 green, 6 blue
	Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red ->	14 red, 3 green, 15 blue
	Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green ->					6 red, 3 green, 2 blue

	this minimum check set has a value given from multipling all its value -> 4*2*6 for the first example -> 48

	Sum the values of the minimum check set of every game
 */

public class Day2 {


	static class Game {
		private int id;
		private List<GameSet> gameSets;


		public int getId() {
			return id;
		}

		public List<GameSet> getGameSets() {
			return gameSets;
		}

		private Game() { }

		public static Game parserStringToGame(String input) {

			Game newGame = new Game();

			String[] splitResult = input.split(":");

			String gameInfo = splitResult[0];
			newGame.id = Integer.parseInt(
					gameInfo.split(" ")[1]
			);

			String gameSetsString = splitResult[1];
			newGame.gameSets = getGameSetList(gameSetsString);

			return newGame;
		}

		private static List<GameSet> getGameSetList(String input) {
			List<GameSet> gameSets = new ArrayList<>();
			for(String gameSetString : input.split(";")) {
				gameSets.add(GameSet.parseStringToGameSet(gameSetString.trim()));
			}

			return gameSets;
		}

		public GameSet getMinimumCheckSet() {

			GameSet minimum = new GameSet();

			for(GameSet gameSet : this.gameSets) {

				if(gameSet.getReds() > minimum.getReds()) {
					minimum.reds = gameSet.getReds();
				}

				if(gameSet.getGreens() > minimum.getGreens()) {
					minimum.greens = gameSet.getGreens();
				}

				if(gameSet.getBlues() > minimum.getBlues()) {
					minimum.blues = gameSet.getBlues();
				}
			}

			return minimum;
		}

		static class GameSet {
			private int reds;
			private int greens;
			private int blues;

			private GameSet() { }

			public static GameSet parseStringToGameSet(String input) {
				GameSet result = new GameSet();

				for(String setValues : input.split(",")) {
					String[] valueComponents = setValues.trim().split(" ");
					switch (valueComponents[1]) {
						case "green":
							result.greens = Integer.parseInt(valueComponents[0]);
							break;
						case "red":
							result.reds = Integer.parseInt(valueComponents[0]);
							break;
						case "blue":
							result.blues = Integer.parseInt(valueComponents[0]);
							break;
					}
				}

				return result;
			}

			public int getReds() {
				return reds;
			}

			public int getGreens() {
				return greens;
			}

			public int getBlues() {
				return blues;
			}
		}
	}

	public static void main(String[] args) {


		int result = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader("./input")) {}){
			for(String line; (line = reader.readLine()) != null; ) {

				Game game = Game.parserStringToGame(line);

				//part 1
//				if (isGameValid(game)) {
//					System.out.println("game " + game.getId() +" is valid");
//					result = result + game.getId();
//				}

				//part 2
				Game.GameSet checkSet = game.getMinimumCheckSet();
				result = result + checkSet.getBlues() * checkSet.getGreens() * checkSet.getReds();
			}
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		System.out.println(result);
	}

	private static boolean isGameValid(Game game) {

		for(Game.GameSet gameSet : game.getGameSets()) {

			if(gameSet.getBlues() > 14 || gameSet.getGreens() > 13 || gameSet.getReds() > 12) {
				return false;
			}
		}

		return true;
	}
}
