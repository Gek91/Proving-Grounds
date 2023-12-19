package adventofcode2023.day6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
	https://adventofcode.com/2023/day/6
 */
public class Day6 {

	public static void main(String[] args) {

		List<RaceRecord> races = getRaceRecords();

		int result = 1;

		for(RaceRecord record : races) {

			int count = record.countRaceWinningWay();
			System.out.println(record.time + "|" +record.distance + " :" + count);
			result = result *count;
		}

		System.out.println(result);
	}

	private static List<RaceRecord> getRaceRecords() {

		List<RaceRecord> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("./input2")) {}){

			String line = reader.readLine();
			String[] times = line.split(":")[1].trim().split("\\s+");

			line = reader.readLine();
			String[] distances = line.split(":")[1].trim().split("\\s+");

			for(int i = 0; i < distances.length; i++) {
				result.add(new RaceRecord(Long.parseLong(times[i]), Long.parseLong(distances[i])));
			}

		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		return result;
	}



	private static class RaceRecord {

		private long time;
		private long distance;

		public RaceRecord(long time, long distance) {
			this.time = time;
			this.distance = distance;
		}

		public int countRaceWinningWay() {

			int count = 0;
			boolean findOne = false;

			for(long i = 1; i < time ; i++) {
				long meter = getMetersFromChargingTime(i, time);
				if(meter > this.distance) {
					count++;
					if(!findOne) {
						findOne = true;
					}
				} else {
					if(findOne) {
						break;
					}
				}
			}

			return count;
		}

		private long getMetersFromChargingTime(long chargingTime, long totalTime) {

			long runningTime = totalTime - chargingTime;

			return runningTime * chargingTime;
		}
	}
}
