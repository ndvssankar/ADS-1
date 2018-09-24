

public class Percolation extends WeightedQuickUnionPathCompressionUF {

	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		super(n * n + 2);
	}

	// open site (row, col) if it is not open already	
	public void open(int row, int col) {

	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {

	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {

	}

	// number of open sites
	public int numberOfOpenSites() {

	}

	// does the system percolate?
	public boolean percolates() {
		return false;
	}

	/**
	 * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input,
	 * where each integer represents some site;
	 * if the sites are in different components, merge the two components
	 * and print the pair to standard output.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		int n = StdIn.readInt();
		Percolation percolation = new Percolation(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (percolation.connected(p, q)) continue;
			percolation.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(percolation.percolates());
	}
}

