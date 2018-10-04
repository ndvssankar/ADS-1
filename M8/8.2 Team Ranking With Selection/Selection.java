
import java.util.*;

public class Selection {

	private static int minIndexElement(Comparable[] a, int index) {
		int min = index;
		int N = a.length;
		for (int i = min + 1; i < N; i++) {
			if (less (a[i], a[min]))
				min = i;
		}
		return min;
	}

	private static boolean less(Comparable v, Comparable w) {
		System.out.println("V : " + (Team)v + " \t And : " + (Team)w);
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
		System.out.println("Swapped : " + (Team) a[i] + "\t and : " + (Team) a[j]);
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int minIndex = minIndexElement(a, i);
			exch(a, i, minIndex);
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




