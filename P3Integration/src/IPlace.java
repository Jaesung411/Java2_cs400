// --== CS400 Project Three File Header ==--
// Name: Kusum Gautam
// CSL Username: kusum
// Email: kgautam3@wisc.edu
// Lecture #: 001
// Notes to Grader: <any optional extra notes to your grader>

/**
 * Instances of classes that implement this interface represent a single
 * place object that can be stored and searched for based on
 * these accessors below.
 */
public interface IPlace extends Comparable<IPlace> {

// constructor args (int ID, String Name, Boolean isDining, double X, double Y, double Z, int[] connections)

  String getName(); // retrieve the name of the place
  int getID(); // return the unique ID of the place
  boolean checkIsDining(); // returns true if place is a dining hall
  int[] connectedTo(); // returns a string of the ID's of the places directly connected to the this
  double getX(); // return X coordinate of the place
  double getY(); // return Y coordinate of the place
  double getZ(); // return Z coordinate of the place

}