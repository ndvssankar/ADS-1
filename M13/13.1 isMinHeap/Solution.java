import java.util.Scanner;
import java.util.Arrays;
/**
 * To find out the array elements are arranged in MinPQ.
 * @author Siva Sankar
 */

public final class Solution {
	/**
	 * default constructor.
	 */
	private Solution() {

	}

	/**
	 * To demonstrate the solution method.
	 * @param args the command line args.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		int N = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= N; i++) {
			switch (type) {
				case "String":
					MinPQ<String> minPQ = new MinPQ(scan.nextLine().split(","));
					System.out.println(minPQ.isMinPQ());
				break;
				case "Integer":
					String[] tokens = scan.nextLine().split(",");
					Integer[] ints = new Integer[tokens.length+1];
					int j = 1;
					ints[0] = 0;
					for (String token : tokens) {
						ints[j++] = Integer.parseInt(token);
					}
					MinPQ<Integer> intPQ = new MinPQ<Integer>(ints);
					System.out.println(intPQ.isMinPQ());
				break;
				case "Double":
					tokens = scan.nextLine().split(",");
					Double[] doubles = new Double[tokens.length+1];
					j = 1;
					doubles[0] = 0.0;
					for (String token : tokens) {
						doubles[j++] = Double.parseDouble(token);
					}
					MinPQ<Double> doublePQ = new MinPQ<Double>(doubles);
					System.out.println(doublePQ.isMinPQ());
				break;
				case "Float":
					String line = scan.nextLine();
					if (line.length() == 0) {
						System.out.println(false);
						break;
					}
					tokens = line.split(",");
					Float[] floats = new Float[tokens.length+1];
					j = 1;
					floats[0] = 0.0f;
					for (String token : tokens) {
						floats[j++] = Float.parseFloat(token);
					}
					MinPQ<Float> floatPQ = new MinPQ<Float>(floats);
					System.out.println(floatPQ.isMinPQ());
				break;
				default:
				break;
			}
		}
	}
}