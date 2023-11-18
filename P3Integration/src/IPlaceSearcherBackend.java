import java.util.ArrayList;

// Email: <jlim83@wisc.edu>
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>

public interface IPlaceSearcherBackend {

        /**
         * get the shortest path from the given starting place to the given ending place
         * @param start the given starting place
         * @param end the given ending place
         * @return the shortest path from the staring place to the ending place
         */
        public DijkstraGraph<IPlace>.Path returnPath(IPlace start, IPlace end);

        /**
         * save all the places in the graph
         * @return the list of the places
         */
        public ArrayList<IPlace> returnAllPlaces();

}