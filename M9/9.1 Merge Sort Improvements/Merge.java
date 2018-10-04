/**
 * Merge class to demonstrate mergesort.
 */
public class Merge {

	private static final int CUTOFF = 7;

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)				aux[k] = a[j++];
			else if (j > hi)			aux[k] = a[i++];
			else if (less (a[j], a[i])) aux[k] = a[j++];
			else						aux[k] = a[i++];
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void insertionSort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1])) {
					exch(a, j, j-1);
				} else {
					break;
				}
			}
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo + CUTOFF) {
			insertionSort(aux, lo, hi);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		if (!less(a[mid + 1], a[mid])) {
			System.arraycopy(a, lo, aux, lo, hi - lo + 1);
			return;
		}
		merge(a, aux, lo, mid, hi);
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length-1);
	}
}