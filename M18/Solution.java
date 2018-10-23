import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MaxPQ<Stock> best;
		MinPQ<Stock> least;
		BinarySearchST<String, Integer> bestst = new BinarySearchST<String, Integer>();
		BinarySearchST<String, Integer> leastst = new BinarySearchST<String, Integer>();
		int N = Integer.parseInt(scan.nextLine());

		for (int k = 0; k < 6; k++) {
			best = new MaxPQ<Stock>();
			least = new MinPQ<Stock>();
			for (int i = 1; i <= N; i++) {
				String[] tokens = scan.nextLine().split(",");
				best.insert(new Stock(tokens[0], Double.parseDouble(tokens[1])));
				least.insert(new Stock(tokens[0], Double.parseDouble(tokens[1])));
			}
			for (int j=0; j<5; j++) {
				Stock stock = best.delMax();
				System.out.println(stock);
				if (bestst.contains(stock.getStockName()))
					bestst.put(stock.getStockName(), bestst.get(stock.getStockName()) + 1);
				else
					bestst.put(stock.getStockName(), 1);
			}
			System.out.println();
			for (int j=0; j<5; j++) {
				Stock stock = least.delMin();
				if (leastst.contains(stock.getStockName())) {
					leastst.put(stock.getStockName(), leastst.get(stock.getStockName()) + 1);
				} else {
					leastst.put(stock.getStockName(), 1);
				}				
				System.out.println(stock);
			}
			System.out.println();
		}

		int t = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= t; i++) {
			String[] tokens = scan.nextLine().split(",");
			if (tokens[0].equals("get")) {
				if (tokens[1].equals("maxST")) {
					if (bestst.get(tokens[2]) != null)
						System.out.println(bestst.get(tokens[2]));
					else
						System.out.println("0");
				} else {
					if (leastst.get(tokens[2]) != null) {
						System.out.println(leastst.get(tokens[2]));
					}
					else
						System.out.println("0");
				}
			} else {
				intersection(bestst, leastst);
			}
		}
	}

	public static void intersection(BinarySearchST<String, Integer> best,
		BinarySearchST<String, Integer> least) {

		for (int i = 0; i < best.size(); i++) {
			if (least.contains(best.select(i))) {
				System.out.println(best.select(i));
			}
		}
	}
}