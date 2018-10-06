
import java.util.*;

public class Insertion {

	private static boolean less(Comparable v, Comparable w) {
		// System.out.println("V : " + (Team)v + " \t And : " + (Team)w);
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
		// System.out.println("Swapped : " + (Team) a[i] + "\t and : " + (Team) a[j]);
	}

	/**
	 * Sorts the elements using insertion sort.
	 * @param a contains elements that are to be sorted.
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less (a[j], a[j-1])) {
					exch(a, j, j-1);
				} else
					break;
			}
		}
	}
}





// England		4,2,3
// India		5,2,4
// Australia	6,2,3
// SouthAfrica	5,3,4
// Bangladesh	3,4,2
// Zimbabwe		3,4,6
// Ireland		3,4,1




