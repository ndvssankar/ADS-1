import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class to demonstrate the merge sort.
 * @author Siva Sankar
 */

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String[] numbers = scan.nextLine().split(",");
			Merge.sort(numbers);
			System.out.println(Arrays.toString(numbers));
			System.out.println();
		}
	}
}