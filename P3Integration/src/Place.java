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
public class Place implements IPlace{

  private int id;
  private String name;
  private boolean isDining;
  private double x;
  private double y;
  private double z;
  private int[] connections;


  // constructor args (int ID, String Name, Boolean isDining, double X, double Y, double Z, int[] connections)
  public Place(int id, String name, boolean isDining, double x, double y, double z, int[] connections) {

    this.id = id;
    this.name = name;
    this.isDining = isDining;
    this.x = x;
    this.y = y;
    this.z = z;
    this.connections = connections;

  }


  // retrieve the name of the place
  @Override
  public String getName() {
    return this.name;
  }

  // return the unique ID of the place
  @Override
  public int getID() {
    return this.id;
  }

  // returns true if place is a dining hall
  @Override
  public boolean checkIsDining() {
    return this.isDining;
  }

  // returns a string of the ID's of the places directly connected to the this
  @Override
  public int[] connectedTo() {
    return this.connections;
  }

  // return X coordinate of the place
  @Override
  public double getX() {
    return this.x;
  }

  // return Y coordinate of the place
  @Override
  public double getY() {
    return this.y;
  }

  // return Z coordinate of the place
  @Override
  public double getZ() {
    return this.z;
  }

  @Override
  public int compareTo(IPlace o) {
    return 0;
  }
}