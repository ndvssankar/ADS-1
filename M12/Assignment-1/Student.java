import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Students class that uses Comaprable to sort the student objects.
 * student who got more total marks will be given the priority
 * if total marks are equal then student who got more marks
 * in subject 3 will be given the priority.
 * if subject 3 marks are equal then student who got more marks
 * in subject 2 will be given the priority.
 * if subject 2 marks are equal then younger student
 * will be given priority.
 * @author Siva Sankar.
 */
public final class Student implements Comparable<Student> {

    /**
     * Student's name.
     */
    private String studentName;

    /**
     * Student's Date of birth.
     */
    private Date db;

    /**
     * Marks in subject 1.
     */
    private int m1;

    /**
     * Marks in subject 2.
     */
    private int m2;

    /**
     * Marks in subject 3.
     */
    private int m3;

    /**
     * Total marks.
     */
    private int tm;

    /**
     * Reservation category.
     */
    private String rc;

    /**
     * Allotment status.
     */
    private boolean alloted;

    /**
     * returns true, if the student is already alloted,
     * otherwise false.
     * @return true if alloted, otherwise false.
     */
    public boolean getAlloted() {
        return alloted;
    }

    /**
     * Changes the alloted status to true once the allotment is done.
     * @param allot should be either true or false.
     */
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }

    /**
     * Gets the data of birth.
     * @return date of birth.
     */
    public Date getDb() {
        return db;
    }

    /**
     * sets the student's date of birth.
     * @param dateOfBirth Date of birth.
     */
    public void setDb(final Date dateOfBirth) {
        this.db = dateOfBirth;
    }

    /**
     * gets the date of birth.
     * @return the student's date of birth.
     */
    public String getRc() {
        return rc;
    }

    /**
     * Sets the student's reservation category.
     * @param rc Reservation Category.
     */
    public void setRc(final String rc) {
        this.rc = rc;
    }

    /**
     * gets the total marks.
     * @return returns the total marks of the student.
     */
    public int getTm() {
        return tm;
    }

    /**
     * sets the student's total marks.
     * @param tm.
     */
    public void setTm(final int tm) {
        this.tm = tm;
    }

    /**
     * Constructs the object based on the parameters.
     * @param  stuName Student Name.
     * @param  dateOfBirth Date of Birth.
     * @param  marksInFirstSubject Marks in first subject.
     * @param  marksInSecondSubject Marks in second subject.
     * @param  marksInThirdSubject Marks in third subject.
     * @param  totalMarks  Total Marks.
     * @param  resCat      Reservation Category.
     */
    public Student(final String stuName,
                   final String dateOfBirth,
                   final int marksInFirstSubject,
                   final int marksInSecondSubject,
                   final int marksInThirdSubject,
                   final int totalMarks,
                   final String resCat) {
        this.studentName = stuName;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.m1 = marksInFirstSubject;
        this.m2 = marksInSecondSubject;
        this.m3 = marksInThirdSubject;
        this.tm = totalMarks;
        this.rc = resCat;
        this.alloted = false;
    }

    /**
     * Gets the marks in subject 3.
     * @return m3 Marks in subject 3.
     */
    public int getM3() {
        return m3;
    }

    /**
     * Sets the m3 to the 3rd subject.
     * @param marks in third subject.
     */
    public void setM3(final int marks) {
        this.m3 = marks;
    }

    /**
     * Gets the marks in subject 2.
     * @return marks in subject 2.
     */
    public int getM2() {
        return m2;
    }

    /**
     * Sets marks in subject 2.
     * @param marks in second subject.
     */
    public void setM2(final int marks) {
        this.m2 = marks;
    }

    /**
     * Gets the marks in subject 1.
     * @return marks in subject 1.
     */
    public int getM1() {
        return m1;
    }

    /**
     * Sets the marks to subject 1.
     * @param marks Marks in first subject.
     */
    public void setM1(final int marks) {
        this.m1 = marks;
    }

    /**
     * Gets the student name.
     * @return the student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student name.
     * @param sName specifies student's name.
     */
    public void setStudentName(final String sName) {
        this.studentName = sName;
    }

    /**
     * Compares two objects of types students.
     * @param  that Student.
     * @return integer based on the requirements.
     */
    public int compareTo(final Student that) {

        if (this.getTm() > that.getTm()) {
            return -1;
        }

        if (this.getTm() < that.getTm()) {
            return 1;
        }

        if (this.getM3() > that.getM3()) {
            return -1;
        }

        if (this.getM3() < that.getM3()) {
            return 1;
        }

        if (this.getM2() > that.getM2()) {
            return -1;
        }

        if (this.getM2() < that.getM2()) {
            return 1;
        }

        if (this.getDb().compareTo(that.getDb()) < 0) {
            return 1;
        }

        if (this.getDb().compareTo(that.getDb()) > 0) {
            return -1;
        }

        return 0;
    }

    /**
     * Gets the String version of the Students.
     * @return String version of object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTm() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}
