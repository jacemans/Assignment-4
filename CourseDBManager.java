import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Implements the CourseDBManagerInterface that is provided.
 * The data manager allows the user to read the courses from a file or to enter the data by hand, and uses an Alert to print out the database elements.
 * The input is read from a file or read from the textfields and is added to the data structure through the add method. The add method uses the CDS add method.
 * 
 * @author Justin Hixson
 */
public class CourseDBManager implements CourseDBManagerInterface {
	
	private static final String FILE = "courses.txt";
	CourseDBStructure cds = new CourseDBStructure();
	/**
	 * Adds new CDE to CDS
	 * @param id the course ID
	 * @param crn the course number
	 * @param credits the number of credits
	 * @param roomNum the room number
	 * @param instructor the instructor's name
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		cds.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	/**
	 * Returns CDE with this CRN
	 * @param crn the course number being searched
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		} catch (IOException e) {
			return null;
		}
	}
	/**
	 * Reads and prints from a file
	 * @param input the file being read
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scan = new Scanner(new java.io.FileInputStream(FILE));
		while (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		scan.close();
	}
	/**
	 * ArrayList of CDE toStrings
	 * @return arraylist of CDE toStrings
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
}