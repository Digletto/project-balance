package utility;

import java.util.ArrayList;

public class ArrayUtility {

	/**
	 * Checks if an array contains and object, going through all objects in the
	 * array using the lowest implementation of their equals method
	 * 
	 * @param array
	 * @param object
	 * @return true if the array contains the object in question
	 */
	public boolean contains(Object[] array, Object object) {
		for (Object o : array) {
			if (o.equals(object) || o == object)
				return true;
		}
		return false;
	}

	public boolean contains(int[] array, int integer) {
		for (int i : array) {
			if (integer == i)
				return true;
		}
		return false;
	}

	public String[] arrayListToArray(ArrayList<String> array) {
		return array.toArray(new String[array.size()]);
	}

	// TODO extend with more contains methods for primitive datatypes if needed
}
