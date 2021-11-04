/**
 * CourseDBElement implements Comparable, and consists of five attributes:
 * the Course ID (a String), the CRN (an int), the number of credits (an int), the room number (a String), and the instructor name (a String).
 * Normally the CourseDBElement will be an object consisting of these five attributes, and is referred to as a CDE.
 * 
 * @author Justin Hixson
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		id = "";
		crn = 0;
		credits = 0;
		roomNum = "";
		instructor = "";
	}
	/**
	 * Constructor
	 * @param id the course ID
	 * @param crn the course number
	 * @param credits the number of credits
	 * @param roomNum the room number
	 * @param instructor the instructor's name
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	/**
	 * Returns the CRN
	 * @return the CRN
	 */
	public int getCRN() {
		return crn;
	}
	/**
	 * Sets the CRN
	 * @param crn the new CRN
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	/**
	 * Returns hashcode of CRN
	 * @return hashcode of CRN
	 */
	@Override
	public int hashCode() {
		return ("" + crn).hashCode();
	}
	/**
	 * Compares two CourseDBElements' hashcode
	 * @return 1 if first CDE's CRN is greater than, -1 if less than, or 0 if equal to second CDE's hashcode
	 */
	@Override
	public int compareTo(CourseDBElement cde) {
		if (hashCode() < cde.hashCode()) {
			return -1;
		}
		else if (hashCode() > cde.hashCode()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	/**
	 * CourseDBElement toString
	 * @return CDE toString
	 */
	@Override
	public String toString() {
		return "Course:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
	}
}