import utility.ConfigReader;

public class MainMain {

	public static void main(String args[]) {
		ConfigReader cfgReader = new ConfigReader("test/actors.cfg");
		cfgReader.loadActorTypes();
		cfgReader.loadStats("PC");
		cfgReader.loadStats("NPC");
	}
}
