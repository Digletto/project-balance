import utility.ArrayUtility;
import utility.ConfigReader;

public class MainMain {
	
	public static void main(String args[]) {
		ConfigReader cfgReader = new ConfigReader("test/actors.cfg");
		ArrayUtility arrayUtil = new ArrayUtility();
		Object[] array = {2,3,6,1};
		
		for(String s:cfgReader.loadActorTypes()) {
			System.out.println(s);
		}
		System.out.println();
		for(String s:cfgReader.loadStats("PC")) {
			System.out.println(s);
		}
		System.out.println();
		for(String s:cfgReader.loadStats("NPC")) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println(arrayUtil.contains(array, 6));
	}
}
