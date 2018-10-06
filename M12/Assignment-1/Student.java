import java.util.Date;
import java.text.SimpleDateFormat;

public class Student implements Comparable<Student> {
	private String studentName;
	private Date db;
	private int m1;
	private int m2;
	private int m3;
	private int tm;
	private String rc;
	private boolean alloted;
	 
	public boolean getAlloted() {
	    return alloted;
	}
	 
	public void setAlloted(boolean alloted) {
	    this.alloted = alloted;
	}

	public Date getDb() {
	    return db;
	}
	 
	public void setDb(Date db) {
	    this.db = db;
	}

	public String getRc() {
	    return rc;
	}
	 
	public void setRc(String rc) {
	    this.rc = rc;
	}

	public int getTm() {
	    return tm;
	}
	 
	public void setTm(int tm) {
	    this.tm = tm;
	}

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

	public int getM3() {
		return m3;
	}

	public void setM3(int m3) {
		this.m3 = m3;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

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

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getStudentName() + ",");
		sb.append(this.getTm() + ",");
		sb.append(this.getRc() + ",");
		sb.append(this.getAlloted());
		return sb.toString();
	}
}