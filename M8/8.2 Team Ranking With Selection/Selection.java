
import java.util.*;

public class Selection {

	private static int minIndexElement(Comparable[] a, int index) {
		int min = index;
		int N = a.length;
		for (int i = min + 1; i < N; i++)
			if (less (a[i], a[min]))
				min = i;

		return min;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int minIndex = minIndexElement(a, i);
			System.out.println("Min Index is : " + minIndex);
			exch(a, i, minIndex);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// int N = Integer.parseInt(scan.nextLine());
		// Team[] teams = new Team[N];
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