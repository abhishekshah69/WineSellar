import java.util.logging.Logger;

/**
 * This class is a Main class for Application
 * @author Abhishek
 * Date 6/05/2018
 * */
public class WineSellarMain {

	/**The execution starts here*/
	public static void main(String[] args) throws Exception {

		System.out.println("1:Please make a folder Winesellar in C:\\ Drive");
		System.out.println("1:Please put file in C:\\Winesellar Drive");

		/**File Path:Change File Path/Name here to parse different file*/
		ReadTextToList parser = new ReadTextToList("C:\\Winesellar\\person_wine_3.txt");

		/**Calling the parsing logic*/
		parser.readTextToList();

		/**Logging the status for better tracking*/
		Logger.getLogger("Done.");
	}

}
