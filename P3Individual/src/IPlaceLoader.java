// --== CS400 Project Three File Header ==--
// Name: Kusum Gautam
// CSL Username: kusum
// Email: kgautam3@wisc.edu
// Lecture #: 001
// Notes to Grader: <any optional extra notes to your grader>

import java.util.List;
import java.io.FileNotFoundException;

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
public interface IPlaceLoader {

  /**
   * This method loads the list of places described within a json file.
   *
   * @param filepath is relative to executable's working directory
   * @return a list of place objects that were read from specified file
   */
  List<IPlace> loadPlaces(String filepath) throws FileNotFoundException;

}