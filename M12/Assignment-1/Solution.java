import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int noCategry = Integer.parseInt(scan.nextLine());
		int noOfBC = Integer.parseInt(scan.nextLine());
		int noOfSC = Integer.parseInt(scan.nextLine());
		int noOfST = Integer.parseInt(scan.nextLine());

		Student[] students = new Student[N];

		int count = 0;
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			students[count++] = new Student(
			    tokens[0], tokens[1], Integer.parseInt(tokens[2]),
			    Integer.parseInt(tokens[3]),
			    Integer.parseInt(tokens[4]),
			    Integer.parseInt(tokens[5]),
			    tokens[6]);
		}

		Insertion.sort(students);
		print(students);

		allotment(students, vacancies, noCategry, noOfBC,
		          noOfSC, noOfST);
		// print(students);
	}

	public static void print(Student[] students) {
		for (Student student : students)
			System.out.println(student);
		System.out.println();
	}

	public static void allotment(Student[] students,
	                             int vacancies, int noCategry, int noBC,
	                             int noSC, int noST) {
		int i = 0;
		int k = 0;
		int N = students.length;
		Student[] alloted = new Student[vacancies];

		for (i = 0; i < N; i++) {
			if (vacancies == 0)
				break;

			if (noCategry > 0) {
				noCategry--;
				students[i].setAlloted(true);
				// System.out.println(students[i]);
				alloted[k++] = students[i];
				vacancies--;
			}

			if (noBC > 0) {
				if (students[i].getRc().equals("BC") &&
				        students[i].getAlloted() != true) {
					noBC--;
					students[i].setAlloted(true);
					// System.out.println(students[i]);
					alloted[k++] = students[i];
					vacancies--;
				}
			}
			if (noSC > 0) {
				if (students[i].getRc().equals("SC") &&
				        students[i].getAlloted() != true) {
					noSC--;
					students[i].setAlloted(true);
					// System.out.println(students[i]);
					alloted[k++] = students[i];
					vacancies--;
				}
			}
			if (noSC > 0) {
				if (students[i].getRc().equals("ST") &&
				        students[i].getAlloted() != true) {
					noST--;
					students[i].setAlloted(true);
					// System.out.println(students[i]);
					alloted[k++] = students[i];
					vacancies--;
				}
			}
		}
		for (i = 0; i < N; i++) {
			if (vacancies > 0 && students[i].getRc().equals("Open") &&
			        students[i].getAlloted() == false) {
				students[i].setAlloted(true);
				// System.out.println(students[i]);
				alloted[k++] = students[i];
				vacancies--;
			}
		}
		Insertion.sort(alloted);
		for (Student student : alloted) {
			System.out.println(student);
		}
	}
}