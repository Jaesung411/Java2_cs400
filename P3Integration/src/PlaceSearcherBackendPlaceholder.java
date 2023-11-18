import java.util.ArrayList;

public class PlaceSearcherBackendPlaceholder implements IPlaceSearcherBackend
{

    public static final Place place1 = new Place(0, "test place", true, 20, 40, 90, new int[]{2});
    public static final Place place2 = new Place(1, "another test place", false, 400, 9, 72, new int[]{3,1});
    public static final Place place3 = new Place(2, "food", true, 20, 40, 90, new int[]{4});
    public static final Place place4 = new Place(3, "my favorite place", false, 20, 40, 90, new int[]{2});
    public static final Place place5 = new Place(4, "a location", false, 20, 40, 90, new int[]{0,3});



    //this placeholder backend returns null for path because you can't instantiate Path directly

    @Override
    public DijkstraGraph<IPlace>.Path returnPath(IPlace start, IPlace end)
    {
	return null;
    }

    @Override
    public ArrayList<IPlace> returnAllPlaces()
    {
	ArrayList<IPlace> res = new ArrayList<>();
	res.add(place1);
	res.add(place2);
	res.add(place3);
	res.add(place4);
	res.add(place5);
	return res;
    }


}