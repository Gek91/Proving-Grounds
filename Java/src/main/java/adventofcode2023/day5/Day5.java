package adventofcode2023.day5;

import adventofcode2023.day4.Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
	https://adventofcode.com/2023/day/5
 */
public class Day5 {

	public static void main(String[] args) {

		List<Long> seeds;

		try (BufferedReader reader = new BufferedReader(new FileReader("./input")) {}){

			//firstPart
//			seeds = getSeedFromStringFirstPart(reader.readLine());
			//SecondPart
			Map<Long, Long> seedCouple = getSeedCouples(reader.readLine());
			//void line
			reader.readLine();

			MapValues seedToSoil = MapValues.buildFromFile(reader);

			MapValues soilToFertilizer = MapValues.buildFromFile(reader);

			MapValues fertilizerToWater = MapValues.buildFromFile(reader);

			MapValues waterToLight = MapValues.buildFromFile(reader);

			MapValues lightToTemperature =  MapValues.buildFromFile(reader);

			MapValues temperatureToHumidity = MapValues.buildFromFile(reader);

			MapValues humidityToLocation = MapValues.buildFromFile(reader);

			Function<Long, Long> minFunction = x -> humidityToLocation.getValue(
					temperatureToHumidity.getValue(
							lightToTemperature.getValue(
									waterToLight.getValue(
											fertilizerToWater.getValue(
													soilToFertilizer.getValue(
															seedToSoil.getValue(x)
													)
											)
									)
							)
					)
			);

			long min = Long.MAX_VALUE;

			//first part
			/*
			min = applyFunctionToSeeds(seeds, min, minFunction);
			 */

			//second part
			for(Map.Entry<Long,Long> entry : seedCouple.entrySet()) {

				long first =entry.getKey();
				long last = entry.getValue() - 1 + first;

				for(long j = first ; j <= last ; j++) {
					min = applyFunctionToSeeds(Arrays.asList(j), min, minFunction);
				}
			}

			System.out.println(min);

		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}



	private static long applyFunctionToSeeds(List<Long> seeds, long startMin, Function<Long, Long> minFunction) {

		long min = startMin;

		for(long seed : seeds) {

			long value = minFunction.apply(seed);

			if(value < min) {
				min = value;
			}
		}

		return min;
	}

	private static List<Long> getSeedFromStringFirstPart(String line) {

		String seedString = line.split(":")[1].trim();

		return Arrays.stream(seedString.split(" "))
				.map(Long::parseLong)
				.collect(Collectors.toList());
	}

	private static Map<Long, Long> getSeedCouples(String line) {

		Map<Long, Long> result = new HashMap<>();

		String seedString = line.split(":")[1].trim();

		List<Long> values = Arrays.stream(seedString.split(" "))
				.map(Long::parseLong)
				.collect(Collectors.toList());

		for(int i = 0 ; i+1 < values.size() ; i = i+2) {
			result.put(values.get(i), values.get(i+1));
		}

		return result;
	}

	private static class MapValues {

		private List<MapElement> elementList = new ArrayList<>();

		private MapValues() {}

		public static MapValues buildFromFile(BufferedReader reader) throws IOException {

			MapValues result = new MapValues();

			//header line
			reader.readLine();

			for(String line; (line = reader.readLine()) != null; ) {

				if(line.isEmpty()) {
					break;
				}

				result.sortedAdd(MapElement.buildFromString(line));
			}

			return result;
		}

		private void sortedAdd(MapElement element) {

			int index = 0;

			if (elementList.isEmpty()) {
				this.elementList.add(element);
			} else {
				while(index <this.elementList.size()) {

					if(this.elementList.get(index).startIndex < element.startIndex) {
						break;
					}
					index++;
				}
				this.elementList.add(index, element);
			}
		}

		public long getValue(long input) {

			for(MapElement element : this.elementList) {

				if(input >= element.startIndex && input <= element.endIndex) {
					return input - element.startIndex + element.baseValue;
				}
			}

			return input;
		}

		private static class MapElement {
			private long startIndex;
			private long endIndex;
			private long baseValue;
			private long rangeLength;

			private MapElement(long startIndex, long baseValue, long rangeLength) {
				this.startIndex = startIndex;
				this.baseValue = baseValue;
				this.rangeLength = rangeLength;
				this.endIndex = startIndex + rangeLength-1;
			}

			private static MapElement buildFromString(String line) {
				String[] values = line.trim().split(" ");

				return new MapElement(Long.parseLong(values[1]), Long.parseLong(values[0]), Long.parseLong(values[2]));
			}
		}
	}
}
