import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This class is a Business class for the Application
 * @author Abhishek
 * Date 6/05/2018
 */
public class ReadTextToList {

	/**Takes file path*/
	private final Path fFilePath;

	/**Defines Encoding for a particular file*/
	private final static Charset ENCODING = StandardCharsets.UTF_8;  

	/**Logging on console*/
	private static void log(Object aObject){
		System.out.println(String.valueOf(aObject));
	}

	/**Formatting Logs*/
	private String quote(String aText){
		String QUOTE = "'";
		return QUOTE + aText + QUOTE;
	}

	/**
	 * START
	 * Global object creation for model classes
	 * */
	Person personObj=new Person();

	Wines winesObj=new Wines();

	Wines winesPerPersonoObj=new Wines();

	OrderChoice orderChoiceobj=new OrderChoice();
	/**
	 * END
	 * Global object creation for model classes
	 * */

	/**Constructor for the class*/
	public ReadTextToList(String aFileName){
		fFilePath = Paths.get(aFileName);
	}

	/**
	 * Parser function:
	 * parses data line by line*/
	public List readTextToList() throws Exception{

		try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
			while (scanner.hasNextLine()){
				processLine(scanner.nextLine());
			}   
			PrepareFinalList();

		}


		return null;

	}

	/**
	 *Parses each line using Delimeter */
	protected void processLine(String aLine){
		//use a second Scanner to parse the content of each line 
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\\t");
		if (scanner.hasNext()){
			//assumes the line has a certain structure
			String name = scanner.next();
			String value = scanner.next();

			if(winesObj.getWineName().contains(value)){

				int index=winesObj.getWineName().indexOf(value);
				String personAtIndex=personObj.getPersonName().get(index);
				if(Collections.frequency(personObj.getPersonName(), personAtIndex )>3){
					personObj.getPersonName().remove(index);
					winesObj.getWineName().remove(index);
					personObj.getPersonName().add(name);
					winesObj.getWineName().add(value);
					orderChoiceobj.getOrderChoice().remove(personAtIndex, value);
					orderChoiceobj.getOrderChoice().put(name, value);
				}
				else{
					orderChoiceobj.getOrderChoiceNotFulfilled().put(name, value);
				}
			}
			else{
				personObj.getPersonName().add(name);
				winesObj.getWineName().add(value);
				orderChoiceobj.getOrderChoice().put(name, value);
			}

			log("Person is : " + quote(name.trim()) + ", and Wine is : " + quote(value.trim()));
		}
		else {
			log("Empty or invalid line. Unable to process.");
		}

	}

	/**Prints the final List
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException */
	public void PrepareFinalList() throws FileNotFoundException, UnsupportedEncodingException{

		List<String> finalPersonList=new ArrayList<String>();
		List<String> finalWineList=new ArrayList<String>();
		int numberOfWinesSold=0;
		System.out.println("Filtering Data Please wait for next promt..Might take a while..");
		Iterator wineIt = winesObj.getWineName().iterator();
		for (String person : personObj.getPersonName()) {
			if(Collections.frequency(finalPersonList, person )<3)
			{
				numberOfWinesSold++;
				finalPersonList.add(person);
				finalWineList.add(wineIt.next().toString());
			}

		}

		Iterator personItr = finalPersonList.iterator();
		Iterator wineItr = finalWineList.iterator();

		PrintWriter writer = new PrintWriter("C:\\Winesellar\\result_3.txt", "UTF-8");
		System.out.println("Writing data in file wait for prompt");
		writer.println("Number of wine bottles sold:"+numberOfWinesSold);
		while(personItr.hasNext()){
			writer.println(personItr.next() + "\t" + wineItr.next());

		}
		System.out.println("Data Writng complete");

	} 

}
