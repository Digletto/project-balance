package utility;

public class ArrayUtility {

	public boolean contains(Object[] array, Object object) {
		for(Object o:array) {
			if(o.equals(object) || o == object) return true;
		}
		return false;
	}
	
	public boolean contains(int[] array, int integer) {
		for(int i:array) {
			if(integer == i) return true;
		}
		return false;
	}
	
	//TODO extend with more contains methods for primitive datatypes if needed
}
