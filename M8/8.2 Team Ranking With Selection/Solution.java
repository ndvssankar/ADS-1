import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class for team sorting.
 * @author Siva Sankar
 */
public final class Solution {
	/**
	 * main method to demonstrate
	 * @param args command line args
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		StringBuffer sb = new StringBuffer();
		while(scan.hasNext()) {
			sb.append(scan.nextLine() + "::");
		}
		String[] lines = sb.toString().split("::");
		Team[] teams = new Team[lines.length];
		for (String line : lines) {
			String[] tokens = line.split(",");
			teams[i++] = new Team(tokens[0],
				Integer.parseInt(tokens[1]),
				Integer.parseInt(tokens[2]),
				Integer.parseInt(tokens[3]));
		}
		Selection.sort(teams);
		String output = Arrays.toString(teams).replace("[","").replace("]","").replace(", ", ",");
		System.out.println(output);
	}
}