import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Implements the CourseDBStructureInterface that is provided. You will be implementing a hash table with buckets.
 * It will be an array of linked lists of CourseDBElements.  Each CDE will have a hash code that comes from the CRN, since the CRN is unique for courses.
 * Note that the CRN is an int, and the tests require the hashcode of a string, so you will need to coerce it to a String, and take the hash code of the resulting string.
 * The add method will take a CourseDBElement and add it to the data structure.
 * If a linked list at the relevant hash code doesn’t exist, create a LinkedList with the first element being the CDE and add it to the HashTable.
 * If the LinkedList already exists, add the CDE to the existing list.
 * Two constructors for the CDS will be required, one that takes in an integer that is the estimated number of courses, the other is used for testing purposes.
 * 
 * @author Justin Hixson
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	
	private int tableSize;
	protected LinkedList<CourseDBElement>[] hashTable;
	/**
	 * Default constructor with table size set to 20
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure() {
		tableSize = 20;
		hashTable = new LinkedList[tableSize];
	}
	/**
	 * Constructor with table size parameter
	 * @param tableSize the table size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int tableSize) {
		this.tableSize = tableSize;
		hashTable = new LinkedList[tableSize];
	}
	/**
	 * Constructor used for testing purposes
	 * @param testing testing string
	 * @param tableSize the table size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int tableSize) {
		this.tableSize = tableSize;
		hashTable = new LinkedList[tableSize];
	}
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added
	*/
	@Override
	public void add(CourseDBElement element) {
		int hash = element.hashCode() % tableSize;
		
		if (hashTable[hash] != null) {
			hashTable[hash].add(element);
		}
		else {
			hashTable[hash] = new LinkedList<>();
			hashTable[hash].add(element);
		}
	}
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param crn the CDE to be added
	* @throws IOException if no CourseDatabaseElement is in the hashtable
	*/
	@Override
	public CourseDBElement get(int crn) throws IOException {
		for (int i = 0 ; i < getTableSize() ; i++) {

			LinkedList<CourseDBElement> list = hashTable[i];

			for (int j = 0 ; j < list.size() ; j++) {
				if (list.get(j).getCRN() == crn) {
					return list.get(j);
				}
			}
		}
		throw new IOException();
	}
	/**
	 * ArrayList of CDE toStrings
	 * @return arraylist of CDE toStrings
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> all = new ArrayList<>();
		for(int i = 0; i < getTableSize(); i++)
		{
			if(hashTable[i] != null)
			{
				LinkedList<CourseDBElement> list = hashTable[i];
				for(CourseDBElement element : list)
				{
					String string = "\n" + element.toString();
					all.add(string);
				}
			}
		}
		return all;
	}
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	* @return the table size
	*/
	@Override
	public int getTableSize() {
		return tableSize;
	}
}