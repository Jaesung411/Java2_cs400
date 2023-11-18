// --== CS400 Project Three File Header ==--
// Name: Kusum Gautam
// CSL Username: kusum
// Email: kgautam3@wisc.edu
// Lecture #: 001
// Notes to Grader: <any optional extra notes to your grader>

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Instances of classes that implement this interface can be used to load a
 * list of places from a specified json source file.
 * The following json columns are used to load these place attributes:
 * - Name: the name of the dorm / dining hall
 * - isDining: true is place is a dining hall, false if dorm
 * - X: x coordinate of the place
 * - Y: y coordinate of the place
 * - Z: elevation
 */

public class PlaceLoader implements IPlaceLoader {

  /**
   * This method loads the list of places described within a json file.
   *
   * @param filepath is relative to executable's working directory
   * @return a list of place objects that were read from specified file
   */
  @Override
  public List<IPlace> loadPlaces(String filepath) throws FileNotFoundException {
    int ID = -1;
    String name = "noname";
    Boolean isDining = false;
    double x = -1.0;
    double y = -1.0;
    double z = -1.0;
    int[] connections;

    List<IPlace> places = new ArrayList<IPlace>();

    try {
      Scanner input = new Scanner(new File(filepath));
      input.nextLine();
      input.nextLine();
      String temp;

      boolean done = false;

      while (!done) {
        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 2);
        ID = Integer.parseInt(temp);

        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 2);
        name = temp;

        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 2);
        isDining = false;
        if (temp.equals("Y"))
          isDining = true;

        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 2);
        connections = connectionsArray(temp);

        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 2);
        x = Double.parseDouble(temp);

        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 2);
        y = Double.parseDouble(temp);

        input.findInLine(": \"");
        temp = input.nextLine();
        temp = temp.substring(0, temp.length() - 1);
        z = Double.parseDouble(temp);

        input.nextLine(); // go to line of next parameter

        places.add(new Place(ID, name, isDining, x, y, z, connections)); // create
        isDining = false;

        if (input.nextLine().equals("]"))
          done = true;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return places;
  }

  private int[] connectionsArray(String connections) {
    String[] input = connections.split(",");
    int[] connectArray = new int[input.length];

    // convert the String into int and save it in int array.
    for (int i = 0; i < input.length; i++) {
      connectArray[i] = Integer.parseInt(input[i]);
    }

    return connectArray;
  }

//  public static void main(String[] args) {
//    PlaceLoader test = new PlaceLoader();
//    try {
//      test.loadPlaces("/Users/kusumgautam/Documents/CS400/places.json");
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }
//
//  }

}