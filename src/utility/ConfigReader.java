package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigReader {
	Scanner cfgScanner;
	String cfgPath;
	File cfgFile;
	ArrayUtility arrayUtil = new ArrayUtility();

	public ConfigReader(String cfgPath) {
		this.cfgPath = cfgPath;
		this.cfgFile = new File(cfgPath);
	}

	public String[] loadActorTypes() {
		ArrayList<String> types = new ArrayList<String>();
		restartCfgScanner();
		String currentLine;
		while (cfgScanner.hasNextLine()) {
			currentLine = cfgScanner.nextLine();
			if (currentLine.startsWith("$")) {
				types.add((currentLine.substring(1)));
			}
		}
		cfgScanner.close();
		return arrayUtil.arrayListToArray(types);
	}

	/**
	 * Loads and returns the different stats assigned to a certain actor type
	 * 
	 * @param type
	 *            the type of actor to load the stats of
	 * @return an Array of Strings containing all stat-names belonging to the
	 *         actor type
	 */
	public String[] loadStats(String type) {
		restartCfgScanner();
		ArrayList<String> stats = new ArrayList<String>();
		String currentLine;

		while (cfgScanner.hasNextLine()) {
			currentLine = cfgScanner.nextLine();
			if (currentLine.startsWith("@" + type))
				addStatList(stats, currentLine);
		}
		cfgScanner.close();

		return arrayUtil.arrayListToArray(stats);
	}

	private void addStatList(ArrayList<String> stats, String currentLine) {
		currentLine = cfgScanner.nextLine();
		while (!currentLine.contains(">@")) {
			stats.add(currentLine);
			currentLine = cfgScanner.nextLine();
		}
	}

	private void restartCfgScanner() {
		try {
			cfgScanner = new Scanner(cfgFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}