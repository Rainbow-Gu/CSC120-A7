import java.util.ArrayList;

/**
 * The House class is a specific type of Building 
 * A place where students live, work, and sometimes eat (if the House has a dining room)
 */
public class House extends Building implements HouseRequirements {
  
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
   * Constructor for House class
   * @param name house name
   * @param address house address
   * @param nFloors house number of floors
   * @param hasDiningRoom whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /** 
   * Accessor for whether the house have a dining room
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /** 
   * Accessor for number of residents
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Add a student to the list of residents
   * @param s the student/resident to move in
   */
  public void moveIn(Student s) {
    if (!residents.contains(s)) {
      residents.add(s);
      System.out.println(s + " moved in.");
    } else {
      System.out.println(s + " is already a resident.");
    }
  }

  /** 
   * Remove a student from the list and return them
   * @param s the student/resident to move out
   * @return s the student who had moved out
   */
  public Student moveOut(Student s) {
    if (residents.contains(s)) {
      residents.remove(s);
      System.out.println(s + " moved out.");
      return s;
    } else {
      System.out.println(s + " is not a resident.");
      return null;
    }
  }

  /** 
   * Check if a student is a resident
   * @param s the student to check
   * @return true if the student is a resident; false otherwise
   */ 
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  /**
   * Main method for testing the House class
   */
  public static void main(String[] args) {
    House washburn = new House("Washburn", "5 Seelye Drive", 3, false);
    Student emily = new Student("Emily", "991345627", 2028);
    washburn.moveIn(emily);
    washburn.moveIn(emily);
    System.out.println("There is a dining room: " + washburn.hasDiningRoom());
    System.out.println("Number of residents: " + washburn.nResidents());
    System.out.println("Is Emily a resident? " + washburn.isResident(emily));
    washburn.moveOut(emily);
    washburn.moveOut(emily);
  }

}