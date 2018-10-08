import java.util.Scanner;

public class MinPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;

	public MinPQ() {

	}

	public MinPQ(Key[] minPQ) {
		this.pq = minPQ;
		N = minPQ.length-1;
	}

	public MinPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}

	public void insert(Key key) {
		pq[++N] = key;
		swim(N);
	}

	public Key delMin() {
		Key key = pq[N];
		exch (1, N--);
		sink(1);
		return key;
	}

	public Key min() {
		return pq[1];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void sink(int k) {
		while ((2 * k) <= N) {
			int j = 2 * k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch (k, j);
			k = j;
		}
	}

	public void swim(int k) {
		while (k > 1 && less(k, k/2)) {
			exch(k/2, k);
			k = k / 2;
		}
	}

	public boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) <= 0;
	}

	public void exch(int i, int j) {
		Key k = pq[i];
		pq[i] = pq[j];
		pq[j] = k;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < N; i++) {
			sb.append(pq[i] + ", ");
		}
		sb.append(pq[N]);
		return sb.toString();
	}

	public boolean isMinPQ(int k) {
		if (k > N) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left <= N && !less(k, left)) return false;
		if (right <= N && !less(k, right)) return false;
		return isMinPQ(left) && isMinPQ(right);
	}

	public boolean isMinPQ() {
		return isMinPQ(1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// int N = scan.nextInt();
		Integer[] ints = {0, -1, 2, 13, 11, 4, 15, 14};
		MinPQ<Integer> minPQ = new MinPQ(ints);
		// while(scan.hasNext()) {
		// 	minPQ.insert(scan.nextInt());
		// }
		System.out.println(minPQ);
		System.out.println(minPQ.isMinPQ());
	}
}