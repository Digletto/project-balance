package balance;

import java.util.HashMap;

public class Actor {
	private HashMap<String, Integer> statMap;
	
	public Actor() {
		this.statMap = null;
	}
	
	public Actor(HashMap<String, Integer> statMap) {
		this.statMap = statMap;
	}
	
	/**
	 * Creates the stat if it doesn't exists and puts it to 0
	 * 
	 * @param statName
	 * @return true if the stat didn't already exist, otherwise false
	 */
	public Boolean addStat(String statName) {
		return putIfAbsent(statName, 0);
	}
	
	public Boolean addStat(String statName, int statValue) {
		return putIfAbsent(statName, statValue);
	}
	
	public Integer setStat(String statName, int statValue) {
		return put(statName, statValue);
	}
	
	public boolean containsStat(String statName) {
		return containsKey(statName);
	}

	/**
	 * returns true if the key does not exist or is mapped to null and maps to the given value
	 * 
	 * @param statKey 
	 * @param statValue
	 * @return
	 */
	private boolean putIfAbsent(String statKey, int statValue) {
		if(statMap.putIfAbsent(statKey, statValue) == null) return true;
		else return false;
	}
	
	private Integer put(String statKey, int statValue) {
		return statMap.put(statKey, statValue);
	}
	
	private boolean containsKey(String statKey) {
		return statMap.containsKey(statKey);
	}
}