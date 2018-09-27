
import java.util.*;

public class ParenthesesClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(scan.nextLine());
		Stack<Character> stack = new Stack<Character>();
		for (int i=0; i<numberOfTestCases; i++) {
			String line = scan.nextLine();
			int j = 0;
			for (j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				if (ch == '(' || ch == '[' || ch == '{') {
					try {
						stack.push(ch);
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					if (ch == ')') {
						try {
						char popChar = stack.pop();
						if (popChar != '(') {
							System.out.println("NO");
							break;
						}
					} catch (Exception ex) {
						System.out.println("NO");
						break;
					}
					} else if (ch == ']') {
						try {
						char popChar = stack.pop();
						if (popChar != '[') {
							System.out.println("NO");
							break;
						}
					} catch (Exception ex) {
						System.out.println("NO");
						break;
					}
					} else if (ch == '}') {
						try {
						char popChar = stack.pop();
						if (popChar != '{') {
							System.out.println("NO");
							break;
						}
					} catch(Exception ex) {
						System.out.println("NO");
						break;
					}
					}
				}
			}
			if (j == line.length() && stack.isEmpty() == true) {
				System.out.println("YES");
			} else if (j == line.length()) {
				System.out.println("NO");
			}
		}
 	}
}