import java.util.Scanner;
import java.util.Iterator;

/**
 * Adding of two Large numbers.
 * @author Siva Sankar
 */
class AddLargeNumbers {

    /**
     * Private Constructor.
     */
    private AddLargeNumbers() {

    }
    /**
     * TEN represents a constant that indicates Integer 10.
     */
    public static final int TEN = 10;

    /**
     * Converting the number to digits.
     * @param  number a String version of the number.
     * @return returns the list contains the digits where each
     * digit is a node.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList<String> ll = new LinkedList<String>();
        for (int i = 0; i < number.length(); i++) {
            ll.insert(number.charAt(i) + "");
        }
        return ll;
    }

    /**
     * Converting digits to number.
     * @param  list containing the digits
     * @return the String version of the list
     */
    public static String digitsToNumber(final LinkedList<String> list) {
        return list.toString();
    }

    /**
     * Converting the list to stack.
     * @param  lst list containing the digits.
     * @return the stack that contains digits.
     */
    public static Stack<Integer> createStack(final LinkedList<String> lst) {
        Stack<Integer> stack = new Stack<Integer>();
        Iterator<String> iter = lst.iterator();
        while (iter.hasNext()) {
            try {
                stack.push(Integer.parseInt(iter.next()));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return stack;
    }

    /**
     * Adding large numbers.
     * @param  list1 list containing digits of the first number.
     * @param  list2 list containing digits of the second number.
     * @return returns the list containing the digits of result.
     */
    public static LinkedList addLargeNumbers(final LinkedList<String> list1,
            final LinkedList<String> list2) {
        Stack<Integer> aStack = createStack(list1);
        Stack<Integer> bStack = createStack(list2);
        LinkedList<String> result = new LinkedList<String>();
        int flag = 0;
        while (!(aStack.isEmpty() && bStack.isEmpty())) {
            int a = 0;
            int b = 0;
            if (!aStack.isEmpty()) {
                a = aStack.pop();
            }

            if (!bStack.isEmpty()) {
                b = bStack.pop();
            }

            int sum = a + b + flag;
            if (sum >= TEN) {
                flag = 1;
                sum = sum - TEN;
            } else {
                flag = 0;
            }
            result.pushFront(sum + "");
        }
        if (flag == 1) {
            result.pushFront(flag + "");
        }
        return result;
    }
}

/**
 * Solution class to demonstrate the addition of two big numbers.
 */
public final class Solution {

    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * Main Method...
     * @param args command line args
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList<String> pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList<String> qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList<String> result = AddLargeNumbers.addLargeNumbers(pDigits,
                                        qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }
}
