//--== CS400 Individual Role Code for Data Wrangler File Header ==--
//Name: <Changjae Han>
//CSL Username: <changjae>
//Email: <chan82@wisc.edu>
//Lecture #: <001 @11:00am>
//Notes to Grader:

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//import javax
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import org
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * @author changjae
 *
 * GameLoader
 * This class implements IGameLoader that loadShows takes @param file
 * to read xml file that returns List<IGame> Games
 */
public class GameLoader implements IGameLoader {

	@Override
	public List<IGame> loadShows(String filepath) throws FileNotFoundException {

		//List<IGame> Games that contains Game with:
		// 1.rank 2.name 3.platform 4.NASales 5.EUSales 6.JPSales
		List<IGame> Games = new ArrayList<>();

		//try catch method to catch exception
		try {

			//javax for xml reader
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filepath);
			document.getDocumentElement().normalize();
			NodeList list = document.getElementsByTagName("row");

			//double for-loop to assign game to games by using Node and NodeList
			for(int i = 0; i < list.getLength(); i++) {
				IGame addedGame;

				//Node & NodeList to get each element
				Node item = list.item(i);
				NodeList childList =item.getChildNodes();

				//initialize game element that needs casting later
				String Rank = null;
				String Name = null;
				String Platform = null;
				String NASales = null;
				String EUSales = null;
				String JPSales = null;

				//get element and assign
				for(int j = 0; j<childList.getLength(); j++) {
					Node item2 = childList.item(j);
					Object value = item2.getNodeName();

					if(value.equals("#text")) continue; //other text
					if(value.equals("Rank")) Rank = item2.getTextContent();
					if(value.equals("Name")) Name = item2.getTextContent();
					if(value.equals("Platform")) Platform = item2.getTextContent();
					if(value.equals("NA_Sales")) NASales = item2.getTextContent();
					if(value.equals("EU_Sales")) EUSales = item2.getTextContent();
					if(value.equals("JP_Sales")) JPSales = item2.getTextContent();
				}
				//casting
				int rank = Integer.parseInt(Rank);
				double naSales = Double.parseDouble(NASales);
				double euSales = Double.parseDouble(EUSales);
				double jpSales = Double.parseDouble(JPSales);

				//Create Game object and add to Games list
				addedGame = new Game(rank, Name, Platform, naSales,
						euSales, jpSales);
				Games.add(addedGame);
			}

			//for integrating, we remove this part
//			//Only for DataWranglerTests (needed to be commented later)
//			for(IGame addedGame : Games) {
//				System.out.println(addedGame.getRank() +" "+ addedGame.getName() +" "
//						+ addedGame.getPlatform() +" "+ addedGame.getNASales() +" "
//						+ addedGame.getEUSales() +" "+ addedGame.getJPSales());
//			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return Games;

	}
	//for integrating, we remove this part
//	public static void main(String[] args) throws FileNotFoundException {
//		//temp for makefile test
//		IGameLoader loader = new GameLoader();
// 		List<IGame> games = loader.loadShows("GamesPractice.xml");
//	}
}