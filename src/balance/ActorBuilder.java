package balance;

import utility.ArrayUtility;
import utility.ConfigReader;

public class ActorBuilder {
	ConfigReader cfgReader;
	ArrayUtility arrayUtil = new ArrayUtility();
	
	public ActorBuilder(String cfgPath) {
		cfgReader = new ConfigReader(cfgPath);
	}
	
	public ActorBuilder() {
		cfgReader = new ConfigReader("cfg/actors.cfg");
	}
	
	public Actor newActor(String type) {
		Actor actor = new Actor();
		actor.setType(type);
		if(arrayUtil.contains(cfgReader.loadActorTypes(), type)) {
			actor.addStatArray(cfgReader.loadStats(type));
		}
		return actor;
	}
}
