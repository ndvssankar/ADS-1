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
 * @author Siva Sankar
 */
public class Student implements Comparable<Student> {
    private String studentName;
    private Date db;
    private int m1;
    private int m2;
    private int m3;
    private int tm;
    private String rc;
    private boolean alloted;
    
    /**
     * returns true, if the student is already alloted,
     * otherwise false.
     * 
     * @return true if alloted, otherwise false.
     */
    public boolean getAlloted() {
        return alloted;
    }

    /**
     * Changes the alloted status to true once the allotment is done.
     * @param alloted should be either true or false.
     */
    public void setAlloted(boolean alloted) {
        this.alloted = alloted;
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
     * @param db [description]
     */
    public void setDb(Date db) {
        this.db = db;
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
     * @param rc.
     */
    public void setRc(String rc) {
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
    public void setTm(int tm) {
        this.tm = tm;
    }

    /**
     * Constructs the object based on the parameters.
     * @param  studentName Student Name
     * @param  dateOfBirth Date of Birth
     * @param  m1          Marks in first subject.
     * @param  m2          Marks in second subject.
     * @param  m3          Marks in third subject.
     * @param  tm          Total Marks.
     * @param  rc          Reservation Category.
     */
    public Student(String studentName, String dateOfBirth,
                   int m1, int m2, int m3, int tm,
                   String rc) {
        this.studentName = studentName;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);   
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.tm = tm;
        this.rc = rc;
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
     * @param m3.
     */
    public void setM3(int m3) {
        this.m3 = m3;
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
     * @param m2.
     */
    public void setM2(int m2) {
        this.m2 = m2;
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
     * @param m1.
     */
    public void setM1(int m1) {
        this.m1 = m1;
    }

    /**
     * Gets the student name.
     * @return the student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * When required the student's name can be updated.
     * @param studentName.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Compares two objects of types students.
     * @param  that second Student.
     * @return integer based on the requirements.
     */
    public int compareTo(Student that) {
        if (this.getTm() > that.getTm()) return -1;
        if (this.getTm() < that.getTm()) return 1;

        if (this.getM3() > that.getM3()) return -1;
        if (this.getM3() < that.getM3()) return 1;

        if (this.getM2() > that.getM2()) return -1;
        if (this.getM2() < that.getM2()) return 1;

        if (this.getDb().compareTo(that.getDb()) < 0) return 1;
        if (this.getDb().compareTo(that.getDb()) > 0) return -1;
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