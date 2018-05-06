import java.util.ArrayList;
import java.util.List;

/**
 * This class is a Model class for Wines
 * @author Abhishek
 * Date 6/05/2018
 * */
public class Wines {

	/**
	 * Constructor for the class*/
	public Wines() {}

	/**This List stores Wine name that can be sold after filtering with business rules.*/
	private List<String> wineName=new ArrayList<String>();

	/**
	 * @return wineName List
	 */
	public List<String> getWineName() {
		return wineName;
	}

	/**
	 * @param wineName List
	 */
	public void setWineName(List<String> wineName) {
		this.wineName = wineName;
	}
}
