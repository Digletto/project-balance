package balance;

import java.util.HashMap;

public class Actor {
	private HashMap<String, Integer> statMap;
	private String type;

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
	 * @return true if the stat didn't exist and was added
	 */
	public Boolean addStat(String statName) {
		return putIfAbsent(statName, 0);
	}
	
	public Boolean addStat(String statName, int statValue) {
		return putIfAbsent(statName, statValue);
	}

	/**
	 * If the specified stat is not already added with a value (or is mapped to
	 * null) adds the stat with the given value and returns null, else returns
	 * the current value.
	 * 
	 * @param statName
	 * @param statValue
	 * @return the previous value associated with the specified stat, or null if
	 *         there was no mapping for the key. (A null return can also
	 *         indicate that the map previously associated null with the key, if
	 *         the implementation supports null values.)
	 */
	public int addStatIfAbsent(String statName, int statValue) {
		return statMap.putIfAbsent(statName, statValue);
	}
	
	public void addStatArray(String[] statArray) {
		for(String s:statArray) {
			addStat(s);
		}
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	/**
	 * sets the value of a stat
	 * 
	 * @param statName
	 * @param statValue
	 * @return old value if there was one, else null
	 */
	public Integer setStat(String statName, int statValue) {
		return put(statName, statValue);
	}

	public boolean containsStat(String statName) {
		return containsKey(statName);
	}

	/**
	 * returns true if the key does not exist or is mapped to null and maps to
	 * the given value
	 * 
	 * @param statKey
	 * @param statValue
	 * @return
	 */
	private boolean putIfAbsent(String statKey, int statValue) {
		if (statMap.putIfAbsent(statKey, statValue) == null)
			return true;
		else
			return false;
	}

	private Integer put(String statKey, int statValue) {
		return statMap.put(statKey, statValue);
	}

	private boolean containsKey(String statKey) {
		return statMap.containsKey(statKey);
	}
}