import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
/*
 *  List class
 *    
 *  A List is an ordered collection of any kind of Object.
 * 
 *  Operations:
 *     AddToEnd    Add a given object to the end of the list.
 *     Print       Print (to standard output) the objects in the list in order,
 *                 enclosed in square brackets, separated by spaces.
 */
public class List {
  private static final int INIT_LEN = 10;
  private Object [] items;  // the actual items
  private int numItems;     // the number of items currently in the list
  private int currentObject ; //  a pointer to the current object
  
  /*
   * constructor: initialize the list to be empty
   */
  public List()
  {
    items = new Object [INIT_LEN];
    numItems = 0;
  }

  /*
   * AddToEnd
   *
   * Given: Object ob
   * Do:    Add ob to the end of the list.
   */
  public void AddToEnd(Object ob)
  {

      items[numItems] = ob ;
      numItems++ ;
      currentObject = numItems ;
  }
  
  /*
   * Print
   *
   * Print (to standard output) the objects in the list in order, enclosed in
   * square brackets, separated by spaces.
   */
  public void Print()
  {
    System.out.print("[") ;
    for (int i =0; i<numItems; i++)
    {
      System.out.print(items[i]+ " ");
    }

    System.out.println("]");

  }

  // set the current object to first element in items array
  public void firstElement()
  {
    currentObject = 0 ;
  }

  // which returns the current object, and 
  // also updates the currentObject field to "point to" the next object in the list
  public Object nextElement()
  {
    Object ob = items[currentObject] ; // assign the current object to ob
    currentObject++ ; // update the currentObject

    return ob ; // return the current object
  }

  /*
  Add method hasMoreElements, which returns true iff the list is not empty and the 
  current-object "pointer" hasn't "fallen off" the end of the list (i.e., if there 
  are still more items in the list that haven't been accessed yet). Note that this 
  method should return true when the current-object "pointer" is pointing to the last 
  object in the list -- it should only return false when the list is empty or the 
  current-object pointer has "fallen off" the end of the list.
  */

  public boolean hasMoreElements()
  {
    boolean tf = false ;
    if(numItems!=0 && numItems>=currentObject)
    {
      tf = true ;
    }
    return tf ;
  }

// make and write output to file
  public void WriteToFile()
  {
    // Make the file
    try {
      File myObj = new File("output.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    // Write to the file

    try 
    {
      FileWriter myWriter = new FileWriter("output.txt");
      myWriter.write("[");
      for (int i = 0; i<numItems; i++)
      {
        myWriter.write(items[i]+ " ");
      }
      myWriter.write("]"+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } 
    catch (IOException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

  // the main function

  public static void main( String [] args )
  {

    List L1 = new List();
    L1.AddToEnd(10);
    L1.AddToEnd(4);
    L1.AddToEnd(5);
    L1.AddToEnd(6);
    L1.AddToEnd(7);
    L1.AddToEnd(8);
    L1.AddToEnd(9); 

    L1.WriteToFile() ;

  }
}
