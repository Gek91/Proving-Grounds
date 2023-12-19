package adventofcode2023.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	https://adventofcode.com/2023/day/8
	given a rapresentation of a graph where every node has only two possible edeg (Left and right).
	Given ain input string composted only by L or R that stay for left and right.
	Starting from a specific node (AAA) follow the edge to other nodes based on the input string characters. Repeat until found terminal node (ZZZ)
	Count the steps

	part2
	The starting nodes all are the nodes taht ends with A (XXA) and all the ending node are all the nodes ending with Z (XXZ)
	Starting simultaneously on every starting nodes how many steps it takes to end that specific step for all the paths in a final nodes following the input string to choose the nest step to take for every path.
 */
public class Day8 {

	public static void main(String[] args) {


		Map<String, Node> nodesMap = new HashMap<>();
		List<Node> startNodes = new ArrayList<>();

		String input = "";

		try (BufferedReader reader = new BufferedReader(new FileReader("./input")) {}){

			input = reader.readLine();

			//void line
			reader.readLine();

			for(String line; (line = reader.readLine()) != null; ) {

				line = line.replace(" ", "").replace(")", "").replace("(", "");
				String[] nodeElements = line.split("=");

				String[] instructions =  nodeElements[1].split(",");

				Node node = new Node(nodeElements[0], instructions[0], instructions[1]);

				nodesMap.put(nodeElements[0], node);

				if(node.value.endsWith("A")) {
					startNodes.add(node);
				}
			}
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		//part 1
//		int count = countStepFromAAAToZZZ(input, nodesMap);
		//part 2
		long count = countStepFromANodesToSimultaneouslyZNode(input, nodesMap, startNodes);
		System.out.println(count);
	}

	private static long countStepFromANodesToSimultaneouslyZNode(String input, Map<String, Node> networkNodes, List<Node> startNodes) {

		long result = 1;

		for(Node node : startNodes) {
			int value = countStepFromXXAToXXZ(node, input, networkNodes);
			System.out.println(value);
			result = LCM(result, value);
		}

		return result;
	}

	//I don't really know why this work. Probably is some properties of the input
	private static int countStepFromXXAToXXZ(Node startingNode, String input, Map<String, Node> networkNodes) {

		int result = 0;
		Node currentNode = startingNode;

		while(!currentNode.value.endsWith("Z")) {

			for(Character c : input.toCharArray()) {

				switch(c) {
					case 'R':
						currentNode = networkNodes.get(currentNode.right);
						break;
					case 'L':
						currentNode = networkNodes.get(currentNode.left);
						break;
				}
				result++;


				if(currentNode.value.equals("ZZZ")) {
					break;
				}
			}
		}
		return result;
	}

	private static long LCM(long a, long b) {
		return (a * b) / GCD(a, b);
	}

	private static long GCD(long number1, long number2) {
		if (number1 == 0 || number2 == 0) {
			return number1 + number2;
		} else {
			long absNumber1 = Math.abs(number1);
			long absNumber2 = Math.abs(number2);
			long biggerValue = Math.max(absNumber1, absNumber2);
			long smallerValue = Math.min(absNumber1, absNumber2);
			return GCD(biggerValue % smallerValue, smallerValue);
		}
	}

	private static int countStepFromAAAToZZZ(String input, Map<String, Node> networkNodes) {

		int result = 0;
		Node currentNode = networkNodes.get("AAA");

		while(!currentNode.value.equals("ZZZ")) {

			for(Character c : input.toCharArray()) {

				switch(c) {
					case 'R':
						currentNode = networkNodes.get(currentNode.right);
						break;
					case 'L':
						currentNode = networkNodes.get(currentNode.left);
						break;
				}
				result++;


				if(currentNode.value.equals("ZZZ")) {
					break;
				}
			}
		}
		return result;
	}

	private static class Node {

		private String value;
		private String left;
		private String right;

		public Node(String value, String left, String right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
