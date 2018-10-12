import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		System.out.println(Taxicab.findTaxiCab(N, M));
	}
}