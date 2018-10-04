
public class Sample {
	public static String addStar(String str, int index) {
		if (str.length()-1 == index) {
			return str;
		} else if (str.charAt(index) == str.charAt(index+1)) {
			str = str.substring(0, index+1) + "*" + str.substring(index+1);
			return addStar(str, index+1);
		} else {
			return addStar(str, index+1);
		}
	}

	public static void main(String[] args) {
		String str = "aabbaaa*a";
		str = addStar(str, 0);
		System.out.println(str);
	}
}