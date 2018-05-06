import java.util.ArrayList;
import java.util.List;

/**
 * This class is a Model class for Person
 * @author Abhishek
 * Date 6/05/2018
 * */
public class Person {

	/**
	 * Constructor for the class*/
	public Person() {}

	/**This List stores person names filtering with business rules.*/
	private List<String> personName=new ArrayList<String>();

	/**
	 * @return personName List
	 */
	public List<String> getPersonName() {
		return personName;
	}

	/**
	 * @param personName List
	 */
	public void setPersonName(List<String> personName) {
		this.personName = personName;
	}

}
