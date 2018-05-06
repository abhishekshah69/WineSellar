import java.util.LinkedHashMap;

/**
 * This class is a Model class for Order
 * @author Abhishek
 * Date 6/05/2018
 * */

public class OrderChoice {

	/**
	 * Constructor for the class*/
	public OrderChoice() {}

	/**This List stores order that can be fulfilled after filtering with business rules.*/
	private	LinkedHashMap<String,String> orderChoiceFulfilled=new LinkedHashMap<String,String>();

	/**This List stores order that cannot be fulfilled after filtering with business rules.*/
	private	LinkedHashMap<String,String> orderChoiceNotFulfilled=new LinkedHashMap<String,String>();

	/**
	 * @return orderChoiceNotFulfilled
	 */
	public LinkedHashMap<String, String> getOrderChoiceNotFulfilled() {
		return orderChoiceNotFulfilled;
	}

	/**
	 * @param orderChoiceNotFulfilled
	 */
	public void setOrderChoiceNotFulfilled(LinkedHashMap<String, String> orderChoiceNotFulfilled) {
		this.orderChoiceNotFulfilled = orderChoiceNotFulfilled;
	}

	/**
	 * @return orderChoiceFulfilled
	 */
	public LinkedHashMap<String, String> getOrderChoice() {
		return orderChoiceFulfilled;
	}

	/**
	 * @param orderChoiceFulfilled
	 */
	public void setOrderChoice(LinkedHashMap<String,String> orderChoice) {
		this.orderChoiceFulfilled = orderChoice;
	}

}
