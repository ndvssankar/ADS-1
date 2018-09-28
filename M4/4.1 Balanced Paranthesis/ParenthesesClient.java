
import java.util.*;

public class ParenthesesClient {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(scan.nextLine());
		for (int i=0; i<numberOfTestCases; i++) {
			String line = scan.nextLine();
			Stack<Character> stack = new Stack<Character>();
			int j = 0;
			for (j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				if (ch == '(' || ch == '[' || ch == '{') {
					stack.push(ch);
				} else if (stack.isEmpty() == false) {
					if (ch == ')' && stack.peek() == '(')
						stack.pop();
					else if (ch == ']' && stack.peek() == '[')
						stack.pop();
					else if (ch == '}' && stack.peek() == '{')
						stack.pop();
				} else {
					break;
				}
			}
			if (line.length() == j && stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
 	}
}