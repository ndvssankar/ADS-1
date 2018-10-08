import java.util.Scanner;

/**
 * Solution class for alloting the seats based on the given criteria.
 * @author Siva Sankar.
 */
public final class Solution {

    /**
     * Default constructor.
     */
    private Solution() {

    }

    /**
     * main method to demostrate the solution.
     * @param args the command line arguments.
     */
    public static void main(final String[] args) {
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
            students[count] = new Student(
                tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[3]),
                Integer.parseInt(tokens[4]),
                Integer.parseInt(tokens[5]),
                tokens[6]);
            count++;
        }
        Insertion.sort(students);
        print(students);
        allotment(students, vacancies, noCategry, noOfBC,
                  noOfSC, noOfST);
    }

    /**
     * prints the student details to the console.
     * @param students list.
     */
    public static void print(final Student[] students) {
        for (Student student : students)
            System.out.println(student);
        System.out.println();
    }

    /**
     * Alloting the seats to the students based on merit.
     * @param students  list of students.
     * @param vacancies number of vacancies.
     * @param noCategry Un-reserved category.
     * @param noBC      Number of BC seats.
     * @param noSC      Number of SC seats.
     * @param noST      Number of ST seats.
     */
    public static void allotment(final Student[] students,
                                 int vacancies,
                                 int noCategry,
                                 int noBC,
                                 int noSC,
                                 int noST) {
        int i = 0;
        int k = 0;
        int N = students.length;
        Student[] alloted = new Student[vacancies];

        for (i = 0; i < N; i++) {
            if (vacancies == 0) {
                break;
            }

            if (noCategry > 0) {
                noCategry--;
                students[i].setAlloted(true);
                alloted[k] = students[i];
                vacancies--;
                k++;
            }

            if (noBC > 0) {
                if (students[i].getRc().equals("BC")
                        && students[i].getAlloted() != true) {
                    noBC--;
                    students[i].setAlloted(true);
                    alloted[k] = students[i];
                    vacancies--;
                    k++;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("SC")
                        && students[i].getAlloted() != true) {
                    noSC--;
                    students[i].setAlloted(true);
                    alloted[k] = students[i];
                    vacancies--;
                    k++;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("ST")
                        && students[i].getAlloted() != true) {
                    noST--;
                    students[i].setAlloted(true);
                    alloted[k] = students[i];
                    vacancies--;
                    k++;
                }
            }
        }

        for (i = 0; i < N; i++) {
            if (vacancies > 0
                    && students[i].getRc().equals("Open")
                    && students[i].getAlloted() == false) {
                students[i].setAlloted(true);
                alloted[k] = students[i];
                vacancies--;
                k++;
            }
        }

        Insertion.sort(alloted);
        print(alloted);
    }
}
