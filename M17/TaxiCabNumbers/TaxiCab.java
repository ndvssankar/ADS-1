
public class Taxicab implements Comparable<Taxicab> {
    int i;
    int j;
    long sum;

    public Taxicab(int i, int j) {
        this.sum = (long)(i*i*i) + (j*j*j);
        this.i = i;
        this.j = j;
    }

    public int compareTo(Taxicab that) {
        if (this.sum > that.sum) return +1;
        if (this.sum < that.sum) return -1;
        if (this.i > that.i) return +1;
        if (this.i < that.i) return -1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3 + " + j + "^3";
    }

    // public static void main(String[] args) {
    public static long findTaxicab(int N, int M) {
        MinPQ<Taxicab> minPQ = new MinPQ<Taxicab>();
        int n = 600;
        int count = 0;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            minPQ.insert(new Taxicab(i, i));
        }

        Taxicab prev = new Taxicab(0, 0);

        int run = 1;
        while (!minPQ.isEmpty()) {
            Taxicab curr = minPQ.delMin();
            if (prev.sum == curr.sum) {
                run = run + 1;
                // System.out.println(prev + " " + curr);
                if (run == M) {
                    count++;
                    if (count == N) {
                        res = curr.sum;
                        break;
                    }
                }
            } else {
                run = 1;
            }
            if (curr.j < n)
                minPQ.insert(new Taxicab(curr.i, curr.j+1));
            prev = curr;
        }
        return res;
        // System.out.println("Result is : " + res);
    }
}