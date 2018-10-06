import java.util.*;

/**
 * This class demostrates the insertion sort which is used to sort
 * the comparable elements .
 * @author Siva Sankar.
 */
public final class Insertion {

    /**
     * Insertion sort.
     */
    private Insertion() {

    }

    /**
     * This method compares two comparable objects and returns
     * true if the first object is less than second object.
     * @param  v the first object.
     * @param  w the second object.
     * @return   boolean if the first object is less than second object.
     */
    private static boolean less(final Comparable v,
                                final Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * swaps two elements in the specified array.
     * @param a the array.
     * @param i the ith index position.
     * @param j the jth index position.
     */
    private static void exch(Comparable[] a, final int i,
                             final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Sorts the elements using insertion sort.
     * @param a contains elements that are to be sorted.
     */
    public static void sort(final Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less (a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else
                    break;
            }
        }
    }
}
