import java.util.Hashtable;

/**
 * The Library class is a specific type of Building
 * It does have a collection of books
 */
public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for Library Class
   * @param name library name
   * @param address library address
   * @param nFloors library number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  /**
   * Adds a book to the collection by title and marks it as available
   * @param title book title to add
   */
  public void addTitle(String title) {
    collection.put(title, true);
    System.out.println(title + " added to collection.");
  }

  /**
    * Removes the book from the collection
    * @param title book title to remove
    * @return title removed, otherwise null
    */
  public String removeTitle(String title) {
    if (collection.containsKey(title)) {
      collection.remove(title);
      System.out.println(title + " removed from collection.");
      return title;
    } else {
      System.out.println(title + " unable to remove.");
      return null;
    }
  }

  /**
   * Checks out a book by marking it unavailable
   * @param title book title to check out
   */
  public void checkOut(String title) {
    if (collection.containsKey(title) && collection.get(title)) {
      collection.replace(title, false);
      System.out.println(title + " checked out.");
    } else {
      System.out.println(title + " unavailable for check out.");
    }
  }

  /**
   * Returns a book and mark it available
   * @param title the title of the book to return
   */
  public void returnBook(String title) {
      if (collection.containsKey(title)) {
        collection.replace(title, true);
        System.out.println(title + " checked in.");
      } else {
        System.out.println(title + " doesn't exist in collection.");
      }
  }

  /**
   * Checks if the library contains a given book
   * @param title the title to check
   * @return true if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(String title) {
    System.out.println("The collection have " + title + "? " + collection.containsKey(title));
    return collection.containsKey(title);
  }

  /**
   * Checks if the book is available
   * @param title the title to check
   * @return true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title) {
    boolean availability = collection.containsKey(title) && collection.get(title);
    System.out.println(title + " is available? " + availability);
    return availability;
  }

  /**
   * Prints out the entire collection in an easy-to-read way (including checkout status)
   */
  public void printCollection() {
    System.out.println("\n" + name + " Collection:");
    for (String title : collection.keySet()) {
      boolean value = collection.get(title);
      String status; // define variable before if-else statement for accessing
      if (value == true) {
        status = "Available";
      } else {
        status = "Unavailable";
      }
      System.out.println("- \"" + title + "\" [" + status + "]");
    }
    System.out.println(" "); // add a single new line
  }

  /**
   * Main method for testing the Library class.
   */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive", 5);
    neilson.addTitle("The Lorax by Dr. Seuss");
    neilson.addTitle("Thinking About History by Sarah Maza");

    neilson.printCollection();
    neilson.removeTitle("Thinking About History by Sarah Maza");
    neilson.containsTitle("Thinking About History by Sarah Maza");
    neilson.isAvailable("Thinking About History by Sarah Maza");
    neilson.removeTitle("Thinking About History by Sarah Maza");
    neilson.returnBook("Thinking About History by Sarah Maza");
    
    neilson.isAvailable("The Lorax by Dr. Seuss");
    neilson.checkOut("The Lorax by Dr. Seuss");
    neilson.isAvailable("The Lorax by Dr. Seuss"); 
    neilson.checkOut("The Lorax by Dr. Seuss");
    neilson.printCollection();

    neilson.returnBook("The Lorax by Dr. Seuss");
    neilson.printCollection();


  }
  
}